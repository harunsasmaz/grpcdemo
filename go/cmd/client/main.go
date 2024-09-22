package main

import (
	"context"
	"log"
	"os"
	"time"

	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
	"google.golang.org/grpc/keepalive"
	"google.golang.org/grpc/metadata"

	"github.com/getmidas/grpcdemo-go/pkg/interceptor"
	instrumentv1 "github.com/getmidas/grpcdemo-go/proto/gen/instrument/v1"
)

func main() {
	serverUrl := "0.0.0.0:2222"
	if url, ok := os.LookupEnv("SERVER_URL"); ok {
		serverUrl = url
	}

	conn, err := grpc.NewClient(serverUrl,
		grpc.WithKeepaliveParams(keepalive.ClientParameters{
			Time:                30 * time.Second,
			Timeout:             30 * time.Second,
			PermitWithoutStream: true,
		}),
		grpc.WithTransportCredentials(
			insecure.NewCredentials(),
		),
		grpc.WithChainUnaryInterceptor(
			interceptor.UnaryClientLogInterceptor(),
		),
		grpc.WithChainStreamInterceptor(
			interceptor.StreamClientLogInterceptor(),
		),
		grpc.WithDefaultCallOptions(
			grpc.MaxCallSendMsgSize(1000),
		),
	)
	if err != nil {
		log.Fatalf("did not connect: %v", err)
	}
	defer conn.Close()

	client := instrumentv1.NewInstrumentServiceClient(conn)

	ctx, cancel := context.WithCancel(context.Background())
	defer cancel()

	md := metadata.New(map[string]string{
		"X-Sender-Name": "midascrypto",
	})

	oCtx := metadata.NewOutgoingContext(ctx, md)

	createReq := &instrumentv1.CreateRequest{
		Instrument: &instrumentv1.Instrument{
			Name:    "Bitcoin",
			Symbol:  "BTC",
			LogoUrl: "logos/BTC.png",
			Pair: &instrumentv1.Instrument_TryPair{
				TryPair: &instrumentv1.TradingPair{
					Buyable:  true,
					Sellable: true,
					Status:   instrumentv1.TradingPairStatus_ACTIVE,
					Left: &instrumentv1.TradingPairItem{
						Symbol:        "BTC",
						DecimalPlaces: "8",
					},
					Right: &instrumentv1.TradingPairItem{
						Symbol:        "TRY",
						DecimalPlaces: "2",
					},
					Threshold: &instrumentv1.Threshold{
						MinAmount:   50,
						MaxAmount:   1000000,
						MinQuantity: 0.000001,
						MaxQuantity: 10,
					},
				},
			},
			Labels:  []string{"asset", "trading", "currency"},
			Version: 1,
			Metadata: map[string]string{
				"created_at": time.Now().Format(time.RFC3339),
			},
		},
	}

	createRes, err := client.Create(oCtx, createReq)
	if err != nil {
		log.Fatalf("could not create: %v", err)
	}

	getReq := &instrumentv1.GetRequest{Uid: createRes.GetUid()}

	getRes, err := client.Get(oCtx, getReq)
	if err != nil {
		log.Fatalf("could not get: %v", err)
	}

	log.Printf("Created instrument: %+v", getRes.GetInstrument())
}

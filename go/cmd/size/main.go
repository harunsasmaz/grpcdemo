package main

import (
	"encoding/json"
	"fmt"
	"time"

	"google.golang.org/protobuf/proto"

	instrumentv1 "github.com/getmidas/grpcdemo-go/proto/gen/instrument/v1"
)

func main() {
	dataObj := &instrumentv1.Instrument{
		Uid:     "c6abfc9b-c2e1-4d06-8f1b-cf21b07cc4be",
		Name:    "Bitcoin",
		Symbol:  "BTC",
		LogoUrl: "logos/BTC.png",
		Pair: &instrumentv1.Instrument_TryPair{
			TryPair: &instrumentv1.TradingPair{
				Uid:      "c6abfc9b-c2e1-4d06-8f1b-cf21b07cc4be",
				Buyable:  true,
				Sellable: true,
				Status:   instrumentv1.TradingPairStatus_ACTIVE,
				Left: &instrumentv1.TradingPairItem{
					Uid:           "c6abfc9b-c2e1-4d06-8f1b-cf21b07cc4be",
					Symbol:        "BTC",
					DecimalPlaces: "8",
				},
				Right: &instrumentv1.TradingPairItem{
					Uid:           "c6abfc9b-c2e1-4d06-8f1b-cf21b07cc4be",
					Symbol:        "TRY",
					DecimalPlaces: "2",
				},
				Threshold: &instrumentv1.Threshold{
					MinAmount:   50,
					MaxAmount:   1000000,
					MinQuantity: 0.00001,
					MaxQuantity: 1,
				},
			},
		},
		Labels:  []string{"Token", "Currency", "NFT"},
		Version: 1,
		Metadata: map[string]string{
			"created_at": time.Now().Format(time.RFC3339),
		},
	}

	protoBinary, err := proto.Marshal(dataObj)
	if err != nil {
		panic(err)
	}

	jsonBinary, err := json.Marshal(dataObj)
	if err != nil {
		panic(err)
	}

	fmt.Printf("Proto Size: %d, Json Size: %d\n", len(protoBinary), len(jsonBinary))
	fmt.Printf("Proto Output: %s\n", string(protoBinary))
	fmt.Printf("Json Output: %s\n", string(jsonBinary))
}

package main

import (
	"log"
	"net"
	"os"
	"os/signal"
	"syscall"
	"time"

	"google.golang.org/grpc"
	"google.golang.org/grpc/keepalive"

	servicev1 "github.com/getmidas/grpcdemo-go/api/service/v1"
	"github.com/getmidas/grpcdemo-go/pkg/interceptor"
	instrumentv1 "github.com/getmidas/grpcdemo-go/proto/gen/instrument/v1"
)

func main() {
	port := "2222"
	if val, ok := os.LookupEnv("PORT"); ok {
		port = val
	}

	listener, err := net.Listen("tcp", "0.0.0.0:"+port)
	if err != nil {
		panic(err)
	}

	defer listener.Close()

	service := servicev1.NewService()

	server := grpc.NewServer(
		grpc.KeepaliveParams(keepalive.ServerParameters{
			MaxConnectionIdle:     5 * time.Minute,
			MaxConnectionAge:      1 * time.Hour,
			MaxConnectionAgeGrace: 5 * time.Minute,
			Time:                  2 * time.Hour,
			Timeout:               30 * time.Second,
		}),
		grpc.ChainUnaryInterceptor(
			interceptor.UnaryServerLogInterceptor(),
			interceptor.UnaryServerAuthInterceptor(),
		),
		grpc.ChainStreamInterceptor(
			interceptor.StreamServerLogInterceptor(),
			interceptor.StreamServerAuthInterceptor(),
		),
		grpc.MaxRecvMsgSize(1000),
		grpc.MaxConcurrentStreams(100),
	)

	instrumentv1.RegisterInstrumentServiceServer(server, service)

	stopChan := make(chan os.Signal, 1)
	signal.Notify(stopChan, syscall.SIGTERM, syscall.SIGINT)

	go func() {
		log.Println("Server is running on port: " + port)
		if err := server.Serve(listener); err != nil {
			log.Fatalf("failed to serve: %v", err)
		}
	}()

	<-stopChan

	log.Println("Shutting down server...")
	server.GracefulStop()
	log.Println("Server stopped")
}

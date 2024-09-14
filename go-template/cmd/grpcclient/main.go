package main

import (
	"context"
	"os"
)

func main() {
	serverUrl := "0.0.0.0:2222"
	if url, ok := os.LookupEnv("SERVER_URL"); ok {
		serverUrl = url
	}

	ctx, cancel := context.WithCancel(context.Background())
	defer cancel()

	// TODO: create a new grpc connection and client

	// TODO: create a new outgoing context with auth header

	// TODO: create a new CreateInstrumentRequest

	// TODO: send CreateInstrument gRPC request

	// TODO: create a new GetInstrumentRequest

	// TODO: send GetInstrument gRPC request and log response
}

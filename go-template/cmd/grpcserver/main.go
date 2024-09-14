package main

import (
	"net"
	"os"
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

	// TODO: create a new service impl instance

	// TODO: create a new gRPC server

	// TODO: register service impl to gRPC server

	// TODO: serve the server and gracefully shutdown on termination
}

package interceptor

import (
	"context"
	"log"
	"time"

	"google.golang.org/grpc"
)

func UnaryServerLogInterceptor() grpc.UnaryServerInterceptor {
	return func(ctx context.Context, req interface{}, info *grpc.UnaryServerInfo, handler grpc.UnaryHandler) (interface{}, error) {
		start := time.Now().UTC()

		a, err := handler(ctx, req)

		took := float64(time.Since(start).Nanoseconds()) / 1e+6
		log.Printf("method: %v, request: %v, took: %.4f ms", info.FullMethod, req, took)

		return a, err
	}
}

func StreamServerLogInterceptor() grpc.StreamServerInterceptor {
	return func(srv interface{}, stream grpc.ServerStream, info *grpc.StreamServerInfo, handler grpc.StreamHandler) error {
		start := time.Now().UTC()

		err := handler(srv, stream)

		took := float64(time.Since(start).Nanoseconds()) / 1e+6
		log.Printf("method: %v, took: %.4f ms, error: %v", info.FullMethod, took, err)

		return err
	}
}

func UnaryClientLogInterceptor() grpc.UnaryClientInterceptor {
	return func(ctx context.Context, method string, req, reply any, cc *grpc.ClientConn, invoker grpc.UnaryInvoker, opts ...grpc.CallOption) error {
		log.Printf("method: %s, request: %v", method, req)

		startTime := time.Now()

		err := invoker(ctx, method, req, reply, cc, opts...)

		took := float64(time.Since(startTime).Nanoseconds()) / 1e+6
		log.Printf("response: %v, error: %v, took: %.4f ms", reply, err, took)

		return err
	}
}

func StreamClientLogInterceptor() grpc.StreamClientInterceptor {
	return func(ctx context.Context, desc *grpc.StreamDesc, cc *grpc.ClientConn, method string, streamer grpc.Streamer, opts ...grpc.CallOption) (grpc.ClientStream, error) {
		log.Printf("method: %s", method)

		start := time.Now()

		clientStream, err := streamer(ctx, desc, cc, method, opts...)

		took := float64(time.Since(start).Nanoseconds()) / 1e+6
		log.Printf("stream created, error: %v, took: %.4f ms", err, took)

		return clientStream, err
	}
}

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

package interceptor

import (
	"context"

	"google.golang.org/grpc"
)

func UnaryServerAuthInterceptor() grpc.UnaryServerInterceptor {
	return func(ctx context.Context, req interface{}, info *grpc.UnaryServerInfo, handler grpc.UnaryHandler) (interface{}, error) {
		// TODO: retrieve metadata from context

		// TODO: check if auth header exists and correct

		// TODO: call the handler
	}
}

func StreamServerAuthInterceptor() grpc.StreamServerInterceptor {
	return func(srv interface{}, stream grpc.ServerStream, info *grpc.StreamServerInfo, handler grpc.StreamHandler) error {
		// TODO: retrieve metadata from context

		// TODO: check if auth header exists and correct

		// TODO: call the handler
	}
}

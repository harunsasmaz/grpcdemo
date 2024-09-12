package interceptor

import (
	"context"

	"google.golang.org/grpc"
	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/metadata"
	"google.golang.org/grpc/status"
)

func UnaryServerAuthInterceptor() grpc.UnaryServerInterceptor {
	return func(ctx context.Context, req interface{}, info *grpc.UnaryServerInfo, handler grpc.UnaryHandler) (interface{}, error) {
		md, ok := metadata.FromIncomingContext(ctx)
		if !ok {
			return nil, status.Error(codes.Aborted, "unauthorized")
		}

		if len(md["x-sender-name"]) < 1 {
			return nil, status.Error(codes.Aborted, "unauthorized")
		}

		if md["x-sender-name"][0] != "midascrypto" {
			return nil, status.Error(codes.Aborted, "unauthorized")
		}

		return handler(ctx, req)
	}
}

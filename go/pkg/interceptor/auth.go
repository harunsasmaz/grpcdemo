package interceptor

import (
	"context"

	"google.golang.org/grpc"
	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/metadata"
	"google.golang.org/grpc/status"

	instrumentv1 "github.com/getmidas/grpcdemo-go/proto/gen/instrument/v1"
)

func UnaryServerAuthInterceptor() grpc.UnaryServerInterceptor {
	return func(ctx context.Context, req interface{}, info *grpc.UnaryServerInfo, handler grpc.UnaryHandler) (interface{}, error) {
		if info.FullMethod == instrumentv1.InstrumentService_Get_FullMethodName {
			return handler(ctx, req)
		}

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

func StreamServerAuthInterceptor() grpc.StreamServerInterceptor {
	return func(srv interface{}, stream grpc.ServerStream, info *grpc.StreamServerInfo, handler grpc.StreamHandler) error {
		if info.FullMethod == instrumentv1.InstrumentService_Get_FullMethodName {
			return handler(srv, stream)
		}

		md, ok := metadata.FromIncomingContext(stream.Context())
		if !ok {
			return status.Error(codes.Aborted, "unauthorized")
		}

		if len(md["x-sender-name"]) < 1 {
			return status.Error(codes.Aborted, "unauthorized")
		}

		if md["x-sender-name"][0] != "midascrypto" {
			return status.Error(codes.Aborted, "unauthorized")
		}

		return handler(srv, stream)
	}
}

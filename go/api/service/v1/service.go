package v1

import (
	"context"

	"github.com/google/uuid"
	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/status"

	"github.com/getmidas/grpcdemo-go/proto/gen/instrument/v1"
)

type service struct {
	db map[string]*instrumentv1.Instrument
	instrumentv1.UnimplementedInstrumentServiceServer
}

func NewService() instrumentv1.InstrumentServiceServer {
	return &service{
		db: make(map[string]*instrumentv1.Instrument),
	}
}

func (s *service) Create(ctx context.Context, in *instrumentv1.CreateRequest) (*instrumentv1.CreateResponse, error) {
	if in.GetInstrument() == nil {
		return nil, status.Error(codes.InvalidArgument, "instrument is required")
	}

	if in.GetInstrument().GetName() == "" {
		return nil, status.Error(codes.InvalidArgument, "instrument name is required")
	}

	if in.GetInstrument().GetSymbol() == "" {
		return nil, status.Error(codes.InvalidArgument, "instrument symbol is required")
	}

	if in.GetInstrument().GetPair() == nil {
		return nil, status.Error(codes.InvalidArgument, "one trading pair is required")
	}

	in.Instrument.Uid = uuid.New().String()
	s.db[in.GetInstrument().GetUid()] = in.GetInstrument()

	return &instrumentv1.CreateResponse{Uid: in.Instrument.Uid}, nil
}

func (s *service) Get(ctx context.Context, in *instrumentv1.GetRequest) (*instrumentv1.GetResponse, error) {
	if in.GetUid() == "" {
		return nil, status.Error(codes.InvalidArgument, "instrument uid is required")
	}

	instrument, ok := s.db[in.GetUid()]
	if !ok {
		return nil, status.Error(codes.NotFound, "instrument not found")
	}

	return &instrumentv1.GetResponse{Instrument: instrument}, nil
}

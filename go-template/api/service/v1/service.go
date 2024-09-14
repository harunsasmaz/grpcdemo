package v1

import (
	"context"
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
	// TODO: check if request is valid

	// TODO: save created instrument to db

	// TODO: return response
}

func (s *service) Get(ctx context.Context, in *instrumentv1.GetRequest) (*instrumentv1.GetResponse, error) {
	// TODO: check if request is valid

	// TODO: check if requested instrument exists in db

	// TODO: return response
}

# gRPC Demo / Chapter 1

In this demo, you will learn defining and running a gRPC service in Go and Java.

## Pre-requisites

- Make sure to have [Go](https://go.dev/doc/install) installed on your computer.
- Make sure to have [Java](https://www.java.com/en/download/help/download_options.html) installed on your computer.
- Make sure to have IDEs or text editors to write code in Go, Java and Protobuf.

## Proto

First, you should read `proto` path to learn how to define proto messages and how to generate code for other languages.

Please follow instructions on `proto/README.md`.

## Go

Now, you can read `go` path to learn how to implement a gRPC server and client to communicate via generated proto messages. It will enrich your gRPC usage by adding middlewares and server opts.

Please follow instructions on `go/README.md`.

## Java

Then, you can read `java` path to learn how to implement a gRPC server and client to communicate via generated proto messages. It will enrich your gRPC usage by adding middlewares and server opts.

Please follow instructions on `java/README.md`.

## Minikube
you 
In the `README` files under `go` and `java`, you will see deployment files and how to deploy them on your local computer by using [minikube](https://minikube.sigs.k8s.io/docs/). Even though it is optional, it may be helpful to understand deployment of grpc services in [kubernetes](https://kubernetes.io/) clusters with [docker](https://docs.docker.com/) containers.
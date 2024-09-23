# gRPC Demo / Go / Chapter 1

This demo aims to cover implementation of a simple gRPC server and a gRPC client around a single Unary RPC endpoint.

Main goals to cover are:

- How to import generated protobuf code.
- How to implement a gRPC service.
- How to register a service to a gRPC server.
- How to connect and invoke to a gRPC server.
- gRPC server configurations.
- gRPC client configurations.
- Interceptors.

## Setup

#### Install docker

```sh
brew install docker
```

#### Install Go

```sh
brew install go
```

#### Install minikube

```sh
brew install minikube
```

## Running on Local

#### Using `go run`

**Size Comparison**

```sh
go run cmd/size/main.go
```

**Server**

```sh
go run cmd/server/main.go
```

**Client**

```sh
go run cmd/client/main.go
```

#### Using `go build`

**Server**

```sh
go build -o server cmd/server/main.go
./server
```

**Client**

```sh
go build -o client cmd/client/main.go
./client
```

## Work with Minikube

#### Setup Limits

```sh
minikube config set cpus 4
minikube config set memory 4096
```

#### Start Cluster

```sh
minikube start
```

#### Enable Add-ons (Optional)

See full list of add-ons

```sh
minikube addons list
```

```sh
minikube addons enable metrics-server
minikube addons enable istio-provisioner
minikube addons enable istio
```

#### Allow to use local Docker images

```sh
eval $(minikube docker-env)
```

#### Shutdown (at the end)

```sh
minikube stop
minikube delete
```

## Deploy

#### Build Images

```sh
docker build -t grpcdemo-go-server -f Dockerfile.server .
docker build -t grpcdemo-go-client -f Dockerfile.client .
```

#### Deploy Server

```sh
kubectl apply -f deployment-server.yaml
kubectl apply -f service-server.yaml
```

#### Deploy Client

```sh
kubectl apply -f deployment-client.yaml
```

#### Access to logs

```sh
kubectl get pods
```

```sh
kubectl logs <pod_name> -f
```
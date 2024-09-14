# gRPC Demo / Java / Chapter 1

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

#### Install JDK (via Temurin)

```sh
brew install --cask temurin
```

#### Install minikube

```sh
brew install minikube
```

## Running on Local

#### Using `mvn exec`

**Server**

```sh
mvn exec:java -Dexec.mainClass="com.grpcdemo.instrument.v1.server.Main"
```

**Client**

```sh
mvn exec:java -Dexec.mainClass="com.grpcdemo.instrument.v1.client.Main"
```

#### Using `java`

**Server**

```sh
mvn clean package -Pserver
java -jar target/grpcdemo-java-server.jar
```

**Client**

```sh
mvn clean package -Pclient
java -jar target/grpcdemo-java-client.jar
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
docker build -t grpcdemo-java-server -f Dockerfile.server .
docker build -t grpcdemo-java-client -f Dockerfile.client .
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
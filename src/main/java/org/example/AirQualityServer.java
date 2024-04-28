package org.example;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Random;

public class AirQualityServer {

    private static final int PORT = 9091;
    private static final String SERVICE_NAME = "air-quality";

    public static void main(String[] args) throws IOException, InterruptedException {
        // Starting the gRPC server
        Server server = startGRPCServer(PORT);

        // Registering service with Consul
        registerServiceWithConsul();

        // Awaiting server termination
        server.awaitTermination();
    }

    private static Server startGRPCServer(int port) throws IOException {
        Server server = ServerBuilder.forPort(port)
                .addService(new AirQualityServiceImpl())
                .build();

        System.out.println("Server started, listening on port " + port);
        server.start();
        return server;
    }

    private static void registerServiceWithConsul() {
        ConsulClient consulClient = new ConsulClient();
        NewService newService = new NewService();
        newService.setName(SERVICE_NAME);
        newService.setPort(PORT);

        consulClient.agentServiceRegister(newService);
        System.out.println("Service registered with Consul");
    }

    private static void deregisterServiceFromConsul() {
        ConsulClient consulClient = new ConsulClient();
        consulClient.agentServiceDeregister(SERVICE_NAME);
        System.out.println("Service deregistered from Consul");
    }

    static class AirQualityServiceImpl extends AirQualityServiceGrpc.AirQualityServiceImplBase {
        public void getAirQualityIndex(AirQualityIndex.AirQualityRequest request, StreamObserver
                <AirQualityIndex.AirQualityResponse> responseObserver) {
            // Generating a random air quality index
            int airQualityIndex = generateRandomAirQualityIndex();
            // Calculate status based on the air quality index
            String status = calculateStatus(airQualityIndex);

            AirQualityIndex.AirQualityResponse response = AirQualityIndex.AirQualityResponse.newBuilder()
                    .setAirQualityIndex(airQualityIndex)
                    .setAirStatus(status)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        private int generateRandomAirQualityIndex() {
            // Generating a random air quality index between 0 and 500
            Random random = new Random();
            return random.nextInt(501);
        }

        private String calculateStatus(int aqiLevel) {
            // Example implementation of status calculation
            if (aqiLevel <= 50) {
                return "Good";
            } else if (aqiLevel <= 100) {
                return "Moderate";
            } else if (aqiLevel <= 150) {
                return "Unhealthy for Sensitive Groups";
            } else if (aqiLevel <= 200) {
                return "Unhealthy";
            } else if (aqiLevel <= 300) {
                return "Very Unhealthy";
            } else {
                return "Hazardous";
            }
        }
    }

    // Hook to deregister service from Consul when server shuts down
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(AirQualityServer::deregisterServiceFromConsul));
    }
}

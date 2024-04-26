package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Random;

public class AirQualityServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 9091;

        Server server = ServerBuilder.forPort(port)
                .addService(new AirQualityServiceImpl())
                .build();

        System.out.println("Server started, listening on port " + port);
        server.start();
        server.awaitTermination();
    }

    static class AirQualityServiceImpl extends AirQualityServiceGrpc.AirQualityServiceImplBase {
        public void getAirQualityIndex(AirQualityIndex.AirQualityRequest request, StreamObserver<AirQualityIndex.AirQualityResponse> responseObserver) {
            // Generate a random air quality index
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
            // Generate a random air quality index between 0 and 500
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
}

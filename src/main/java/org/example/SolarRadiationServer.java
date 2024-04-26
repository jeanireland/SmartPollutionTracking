package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Random;

public class SolarRadiationServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 9092;

        Server server = ServerBuilder.forPort(port)
                .addService(new SolarRadiationServiceImpl())
                .build();

        System.out.println("Solar Radiation Server started, listening on port " + port);
        server.start();
        server.awaitTermination();
    }

    static class SolarRadiationServiceImpl extends SolarRadiationServiceGrpc.SolarRadiationServiceImplBase {
        @Override
        public void getSolarRadiationLevel(SolarRadiation.SolarRadiationRequest request, StreamObserver<SolarRadiation.SolarRadiationResponse> responseObserver) {

            double solarRadiationLevel = generateRandomSolarRadiationLevel();

            SolarRadiation.SolarRadiationResponse response = SolarRadiation.SolarRadiationResponse.newBuilder()
                    .setSolarRadiationLevel(solarRadiationLevel)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        private double generateRandomSolarRadiationLevel() {
            // The method will generate a random solar radiation level between 0 and 1000 W/m^2
            Random random = new Random();
            return random.nextDouble() * 1000;
        }
    }
}

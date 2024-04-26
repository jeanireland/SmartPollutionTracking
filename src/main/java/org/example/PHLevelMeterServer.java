package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Random;

public class PHLevelMeterServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 9090;

        Server server = ServerBuilder.forPort(port)
                .addService(new PHLevelMeterServiceImpl())
                .build();

        System.out.println("Server started, listening on port " + port);
        server.start();
        server.awaitTermination();
    }

    static class PHLevelMeterServiceImpl extends pHLevelMeterGrpc.pHLevelMeterImplBase {
        public void getPhLevel(PHLevelMeter.PhLevelRequest request, StreamObserver<PHLevelMeter.PhLevelResponse> responseObserver) {
            // Generate a random pH level
            float phLevel = generateRandomPH();
            String status = calculateStatus(phLevel);

            PHLevelMeter.PhLevelResponse response = PHLevelMeter.PhLevelResponse.newBuilder()
                    .setPhLevel(phLevel)
                    .setPhStatus(status)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        private float generateRandomPH() {
            // Generate a random pH level between 0 and 14
            Random random = new Random();
            return random.nextFloat() * 14;
        }

        private String calculateStatus(float phLevel) {
            // Example implementation of status calculation
            if (phLevel < 7) {
                return "Acidic";
            } else if (phLevel > 7) {
                return "Alkaline";
            } else {
                return "Neutral";
            }
        }
    }
}

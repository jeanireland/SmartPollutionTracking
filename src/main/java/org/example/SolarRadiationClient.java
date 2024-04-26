package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SolarRadiationClient {
    private final ManagedChannel channel;
    private final SolarRadiationServiceGrpc.SolarRadiationServiceBlockingStub blockingStub;

    public SolarRadiationClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
    }

    SolarRadiationClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = SolarRadiationServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }

    public void getSolarRadiationLevel(String location) {
        SolarRadiation.SolarRadiationRequest request = SolarRadiation.SolarRadiationRequest.newBuilder().setLocation(location).build();
        SolarRadiation.SolarRadiationResponse response = blockingStub.getSolarRadiationLevel(request);
        System.out.println("Solar Radiation Level at " + location + ": " + response.getSolarRadiationLevel() + " W/m^2");
    }

    public static void main(String[] args) throws InterruptedException {
        SolarRadiationClient client = new SolarRadiationClient("localhost", 9092);
        try {
            client.getSolarRadiationLevel("CO. Dublin");
        } finally {
            client.shutdown();
        }
    }
}

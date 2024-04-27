package org.example;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AirQualityClient {
    private final ManagedChannel channel;
    private final AirQualityServiceGrpc.AirQualityServiceBlockingStub blockingStub;

    public AirQualityClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
    }

    AirQualityClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = AirQualityServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }

    public void getAirQualityIndex(String location) {
        AirQualityIndex.AirQualityRequest request = AirQualityIndex.AirQualityRequest.newBuilder().setLocation(location).build();
        AirQualityIndex.AirQualityResponse response = blockingStub.getAirQualityIndex(request);
        System.out.println("Air Quality Index at " + location + ": " + response.getAirQualityIndex());
        System.out.println("Air Quality Status: " + response.getAirStatus());
    }

    public static void main(String[] args) throws InterruptedException {
        AirQualityClient client = new AirQualityClient("localhost", 9091);
        try {
            client.getAirQualityIndex("CO. Dublin");
        } finally {
            client.shutdown();
        }
    }
}

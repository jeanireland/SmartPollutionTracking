package org.example;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class PHLevelMeterClient {
    private final ManagedChannel channel;
    private final pHLevelMeterGrpc.pHLevelMeterBlockingStub blockingStub;

    public PHLevelMeterClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
    }

    PHLevelMeterClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = pHLevelMeterGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }

    public void getPhLevel(String location) {
        PHLevelMeter.PhLevelRequest request = PHLevelMeter.PhLevelRequest.newBuilder().setLocation(location).build();
        PHLevelMeter.PhLevelResponse response = blockingStub.getPhLevel(request);
        System.out.println("pH Level: " + response.getPhLevel());
        System.out.println("Status: " + response.getPhStatus());
    }

    public static void main(String[] args) throws InterruptedException {
        PHLevelMeterClient client = new PHLevelMeterClient("localhost", 9090);
        try {
            client.getPhLevel("Some Location");
        } finally {
            client.shutdown();
        }
    }
}

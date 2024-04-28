package org.example;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class PHLevelMeterClient {
    private final ManagedChannel channel;
    private final pHLevelMeterGrpc.pHLevelMeterBlockingStub blockingStub;
    //This is the constructor for PHlevelMeterClient
    public PHLevelMeterClient(String host, int port) {
        //Here Creating a channel
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
    }
    //This is the constructor for PHLevelMeterClient with ManagedChannel parameter
    PHLevelMeterClient(ManagedChannel channel) {
        this.channel = channel;
        //Creating a blocking stub
        blockingStub = pHLevelMeterGrpc.newBlockingStub(channel);
    }
    //Method to shutdown the client
    public void shutdown() throws InterruptedException {
        //Shutting down the channel
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }
    //Method to get phLevel for a location
    public void getPhLevel(String location) {
        //Creating a request
        PHLevelMeter.PhLevelRequest request = PHLevelMeter.PhLevelRequest.newBuilder().setLocation(location).build();
        //Sending the request and getting the response
        PHLevelMeter.PhLevelResponse response = blockingStub.getPhLevel(request);
        //Displaying the pH level and status
        System.out.println("pH Level: " + response.getPhLevel());
        System.out.println("Status: " + response.getPhStatus());
    }
    //Main method to run the client
    public static void main(String[] args) throws InterruptedException {
        //Here I am creating an instance of PHLevelMeterClient
        PHLevelMeterClient client = new PHLevelMeterClient("localhost", 9090);
        try {
            //Calling the method to get pHLevel
            client.getPhLevel("Some Location");
        } finally {
            //Shutting down the client
            client.shutdown();
        }
    }
}

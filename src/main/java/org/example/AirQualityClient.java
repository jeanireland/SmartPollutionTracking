package org.example;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AirQualityClient {
    private final ManagedChannel channel;
    private final AirQualityServiceGrpc.AirQualityServiceBlockingStub blockingStub;
    //This is the constructor for AirQualityClient
    public AirQualityClient(String host, int port) {
        //Here I am creating a channel
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
    }
    //This is the constructor for AirQualityClient with ManagedChannel parameter
    AirQualityClient(ManagedChannel channel) {
        this.channel = channel;
        //Here I am creating a blocking stub
        blockingStub = AirQualityServiceGrpc.newBlockingStub(channel);
    }
    //This is the method to shut down the client
    public void shutdown() throws InterruptedException {
        //Shutting down the channel
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }
    //This is the method to get air quality index for a location
    public void getAirQualityIndex(String location) {
        //Creating a request
        AirQualityIndex.AirQualityRequest request = AirQualityIndex.AirQualityRequest.newBuilder().setLocation(location).build();
        //Sending the request band getting the response
        AirQualityIndex.AirQualityResponse response = blockingStub.getAirQualityIndex(request);
        //Displaying the air quality index and status
        System.out.println("Air Quality Index at " + location + ": " + response.getAirQualityIndex());
        System.out.println("Air Quality Status: " + response.getAirStatus());
    }
    //This is the main method to run the client
    public static void main(String[] args) throws InterruptedException {
        //Creating an instance of AirQualityClient
        AirQualityClient client = new AirQualityClient("localhost", 9091);
        try {
            //Calling the method to get air quality index
            client.getAirQualityIndex("CO. Dublin");
        } finally {
            //And then Shutdown  the client
            client.shutdown();
        }
    }
}

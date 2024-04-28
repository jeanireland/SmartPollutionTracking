package org.example;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SolarRadiationClient {
    private final ManagedChannel channel;
    private final SolarRadiationServiceGrpc.SolarRadiationServiceBlockingStub blockingStub;
    //This is the constructor for SolarRadiationClient
    public SolarRadiationClient(String host, int port) {
        //Creating a channel
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
    }
    //Constructor for SolarRadiation client with Managed Channel parameter
    SolarRadiationClient(ManagedChannel channel) {
        this.channel = channel;
        //Here I am Creating a blocking stub
        blockingStub = SolarRadiationServiceGrpc.newBlockingStub(channel);
    }
    //Method to shutdown the client
    public void shutdown() throws InterruptedException {
        //Shutting down the channel
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }
    //Method to get solar radiation level for a location
    public void getSolarRadiationLevel(String location) {
        //Creating a request
        SolarRadiation.SolarRadiationRequest request = SolarRadiation.SolarRadiationRequest.newBuilder().setLocation(location).build();
        //Sending the request and getting the response
        SolarRadiation.SolarRadiationResponse response = blockingStub.getSolarRadiationLevel(request);
        //Displaying the solar radiation level
        System.out.println("Solar Radiation Level at " + location + ": " + response.getSolarRadiationLevel() + " W/m^2");
    }
    //Main method to run the client
    public static void main(String[] args) throws InterruptedException {
        //Creating and instance of SolarRadiationClient
        SolarRadiationClient client = new SolarRadiationClient("localhost", 9092);
        try {
            //Calling the method to get solar radiation level
            client.getSolarRadiationLevel("CO. Dublin");
        } finally {
            //Shutting down the client
            client.shutdown();
        }
    }
}

package org.example;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Random;

public class SolarRadiationServer {

    private static final int PORT = 9092;
    private static final String SERVICE_NAME = "solar-radiation";

    public static void main(String[] args) throws IOException, InterruptedException {
        // Start the gRPC server
        Server server = startGRPCServer(PORT);

        // Register service with Consul
        registerServiceWithConsul();

        // Await server termination
        server.awaitTermination();
    }

    private static Server startGRPCServer(int port) throws IOException {
        Server server = ServerBuilder.forPort(port)
                .addService(new SolarRadiationServiceImpl())
                .build();

        System.out.println("Solar Radiation Server started, listening on port " + port);
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

    // Hook to deregister service from Consul when server shuts down
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(SolarRadiationServer::deregisterServiceFromConsul));
    }
}

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.example.PHLevelMeter;
import org.example.common.pHLevelMeterGrpc;

import java.io.IOException;
import java.util.Random;

public class PHLevelMeterServer {

    private static final int PORT = 9090;
    private static final String SERVICE_NAME = "ph-level-meter";

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
                .addService(new PHLevelMeterServiceImpl())
                .build();

        System.out.println("Server started, listening on port " + port);
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

    static class PHLevelMeterServiceImpl extends pHLevelMeterGrpc.pHLevelMeterImplBase {
        public void getPhLevel(PHLevelMeter.PhLevelRequest request, StreamObserver
                <PHLevelMeter.PhLevelResponse> responseObserver) {
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

    // Hook to deregister service from Consul when server shuts down
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(PHLevelMeterServer::deregisterServiceFromConsul));
    }
}

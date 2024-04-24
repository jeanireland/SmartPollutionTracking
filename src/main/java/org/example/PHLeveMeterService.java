//package org.example;
//
//import io.grpc.Server;
//import io.grpc.ServerBuilder;
//import io.grpc.stub.StreamObserver;
//import org.example.common.pHLevelMeterGrpc;
//
//public class PHLevelMeterService extends pHLevelMeterGrpc.pHLevelMeterImplBase {
//
//    @Override
//    public void GetPhLevel(PhLevelRequest request, StreamObserver<PhLevelResponse> responseObserver) {
//        // Here you can implement the logic to calculate the water's pH
//        // In this example, we will return a fake value
//        float phLevel = calculatePHLevel(request.getLocation()); // Fake method to calculate pH
//
//        // Checking if the pH is acidic, neutral, or basic
//        String pHStatus;
//        if (phLevel < 7) {
//            pHStatus = "The water is acidic.";
//        } else if (phLevel == 7) {
//            pHStatus = "The water is neutral.";
//        } else {
//            pHStatus = "The water is basic.";
//        }
//
//        // Creating the response with the calculated pH and status
//        PhLevelResponse response = PhLevelResponse.newBuilder()
//                .setPhLevel(phLevel)
//                .setPhStatus(pHStatus)
//                .build();

//        // Sending the response to the client
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    // Fake method to calculate water's pH
//    private float calculatePHLevel(String location) {
//        // Here you can implement the real logic to calculate the water's pH
//        // In this example, we will return a random value between 0 and 14
//        return (float) (Math.random() * 14);
//    }
//
//    public static void main(String[] args) throws Exception {
//        // Starting gRPC server
//        Server server = ServerBuilder.forPort(9090)
//                .addService(new PHLevelMeterService())
//                .build();
//
//        server.start();
//        System.out.println("gRPC Server started on port 9090");
//
//        // Waiting for server termination
//        server.awaitTermination();
//    }
//}

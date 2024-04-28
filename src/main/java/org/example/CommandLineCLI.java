
package org.example;
import java.util.Scanner;

public class CommandLineCLI {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        String choice;
        do {
            System.out.println("Choose an option:");
            System.out.println("1. Get pH level");
            System.out.println("2. Get air quality index");
            System.out.println("3. Get solar radiation level");

            choice = scanner.next();

            switch (choice) {
                case "1":
                    runPHLevelMeterClient(); //Get the PH level
                    break;
                case "2":
                    runAirQualityClient(); //Get the air quality index
                    break;
                case "3":
                    runSolarRadiationClient(); //Get the solar radiation
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                    choice = null; // Here Reset choice in order to repeat the loop
            }

            if (choice != null) {
                System.out.print("Do you want to check another information? (yes/no): ");
            }
        } while (choice == null || scanner.next().equalsIgnoreCase("yes"));

        scanner.close(); //closing scanner as a good practice.
    }

    private static void runPHLevelMeterClient() throws InterruptedException {
        PHLevelMeterClient client = new PHLevelMeterClient("localhost", 9090);
        client.getPhLevel("Some Location");
        client.shutdown(); //Getting the pH level
    }

    private static void runAirQualityClient() throws InterruptedException {
        AirQualityClient client = new AirQualityClient("localhost", 9091);
        client.getAirQualityIndex("CO. Dublin");
        client.shutdown();// Getting air quality index
    }

    private static void runSolarRadiationClient() throws InterruptedException {
        SolarRadiationClient client = new SolarRadiationClient("localhost", 9092);
        client.getSolarRadiationLevel("CO. Dublin");
        client.shutdown(); // Getting solar radiation
    }
}

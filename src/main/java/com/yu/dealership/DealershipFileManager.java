package com.yu.dealership;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DealershipFileManager {

    public static String dealershipFileName = "01-DealershipVehicleList";

    //        private final ArrayList<com.yu.dealership.Vehicle> vehiclesList = new ArrayList<>();
    public Dealership getDealership() {
        Dealership anotherDealership = null;
        try {
            // To open the dealership file for reading
            BufferedReader dealershipFileReader = new BufferedReader(new FileReader(dealershipFileName));

            // To extract dealership information (name, address, phone)
            String dealershipInformation = dealershipFileReader.readLine();
            String[] dealershipDetails = dealershipInformation.split("\\|");
            String name = dealershipDetails[0];
            String address = dealershipDetails[1];
            String phone = dealershipDetails[2];

            // Create a new com.yu.dealership.Dealership object with the extracted information
            anotherDealership = new Dealership(name, address, phone);


            // Read the remaining lines of the file containing vehicle information
            String fileLine;
            while ((fileLine = dealershipFileReader.readLine()) != null) {
                if (!fileLine.isEmpty()) {
                    String[] vehicleDetails = fileLine.split("\\|");
                    // Extract vehicle information
                    int vin = Integer.parseInt(vehicleDetails[0]);
                    String color = vehicleDetails[1];
                    String vehicleType = vehicleDetails[2];
                    int year = Integer.parseInt(vehicleDetails[3]);
                    String make = vehicleDetails[4];
                    String model = vehicleDetails[5];
                    int odometer = Integer.parseInt(vehicleDetails[6]);
                    double price = Double.parseDouble(vehicleDetails[7]);
                    // Create a new com.yu.dealership.Vehicle object with the extracted information
                    Vehicle vehicle = new Vehicle(vin, color, vehicleType, year, make, model, odometer, price);
                    // Add the com.yu.dealership.Vehicle object to the com.yu.dealership.Dealership's inventory
                    anotherDealership.addVehicle(vehicle);
                }
            }
            dealershipFileReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return anotherDealership;// Return the newly constructed com.yu.dealership.Dealership object
    }


    public void saveDealership(Dealership anotherDealership) {
        //TODO: Implement logic for saving a new dealership.
        try (FileWriter fileWriter = new FileWriter(dealershipFileName, false)) {
//            List<Vehicle> vehicles = anotherDealership.getAllVehicles();
            //Write first line: Dealership Info
            fileWriter.write(String.format("%s|%s|%s",
                    anotherDealership.getName(),
                    anotherDealership.getAddress(),
                    anotherDealership.getPhone()));

            for (Vehicle vehicle : anotherDealership.getAllVehicles()) {
                String nVehicle =
                        String.format("\n%d|%s|%s|%d|%s|%s|%d|%.2f",
                                vehicle.getVin(),
                                vehicle.getColor(),
                                vehicle.getVehicleType(),
                                vehicle.getYear(),
                                vehicle.getMake(),
                                vehicle.getModel(),
                                vehicle.getOdometer(),
                                vehicle.getPrice());

                fileWriter.write(nVehicle);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

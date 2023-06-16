package com.yu.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List <Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory){
            if (vehicle.getPrice() >= min && vehicle.getPrice()<= max) {
                matchingVehicles.add(vehicle);
            }
        } return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List <Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                matchingVehicles.add(vehicle);
            }
        } return matchingVehicles;
    }
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List <Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max){
                matchingVehicles.add(vehicle);
            }
        } return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List <Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                matchingVehicles.add(vehicle);
            }
        } return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List <Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                matchingVehicles.add(vehicle);
            }
        } return matchingVehicles;

    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List <Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                matchingVehicles.add(vehicle);
            }
        } return matchingVehicles;

    }

    public Vehicle getVehiclesByVin(int vin) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vin) {
                return vehicle;
            }
        }
        return null; // Vehicle with the specified VIN was not found
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle anotherVehicle) {
        inventory.add(anotherVehicle);
    }

    public void removeVehicle(Vehicle anotherVehicle) {
        inventory.remove(anotherVehicle);
    }

}

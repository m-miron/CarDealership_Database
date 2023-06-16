package com.yu.dealership;

public class Vehicle {
    private int vin;
    private String color;
    private String vehicleType;
    private int year;
    private String make;
    private String model;
    private int odometer;
    private double price;

    public Vehicle(int vin, String color, String vehicleType, int year, String make, String model, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }

    public String vehicleListFormat() {
        return String.format("%-15d %-15s %-15s %-15d %-15s %-15s %-15d %-25.2f",
        vin, color, vehicleType, year, make, model, odometer, price);
    }

}

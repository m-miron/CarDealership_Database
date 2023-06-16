package com.yu.dealership;

public abstract class Contract {
    private String contractDate;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;

    public Contract(String contractDate, String customerName, String customerEmail, Vehicle vehicle) {
        this.contractDate = contractDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    public String getContractDate() {
        return contractDate;
    }

    public String getCustomerName() {

        return customerName;
    }

    public String getCustomerEmail() {

        return customerEmail;
    }

    public Vehicle getVehicle() {

        return vehicle;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

    public abstract String getPersistentString();

}

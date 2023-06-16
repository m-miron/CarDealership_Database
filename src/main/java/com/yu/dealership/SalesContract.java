package com.yu.dealership;

import java.text.DecimalFormat;

public class SalesContract extends Contract {
    private double salesTax;
    //private double recordingFee;
    private double processingFee;
    private boolean financed;


    public SalesContract(String contractDate, String customerName, String customerEmail, Vehicle vehicle) {
        super(contractDate, customerName, customerEmail, vehicle);
    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getRecordingFee() {
        return 100;
    }

    public double getProcessingFee() {

        return processingFee;
    }

    public boolean isFinanced() {
        return financed;
    }

    @Override
    public double getTotalPrice() {

        double totalPrice;
        double vehiclePrice = getVehicle().getPrice();
        salesTax = vehiclePrice * 0.05;
        if ((vehiclePrice < 10000)) {

            totalPrice = vehiclePrice + 295;
            processingFee = 295;
        } else {
            totalPrice = vehiclePrice + 495;
            processingFee = 495;
        }
        totalPrice = totalPrice + getRecordingFee();
        totalPrice = totalPrice + (vehiclePrice * 0.05);
        return totalPrice;

    }

    @Override
    public double getMonthlyPayment() {
        double vehiclePrice = getVehicle().getPrice();
        double p;
        p = vehiclePrice;
        double r;
        double n;
        double t;
        double payment;
        if (financed = true) {
            if (vehiclePrice >= 10000) {
                r = 0.0425;
                t = 4;
                n = 12;
            } else {
                r = 0.0525;
                t = 2;
                n = 12;
            }

            double rOverN = r / n;
            double numerator = p * rOverN;
            double onePlusROverN = 1 + rOverN;
            double power = -t * n;
            double denominator = 1 - Math.pow(onePlusROverN, power);
            payment = numerator / denominator;
        } else {
            payment = 0.00;
        }
        return payment;
    }

    @Override
    public String getPersistentString() {
        DecimalFormat df = new DecimalFormat(".00");
        StringBuilder sb = new StringBuilder();

        sb.append("SALE|")
                .append(getContractDate()).append("|")
                .append(getCustomerName()).append("|")
                .append(getCustomerEmail()).append("|")
                .append(getVehicle()).append("|")
                .append(df.format(getSalesTax())).append("|")
                .append(df.format(getRecordingFee())).append("|")
                .append(df.format(getProcessingFee())).append("|")
                .append(df.format(getTotalPrice())).append("|")
                .append(isFinanced() ? "Y" : "N").append("|")
                .append(df.format(getMonthlyPayment()));
        return sb.toString();
    }
}

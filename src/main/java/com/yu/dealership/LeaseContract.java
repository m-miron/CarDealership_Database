package com.yu.dealership;

import java.text.DecimalFormat;

public class LeaseContract extends Contract {

    public LeaseContract(String contractDate, String customerName, String customerEmail, Vehicle vehicle) {
        super(contractDate, customerName, customerEmail, vehicle);
    }
    double getExpectedEndValue(){
        double vehiclePrice = getVehicle().getPrice();
        double expectedEndValue = vehiclePrice / 2;
        return expectedEndValue;
    }
    double getLeaseFee(){
        double vehiclePrice = getVehicle().getPrice();
        double leaseFee = vehiclePrice * .07;
        return leaseFee;
    }

    double getEndValuePlusLeaseFee(){
        double endValue = getExpectedEndValue();
        double leaseFee = getLeaseFee();
        return endValue + leaseFee;
    }

    @Override
    public double getTotalPrice() {
        double vehiclePrice = getVehicle().getPrice();
        return vehiclePrice;
    }

    @Override
    public double getMonthlyPayment() {
        double vehiclePrice = getVehicle().getPrice();
        double p;
        p = vehiclePrice;
        double r = 0.04;
        double n = 12;
        double t = 3;
        double payment;

        double rOverN = r / n;
        double numerator = p * rOverN;
        double onePlusROverN = 1 + rOverN;
        double power = -t * n;
        double denominator = 1 - Math.pow(onePlusROverN, power);
            payment = numerator / denominator;

        return payment;
    }

    @Override
    public String getPersistentString() {
        DecimalFormat df = new DecimalFormat(".00");
        StringBuilder sb = new StringBuilder();

        sb.append("LEASE|")
                .append(getContractDate()).append("|")
                .append(getCustomerName()).append("|")
                .append(getCustomerEmail()).append("|")
                .append(getVehicle()).append("|")
                .append(df.format(getExpectedEndValue())).append("|")
                .append(df.format(getLeaseFee())).append("|")
                .append(df.format(getEndValuePlusLeaseFee())).append("|")
                .append(df.format(getMonthlyPayment()));
        return sb.toString();
    }
}

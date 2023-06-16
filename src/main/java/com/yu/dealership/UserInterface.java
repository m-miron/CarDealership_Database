package com.yu.dealership;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class UserInterface {


    private Dealership dealership;
    private ContractFileManager contractManager;
    public static Scanner userInput = new Scanner(System.in);


    public void display() {
        init();
        while (true) {
            displayMainMenu();
            return;
        }
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
        contractManager = new ContractFileManager();
    }

    private void displayMainMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("""
                    -------------------- Dealership Menu --------------------\s
                            
                    Welcome! Please enter an option below (number only):
                            
                    1   Vehicles by Price
                    2   Vehicles by Make and Model
                    3   Vehicles by Year
                    4   Vehicles by Color
                    5   Vehicles by Mileage
                    6   Vehicles by Type
                    7   All Vehicles
                    8   Add Vehicle
                    9   Remove Vehicle
                    10  Sell/Lease Vehicle
                    0   Exit  \s
                                    
                    ---------------------------------------------------------\s
                            
                    Go to:  \s""");
            String usersInput = userInput.nextLine();
            switch (usersInput) {
                case "1" -> {
                    processGetByPriceRequest();
                    exit = returnToMenu();
                }
                case "2" -> {
                    processGetByMakeModelRequest();
                    exit = returnToMenu();
                }
                case "3" -> {
                    processGetByYearRequest();
                    exit = returnToMenu();
                }
                case "4" -> {
                    processGetByColorRequest();
                    exit = returnToMenu();
                }
                case "5" -> {
                    processGetByMileageRequest();
                    exit = returnToMenu();
                }
                case "6" -> {
                    processGetByVehicleTypeRequest();
                    exit = returnToMenu();
                }
                case "7" -> {
                    processGetAllVehiclesRequest();
                    exit = returnToMenu();
                }
                case "8" -> {
                    processAddVehicleRequest();
                    exit = returnToMenu();
                }
                case "9" -> {
                    processRemoveVehicleRequest();
                    exit = returnToMenu();
                }
                case "10" -> {
                    processSellOrLeaseRequest();
                    exit = returnToMenu();
                }
                case "0" -> {
                    System.out.println("Good-bye.");
                    exit = true;
                }
                default -> {
                }
            }
        }
    }

    private void processGetByPriceRequest() {
        //TODO: Input logic for for getting vehicles by price
        System.out.println("Enter minimum price: ");
        double minPriceInput = userInput.nextDouble();
        System.out.println("Enter maximum price: ");
        double maxPriceInput = userInput.nextDouble();
        userInput.nextLine();
        horizontalLine();
        String title = "SEARCH BY PRICE";
        titleLine(title, 110);
        headerLine();

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPriceInput, maxPriceInput);
        if (vehicles.isEmpty()) {
            noMatch();
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.vehicleListFormat());
            }
        }
    }

    private void processGetByMakeModelRequest() {
        //TODO: Input logic for getting vehicles by make and model
        System.out.println("Enter make: ");
        String makeInput = userInput.nextLine();
        System.out.println("Enter model: ");
        String modelInput = userInput.nextLine();
        horizontalLine();
        String title = "SEARCH BY MAKE/MODEL";
        titleLine(title, 110);
        headerLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(makeInput, modelInput);
        if (vehicles.isEmpty()) {
            noMatch();
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.vehicleListFormat());
            }
        }
    }

    private void processGetByYearRequest() {
        //TODO: Input logic for getting vehicles by year
        System.out.println("Enter oldest year: ");
        int oldestYearInput = userInput.nextInt();
        System.out.println("Enter newest year: ");
        int newestYearInput = userInput.nextInt();
        userInput.nextLine();
        horizontalLine();
        String title = "SEARCH BY YEAR";
        titleLine(title, 110);
        headerLine();

        List<Vehicle> vehicles = dealership.getVehiclesByYear(oldestYearInput, newestYearInput);
        if (vehicles.isEmpty()) {
            noMatch();
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.vehicleListFormat());
            }
        }
    }

    private void processGetByColorRequest() {
        //TODO: Input logic for getting vehicles by color
        System.out.println("Enter color: ");
        String colorInput = userInput.nextLine();
        horizontalLine();
        String title = "SEARCH BY COLOR";
        titleLine(title, 110);
        headerLine();

        List<Vehicle> vehicles = dealership.getVehiclesByColor(colorInput);
        if (vehicles.isEmpty()) {
            noMatch();
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.vehicleListFormat());
            }
        }
    }

    private void processGetByMileageRequest() {
        //TODO: Input logic for getting vehicles by mileage
        System.out.println("Enter minimum mileage: ");
        int minMileageInput = userInput.nextInt();
        System.out.println("Enter maximum mileage: ");
        int maxMileageInput = userInput.nextInt();
        horizontalLine();
        String title = "SEARCH BY MILEAGE";
        titleLine(title, 110);
        headerLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileageInput, maxMileageInput);
        if (vehicles.isEmpty()) {
            noMatch();
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.vehicleListFormat());
            }
        }
    }

    private void processGetByVehicleTypeRequest() {
        //TODO: Input logic for getting vehicles by vehicle type
        System.out.println("Enter vehicle type: ");
        String vehicleTypeInput = userInput.nextLine();
        horizontalLine();
        String title = "SEARCH BY VEHICLE TYPE";
        titleLine(title, 110);
        headerLine();

        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleTypeInput);
        if (vehicles.isEmpty()) {
            noMatch();
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.vehicleListFormat());
            }
        }
    }

    private void processGetAllVehiclesRequest() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
        //return;
    }

    private void processAddVehicleRequest() {
        //TODO: Input logic for adding a vehicle
        System.out.println("Add a Vehicle: ");

        System.out.print("Enter the 9-digit VIN: ");
        int vinInput = userInput.nextInt();
        userInput.nextLine();

        System.out.print("Enter the color: ");
        String colorInput = userInput.nextLine();

        System.out.print("Enter the vehicle type: ");
        String vehicleTypeInput = userInput.nextLine();

        System.out.print("Enter the year: ");
        int yearInput = userInput.nextInt();
        userInput.nextLine();

        System.out.print("Enter the make: ");
        String makeInput = userInput.nextLine();

        System.out.print("Enter the model: ");
        String modelInput = userInput.nextLine();

        System.out.print("Enter the mileage: ");
        int mileageInput = userInput.nextInt();
        userInput.nextLine();

        System.out.print("Enter the price: ");
        double priceInput = userInput.nextDouble();
        userInput.nextLine();

        Vehicle vehicle = new Vehicle(vinInput, colorInput, vehicleTypeInput, yearInput, makeInput, modelInput, mileageInput, priceInput);
        dealership.addVehicle(vehicle);

        System.out.println("Vehicle added successfully.");
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);
    }

    private void processRemoveVehicleRequest() {
        //TODO: Input logic for removing a vehicle
        System.out.println("To remove a vehicle: enter its VIN.");
        int vin = userInput.nextInt();
        userInput.nextLine();

        Vehicle vehicleEntered = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleEntered = vehicle;
                break;
            }
        }
        if (vehicleEntered != null) {
            dealership.removeVehicle(vehicleEntered);
            System.out.println("Vehicle removed.");
            DealershipFileManager dealershipFileManager = new DealershipFileManager();
            dealershipFileManager.saveDealership(dealership);
        } else {
            noMatch();
        }
    }
    public boolean financed;
    Contract contract;
    private void processSellOrLeaseRequest(){
//        System.out.println("Not Ready. :(");
        contract = null;
        horizontalLine();
        System.out.println("Let's prepare a contract.");

        LocalDate currentDate = java.time.LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String contractDate = currentDate.format(df);

        System.out.print("Enter full name: ");
        String customerName = userInput.nextLine();
        System.out.print("Enter e-mail address: ");
        String customerEmail = userInput.nextLine();

        System.out.println("Leasing or purchasing?");
        String userChoice = userInput.nextLine().toUpperCase();

        if(userChoice.equals("LEASING")) {
            System.out.println("Enter VIN: ");
            Integer vehicleChosen = userInput.nextInt();
            userInput.nextLine();
            Vehicle v = dealership.getVehiclesByVin(vehicleChosen);
            LeaseContract lc = new LeaseContract(contractDate, customerName, customerEmail, v);
            double monthlyPayment = lc.getMonthlyPayment();
            System.out.println("All set. Monthly payment is " + monthlyPayment);
            contractManager.saveContract(lc);
            dealership.removeVehicle(v);
        }
        else {
            System.out.println("Invalid entry.");
        }

//        SalesContract anotherSalesContract = new SalesContract(
//                contract.getContractDate(), contract.getCustomerName(), contract.getCustomerEmail(), contract.getVehicle());
//        String financingChoice;
//        System.out.println("Will you be financing the vehicle? (Y/N)");
//        financingChoice = userInput.nextLine().toUpperCase();
//        financed = financingChoice.equals("Y");
//        double monthlyPayment = anotherSalesContract.getMonthlyPayment();
//        if (financed == true){
//            horizontalLine();
//            System.out.println("Monthly Payment: " + monthlyPayment);
//        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        horizontalLine();
        String title = "ALL VEHICLES";
        titleLine(title, 110);
        headerLine();
        for (Vehicle vehicle : vehicles) {
            String vehiclesListFormat = vehicle.vehicleListFormat();
            System.out.println(vehiclesListFormat);
        }
    }

    private void horizontalLine() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
    }

    private void headerLine() {
        System.out.println("""
                --------------------------------------------------------------------------------------------------------------------------
                 VIN             COLOR          TYPE            YEAR             MAKE           MODEL           MILEAGE         PRICE\s
                --------------------------------------------------------------------------------------------------------------------------\s
                """);
    }

    private void titleLine(String title, int lineLength) {
        int titleLength = title.length();
        int padding = (lineLength - titleLength) / 2;

        System.out.printf("%" + padding + "s%s%" + padding + "s%n", "", title, "");
    }

    private void noMatch() {
        System.out.println("None found.");
        returnToMenu();
    }

    private boolean returnToMenu() {
        horizontalLine();
        System.out.println("\nEnter any number when you would like to return to the menu.");
        String usersInput = userInput.nextLine();
        return usersInput.equalsIgnoreCase("");
    }

}


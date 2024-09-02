package GreenPulse.Service;

import GreenPulse.CarbonConsumption;
import GreenPulse.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageCarbonConsumption {
    private Scanner scanner;
    private ManageUser manageUser;
    private List<CarbonConsumption> consumptions;

    public ManageCarbonConsumption(ManageUser manageUser) {
        this.scanner = new Scanner(System.in);
        this.manageUser = manageUser;
        this.consumptions = new ArrayList<>();
    }

    public void createCarbonConsumption(){
        System.out.print("Enter the CIN of the user you want to add a consumption to: ");
        String cin = this.scanner.next();
        if (manageUser.getUsers().containsKey(cin)) {
            User user = this.manageUser.getUser(cin);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.print("enter the value of carbon consumption in kg: ");
            float carbonConsumption = this.scanner.nextFloat();
            System.out.print("enter the start date:");
            String startDate = this.scanner.next();
            LocalDate startDateFormatted = LocalDate.parse(startDate, dateTimeFormatter);
            System.out.print("enter the end date:");
            String endDate = this.scanner.next();
            LocalDate endDateFormatted = LocalDate.parse(endDate, dateTimeFormatter);
            CarbonConsumption consumption = new CarbonConsumption(startDateFormatted, endDateFormatted, carbonConsumption, user);
            user.addCarbonConsumption(consumption);
        }else System.out.println("user does not exist!");
    }

    public void displayUserConsumptions(){
        System.out.print("Enter the CIN of the user you want to add a consumption to: ");
        String cin = scanner.next();
        User user = manageUser.getUsers().get(cin);
        if (user == null) {
            System.out.println("User not found with CIN: " + cin);
        }else {
            List<CarbonConsumption> consumptions = user.getConsumptions();

            if (consumptions == null || consumptions.isEmpty()) {
                System.out.println("No consumptions found for user with CIN: " + cin);
            } else {
                System.out.println("name: " + user.getFirstName() + " " + user.getLastName());
                System.out.println("age: " + user.getAge());
                for (CarbonConsumption consumption : consumptions) {
                    System.out.println("carbon consumption: " + consumption.getCarbon() + "kg" + " from: " + consumption.getStartDate() + " to: " + consumption.getEndDate());
                }
            }
        }
    }
}

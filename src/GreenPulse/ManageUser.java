package GreenPulse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ManageUser {
    private HashMap<String, User> users;
    private Scanner scanner;
    private List<CarbonConsumption> consumptions;

    public ManageUser() {
        users = new HashMap<String, User>();
        scanner = new Scanner(System.in);
    }

    public void createUser(){
        System.out.print("enter the cin: ");
        String cin = this.scanner.next();
        this.scanner.nextLine();
        if (!users.containsKey(cin)){
            System.out.print("enter the first name: ");
            String name = this.scanner.nextLine();
            System.out.print("enter the last name: ");
            String lastName = scanner.nextLine();
            System.out.print("enter the age: ");
            int age = scanner.nextInt();
            User user = new User(cin, name, lastName, age);
            users.put(user.getCin(), user);
            System.out.println("the user has been created successfully!");
        }else System.out.println("user already exists");

    }
    public void updateUser(){
        System.out.println("enter the cin: ");
        String cin = scanner.next();
        this.scanner.nextLine();
        if (users.containsKey(cin)){
            User user = users.get(cin);
//            System.out.print("enter the cin: ");
//            user.setCin(scanner.next());
            System.out.print("enter the first name: ");
            user.setFirstName(scanner.nextLine());
            System.out.print("enter the last name: ");
            user.setLastName(scanner.nextLine());
            System.out.print("enter the age: ");
            user.setAge(scanner.nextInt());
//            users.put(user.getCin(), user);
            System.out.println("the user has been created successfully!");
        }else System.out.println("user does not exist");
    }

    public void deleteUser(){
        System.out.println("enter the cin: ");
        String cin = scanner.next();
        if (users.containsKey(cin)){
            users.remove(cin);
            System.out.println("the user has been removed successfully!");
        }else System.out.println("user does not exist");
    }

    public void displayUsers(){
        for (String i : users.keySet()) {
            System.out.println(users.get(i));
        }
    }

    public void manageConsumption(){
        System.out.print("Enter the CIN of the user you want to add a consumption to: ");
        String cin = scanner.next();
        User user = users.get(cin);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("enter the value of carbon consumption in kg: ");
        Float carbonConsumption = this.scanner.nextFloat();
        System.out.print("enter the start date:");
        String startDate = this.scanner.next();
        LocalDate startDateFormatted = LocalDate.parse(startDate, dateTimeFormatter);
        System.out.print("enter the end date:");
        String endDate = this.scanner.next();
        LocalDate endDateFormatted = LocalDate.parse(endDate, dateTimeFormatter);
        CarbonConsumption consumption = new CarbonConsumption(startDateFormatted, endDateFormatted, carbonConsumption, user);
        user.addConsumption(consumption);
    }

    public void displayUserConsumptions(){
        System.out.print("Enter the CIN of the user you want to add a consumption to: ");
        String cin = scanner.next();
        User user = users.get(cin);
        if (user == null) {
            System.out.println("User not found with CIN: " + cin);
        }else {
            List<CarbonConsumption> consumptions = user.getConsumptions();

            if (consumptions == null || consumptions.isEmpty()) {
                System.out.println("No consumptions found for user with CIN: " + cin);
            } else {
                for (CarbonConsumption consumption : consumptions) {
                    System.out.println("carbon consumption: " + consumption.getCarbon() + "kg" + " from: " + consumption.getStartDate() + " to: " + consumption.getEndDate());
                }
            }
        }
    }


}

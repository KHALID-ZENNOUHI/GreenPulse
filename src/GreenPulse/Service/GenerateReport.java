package GreenPulse.Service;

import GreenPulse.CarbonConsumption;
import GreenPulse.User;

import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class GenerateReport {
    private Scanner scanner;
    private ManageUser manageUser;

    public GenerateReport(ManageUser manageUser) {
        this.scanner = new Scanner(System.in);
        this.manageUser = manageUser;
    }

    public long calculateTotalOfDays(User user) {
        long totalOfDays = 0;
            for (CarbonConsumption consumption : user.getConsumptions()) {
                totalOfDays += ChronoUnit.DAYS.between(consumption.getStartDate(), consumption.getEndDate());
            }
        return totalOfDays;
    }

    public float calculateTotalCarbonConsumption(User user) {
      float totalCarbonConsumption = 0;
        for (CarbonConsumption consumption : user.getConsumptions()) totalCarbonConsumption += (float) consumption.getCarbon();
        return totalCarbonConsumption;
    }

    public void displayReport() {
        System.out.print("enter the cin of the user you want there report: ");
        String cin = this.scanner.next();
        if (this.manageUser.getUsers().containsKey(cin)) {
            User user = this.manageUser.getUser(cin);
            double dailyCarbonConsumption = this.calculateTotalCarbonConsumption(user) / this.calculateTotalOfDays(user);
            System.out.println("Daily Carbon Consumption of : " + user.getFirstName() + " " + user.getLastName() + " is :" + dailyCarbonConsumption);
            double monthlyCarbonConsumption = this.calculateTotalCarbonConsumption(user) / ((double) this.calculateTotalOfDays(user) / 30);
            System.out.println("Month Carbon Consumption of : " + user.getFirstName() + user.getLastName() + " is :" + monthlyCarbonConsumption);
            double yearlyCarbonConsumption = this.calculateTotalCarbonConsumption(user) / ((double) this.calculateTotalOfDays(user) / 365);
            System.out.println("Month Carbon Consumption of : " + user.getFirstName() + " " + user.getLastName() + " is :" + yearlyCarbonConsumption);

        }else System.out.println("User not found with CIN: " + cin);
    }




}

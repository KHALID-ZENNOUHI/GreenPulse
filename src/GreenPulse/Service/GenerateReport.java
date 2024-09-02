package GreenPulse;

import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class GenerateReport {
    private Scanner scanner;
    private ManageUser manageUser;

    public GenerateReport() {
        this.scanner = new Scanner(System.in);
        this.manageUser = new ManageUser();
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
        String cin = this.scanner.nextLine();
        double dailyCarbonConsumption = 0;
        double monthlyCarbonConsumption = 0;
        double yearlyCarbonConsumption = 0;
        if (this.manageUser.getUsers().containsKey(cin)) {
            User user = this.manageUser.getUser(cin);
            dailyCarbonConsumption = this.calculateTotalCarbonConsumption(user) / this.calculateTotalOfDays(user);
            System.out.println("Daily Carbon Consumption of : " + user.getFirstName() + user.getLastName() + "is :" + dailyCarbonConsumption);
            monthlyCarbonConsumption = this.calculateTotalCarbonConsumption(user) / ((double) this.calculateTotalOfDays(user) / 30);
            System.out.println("Month Carbon Consumption of : " + user.getFirstName() + user.getLastName() + "is :" + monthlyCarbonConsumption);
            yearlyCarbonConsumption = this.calculateTotalCarbonConsumption(user) / ((double) this.calculateTotalOfDays(user) / 365);
            System.out.println("Month Carbon Consumption of : " + user.getFirstName() + user.getLastName() + "is :" + yearlyCarbonConsumption);

        }
    }




}

package GreenPulse;

import GreenPulse.Service.GenerateReport;
import GreenPulse.Service.ManageCarbonConsumption;
import GreenPulse.Service.ManageUser;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ManageUser userManager = new ManageUser();
        GenerateReport report = new GenerateReport();
        ManageCarbonConsumption carbonConsumptionManager = new ManageCarbonConsumption();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("<--------Carbon Consumption Management-------->");
            System.out.println("choice one of those:");
            System.out.print("    -> 1. Create new user:\n" +
                            "    -> 2. Update user:\n" +
                            "    -> 3. Delete user:\n" +
                            "    -> 4. Display users:\n" +
                            "    -> 5. Add consumption:\n" +
                            "    -> 6. Display user consumption:\n" +
                            "    -> 7. Show user carbon consumption reports:\n" +
                            "    -> 7. Exit\n");
            System.out.print("enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    userManager.createUser();
                    break;
                case 2:
                    userManager.updateUser();
                    break;
                case 3:
                    userManager.deleteUser();
                    break;
                case 4:
                    userManager.displayUsers();
                    break;
                case 5:
                    carbonConsumptionManager.createCarbonConsumption();
                    break;
                case 6:
                    carbonConsumptionManager.displayUserConsumptions();
                    break;
                case 7:
                    report.displayReport();
                case 8:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid choice");
            }
        }
    }


}

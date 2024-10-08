package GreenPulse;

import GreenPulse.Config.DataBaseConnection;
import GreenPulse.Entity.*;
import GreenPulse.Repository.CarbonConsumptionRepository;
import GreenPulse.Repository.UserRepository;
//import GreenPulse.Service.GenerateReport;
import GreenPulse.Service.CarbonConsumptionService;
import GreenPulse.Service.UserService;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
//        GenerateReport report = new GenerateReport(userManager);
        Scanner scanner = new Scanner(System.in);
        Transport transport = new Transport(LocalDate.of(2024, 9, 10), LocalDate.of(2024, 9, 15), 100, CarbonConsumptionType.Transport, 1, 70.9, TransportType.Car);
        CarbonConsumptionService carbonConsumptionService = new CarbonConsumptionService();
        carbonConsumptionService.saveTransport(transport);









//        while (true){
//            System.out.println("<--------Carbon Consumption Management-------->");
//            System.out.println("choice one of those:");
//            System.out.print("    -> 1. Create new user:\n" +
//                            "    -> 2. Update user:\n" +
//                            "    -> 3. Delete user:\n" +
//                            "    -> 4. Display users:\n" +
//                            "    -> 5. Add consumption:\n" +
//                            "    -> 6. Display user consumption:\n" +
//                            "    -> 7. Show user carbon consumption reports:\n" +
//                            "    -> 8. Exit\n");
//            System.out.print("enter your choice: ");
//            int choice = scanner.nextInt();
//            switch (choice){
//                case 1:
//                    userManager.createUser();
//                    break;
//                case 2:
//                    userManager.updateUser();
//                    break;
//                case 3:
//                    userManager.deleteUser();
//                    break;
//                case 4:
//                    userManager.displayUsers();
//                    break;
//                case 5:
//                    carbonConsumptionManager.createCarbonConsumption();
//                    break;
//                case 6:
//                    carbonConsumptionManager.displayUserConsumptions();
//                    break;
//                case 7:
//                    report.displayReport();
//                    break;
//                case 8:
//                    scanner.close();
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("invalid choice");
//            }
//        }
    }


}

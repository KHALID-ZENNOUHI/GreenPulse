package GreenPulse;

import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ManageUser userManager = new ManageUser();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("choice one of those:");
            System.out.print("    -> 1. Create new user:\n" +
                            "    -> 2. Update user:\n" +
                            "    -> 3. Delete user:\n" +
                            "    -> 4. Display users:\n" +
                            "    -> 5. Add consumption:\n" +
                            "    -> 6. Display user consumption:\n" +
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
                    userManager.manageConsumption();
                    break;
                case 6:
                    userManager.displayUserConsumptions();
                    break;
                case 7:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid choice");
            }
        }
    }


}

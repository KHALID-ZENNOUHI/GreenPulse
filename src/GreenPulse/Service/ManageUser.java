package GreenPulse.Service;

import GreenPulse.CarbonConsumption;
import GreenPulse.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ManageUser {
    private HashMap<String, User> users;
    private Scanner scanner;


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





    public User getUser(String cin){
        return users.get(cin);
    }

    public HashMap<String, User> getUsers() {
        return users;
    }


}

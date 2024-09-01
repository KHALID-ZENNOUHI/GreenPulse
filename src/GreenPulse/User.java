package GreenPulse;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String cin;
    private String firstName;
    private String lastName;
    private int age;
    private List<CarbonConsumption> consumptions;
//    private List<Report> reports;

    public User(String cin, String firstName, String lastName, int age) {
        this.cin = cin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public User() {

    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<CarbonConsumption> getConsumptions() {
        return consumptions;
    }
//
//    public void setConsumptions(List<Consumption> consumptions) {
//        if (consumptions == null) {
//            this.consumptions = new ArrayList<Consumption>();
//        }
//    }

    public void addConsumption(CarbonConsumption consumption) {
        if (consumptions == null) {
            consumptions = new ArrayList<CarbonConsumption>();
        }
        this.consumptions.add(consumption);
    }

    @Override
    public String toString() {
        return "User{" +
                "cin=" + cin +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

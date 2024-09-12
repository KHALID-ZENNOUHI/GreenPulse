//package GreenPulse.Service;
//
//import GreenPulse.Entity.CarbonConsumption;
//import GreenPulse.Entity.User;
//import GreenPulse.Util.Date;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class ManageCarbonConsumption {
//    private Scanner scanner;
//    private UserService userService;
//    private List<CarbonConsumption> consumptions;
//    private
//
//    public ManageCarbonConsumption(UserService userService) {
//        this.scanner = new Scanner(System.in);
//        this.userService = userService;
//        this.consumptions = new ArrayList<>();
//    }
//
//    public void createCarbonConsumption(){
//        System.out.print("Enter the CIN of the user you want to add a consumption to: ");
//        String cin = this.scanner.next();
//        if (userService.getUsers().containsKey(cin)) {
//            User user = this.userService.getUser(cin);
//            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            System.out.print("enter the value of carbon consumption in kg: ");
//            float carbonConsumption = this.scanner.nextFloat();
//            System.out.print("enter the start date:");
//            String startDate = this.scanner.next();
//            LocalDate startDateFormatted = LocalDate.parse(startDate, dateTimeFormatter);
//            System.out.print("enter the end date:");
//            String endDate = this.scanner.next();
//            LocalDate endDateFormatted = LocalDate.parse(endDate, dateTimeFormatter);
//
//            if (Date.isAvailableDate(startDateFormatted, endDateFormatted, ListOfDate(user.getConsumptions()))){
//                CarbonConsumption newConsumption = new CarbonConsumption(startDateFormatted, endDateFormatted, carbonConsumption, user);
//                user.addCarbonConsumption(newConsumption);
//            }else System.out.println("You entered an interval of date who's exist!");
////          this.checkIfPeriodExistInConsumptions(user, startDateFormatted, endDateFormatted, carbonConsumption);
//        }else System.out.println("user does not exist!");
//    }
//
//    public void displayUserConsumptions(){
//        System.out.print("Enter the CIN of the user you want to add a consumption to: ");
//        String cin = scanner.next();
//        User user = userService.getUsers().get(cin);
//        if (user == null) {
//            System.out.println("User not found with CIN: " + cin);
//        }else {
//            List<CarbonConsumption> consumptions = user.getConsumptions();
//
//            if (consumptions == null || consumptions.isEmpty()) {
//                System.out.println("No consumptions found for user with CIN: " + cin);
//            } else {
//                System.out.println("name: " + user.getFirstName() + " " + user.getLastName());
//                System.out.println("age: " + user.getAge());
//                for (CarbonConsumption consumption : consumptions) {
//                    System.out.println("carbon consumption: " + consumption.getCarbon() + "kg" + " from: " + consumption.getStartDate() + " to: " + consumption.getEndDate());
//                }
//            }
//        }
//    }
//
//    public List<LocalDate> ListOfDate(List<CarbonConsumption> consumptions) {
//        List<LocalDate> dates = new ArrayList<>();
//        if (consumptions == null || consumptions.isEmpty()) {
//            return dates;
//        }else {
//            for (CarbonConsumption consumption : consumptions) {
//                for (LocalDate date = consumption.getStartDate(); !date.isAfter(consumption.getEndDate()); date = date.plusDays(1)) {
//                    dates.add(date);
//                }
//            }
//        }
//        return dates;
//    }
//
////    public void checkIfPeriodExistInConsumptions(User user, LocalDate startDate, LocalDate endDate, Float carbonConsumption){
////        for (CarbonConsumption consumption : consumptions) {
////            if (startDate.equals(consumption.getStartDate()) || startDate.isAfter(consumption.getStartDate()) && endDate.equals(consumption.getEndDate()) || endDate.isBefore(consumption.getEndDate())) {
////                LocalDate newStartDate =  startDate.isAfter(consumption.getEndDate()) ? startDate : consumption.getEndDate();
////                LocalDate newEndDate = endDate.isBefore(consumption.getEndDate()) ? endDate : consumption.getEndDate();
////                consumption.setStartDate(newStartDate);
////                consumption.setEndDate(newEndDate);
////                consumption.setCarbon(consumption.getCarbon() + carbonConsumption);
////            }else {
////                CarbonConsumption newConsumption = new CarbonConsumption(startDate, endDate, carbonConsumption, user);
////                user.addCarbonConsumption(newConsumption);
////            }
////        }
////    }
//}

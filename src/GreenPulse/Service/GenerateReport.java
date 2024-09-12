//package GreenPulse.Service;
//
//import GreenPulse.Entity.CarbonConsumption;
//import GreenPulse.Entity.User;
//
//import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;
//import java.time.temporal.WeekFields;
//import java.util.HashMap;
//import java.util.Locale;
//import java.util.Map;
//import java.util.Scanner;
//
//public class GenerateReport {
//    private Scanner scanner;
//    private UserService userService;
//
//    public GenerateReport(UserService userService) {
//        this.scanner = new Scanner(System.in);
//        this.userService = userService;
//    }
//
//    public long calculateTotalOfDays(User user) {
//        long totalOfDays = 0;
//            for (CarbonConsumption consumption : user.getConsumptions()) {
//                totalOfDays += ChronoUnit.DAYS.between(consumption.getStartDate(), consumption.getEndDate());
//            }
//        return totalOfDays;
//    }
//
//    public float calculateTotalCarbonConsumption(User user) {
//      float totalCarbonConsumption = 0;
//        for (CarbonConsumption consumption : user.getConsumptions()) totalCarbonConsumption +=  consumption.getCarbon();
//        return totalCarbonConsumption;
//    }
//
//    public void displayReport() {
//        System.out.print("enter the cin of the user you want there report: ");
//        String cin = this.scanner.next();
//        if (this.userService.getUsers().containsKey(cin)) {
//            User user = this.userService.getUser(cin);
//            System.out.println("The total carbon consumption is: " + calculateTotalCarbonConsumption(user));
//            this.dailyCarbonConsumption(user);
//            this.weeklyCarbonConsumption(user);
//            this.monthlyCarbonConsumption(user);
//        }else System.out.println("User not found with CIN: " + cin);
//    }
//
//    public void dailyCarbonConsumption(User user){
//
//        for (CarbonConsumption consumption : user.getConsumptions()) {
//            LocalDate startDate = consumption.getStartDate();
//            LocalDate endDate = consumption.getEndDate();
//
//            // Calculate the number of days in the period
//            long daysInPeriod = startDate.until(endDate, ChronoUnit.DAYS) + 1; // +1 to include both start and end dates
//
//            // Calculate the daily carbon consumption for this period
//            Float totalCarbonConsumption = consumption.getCarbon();
//            Float dailyCarbonConsumption = totalCarbonConsumption / daysInPeriod;
//
//            // Print the daily carbon consumption for this period
//            System.out.println("Daily carbon consumption from " + startDate + " to " + endDate + " is: " + dailyCarbonConsumption);
//        }
//    }
//
//    public void weeklyCarbonConsumption(User user) {
//        Map<String, Float> weeklyConsumptionMap = new HashMap<>();
//        WeekFields weekFields = WeekFields.of(Locale.getDefault());
//
//
//        for (CarbonConsumption consumption : user.getConsumptions()) {
//            LocalDate startDate = consumption.getStartDate();
//            LocalDate endDate = consumption.getEndDate();
//
//            // Calculate the number of days in the period
//            long daysInPeriod = startDate.until(endDate, ChronoUnit.DAYS) + 1; // +1 to include both start and end dates
//
//            // Calculate the daily carbon consumption for this period
//            Float totalCarbonConsumption = consumption.getCarbon();
//            Float dailyCarbonConsumption = totalCarbonConsumption / daysInPeriod;
//
//            // Accumulate weekly carbon consumption
//            for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
//                int weekOfYear = date.get(weekFields.weekOfWeekBasedYear());
//                String yearAndWeek = date.getYear() + "-W" + weekOfYear;
//
//                weeklyConsumptionMap.put(yearAndWeek,
//                        weeklyConsumptionMap.getOrDefault(yearAndWeek, 0.0f) + dailyCarbonConsumption);
//            }
//        }
//
//        // Print the weekly carbon consumption
//        for (Map.Entry<String, Float> entry : weeklyConsumptionMap.entrySet()) {
//            System.out.println("Weekly carbon consumption for " + entry.getKey() + " is: " + entry.getValue());
//        }
//
////        return weeklyConsumptionMap;
//    }
//
//    public void monthlyCarbonConsumption(User user) {
//        Map<String, Float> monthlyConsumptionMap = new HashMap<>();
//
//        for (CarbonConsumption consumption : user.getConsumptions()) {
//            LocalDate startDate = consumption.getStartDate();
//            LocalDate endDate = consumption.getEndDate();
//
//            // Calculate the number of days in the period
//            long daysInPeriod = startDate.until(endDate, ChronoUnit.DAYS) + 1;
//
//            // Calculate the daily carbon consumption for this period
//            Float totalCarbonConsumption = consumption.getCarbon();
//            Float dailyCarbonConsumption = totalCarbonConsumption / daysInPeriod;
//
//            // Accumulate monthly carbon consumption
//            for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
//                String yearAndMonth = date.getYear() + "-" + String.format("%02d", date.getMonthValue());
//
//                monthlyConsumptionMap.put(yearAndMonth,
//                        monthlyConsumptionMap.getOrDefault(yearAndMonth, 0.0f) + dailyCarbonConsumption);
//            }
//        }
//
//        // Print the monthly carbon consumption
//        for (Map.Entry<String, Float> entry : monthlyConsumptionMap.entrySet()) {
//            System.out.println("Monthly carbon consumption for " + entry.getKey() + " is: " + entry.getValue());
//        }
//
////        return monthlyConsumptionMap;
//    }
//
//
//
//
//
//
//}

package GreenPulse.Util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Date {

    public static boolean isAvailableDate(LocalDate startDate, LocalDate endDate, List<LocalDate> listOfDates) {
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)){
            if (listOfDates.contains(date)){
                return false;
            }
        }
        return true;
    }

    public static List<LocalDate> periodToDates(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> listOfDates = new ArrayList<>();
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)){
            listOfDates.add(date);
        }
        return listOfDates;
    }
}

package utility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.time.*;
import java.util.TimeZone;

import static java.time.ZoneOffset.UTC;

public class Time {
    public static ZonedDateTime businessStart = ZonedDateTime.of(LocalDate.now(),LocalTime.of(8,0),ZoneId.of("America/New_York"));
    public static ZonedDateTime businessEnd = ZonedDateTime.of(LocalDate.now(),LocalTime.of(22,0),ZoneId.of("America/New_York"));
    public static ZoneId est = ZoneId.of("America/New_York");
    public static ZoneId localID = ZoneId.of(TimeZone.getDefault().getID());
    public static LocalTime convertTime(LocalTime lt, ZoneId current, ZoneId converted){
        ZonedDateTime zdt = ZonedDateTime.of(LocalDate.now(),lt,current);
        ZonedDateTime convertedZDT = zdt.withZoneSameInstant(converted);
        LocalTime newTime = convertedZDT.toLocalTime();
        return newTime;
    }

    public static ObservableList<LocalTime> getBusinessHours(){
        ZonedDateTime startLocal = businessStart.withZoneSameInstant(localID);
        ZonedDateTime endLocal = businessEnd.withZoneSameInstant(localID);
        LocalDateTime start = startLocal.toLocalDateTime();
        LocalDateTime end = endLocal.toLocalDateTime();
        ObservableList<LocalTime> businessHours = FXCollections.observableArrayList();
        while (start.isBefore(end.plusSeconds(1))){
            businessHours.add(start.toLocalTime());
            start = start.plusMinutes(15);
        } return businessHours;
    }

    public static ObservableList getTime(){
        ObservableList<LocalTime> businessHours = FXCollections.observableArrayList();
        LocalTime start = LocalTime.of(5, 0);
        LocalTime end = LocalTime.of(23,0);
        while (start.isBefore(end.plusSeconds(1))){
            businessHours.add(start);
            start = start.plusMinutes(15);
        }
            return businessHours;
    }
    public static int lookupTime(LocalTime time) {
        int index = 0;
        System.out.println(time);
        ObservableList allTime = getTime();
        for (int i = 0; i < allTime.size(); i++) {
            Object t = allTime.get(i);
            if (t.toString().contains(time.toString())) {
                index = allTime.indexOf(t);
            }
        } return index;
    }
    public static LocalDateTime combineDateTime(DatePicker d, ComboBox t){
        LocalDate ld = d.getValue();
        LocalTime lt = LocalTime.parse(t.getValue().toString());
        return LocalDateTime.of(ld,lt);
    }
    public static boolean getMonth(LocalDateTime ldt){
        LocalDate now = LocalDate.now();
        LocalDate month = now.plusMonths(1);
        LocalDate chkDate = ldt.toLocalDate();
        return chkDate.isAfter(now) && chkDate.isBefore(month);
    }
    public static boolean getWeek(LocalDateTime ldt){
        LocalDate now = LocalDate.now();
        LocalDate week = now.plusDays(7);
        LocalDate chkDate = ldt.toLocalDate();
        return chkDate.isAfter(now) && chkDate.isBefore(week);
    }
}

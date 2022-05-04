package utility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.time.*;

public class Time {
    public static ObservableList getTime(){
        ObservableList<LocalTime> businessHours = FXCollections.observableArrayList();
        LocalTime start = LocalTime.of(5, 0);
        LocalTime end = LocalTime.of(23,0);
        while (start.isBefore(end.plusSeconds(1))){
            businessHours.add(start);
            start = start.plusMinutes(15);
        } return businessHours;
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

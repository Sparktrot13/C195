package utility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.Contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public static ObservableList getTime(){
        ObservableList businessHours = FXCollections.observableArrayList();
        LocalTime start = LocalTime.of(5, 00);
        LocalTime end = LocalTime.of(23,00);
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
        LocalDateTime ldt = LocalDateTime.of(ld,lt);
        return ldt;
    }
}

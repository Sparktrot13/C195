package utility;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.xml.crypto.Data;
import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


import static utility.Utility.*;

public class Validator {

    public static void chkBlank(TextField t, String s){
        if (t.getText().isBlank()){
            errors.add(s);
        }
    }
    public static boolean chkDatePicker(DatePicker dp) {
       if(dp.getValue() == null){
           return false;
       } else {
           return true;
       }
    }
    public static boolean chkComboBoxBlank(ComboBox c){
        if (c.getSelectionModel().isEmpty()){
            return false;
        } else{
            return true;
        }
    }

    public static void chkDate(Timestamp start, Timestamp end){
        LocalDateTime st = start.toLocalDateTime();
        LocalDateTime et = end.toLocalDateTime();
        if (st.isAfter(et)){
            errors.add(chkDateInv);
            //alert(alertType.error,chkDateInv,chkDateTitle);
        }
    }
    public static void chkAppointments(DatePicker start, DatePicker end,ComboBox st, ComboBox et){
        errors.clear();
        if (!chkDatePicker(start)){
            errors.add(startDateBlank+"\n");
            if (!chkDatePicker(end)){
                errors.add(endDateBlank+"\n");
            }
            throw new NumberFormatException("Date Null");
        } else {
            System.out.println("Date Good");
        }
        if (!chkComboBoxBlank(st)){
            errors.add(startTimeBlank);
            if(!chkComboBoxBlank(et)){
                errors.add(endTimeBlank);
            }
            throw new NumberFormatException("Time null");
        } else {
            System.out.println("Time Good");
        }
    }
}

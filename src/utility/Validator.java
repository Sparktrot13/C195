package utility;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;


import static utility.Utility.*;

public class Validator {
    public static void chkBlank(TextField t, String s){
        if (t.getText().isBlank()){
            errors.add(s);
        }
    }
    public static void chkDatePicker(DatePicker dp, String s){
        if(dp.toString().isBlank()){
            errors.add(s);
        }
    }
    public static void chkComboBoxBlank(ComboBox c, String s){
        if (c.getSelectionModel().isEmpty()){
            errors.add(s);
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
}

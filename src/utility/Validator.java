package utility;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Timestamp;
import java.time.LocalDateTime;


import static utility.Utility.*;

public class Validator {

    public static boolean chkBlank(TextField t){
        if (t.getText().isBlank()){
            return false;
        } else{
            return true;
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
    public static void chkApptBlank(TextField title, TextField des, TextField loc, TextField type, DatePicker start, ComboBox st, DatePicker end, ComboBox et, ComboBox cust, ComboBox user, ComboBox contact){
        errors.clear();
        if (!chkDatePicker(start)){
            errors.add(startDateBlank+"\n");
        }
        if (!chkDatePicker(end)){
            errors.add(endDateBlank+"\n");
        }
        if (!chkComboBoxBlank(st)){
            errors.add(startTimeBlank+"\n");
        }
        if(!chkComboBoxBlank(et)){
            errors.add(endTimeBlank+"\n");
        }
        if(!chkBlank(title)){
            errors.add(titleFieldBlank +"\n");
        }
        if(!chkComboBoxBlank(cust)){
            errors.add(custBoxBlank+"\n");
        }
        if(!chkComboBoxBlank(user)){
            errors.add(userBoxBlank+"\n");
        }
        if(!chkComboBoxBlank(contact)){
            errors.add(contBoxBlank+"\n");
        }
        if(!chkBlank(des)){
            errors.add(desFieldBlank);
        }
        if(!chkBlank(loc)){
            errors.add(locFieldBlank);
        }
        if(!chkBlank(type)){
            errors.add(typeFieldBlank);
        }
        throw new NumberFormatException("Blank fields");
    }
}

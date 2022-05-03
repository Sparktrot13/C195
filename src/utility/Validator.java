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
    public static void chkDate(Timestamp start, Timestamp end, Timestamp now){
        LocalDateTime st = start.toLocalDateTime();
        LocalDateTime et = end.toLocalDateTime();
        LocalDateTime rn = now.toLocalDateTime();
        errors.clear();
        if(rn.isAfter(st)){
            errors.add(chkDateInv2);
            throw new NumberFormatException(chkDateTitle);
        }
        if (st.isAfter(et)){
            errors.add(chkDateInv);
            throw new NumberFormatException(chkDateTitle);
        }
    }
    public static void chkApptBlank(TextField title, TextField des, TextField loc, TextField type, DatePicker start, ComboBox st, DatePicker end, ComboBox et, ComboBox cust, ComboBox contact){
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
        if(!chkComboBoxBlank(contact)){
            errors.add(contBoxBlank+"\n");
        }
        if(!chkBlank(des)){
            errors.add(desFieldBlank+"\n");
        }
        if(!chkBlank(loc)){
            errors.add(locFieldBlank+"\n");
        }
        if(!chkBlank(type)){
            errors.add(typeFieldBlank+"\n");
        }
        if((!chkDatePicker(start))||(!chkDatePicker(end))||(!chkComboBoxBlank(st))||(!chkComboBoxBlank(et))||(!chkComboBoxBlank(cust))||(!chkComboBoxBlank(contact))||(!chkBlank(des))||(!chkBlank(title))||(!chkBlank(loc))||(!chkBlank(type))){
            throw new NumberFormatException("Blank fields");
        }
    }
    public static void chkCustomerBlank(TextField name,TextField address,TextField phone,TextField postal,ComboBox region, ComboBox country){
        errors.clear();
        if(!chkBlank(name)){
            errors.add(custNameBlank+"\n");}
        if(!chkBlank(address)) {
            errors.add(custAddressBlank + "\n");
        }
        if(!chkBlank(phone)) {
            errors.add(custPhoneBlank + "\n");
        }
        if(!chkBlank(postal)) {
            errors.add(custPostalBlank + "\n");
        }
        if(!chkComboBoxBlank(region)) {
            errors.add(regionBoxBlank + "\n");
        }
        if(!chkComboBoxBlank(country)) {
            errors.add(countryBoxBlank + "\n");
        }
        if((!chkBlank(name))||(!chkBlank(address))||(!chkBlank(phone))||(!chkBlank(postal))||(!chkComboBoxBlank(region))||(!chkComboBoxBlank(country))){
            throw new NumberFormatException("Blanks not good");
        }
    }
}

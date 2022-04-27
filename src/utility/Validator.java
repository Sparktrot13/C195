package utility;

import java.awt.*;
import java.time.LocalDateTime;


import static utility.Utility.*;

public class Validator {
    public static void chkBlank(TextField t, Label l){
        if (t.getText().isBlank()){
            errors.add(l.getText().trim());
        }
    }
    public static void chkDate(LocalDateTime start, LocalDateTime end){
        if (start.isAfter(end)){
            errors.add()
            //alert(alertType.error,chkDateInv,chkDateTitle);
        }
    }
}

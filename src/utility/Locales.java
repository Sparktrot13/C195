package utility;

import java.util.Locale;
import java.util.ResourceBundle;

public class Locales {
    Locale en = Locale.ENGLISH;
    Locale fr = Locale.FRENCH;
    public static ResourceBundle bundle(){
        return ResourceBundle.getBundle("utility/propRB", Locale.getDefault());
    }
}

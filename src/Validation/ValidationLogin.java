package Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationLogin {
    public static boolean isValidUsername(String name){

        String regex = "^[A-Za-z][A-Za-z0-9_ ]{2,}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public static boolean isValidPassword(String name){

        String regex = "^[A-Za-z][A-Za-z0-9_ !@#$%^&*~]{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);
        return m.matches();
    }


}

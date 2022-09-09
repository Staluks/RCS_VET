package Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation_LogIn {
    public boolean isValidUsername(String name) {
        String regex = "[a-zA-Z\\d]*";
        Pattern p = Pattern.compile(regex);

        if (name.length() < 6) {
            return false;
        }

        Matcher m = p.matcher(name);
        return m.matches();
    }

    public boolean isValidPassword(String password) {
        String regex = "[A-Za-z\\d@\u0024\u0021\u0023\u0025\u0026\u002A\u005F\u005E\u007E]+";
        Pattern p = Pattern.compile(regex);

        if (password.length() < 8 || password.length() > 20) {
            return false;
        }

        Matcher m = p.matcher(password);
        return m.matches();
    }
}

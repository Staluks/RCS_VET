package Validation;

import java.util.regex.Pattern;

public class Validation_ClinicRegistration {
    String pattern_common1 = "[a-zA-Z\s\\d\u002D]*";
    String pattern_common2 = "[a-zA-Z\\d]*";
    String pattern_email = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    String pattern_phone = "\\d{8,8}$";
    String pattern_password = "[A-Za-z\\d@\u0024\u0021\u0023\u0025\u0026\u002A\u005F\u005E\u007E]+";

    public boolean isValidName(String text) {
        if (text.length() < 2 || text.length() > 30) {
            return false;
        }

        return Pattern.matches(pattern_common1, text);
    }

    public boolean isValidEmail(String text) {
        if (text.length() > 50) {
            return false;
        }

        return Pattern.matches(pattern_email, text);
    }

    public boolean isValidPhone(String text) {
        return Pattern.matches(pattern_phone, text);
    }

    // Use for legal & physical addresses
    public boolean isValidAddress(String text) {
        if (text.length() > 255) {
            return false;
        }

        return Pattern.matches(pattern_common1, text);
    }

    public boolean isValidRegistrationNumber(String text) {
        if (text.length() < 2 || text.length() > 30) {
            return false;
        }

        return Pattern.matches(pattern_common2, text);
    }

    public boolean isValidUsername(String text) {
        if (text.length() < 6 || text.length() > 30) {
            return false;
        }

        return Pattern.matches(pattern_common2, text);
    }

    public boolean isValidPassword(String password, String repeatPassword) {
        if (!password.equals(repeatPassword)) {
            return false;
        } else {
            if (password.length() < 8 || password.length() > 20) {
                return false;
            }
        }

        return Pattern.matches(pattern_password, password);
    }
}

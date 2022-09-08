package Validation;

import javax.swing.*;
import java.util.regex.Pattern;

public class Validation_DoctorRegistration {
    String pattern_common1 = "[a-zA-Z\s\\d\u002D]*";
    String pattern_common2 = "[a-zA-Z\\d]*";
    String pattern_personalCode ="\\d{6}+-+\\d{5}";
    String pattern_password = "[A-Za-z\\d@\u0024\u0021\u0023\u0025\u0026\u002A\u005F\u005E\u007E]+";

    // min: 2 letters, allowed values: a-z, A-Z, 0-9, space, -
    // can be used for name and surname
    public boolean isValidName(String text) {
        if (text.length() < 2 || text.length() > 30) {
            return false;
        }

        return Pattern.matches(pattern_common1, text);
    }

    // min: 6 letters, allowed values: a-z, A-Z, 0-9
    public boolean isValidUsername(String text) {
        if (text.length() < 6 || text.length() > 30) {
            return false;
        }

        return Pattern.matches(pattern_common2, text);
    }

    // min: 8 letters,  max 20, allowed values: a-z, A-Z, 0-9, !@#$%^&*~_
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

    // format: 123456-12345
    public boolean isValidPersonalCode(String text) {
        return Pattern.matches(pattern_personalCode, text);
    }

    // min: 2 letters, allowed values: a-z, A-Z, 0-9
    public boolean isValidCertificate(String text) {
        if (text.length() < 2 || text.length() > 50) {
            return false;
        }

        return Pattern.matches(pattern_common2, text);
    }

    // validation for new doctors form
    public boolean isValidRegistration(String name, String surname, String username, String password,
                                       String repeatPassword, String personal_code, String certificate) {
        if (isValidName(name) && isValidName(surname) && isValidUsername(username) && isValidPersonalCode(personal_code)
                && isValidCertificate(certificate) && isValidPassword(password, repeatPassword)) {
            return true;
        }

        return false;
    }

    // method to get active or blocked status
    public String getStatus(JRadioButton active) {
        if (active.isSelected()) {
            return "active";
        }

        return "blocked";
    }
}
package Validation;

import javax.swing.*;
import java.util.regex.Pattern;
public class DocRegValidation{
    //    String docName, String docSurname, String docUsername, String personalCode, String sertificate, String password, String reppassword
    String pattern1 = "[a-zA-Z\s\\d\u002D]*";
    String pattern2 = "[a-zA-Z\\d]*";
    String perCodePattern ="\\d{6}+-+\\d{5}";
    String passwordPattern = "[A-Za-z\\d@\u0024\u0021\u0023\u0025\u0026\u002A\u005F\u005E\u007E]+";
    //   validation for min: 2 letters,allowed values: a-z, A-Z, space, - can be used for name and surname
    public boolean nameVal(String text){
        if (text.length()< 1 || text.length() > 30){
            return false;
        }
        return Pattern.matches(pattern1, text);
    }
    //    validation for min: 6 leters,allowed values: a-z, A-Z, 0-9 - can be used for username
    public boolean usernameVal(String text){
        if (text.length()<7 || text.length() > 30){
            return false;
        }
        return Pattern.matches(pattern2, text);
    }
    //    validation for min: 6 leters,allowed values: a-z, A-Z, 0-9 - can be used for certificate
    public boolean certificate(String text){
        if (text.length()<7 || text.length() > 30){
            return false;
        }
        return Pattern.matches(pattern2, text);
    }
    //   validation for personal code \d{6}+-+\d{5}
    public boolean personalCodeVal(String text){

        return Pattern.matches(perCodePattern, text);
    }
    // validation for password and repeat password
    public boolean passwordVal(String password, String repeatePassword){
        if (!password.equals(repeatePassword)){
            return false;
        }else{
            if (password.length()<7 || password.length() > 20) {
                return false;
            }
        }
        return Pattern.matches(passwordPattern, password);
    }
//    validation for new doctors form
    public boolean docRegVal(String name, String surname, String username, String password, String repeatPassword, String personal_code, String certificate) {
        if (nameVal(name) && nameVal(surname) && usernameVal(username) && personalCodeVal(personal_code) && certificate(certificate) && passwordVal(password, repeatPassword)) {
            return true;
        }
        return false;

    }
//    method to get active or blocked statuss
    public String getStatus(JRadioButton active){
        if (active.isSelected()){
            return "active";
        }
        return "blocked";
    }

}
package Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClinicRegistration {


    public static boolean isValidClinicName(String name) {
        String regex = "^[A-Za-z][A-Za-z0-9_ ]{2,}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);


        return m.matches();

    }
    // REGISTRACIJAS NUMURS
    public static boolean isValidClinicRegistration(String name) {
        String regex = "^[A-Za-z][A-Za-z0-9_ ]{2,}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);


        return m.matches();
    }
         //KLINIKAS ADRESE
    public static boolean isValidClinicAdress(String name) {
        String regex = "^[A-Za-z][A-Za-z0-9_ ]{2,}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);


        return m.matches();

    }
    //EPASTS
    public static boolean isValidClinicEmail(String name) {
        String regex = "^^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);


        return m.matches();

    }

    //TELEFONS
    public static boolean isValidClinicPhone(String name) {
        String regex = "\"^[\\\\d+]{12}$\"";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);


        return m.matches();

    }
    public static boolean isValidClinicpRegardAdress(String name) {
        String regex = "^[A-Za-z][A-Za-z0-9_ ]{2,}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);


        return m.matches();

    }

    // USERNAME
    public static boolean isValidClinicUsername(String name) {
        String regex = "^[A-Za-z][A-Za-z0-9_ ]{6,}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);


        return m.matches();

    }
    // PASSWORD


    public static boolean isValidClinicPassword(String name) {
        String regex = "^[A-Zaz][A-Za-z0-9_ !@#$%^&*~]{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);


        return m.matches();


    }
    //RE PASS
    public static boolean isValidClinicRePassword(String name) {
        String regex = "^[A-Zaz][A-Za-z0-9_ !@#$%^&*~]{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);


        return m.matches();

    }
}
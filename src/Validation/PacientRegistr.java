package Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PacientRegistr {
    //Pacienta VARDS!
    public static boolean isValidPacientName(String name)
    {
        String regex = "^[A-Za-z][A-Za-z0-9_ ]{2,}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);


        return m.matches();
    }
    //SUGA
    public static boolean isValidSpecies (String species)
    {
        String regex = "^[A-Za-z][A-Za-z0-9_ ]{2,}$";
        Pattern p = Pattern.compile(regex);
        if (species == null) {
            return false;
        }
        Matcher m = p.matcher(species);

        return m.matches();
    }

    //ID
    public static boolean isValidId (String id)
    {
        String regex = "^[A-Za-z][A-Za-z0-9_ ]{1,}$";
        Pattern p = Pattern.compile(regex);
        if (id == null) {
            return false;
        }
        Matcher m = p.matcher(id);

        return m.matches();
    }
   // Dzimsanas datums
   public static boolean isValidDateOfBirth (String dateOfBirth)
   {
       String regex = "^[A-Za-z][A-Za-z0-9_]{4,15}$";
       Pattern p = Pattern.compile(regex);
       if (dateOfBirth == null) {
           return false;
       }
       Matcher m = p.matcher(dateOfBirth);

       return m.matches();
   }
   //Ipasnieka vards un Uzvards

    //Ipasnieka telefons
    public static boolean isValidPhoneNumber (String PhoneNumber)
    {
        String regex = "^[\\d+]{12}$"; // +37126384998
        Pattern p = Pattern.compile(regex);
        if (PhoneNumber == null) {
            return false;
        }
        Matcher m = p.matcher(PhoneNumber);

        return m.matches();
    }

}

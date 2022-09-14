package Validation;

import java.util.regex.Pattern;

public class Validation_PatientRegistration {
    String pattern_common1 = "[a-zA-Z]*";
    String pattern_common2 = "[a-zA-Z\s\\d\u002D]*";
    String pattern_dateOfBirth = "\\d{4}+-+\\d{2}-+\\d{2}";
    String pattern_passportNumber = "[a-zA-Z\\d]*";

    public boolean isValidName(String text) {
        if (text.length() < 2 || text.length() > 30) {
            return false;
        }

        return Pattern.matches(pattern_common1, text);
    }

    public boolean isValidSpecies(String text) {
        if (text.length() < 2 || text.length() > 30) {
            return false;
        }

        return Pattern.matches(pattern_common1, text);
    }

    public boolean isValidBreed(String text) {
        if (text.length() < 2 || text.length() > 50) {
            return false;
        }

        return Pattern.matches(pattern_common1, text);
    }

    public boolean isValidWeight(float amount) {
        if (amount > 500.0f) {
            return false;
        }

        return true;
    }

   public boolean isValidDateOfBirth(String text) {
       return Pattern.matches(pattern_dateOfBirth, text);
   }

    public boolean isValidPassportNumber(String text) {
        if (text.length() > 50) {
            return false;
        }

        return Pattern.matches(pattern_passportNumber, text);
    }

    // Can be used for name and surname
    public boolean isValidOwnerName(String text) {
        if (text.length() < 2 || text.length() > 30) {
            return false;
        }

        return Pattern.matches(pattern_common2, text);
    }
    public boolean isValidPatRegistration(String name, String spieces, String breed, float weight,
                                       String passport, String birth, String ownerN, String ownerS) {
        if (isValidName(name) && isValidSpecies(spieces) && isValidBreed(breed) && isValidWeight(weight)
                && isValidPassportNumber(passport) && isValidDateOfBirth(birth) && isValidOwnerName(ownerN) && isValidOwnerName(ownerS)) {
            return true;
        }

        return false;
    }
}

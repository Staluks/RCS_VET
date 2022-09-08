package Validation;

import java.util.regex.Pattern;

public class Validation_NewMedicalHistory {
    String pattern_common = "[a-zA-Z\s\\d\u002D]*";
    String pattern_dateOfDiagnosis = "\\d{4}+-+\\d{2}-+\\d{2}";

    public boolean isValidDiagnosis(String text) {
        if (text.length() > 255) {
            return false;
        }

        return Pattern.matches(pattern_common, text);
    }

    public boolean isValidDateOfDiagnosis(String text) {
        return Pattern.matches(pattern_dateOfDiagnosis, text);
    }

    public boolean isValidManipulation(String text) {
        if (text.length() > 500) {
            return false;
        }

        return Pattern.matches(pattern_common, text);
    }

    public boolean isValidMedicaments(String text) {
        if (text.length() > 255) {
            return false;
        }

        return Pattern.matches(pattern_common, text);
    }
}

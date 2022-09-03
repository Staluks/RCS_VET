import java.util.regex.Pattern;
public class DocRegValidation{
//    String docName, String docSurname, String docUsername, String personalCode, String sertificate, String password, String reppassword
    String pattern1 = "[a-zA-Z\s]*";
    String pattern2 = "[a-zA-Z\\d]*";
    String perCodePattern ="\\d{6}+-+\\d{5}";
    String passwordPattern = "[A-Za-z\\d@\u0024\u0021\u0023\u0025\u0026\u002A\u005F\u005E\u007E]+";
//   validation for min: 2 letters,allowed values: a-z, A-Z, space, - can be used for name and username
    public boolean nameVal(String text){
        if (text.length()< 1 || text.length() > 30){
            return false;
        }
        return Pattern.matches(pattern1, text);
    }
//    validation for min: 6 leters,allowed values: a-z, A-Z, 0-9 - can be used for username and certificate
    public boolean userVal(String text){
        if (text.length()<5 || text.length() > 30){
            return false;
        }
        return Pattern.matches(pattern2, text);
    }
//   validation for personal code \d{6}+-+\d{5}
public boolean perCode(String text){

        return Pattern.matches(perCodePattern, text);
}
// validation for password and repeat password
    public boolean passwordVal(String password, String repeatePassword){
        if (!password.equals(repeatePassword)){
            return false;
        }else{
            if (password.length()<7 || password.length() > 30) {
                return false;
            }
        }
        return Pattern.matches(passwordPattern, password);
    }
    public boolean docRegVal(String name, String surname, String username, String password, String repeatPassword, String personal_code, String certificate) {
        if (nameVal(name) && nameVal(surname) && userVal(username) && perCode(personal_code) && userVal(certificate) && passwordVal(password, repeatPassword)) {
            return true;
        }
        return false;

    }

}


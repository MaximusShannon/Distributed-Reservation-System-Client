package functionality;

public class Validator {

    public boolean validateString(String stringToValidate){

        boolean check;

        check = stringToValidate.length() >= 1;

        return check;
    }

    public boolean validateEmail(String emailToValidate){

        boolean check;

        check = emailToValidate.contains("@") && emailToValidate.contains(".");

        return check;
    }

    public boolean validatePasswordsMatch(String passOne, String passTwo){

        boolean check;

        check = passOne.equals(passTwo);

        return check;
    }
}

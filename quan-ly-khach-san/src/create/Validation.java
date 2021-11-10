package create;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String LOGIN_NAME_REGEX = "^[a-zA-Z0-9]{8,16}$";
    public static final String PASSWORD_REGEX = "^[a-zA-Z0-9]{8,16}$";
    public static final String PHONE_NUMBER_REGEX = "0[35789][0-9]{8}";
    public static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    public static final String DATE_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";

    public Validation() {
    }

    public static boolean validate(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static int choiceExceptionHandling() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.err.println("Nhập số nguyên!");
        } finally {
            scanner.nextLine();
        }
        return choice;
    }

}

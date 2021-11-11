package create;

import model.User;
import service.manage.UserManage;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserCreate {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String createRegisterUserName() {
        System.out.print("Nhập tên đăng nhập: ");
        String username = SCANNER.nextLine();
        boolean isValid = Validation.validate(username, Validation.LOGIN_NAME_REGEX);
        boolean isExist = (UserManage.getUserManage().findIndexByUsername(username) != -1);
        while (isExist || !isValid) {
            if (!isValid) {
                System.err.println("Tên đăng nhập không hợp lệ.");
            }
            if (isExist) {
                System.err.println("Tên đăng nhập đã tồn tại.");
            }
            username = SCANNER.nextLine();
            isValid = Validation.validate(username, Validation.LOGIN_NAME_REGEX);
            isExist = (UserManage.getUserManage().findIndexByUsername(username) != -1);
        }
        return username;
    }

    public static String createRegisterPassword() {
        System.out.print("Nhập mật khẩu: ");
        String password = SCANNER.nextLine();
        while (!(Validation.validate(password, Validation.PASSWORD_REGEX))) {
            System.err.println("Mật khẩu không đúng.");
            password = SCANNER.nextLine();
        }
        return password;
    }

    public static String createName() {
        String fullName = SCANNER.nextLine();
        int indexOfChar = fullName.indexOf(',');
        while (!Validation.validate(fullName, Validation.FULL_NAME) || indexOfChar != -1) {
            System.err.println("Họ và tên chưa hợp lệ. Vui lòng nhập lại.");
            fullName = SCANNER.nextLine();
            indexOfChar = fullName.indexOf(',');
        }
        return fullName;
    }

    public static String createBirthDay() throws ParseException {
        System.out.print("Nhập ngày sinh (định dạng dd/MM/yyyy): ");
        String date = ReceiptCreate.createDate();
        String timeNow = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        while ((DateCalculator.dateCalculator(date, timeNow) < 4383)) {
            if (DateCalculator.dateCalculator(date, timeNow) < 4383) {
                System.err.println("Bạn chưa đủ 18 tuổi.");
            }
            date = SCANNER.nextLine();
        }
        return date;
    }

    public static String createPhoneNumber() {
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = SCANNER.nextLine();
        while (!(Validation.validate(phoneNumber, Validation.PHONE_NUMBER_REGEX))) {
            System.err.println("Số điện thoại không hợp lệ: ");
            phoneNumber = SCANNER.nextLine();
        }
        return phoneNumber;
    }

    public static String createEmail() {
        System.out.print("Nhập địa chỉ email: ");
        String email = SCANNER.nextLine();
        while (!(Validation.validate(email, Validation.EMAIL_REGEX))) {
            System.err.println("Email không hợp lệ: ");
            email = SCANNER.nextLine();
        }
        return email;
    }

    public static User createUser() throws ParseException {
        String username = createRegisterUserName();
        String password = createRegisterPassword();
        System.out.print("Nhập họ và tên: ");
        String name = createName();
//        int age = createAge();
        String birthday = createBirthDay();
        String phoneNumber = createPhoneNumber();
        String email = createEmail();
        return new User(name, birthday, phoneNumber, email, username, password);
    }
}

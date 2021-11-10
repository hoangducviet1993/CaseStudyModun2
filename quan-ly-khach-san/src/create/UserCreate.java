package create;

import model.User;
import service.manage.UserManage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserCreate {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String createRegisterUserName() {
        System.out.print("Nhập tên đăng nhập: ");
        String username = SCANNER.nextLine();
        while (!(Validation.validate(username, Validation.LOGIN_NAME_REGEX))) {
            try {
                System.err.println("UserName không hợp lệ: ");
                username = SCANNER.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Error!!!!");
            }
        }
        return username;
    }
    public static String createRegisterPassword() {
        System.out.print("Nhập mật khẩu: ");
        String password = SCANNER.nextLine();
        while (!(Validation.validate(password, Validation.PASSWORD_REGEX))) {
            try {
                System.err.println("Password không hợp lệ: ");
                password = SCANNER.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Error!!!!");
            }
        }
        return password;
    }
    public static int createAge() {
        System.out.print("Nhập tuổi: ");
        int age = 17 ;
        while (age < 18){
            try {
                age = SCANNER.nextInt();
                if(age < 18){
                    System.out.println("Bạn phải từ 18 tuổi trở lên: ");
                }
            } catch (InputMismatchException e){
                System.err.println("Nhập số nguyên!:.");
            } finally {
                SCANNER.nextLine();
            }
        }
        return age;
    }
    public static String createName(){
        System.out.println("Nhập tên người dùng: ");
        String name = SCANNER.nextLine();
        return name;
    }
    public static String createPhoneNumber() {
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = SCANNER.nextLine();
        while (!(Validation.validate(phoneNumber, Validation.PHONE_NUMBER_REGEX))) {
            try {
                System.err.println("Phone Number không hợp lệ: ");
                phoneNumber = SCANNER.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error!!!!");
            }
        }
        return phoneNumber;
    }
    public static String createEmail() {
        System.out.print("Nhập địa chỉ email: ");
        String email = SCANNER.nextLine();
        while (!(Validation.validate(email, Validation.EMAIL_REGEX))) {
            try {
                System.err.println("Email không hợp lệ: ");
                email = SCANNER.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error!!!!");
            }
        }
        return email;
    }
    public static User createUser() {
        String username = createRegisterUserName();
        String password = createRegisterPassword();
        String name = createName();
        int age = createAge();
        String phoneNumber = createPhoneNumber();
        String email = createEmail();
        return new User(name, age, phoneNumber, email, username, password);
    }
}

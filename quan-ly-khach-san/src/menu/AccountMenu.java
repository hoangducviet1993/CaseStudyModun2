package menu;

import create.UserCreate;
import create.Validation;
import fileIO.UserFile;
import service.manage.UserManage;

import java.io.IOException;
import java.util.Scanner;

public class AccountMenu {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void register() throws IOException {
        UserManage.getUserManage().add(UserCreate.createUser());
        UserFile.writeUserToFile();
        System.out.println("Đăng ký thành công: ");
    }

    public static boolean login(String username, String password) {
        int index = UserManage.getUserManage().findIndexByUsername(username);
        return UserManage.getUserManage().getUsersList().get(index).getPassword().equals(password);
    }

    public static void deleteUser(String username) throws IOException {
        System.out.println("Bạn có thật sự muốn xóa Tài Khoản " + username + ":");
        System.err.println("Nhập (yes) để xóa: ");
        String check = SCANNER.nextLine();
        if (check.equals("yes")) {
            UserManage.getUserManage().delete(username);
            System.out.println("Tài khoản " + username + " đã xóa! ");
            UserFile.writeUserToFile();
            UserFile.readUserFromFile();
            System.exit(0);
        } else {
            System.err.println("Xóa không thành công:");
        }
    }

    public static void accountManage(String username) throws IOException {
        int choice = -1;
        while (choice != 0) {
            ShowMenu.showAccountMenu();
            System.out.println("Nhập lựa chọn: ");
            choice = Validation.choiceExceptionHandling();
            switch (choice) {
                case 1:
                    UserManage.getUserManage().displayUserInformationByUsername(username);
                    break;
                case 2:
                    UserManage.getUserManage().edit(username, UserCreate.createUser());
                    break;
                case 3:
                    deleteUser(username);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

}

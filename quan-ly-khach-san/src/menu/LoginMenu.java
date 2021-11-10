package menu;

import create.Validation;
import model.User;
import service.manage.UserManage;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class LoginMenu {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void loginToSystem() throws ParseException, IOException {
        System.out.print("Nhập tên đăng nhập: ");
        String username = SCANNER.nextLine();
        int index = UserManage.getUserManage().findIndexByUsername(username);
        while (index == -1) {
            System.err.println("Tài khoản không tồn tại.");
            username = SCANNER.nextLine();
            index = UserManage.getUserManage().findIndexByUsername(username);
        }
//        User user = UserManage.getUserManage().getUsersList().get(index);
        System.out.print("Nhập mật khẩu: ");
        String password = SCANNER.nextLine();
        if (AccountMenu.login(username, password)) {
            System.out.println("Đăng nhập thành công! ");
            int choice = -1;
            while (choice != 0) {
                ShowMenu.showManageMenu();
                System.out.println("Nhập lựa chọn: ");
                choice = Validation.choiceExceptionHandling();
                switch (choice) {
                    case 1:
                        AccountMenu.accountManage(username);
                        break;
                    case 2:
                        RoomMenu.roomManage(username);
                        break;
                    case 3:
                        ReceiptMenu.receiptManager(username);
                        break;
                    case 0:
                        System.exit(0);
                }
            }
        } else {
            System.err.println("Sai Password");
        }
    }
}

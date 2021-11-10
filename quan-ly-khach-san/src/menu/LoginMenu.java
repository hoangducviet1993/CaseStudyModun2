package menu;

import create.Validation;
import model.User;
import service.manage.UserManage;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class LoginMenu {

    public static void loginToSystem() throws ParseException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên đăng nhập: ");
        String username = scanner.nextLine();
        int index = UserManage.getUserManage().findIndexByUsername(username);
        while (index == - 1) {
            System.err.println("Tài khoản không tồn tại.");
            username = scanner.nextLine();
            index = UserManage.getUserManage().findIndexByUsername(username);
        }
        User user = UserManage.getUserManage().getUsersList().get(index);
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        if (AccountMenu.login(username,password)){
            System.out.println("Đăng nhập thành công! ");
            int choice =-1;
            while (choice!=0){
                ShowMenu.showManageMenu();
                choice = Validation.choiceExceptionHandling();
                switch (choice){
                    case 1:
//                        Account.accountManage(username);
                        break;
                    case 2:
//                        MenuRoom.roomManage(username);
                        break;
                    case 3:
//                        MenuReceipt.receiptManager(username);
                        break;
                    case 0:
                        System.exit(0);
                }
            }
        }else {
            System.err.println("Sai Password");
        }
    }
}
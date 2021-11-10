package menu;

import create.UserCreate;
import fileIO.UserFile;
import service.manage.UserManage;

import java.io.IOException;

public class AccountMenu {
    public static void register() throws IOException {
        UserManage.getUserManage().add(UserCreate.createUser());
        UserFile.writeUserToFile();
        System.out.println("Đăng ký thành công: ");
    }
    public static boolean login(String username,String password){
//        UserManage userManage = UserManage.getUserManage();
        int index = UserManage.getUserManage().findIndexByUsername(username);
        return UserManage.getUserManage().getUsersList().get(index).getPassword().equals(password);
    }


}

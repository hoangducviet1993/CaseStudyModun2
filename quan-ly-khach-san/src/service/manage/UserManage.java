package service.manage;

import fileIO.UserFile;
import model.User;
import service.UserService;

import java.io.IOException;
import java.util.ArrayList;

public class UserManage implements UserService<User> {
    private static ArrayList<User> usersList;

    private UserManage() {
        usersList = new ArrayList<>();
    }

    private static UserManage userManage;

    public static UserManage getUserManage() {
        if (userManage == null) userManage = new UserManage();

        return userManage;
    }

    public ArrayList<User> getUsersList() {
        if (usersList == null) {
            usersList = new ArrayList<>();
//            usersList.add(new User( "Hoàng Đức Việt",27,"0868999600","ducviet12vl@gmail.com","ducviet006","ducviet93"));
//            usersList.add(new User("Việt Hoàng",28,"0358389993","hoangviet12vl@gmail.com","ducviet007","ducviet88"));
        }
        return usersList;
    }

    public void setUsersList(ArrayList<User> usersList) {
        UserManage.usersList = usersList;
    }

    public static void setUserManage(UserManage userManage) {
        UserManage.userManage = userManage;
    }

    @Override
    public void add(User user) {
        usersList.add(user);
    }

    @Override
    public int findIndexByUsername(String username) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void edit(String username, User user) throws IOException {
        usersList.set(findIndexByUsername(username), user);
        UserFile.writeUserToFile();
        UserFile.readUserFromFile();
        System.out.println("Sửa Thông tin Thành công: ");
    }

    @Override
    public void delete(String username) {
        usersList.remove(findIndexByUsername(username));
    }

    @Override
    public void displayUserInformationByUsername(String username) {
        if (userManage.findIndexByUsername(username) != -1) {
            System.out.println();
            System.out.println("____________________________*** THÔNG TIN TÀI KHOẢN ***____________________________");
            System.out.printf("%-20s %-15s %-20s %-25s %n", "Họ và tên", "Ngày Sinh", "Số điện thoại", "Email");
            System.out.println();
            System.out.println(usersList.get(userManage.findIndexByUsername(username)));
            System.out.println("___________________________________________________________________________________");
            System.out.println();
        } else {
            System.err.println("Sai tên đăng nhập.");
        }
    }
}

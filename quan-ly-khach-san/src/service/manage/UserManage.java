package service.manage;

import model.User;
import service.UserService;

import java.util.ArrayList;

public class UserManage implements UserService<User> {
    private static ArrayList<User> usersList;

    private UserManage() {
    }

    private static UserManage userManage;

    public static UserManage getUserManage() {
        if (userManage == null) userManage = new UserManage();
        return userManage;
    }

    public static ArrayList<User> getUsersList() {
        return usersList;
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
        } return -1;
    }

    @Override
    public void edit(String username, User user) {
    }

    @Override
    public void delete(String username) {
        usersList.remove(findIndexByUsername(username));
    }

    @Override
    public void displayUserInformationByUsername(String username) {
//        if (userManage.findIndexByUsername(username) != -1) {
            System.out.println();
            System.out.println("____________________________*** THÔNG TIN TÀI KHOẢN ***____________________________");
            System.out.printf("%-20s %-10s %-20s %-25s %n", "Họ và tên", "Tuổi", "Số điện thoại", "Email");
            System.out.println();
            System.out.println(usersList.get(userManage.findIndexByUsername(username)));
            System.out.println("___________________________________________________________________________________");
            System.out.println();
//        } else {
//            System.err.println("Sai tên đăng nhập.");
//        }
    }
}

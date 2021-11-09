package service.manage;

import model.User;
import service.UserService;

import java.util.ArrayList;

public class UserManage implements UserService<User> {
    private static ArrayList<User> users;

    private UserManage(){

    }
    private static UserManage usersList;

    public static UserManage getUsersList() {
        if (usersList == null) usersList = new UserManage();
        return usersList;public
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public int findIndexById(String username) {
        return 0;
    }

    @Override
    public void edit(String username, User user) {

    }

    @Override
    public void delete(String username) {

    }

    @Override
    public void displayUserInformationByUsername(String username) {

    }
}

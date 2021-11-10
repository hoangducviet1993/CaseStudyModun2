package com.codegym;

import fileIO.UserFile;
import menu.GeneralMenu;
import menu.ShowMenu;
import service.manage.UserManage;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {
//        UserManage.getUserManage().getUsersList();
//        UserFile.writeUserToFile();
//        UserFile.readUserFromFile();
	// write your code here
//        ShowMenu.showLoginMenu();
//        ShowMenu.showManageMenu();
//        ShowMenu.showRoomMenu();
//        ShowMenu.showReceiptMenu();
        GeneralMenu.MainMenu();
    }
}

package com.codegym;

import fileIO.RoomFile;
import fileIO.UserFile;
import menu.GeneralMenu;
import menu.ShowMenu;
import service.manage.RoomManage;
import service.manage.UserManage;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {
//        UserManage.getUserManage().getUsersList();
//        UserFile.writeUserToFile();
//        UserFile.readUserFromFile();
//        RoomManage.getRoomManage().getRoomsList();
//        RoomFile.writeRoomToFile();
//        RoomFile.readRoomFromFile();
	// write your code here2
//        ShowMenu.showLoginMenu();
//        ShowMenu.showManageMenu();
//        ShowMenu.showRoomMenu();
//        ShowMenu.showReceiptMenu();
        GeneralMenu.MainMenu();
    }
}

package com.codegym;

import fileIO.ReceiptFile;
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
        GeneralMenu.MainMenu();
    }
}

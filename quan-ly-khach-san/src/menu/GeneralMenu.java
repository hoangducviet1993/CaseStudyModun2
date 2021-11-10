package menu;

import fileIO.ReceiptFile;
import fileIO.RoomFile;
import fileIO.UserFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class GeneralMenu {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void MainMenu() throws ParseException, IOException {
        try {
            UserFile.readUserFromFile();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!!");
        }
        try {
            ;
            RoomFile.readRoomFromFile();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!!");
        }
        try {
            ReceiptFile.readReceiptFromFile();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!!");
        }
        int choice = -1;
        while (choice != 0) {
            ShowMenu.showLoginMenu();
            System.out.println("Nhập lựa chọn: ");
            choice = SCANNER.nextInt();
            switch (choice) {
                case 1:
                    LoginMenu.loginToSystem();
                    break;
                case 2:
                    AccountMenu.register();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

}

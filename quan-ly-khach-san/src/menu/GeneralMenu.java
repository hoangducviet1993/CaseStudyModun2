package menu;

import fileIO.UserFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class GeneralMenu {
    public static void MainMenu() throws ParseException, IOException {
        UserFile.readUserFromFile();
        int choice = -1;
        while (choice != 0) {
            ShowMenu.showLoginMenu();
            System.out.println("Nhập lựa chọn: ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
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

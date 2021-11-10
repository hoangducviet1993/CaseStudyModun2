package menu;

import create.RoomCreate;
import create.Validation;
import service.manage.RoomManage;

import java.io.IOException;
import java.util.Scanner;

public class RoomMenu {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void roomManage(String username) throws IOException {
        int choice = -1;
        while (choice != 0) {
            ShowMenu.showRoomMenu();
            choice = Validation.choiceExceptionHandling();
            switch (choice) {
                case 1:
                    RoomManage.getRoomManage().displayListRoom();
                    break;
                case 2:
                    System.err.println("Chưa có chức năng này");
                    break;
                case 3:
                    System.err.println("Chưa có chức năng này");
                    break;
                case 4:
                    System.err.println("Chưa có chức năng này");
                    break;
                case 5:
                    RoomManage.getRoomManage().add(RoomCreate.createRoom());
                    break;
                case 6:
                    RoomManage.getRoomManage().edit();
                    break;
                case 7:
                    RoomManage.getRoomManage().displayReadyRoom();
                    break;
                case 8:
                    RoomManage.getRoomManage().findInformationById();
                    break;
                case 9:
                    RoomManage.getRoomManage().findInformationByPrice();
                    break;
                case 10:
                    System.out.println("Nhập Id phòng cần xóa: ");
                    int id = SCANNER.nextInt();
                    RoomManage.getRoomManage().delete(id);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}

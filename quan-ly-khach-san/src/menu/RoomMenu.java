package menu;

import create.RoomCreate;
import create.Validation;
import fileIO.RoomFile;
import service.manage.RoomManage;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class RoomMenu {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void roomManage(String username) throws IOException, ParseException {

        int choice = -1;
        while (choice != 0) {
            ShowMenu.showRoomMenu();
            System.out.println("Nhập lựa chọn: ");
            choice = Validation.choiceExceptionHandling();
            switch (choice) {
                case 1:
                    RoomManage.getRoomManage().displayListRoom();
                    break;
                case 2:
                    int roomId = RoomCreate.createOldRoomId();
                    RoomManage.getRoomManage().doCheckIn(roomId);
                    break;
                case 3:
                    int roomId1 = RoomCreate.createOldRoomId();
                    RoomManage.getRoomManage().doCheckOut(username, roomId1);
                    break;
                case 4:
                    int roomId2 = RoomCreate.createOldRoomId();
                    RoomManage.getRoomManage().cleanTheRoom(roomId2);
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
//                    System.exit(0);
            }
        }
    }
}

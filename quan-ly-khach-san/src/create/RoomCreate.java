package create;

import model.Room;
import service.manage.RoomManage;

import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RoomCreate {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static int createOldRoomId() {
        System.out.print("Nhập số phòng: ");
        int roomId = -1;
        while (RoomManage.getRoomManage().findIndexById(roomId) == -1 || roomId < 0) {
            try {
                roomId = SCANNER.nextInt();
                if (RoomManage.getRoomManage().findIndexById(roomId) == -1) {
                    System.err.println("Phòng không ồn tại.");
                }
                if (roomId < 0) {
                    System.err.println("Số phòng không hợp lệ.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error!! ");
            } finally {
                SCANNER.nextLine();
            }
        }
        return roomId;
    }

    public static int createRoomId() {
        System.out.println("Nhập số phòng: ");
        int roomId = -1;
        while (RoomManage.getRoomManage().findIndexById(roomId) != -1 || roomId < 0) {
            try {
                roomId = SCANNER.nextInt();
                if (RoomManage.getRoomManage().findIndexById(roomId) != -1) {
                    System.err.println("Phòng đã tồn tại: ");
                }
                if (roomId < 0) {
                    System.err.println("Số phòng không hợp lệ.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error!! ");
            } finally {
                SCANNER.nextLine();
            }
        }
        return roomId;
    }

    public static int createNumberOfBeds() {
        System.out.print("Nhập số giường ngủ: ");
        int numberOfBed = -1;
        while (numberOfBed < 0) {
            try {
                numberOfBed = SCANNER.nextInt();
                if (numberOfBed < 0) {
                    System.err.println("Số giường không thể nhỏ hơn 0.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error!!");
            }
        }
        return numberOfBed;
    }

    public static int createNumberOfToilet() {
        System.out.println("Nhập số nhà vệ sinh:");
        int numberOfToilet = -1;
        while (numberOfToilet < 0) {
            try {
                numberOfToilet = SCANNER.nextInt();
                if (numberOfToilet < 0) {
                    System.err.println("Số lượng nhà vệ sinh không hợp lệ.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error!!");
            }
        }
        return numberOfToilet;
    }

    public static int createPrice() {
        System.out.print("Nhập giá phòng: ");
        int price = -1;
        while (price < 0) {
            try {
                price = SCANNER.nextInt();
                if (price < 0) {
                    System.err.println("Số tiền phải lớn hơn 0.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error!!");
            }
        }
        return price;
    }

    public static Room createRoom() {
        int roomId = createRoomId();
        int numberOfBed = createNumberOfBeds();
        int numberOfToilet = createNumberOfToilet();
        int price = createPrice();
        String lastCheckIn = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String lastCheckOut = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return new Room(roomId, price, Room.READY, numberOfBed, numberOfToilet, lastCheckIn, lastCheckOut);
    }

}

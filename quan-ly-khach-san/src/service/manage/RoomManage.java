package service.manage;

import create.ReceiptCreate;
import create.RoomCreate;
import create.UserCreate;
import fileIO.RoomFile;
import model.Receipt;
import model.Room;
import model.User;
import service.RoomService;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RoomManage implements RoomService<Room> {
    private static ArrayList<Room> roomsList;

    private RoomManage() {
    }

    private static RoomManage roomManage;

    public static RoomManage getRoomManage() {
        if (roomManage == null) roomManage = new RoomManage();
        return roomManage;
    }

    public  ArrayList<Room> getRoomsList() {
        if (roomsList == null) {
            roomsList = new ArrayList<>();
            roomsList.add(new Room(101, 10000, Room.READY, 1, 2,"06/11/2021","10/11/2021"));
            roomsList.add(new Room(102, 10000, Room.READY, 1, 1,"7/11/2021","10/11/2021"));
            roomsList.add(new Room(103, 20000, Room.READY, 2, 2,"7/11/2021","10/11/2021"));
        }
        return roomsList;
    }

    public void setRoomsList(ArrayList<Room> roomsList) {
        RoomManage.roomsList = roomsList;
    }

    public void setRoomManage(RoomManage roomManage) {
        RoomManage.roomManage = roomManage;
    }

    @Override
    public void add(Room room) {
        roomsList.add(room);
    }

    @Override
    public int findIndexById(int roomId) {
        for (int i = 0; i < roomsList.size(); i++) {
            if (roomsList.get(i).getRoomId() == roomId) {
                return i;
            }
        } return -1;
    }

    @Override
    public void findRoomByPrice(int minPrice, int maxPrice) {
        System.out.println();
        System.out.println("____________________***  DANH SÁCH PHÒNG PHÙ HỢP  ***____________________");
        System.out.printf("%-10s %-10s %-20s %-15s %-15s %n", "Số phòng", "Giá phòng", "Trạng thái phòng", "Số giường ngủ", "Số nhà VS");
        System.out.println();
        for (Room room : roomsList) {
            if (room.getPrice() >= minPrice && room.getPrice() <= maxPrice) {
                System.out.println(room);
            }
        }
        System.out.println("_________________________________________________________________________");
        System.out.println();
    }

    @Override
    public void edit() {
        int roomId = 0;
        System.out.print("Nhập số phòng muốn sửa: ");
        while (findIndexById(roomId) == -1) {
            Scanner scanner = new Scanner(System.in);
            try {
                roomId = scanner.nextInt();
                if (findIndexById(roomId) == -1) {
                    System.err.println("Phòng không tồn tại! ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error! ");
            }
        }
        delete(roomId);
        System.out.println("Nhập thông tin phòng: ");
        add(RoomCreate.createRoom());
        System.out.println("Cập nhật thành công!!!");
    }

    @Override
    public void delete(int roomId) {
        roomsList.remove(findIndexById(roomId));
    }

    @Override
    public void displayInformationById(int roomId) {
        Room room = getRoomsList().get(getRoomManage().findIndexById(roomId));
        System.out.println();
        System.out.println("______________________***  THÔNG TIN VỀ PHÒNG "+ roomId +" ***______________________");
        System.out.printf("%-10s %-10s %-20s %-15s %-15s %n", "Số phòng", "Giá phòng", "Trạng thái phòng", "Số giường ngủ", "Số nhà VS");
        System.out.println();
        System.out.println(room);
        System.out.println("__________________________________________________________________________");
        System.out.println();
    }

    @Override
    public void displayListRoom() {
        Collections.sort(roomsList);
        System.out.println();
        System.out.println("____________________***  DANH SÁCH TOÀN BỘ PHÒNG  ***_____________________");
        System.out.printf("%-10s %-10s %-20s %-15s %-15s %n", "Số phòng", "Giá phòng", "Trạng thái phòng", "Số giường ngủ", "Số nhà VS");
        System.out.println();
        for (Room room : roomsList) {
            System.out.println(room);
        }
        System.out.println("_________________________________________________________________________");
        System.out.println();
    }

    @Override
    public void displayReadyRoom() {
        System.out.println();
        System.out.println("______________________***  DANH SÁCH PHÒNG TRỐNG ***______________________");
        System.out.printf("%-10s %-10s %-20s %-15s %-15s %n", "Số phòng", "Giá phòng", "Trạng thái phòng", "Số giường ngủ", "Số nhà VS");
        System.out.println();
        for (Room room : roomsList) {
            if (room.getStatus().equals(Room.READY)) {
                System.out.println(room);
            }
        }
        System.out.println("_____________________________________________________________________");
        System.out.println();
    }
    public void doCheckIn(int roomId) throws IOException {
        Room room = roomManage.getRoomsList().get(roomManage.findIndexById(roomId));
        if (room.getStatus().equals(Room.READY)) {
            room.setStatus(Room.OCCUPIED);
            room.setLastCheckIn(java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            RoomFile.writeRoomToFile();
            System.out.println("Đã hoàn tất thủ tục check-in. Thời gian: " + java.time.LocalDate.now());
            System.out.println();
        } else {
            System.err.println("Không thể hoàn tất thủ tục check-in. Phòng đang ở trạng thái: " + room.getStatus());
        }
    }
    public void doCheckOut(String username, int roomId) throws IOException, ParseException {
        Room room = roomManage.getRoomsList().get(roomManage.findIndexById(roomId));
        UserManage userManage = UserManage.getUserManage();
        User user = userManage.getUsersList().get(userManage.findIndexByUsername(username));
        if (room.getStatus().equals(Room.OCCUPIED)) {
            String receiptId = ReceiptCreate.createNewReceiptId();
            System.out.print("Nhập tên khách hàng: ");
            String customerName = UserCreate.createName();
            String staffName = user.getName();
            String checkInTime = room.getLastCheckIn();
            String checkOutTime = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Receipt receipt = new Receipt(receiptId, customerName, staffName, checkInTime, checkOutTime, roomId);
            ReceiptManage.getReceiptManage().add(receipt);
            room.setStatus(Room.ON_CHANGE);
            room.setLastCheckOut(checkOutTime);
            RoomFile.writeRoomToFile();
            System.out.println("Đã hoàn tất thủ tục check-out. Thời gian: " + LocalDate.now());
            System.out.println();
            System.out.println("_____________________________________*** Thông tin hóa đơn *** _____________________________________");
            System.out.println();
            System.out.printf("%-15s %-20s %-20s %-15s %-15s %-15s %n", "Số hóa đơn", "Khách hàng", "Nhân viên", "Ngày check-in", "Ngày check-out", "Tổng tiền");
            System.out.println(receipt);
            System.out.println("____________________________________________________________________________________________________");
            System.out.println();
        } else {
            System.err.println("Không thể hoàn tất thủ tục check-out. Phòng đang ở trạng thái: " + room.getStatus());
        }
    }
    public void cleanTheRoom(int roomId) throws IOException {
        Room room = roomManage.getRoomsList().get(roomManage.findIndexById(roomId));
        if (room.cleanTheRoom()) {
            System.out.println("Đã dọn dẹp phòng xong");
            System.out.println();
        } else {
            System.err.println("Không thể dọn dẹp. Phòng đang ở trạng thái: " + room.getStatus());
        }
    }

    public  void findInformationById() {
        int roomId = 0;
        System.out.print("Nhập số phòng: ");
        while (findIndexById(roomId) == -1) {
            Scanner sc = new Scanner(System.in);
            try {
                roomId = sc.nextInt();
                if (findIndexById(roomId) == -1) {
                    System.err.println("Phòng không tồn tại: ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Số phòng không hợp lệ: ");
            }
        }
        displayInformationById(roomId);
    }
    public void findInformationByPrice() {
        System.out.println("Nhập giá Min: ");
        int minPrice = -1;
        while (minPrice < 0) {
            Scanner sc = new Scanner(System.in);
            try {
                minPrice = sc.nextInt();
                if (minPrice < 0) {
                    System.err.println("Số tiền không hợp lệ:");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error!!");
            }
        }
        System.out.println("Nhập giá Max: ");
        int maxPrice = -1;
        while (maxPrice < 0 || maxPrice < minPrice) {
            Scanner sc = new Scanner(System.in);
            try {
                maxPrice = sc.nextInt();
                if (maxPrice < 0) {
                    System.err.println("Số tiền không hợp lệ: ");
                }
                if (maxPrice < minPrice) {
                    System.err.println("Giá tiền nhỏ hơn giá Min:");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error!!");
            }
        }
        findRoomByPrice(minPrice, maxPrice);
    }
}

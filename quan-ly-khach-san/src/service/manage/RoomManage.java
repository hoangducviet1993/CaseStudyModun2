package service.manage;

import model.Room;
import service.RoomService;

import java.util.ArrayList;
import java.util.Collections;

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
        return roomsList;
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
        System.out.println("________________________***  DANH SÁCH PHÒNG  ***________________________");
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
}

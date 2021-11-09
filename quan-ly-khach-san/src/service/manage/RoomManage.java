package service.manage;

import model.Room;
import service.RoomService;

import java.util.ArrayList;

public class RoomManage implements RoomService<Room> {
    private static ArrayList<Room> rooms;

    private RoomManage(){
    }
    private static RoomManage roomsList;

    public static RoomManage getRoomsList() {
        if (roomsList == null) roomsList = new RoomManage();
        return roomsList;
    }

    public static ArrayList<Room> getRooms() {
        return rooms;
    }

    @Override
    public void add(Room room) {

    }

    @Override
    public int findIndexById(int roomId) {
        return 0;
    }

    @Override
    public void findRoomByPrice(int minPrice, int maxPrice) {

    }

    @Override
    public void delete(int roomId) {

    }

    @Override
    public void displayInformationById(int roomId) {

    }

    @Override
    public void displayListRoom() {

    }

    @Override
    public void displayReadyRoom() {

    }
}

package fileIO;

import model.Room;
import service.manage.RoomManage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class RoomFile {
    public static void writeRoomToFile() throws IOException {
        ArrayList<Room> roomsList = RoomManage.getRoomManage().getRoomsList();
        FileWriter fileWriter = new FileWriter("src/fileIO/roomManageFile.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        StringBuilder str = new StringBuilder("Số phòng,Giá thuê phòng,Trạng thái hiện tại,Số giường ngủ, Số nhà vệ sinh");
        for (Room room : roomsList) {
            str.append("\n").append(room.getRoomId()).append(",");
            str.append(room.getPrice()).append(",");
            str.append(room.getStatus()).append(",");
            str.append(room.getNumberOfBeds()).append(",");
            str.append(room.getNumberOfToilet());
        }
        bufferedWriter.write(str.toString());
        bufferedWriter.close();
    }
    public static void readRoomFromFile() throws IOException {
        ArrayList<Room> roomList = new ArrayList<>();
        FileReader fileReader = new FileReader("src/fileIO/roomManageFile.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String content = bufferedReader.readLine();
        while ((content = bufferedReader.readLine()) != null) {
            String[] array = content.split(",");
            int roomID = Integer.parseInt(array[0]);
            int price = Integer.parseInt(array[1]);
            String status = array[2];
            int numberOfBed = Integer.parseInt(array[3]);
            int numberOfToilet = Integer.parseInt(array[4]);
//            String lastCheckIn = array[5];
//            String lastCheckOut = array[6];
//            roomList.add(new Room(roomID, price, status, numberOfBed, numberOfToilet, lastCheckIn, lastCheckOut));
            roomList.add(new Room(roomID, price, status, numberOfBed, numberOfToilet));
        }
        RoomManage.getRoomManage().setRoomsList(roomList);
        bufferedReader.close();
        fileReader.close();
    }
}

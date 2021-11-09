package model;

public class Room {
    public static final String OCCUPIED = "Phòng đã được thuê: ";
    public static final String ON_CHANGE = "Phòng đang dọn dẹp/Bảo trì: ";
    public static final String READY = "Phòng trống: ";

    private int roomId;
    private int price;
    private String status;
    private int numberOfBeds;
    private int numberOfToilet;
    private String lastCheckIn;
    private String lastCheckOut;

    public Room() {
    }

    public Room(int roomId, int price, String status, int numberOfBeds, int numberOfToilet, String lastCheckIn, String lastCheckOut) {
        this.roomId = roomId;
        this.price = price;
        this.status = status;
        this.numberOfBeds = numberOfBeds;
        this.numberOfToilet = numberOfToilet;
        this.lastCheckIn = lastCheckIn;
        this.lastCheckOut = lastCheckOut;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfToilet() {
        return numberOfToilet;
    }

    public void setNumberOfToilet(int numberOfToilet) {
        this.numberOfToilet = numberOfToilet;
    }

    public String getLastCheckIn() {
        return lastCheckIn;
    }

    public void setLastCheckIn(String lastCheckIn) {
        this.lastCheckIn = lastCheckIn;
    }

    public String getLastCheckOut() {
        return lastCheckOut;
    }

    public void setLastCheckOut(String lastCheckOut) {
        this.lastCheckOut = lastCheckOut;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", numberOfBeds=" + numberOfBeds +
                ", numberOfToilet=" + numberOfToilet +
                ", lastCheckIn='" + lastCheckIn + '\'' +
                ", lastCheckOut='" + lastCheckOut + '\'' +
                '}';
    }
}

package service;

public interface RoomService<T> {
    void add(T t);
    int findIndexById(int roomId);
    void findRoomByPrice(int minPrice, int maxPrice);
    void delete(int roomId);
    void displayInformationById(int roomId);
    void displayListRoom();
    void displayReadyRoom();
}

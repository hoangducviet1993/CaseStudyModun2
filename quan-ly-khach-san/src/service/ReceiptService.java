package service;

public interface ReceiptService <T>{
    void add(T t);
    int findIndexById(String receiptId);
    int findIndexByRoomId(int roomId);
    void edit(String receiptId, T t);
    void delete(String receiptId);
    void displayAllReceipt();
    void displayReceiptListByDay(String startDay, String endDay);
}

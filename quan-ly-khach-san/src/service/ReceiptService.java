package service;

import java.io.IOException;
import java.text.ParseException;

public interface ReceiptService<T> {
    void add(T t) throws IOException, ParseException;

    int findIndexById(String receiptId);

    int findIndexByRoomId(int roomId);

    void edit() throws ParseException, IOException;

    void delete(String receiptId) throws IOException, ParseException;

    void displayAllReceipt();

    void displayReceiptListByDay(String startDay, String endDay) throws ParseException;
}

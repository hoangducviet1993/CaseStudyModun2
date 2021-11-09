package service.manage;

import model.Receipt;
import service.ReceiptService;

import java.util.ArrayList;

public class ReceiptManage implements ReceiptService<Receipt> {
    private static ArrayList<Receipt> receipts;

    private ReceiptManage() {
    }

    private static ReceiptManage receiptsList;

    public static ReceiptManage getReceiptsList() {
        if (receiptsList == null) receiptsList = new ReceiptManage();
        return receiptsList;
    }

    public static ArrayList<Receipt> getReceipts() {
        return receipts;
    }

    @Override
    public void add(Receipt receipt) {

    }

    @Override
    public int findIndexById(String receiptId) {
        return 0;
    }

    @Override
    public int findIndexByRoomId(int roomId) {
        return 0;
    }

    @Override
    public void edit(String receiptId, Receipt receipt) {

    }

    @Override
    public void delete(String receiptId) {

    }

    @Override
    public void displayAllReceipt() {

    }

    @Override
    public void displayReceiptListByDay(String startDay, String endDay) {

    }
}

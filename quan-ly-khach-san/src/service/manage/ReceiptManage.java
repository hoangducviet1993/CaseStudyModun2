package service.manage;

import fileIO.ReceiptFile;
import model.Receipt;
import service.ReceiptService;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

public class ReceiptManage implements ReceiptService<Receipt> {
    private static ArrayList<Receipt> receiptsList;

    private ReceiptManage() {
//        receiptsList = new ArrayList<>();
    }

    private static ReceiptManage receiptManage;

    public static ReceiptManage getReceiptManage() {
        if (receiptManage == null) receiptManage = new ReceiptManage();
        return receiptManage;
    }

    public ArrayList<Receipt> getReceiptsList() {
        return receiptsList;
    }

    public void setReceiptsList(ArrayList<Receipt> receiptsList) {
        ReceiptManage.receiptsList = receiptsList;
    }

    public  void setReceiptManage(ReceiptManage receiptManage) {
        ReceiptManage.receiptManage = receiptManage;
    }

    @Override
    public void add(Receipt receipt) throws IOException, ParseException {
        receiptsList.add(receipt);
        ReceiptFile.writeReceiptToFile();
    }

    @Override
    public int findIndexById(String receiptId) {
        for (int i = 0; i < receiptsList.size(); i++) {
            if (receiptsList.get(i).getReceiptId().equals(receiptId)) {
                return i;
            }
        } return -1;
    }

    @Override
    public int findIndexByRoomId(int roomId) {
        for (int i = 0; i < receiptsList.size(); i++) {
            if (receiptsList.get(i).getRoomId() == roomId) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void edit(String receiptId, Receipt receipt) {

    }

    @Override
    public void delete(String receiptId) throws IOException, ParseException {
        receiptsList.remove(findIndexById(receiptId));
        ReceiptFile.writeReceiptToFile();
    }

    @Override
    public void displayAllReceipt() {
        Collections.sort(receiptsList);
        System.out.println();
        System.out.println("__________________________________*** DANH SÁCH TOÀN BỘ HÓA ĐƠN ***__________________________________");
        System.out.printf("%-15s %-20s %-20s %-15s %-15s %-15s %n", "Số hóa đơn", "Khách hàng", "Nhân viên", "Ngày check-in", "Ngày check-out", "Tổng tiền");
        for (Receipt receipt : receiptsList) {
            System.out.println(receipt);
        }
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println();
    }

    @Override
    public void displayReceiptListByDay(String startDay, String endDay) {

    }
}

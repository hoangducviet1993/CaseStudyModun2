package model;

import create.DateCalculator;
import service.manage.RoomManage;

import java.io.IOException;
import java.text.ParseException;

public class Receipt implements Comparable<Receipt> {
    private String receiptId;
    private String customerName;
    private String staffName;
    private String checkIn;
    private String checkOut;
    private int roomId;

    public Receipt() {
    }

    public Receipt(String receiptId, String customerName, String staffName, String checkIn, String checkOut, int roomId) {
        this.receiptId = receiptId;
        this.customerName = customerName;
        this.staffName = staffName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomId = roomId;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public long getTotalPrice() throws ParseException {
        int roomPrice = RoomManage.getRoomManage().getRoomsList().get(RoomManage.getRoomManage().findIndexById(roomId)).getPrice();
        long dateCal = DateCalculator.dateCalculator(checkIn, checkOut);
        return roomPrice * (dateCal + 1);
    }

    @Override
    public String toString() {
        String str = null;
        try {
            str = String.format("%-15s %-20s %-20s %-15s %-15s %-15d", receiptId, customerName, staffName, checkIn, checkOut, getTotalPrice());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public int compareTo(Receipt o) {
        if (getReceiptId().compareTo(o.getReceiptId()) > 0) return 1;
        else if (getReceiptId().compareTo(o.getReceiptId()) < 0) return -1;
        return 0;
    }
}

package fileIO;

import model.Receipt;
import service.manage.ReceiptManage;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

public class ReceiptFile {
    public static void writeReceiptToFile() throws IOException, ParseException {
        ArrayList<Receipt> receiptList = ReceiptManage.getReceiptManage().getReceiptsList();
        Collections.sort(receiptList);
        FileWriter fileWriter = new FileWriter("src/fileIO/receiptManageFile.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        StringBuilder str = new StringBuilder("Số hóa đơn,Tên khách hàng,Tên nhân viên,Số phòng, Giờ check-in,Giờ check-out,Tổng số tiền");
        for (Receipt receipt : receiptList) {
            str.append("\n");
            str.append(receipt.getReceiptId()).append(",");
            str.append(receipt.getCustomerName()).append(",");
            str.append(receipt.getStaffName()).append(",");
            str.append(receipt.getRoomId()).append(",");
            str.append(receipt.getCheckIn()).append(",");
            str.append(receipt.getCheckOut()).append(",");
            str.append(receipt.getTotalPrice());
        }
        bufferedWriter.write(str.toString());
        bufferedWriter.close();
    }

    public static void readReceiptFromFile() throws IOException {
        ArrayList<Receipt> receiptList = new ArrayList<>();
        FileReader fileReader = new FileReader("src/fileIO/receiptManageFile.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String content = bufferedReader.readLine();
        while ((content = bufferedReader.readLine()) != null) {
            String[] array = content.split(",");
            String receiptId = array[0];
            String customerName = array[1];
            String staffName = array[2];
            int roomId = Integer.parseInt(array[3]);
            String checkInTime = array[4];
            String checkOutTime = array[5];
            receiptList.add(new Receipt(receiptId, customerName, staffName, checkInTime, checkOutTime, roomId));
        }
        ReceiptManage.getReceiptManage().setReceiptsList(receiptList);
        bufferedReader.close();
        fileReader.close();
    }
}

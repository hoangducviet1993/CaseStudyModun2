package create;

import model.Receipt;
import service.manage.ReceiptManage;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReceiptCreate {
    public static final Scanner SCANNER = new Scanner(System.in);

    public String createNewReceiptId() {
        System.out.print("Nhập số hóa đơn: ");
        String receiptId = SCANNER.nextLine();
        while (ReceiptManage.getReceiptManage().findIndexById(receiptId) != -1) {
            try {
                System.out.println("Số hóa đơn đã tồn tại:");
                receiptId = SCANNER.nextLine();
            }catch (InputMismatchException e){
                System.err.println("Error!!!!");
            }
        }
        return receiptId;
    }

    public  String createDate(){
        System.out.println("Nhập ngày (dd/MM/yyyy): ");
        String date = SCANNER.nextLine();
        while (!Validation.validate(date, Validation.DATE_REGEX)) {
            try{
                System.err.println("Ngày không hợp lệ:");
                date = SCANNER.nextLine();
            } catch (InputMismatchException e){
                System.err.println("Error!!!!");
            }
        }
        return date;
    }

    public Receipt createReceipt() throws ParseException {
        String receiptId = createNewReceiptId();
        int roomId = RoomCreate.createRoomId();
        System.out.print("Nhập tên khách hàng: ");
        String customerName = SCANNER.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        String staffName = SCANNER.nextLine();
        System.out.println("Nhập ngày check-in (định dạng dd/MM/yyyy): ");
        String checkIn = createDate();
        System.out.println("Nhập ngày check-out (định dạng dd/MM/yyyy): ");
        String checkOut = createDate();
        while (DateCalculator.dateCompare(checkIn, checkOut) > 0) {
            if (DateCalculator.dateCompare(checkIn, checkOut) > 0) {
                System.err.println("Ngày check-out phải sau ngày check-in!");
            }
            checkOut = createDate();
        }
        return new Receipt(receiptId, customerName, staffName, checkIn, checkOut, roomId);
    }


}
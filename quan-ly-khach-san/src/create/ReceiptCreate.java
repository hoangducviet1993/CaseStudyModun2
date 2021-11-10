package create;

import model.Receipt;
import service.manage.ReceiptManage;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReceiptCreate {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String createNewReceiptId() {
        System.out.print("Nhập số hóa đơn: ");
        String receiptId = SCANNER.nextLine();
        while (ReceiptManage.getReceiptManage().findIndexById(receiptId) != -1) {
            System.out.println("Số hóa đơn đã tồn tại:");
            receiptId = SCANNER.nextLine();
        }
        return receiptId;
    }

    public static String createOldReceiptId() {
        System.out.print("Nhập số hóa đơn: ");
        String receiptId = SCANNER.nextLine();
        while (ReceiptManage.getReceiptManage().findIndexById(receiptId) == -1) {
            System.out.println("Số hóa đơn không tồn tại, vui lòng nhập lại");
            receiptId = SCANNER.nextLine();
        }
        return receiptId;
    }

    public static String createDate() {
        String date = SCANNER.nextLine();
        while (!Validation.validate(date, Validation.DATE_REGEX)) {
            System.err.println("Ngày không hợp lệ:");
            date = SCANNER.nextLine();
        }
        return date;
    }

    public static Receipt createReceipt() throws ParseException {
        String receiptId = createNewReceiptId();
        int roomId = RoomCreate.createOldRoomId();
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

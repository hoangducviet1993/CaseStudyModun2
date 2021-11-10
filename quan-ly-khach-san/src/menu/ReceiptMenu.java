package menu;

import create.DateCalculator;
import create.ReceiptCreate;
import create.Validation;
import service.manage.ReceiptManage;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class ReceiptMenu {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static void receiptManager(String username) throws ParseException, IOException {
        ReceiptManage.getReceiptManage();
        int choice =-1;
        while (choice !=0){
            ShowMenu.showReceiptMenu();
            choice = Validation.choiceExceptionHandling();
            switch (choice){
                case 1:
                    System.out.println("Nhập ngày check-in (định dạng dd/MM/yyyy): ");
                    String startTime = ReceiptCreate.createDate();
                    System.out.println("Nhập ngày check-out (định dạng dd/MM/yyyy): ");
                    String endTime = ReceiptCreate.createDate();
                    while (DateCalculator.dateCompare(startTime, endTime) > 0) {
                        if (DateCalculator.dateCompare(startTime, endTime) > 0) {
                            System.err.println("Ngày check-out phải sau ngày check-in!");
                        }
                        endTime = ReceiptCreate.createDate();
                    }
                    ReceiptManage.getReceiptManage().displayReceiptListByDay(startTime,endTime);
                    break;
                case 2:
                    ReceiptManage.getReceiptManage().edit();
                    break;
                case 3:
                    String receiptId = ReceiptCreate.createOldReceiptId();
                    ReceiptManage.getReceiptManage().delete(receiptId);
                    System.out.println("Xóa hóa đơn thành công: ");
                    System.out.println();;
                    break;
                case 4:
                    ReceiptManage.getReceiptManage().displayAllReceipt();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}

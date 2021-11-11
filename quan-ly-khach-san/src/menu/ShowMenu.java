package menu;

import java.util.Scanner;

public class ShowMenu {
    public static void showLoginMenu() {
        System.out.printf("%30s%-80s%30s", " ", "✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩", " ");
        System.out.println();
        System.out.printf("%31s%52s%25s%30s", "✩", "*** CHỌN ĐỂ ĐĂNG NHẬP NGAY ***", "✩", " ");
        System.out.println();
        System.out.printf("%31s%30s%-46s%-10s%20s", "✩", " ", "1. Đăng Nhập: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%30s%-46s%-20s%20s", "✩", " ", "2. Đăng Ký: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%30s%-46s%-20s%20s", "✩", " ", "0. Thoát trương trình: ", "✩", "");
        System.out.println();
        System.out.printf("%30s%-80s%30s", " ", "✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩", " ");
        System.out.println();
    }

    public static void MenuLogin() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên đăng nhập: ");
        String username = scanner.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = scanner.nextLine();
    }

    public static void showManageMenu() {
        System.out.printf("%30s%-80s%30s", " ", "✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩", " ");
        System.out.println();
        System.out.printf("%31s%52s%25s%30s", "✩", "***CHỌN MENU QUẢN LÝ ***", "✩", " ");
        System.out.println();
        System.out.printf("%31s%30s%-46s%-10s%20s", "✩", " ", "1. Quản lý tài khoản: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%30s%-46s%-20s%20s", "✩", " ", "2. QUản lý phòng: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%30s%-46s%-20s%20s", "✩", " ", "3. Quản lý hóa đơn", "✩", " ");
        System.out.println();
        System.out.printf("%31s%30s%-46s%-20s%20s", "✩", " ", "0. Thoát menu: ", "✩", " ");
        System.out.println();
        System.out.printf("%30s%-80s%30s", " ", "✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩", " ");
        System.out.println();
    }

    public static void showAccountMenu() {
        System.out.printf("%30s%-80s%30s", " ", "✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩", " ");
        System.out.println();
        System.out.printf("%31s%52s%25s%30s", "✩", "*** QUẢN LÝ TÀI KHOẢN ***", "✩", " ");
        System.out.println();
        System.out.printf("%31s%30s%-46s%-10s%20s", "✩", " ", "1. Xem thông tin tài khoản: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%30s%-46s%-20s%20s", "✩", " ", "2. Sửa thông tin cá nhân: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%30s%-46s%-20s%20s", "✩", " ", "3. Xóa tài khoản: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%30s%-46s%-20s%20s", "✩", " ", "0. Thoát menu: ", "✩", " ");
        System.out.println();
        System.out.printf("%30s%-80s%30s", " ", "✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩", " ");
        System.out.println();

    }

    public static void showRoomMenu() {
        System.out.printf("%30s%-80s%30s", " ", "✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩", " ");
        System.out.println();
        System.out.printf("%31s%50s%27s%30s", "✩", "*** QUẢN LÝ PHÒNG ***", "✩", " ");
        System.out.println();
        System.out.printf("%31s%25s%-51s%-20s%20s", "✩", " ", "1. Hiển thị danh sách phòng: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%25s%-51s%-20s%20s", "✩", " ", "2. Check-in: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%25s%-51s%-20s%20s", "✩", " ", "3. Check-out và in hóa đơn: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%25s%-51s%-20s%20s", "✩", " ", "4. Dọn dẹp phòng: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%25s%-51s%-20s%20s", "✩", " ", "5. Thêm phòng: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%25s%-51s%-20s%20s", "✩", " ", "6. Sửa thông tin phòng: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%25s%-51s%-20s%20s", "✩", " ", "7. Danh sách phòng còn trống: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%25s%-51s%-20s%20s", "✩", " ", "8. Tìm kiếm thông tin theo số phòng:  ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%25s%-51s%-20s%20s", "✩", " ", "9. Tìm phòng theo giá: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%25s%-51s%-20s%20s", "✩", " ", "10. Xóa Phòng: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%25s%-51s%-20s%20s", "✩", " ", "0. Thoát menu: ", "✩", " ");
        System.out.println();
        System.out.printf("%30s%-80s%30s", " ", "✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩", " ");
        System.out.println();

    }

    public static void showReceiptMenu() {
        System.out.printf("%30s%-80s%30s", " ", "✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩", " ");
        System.out.println();
        System.out.printf("%31s%52s%25s%30s", "✩", "*** QUẢN LÝ TÀI KHOẢN ***", "✩", " ");
        System.out.println();
        System.out.printf("%31s%20s%-56s%-20s%20s", "✩", " ", "1. In và tính hóa đơn theo khoảng thời gian: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%20s%-56s%-20s%20s", "✩", " ", "2. Sửa thông tin hóa đơn(Theo só hóa đơn): ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%20s%-56s%-20s%20s", "✩", " ", "3. Xóa hóa đơn: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%20s%-56s%-20s%20s", "✩", " ", "4. In danh sách hóa đơn: ", "✩", " ");
        System.out.println();
        System.out.printf("%31s%20s%-56s%-20s%20s", "✩", " ", "0. Thoát menu: ", "✩", " ");
        System.out.println();
        System.out.printf("%30s%-80s%30s", " ", "✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩✰✩", " ");
        System.out.println();
    }
}

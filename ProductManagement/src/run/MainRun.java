package run;

import entity.Product;
import entity.ProductManagement;
import entity.ProductManagementDetail;
import entity.Staff;
import logic_handle.ProductLogic;
import logic_handle.ProductManagementLogic;
import logic_handle.StaffLogic;

import java.util.Scanner;

public class MainRun {

    public static Staff[] staffs = new Staff[1000];
    public static Product[] products = new Product[2000];
    public static ProductManagement[] productManagements = new ProductManagement[3000];
    public static int countProduct = 0;

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int functionChoice = chooseFunction();
            logicHandle(functionChoice);
        }
    }

    private static void logicHandle(int functionChoice) {
        switch (functionChoice) {
            case 1:
                StaffLogic.addNewStaff();
                break;
            case 2:
                StaffLogic.showStaff();
                break;
            case 3:
                ProductLogic.addNewProduct();
                break;
            case 4:
                ProductLogic.showProduct();
                break;
            case 5:
                ProductManagementLogic.addNewProductManagement();
                ProductManagementLogic.showProductManagement();
                break;
            case 6:
                showSortMenu();
                break;
            case 7:
                ProductManagementLogic.calculateSalary();
                break;
            case 8:
                System.exit(0);
        }
    }



    public static void showSortMenu() {
        System.out.println("Nhập lựa chọn của bạn: ");
        System.out.println("1. Sắp xếp theo tên nhân viên  ");
        System.out.println("2. Sắp xếp theo Theo nhóm mặt hàng");
        System.out.println("3. Thoát ra ngoài menu chính.");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {
                break;
            }
            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        switch (choice) {
            case 1:
                ProductManagementLogic.sortbyStaffName();
                break;
            case 2:
                ProductManagementLogic.sortbyProductTypeName();
                break;
            case 3:
                return;
        }
    }


    private static int chooseFunction () {
        System.out.print("Xin mời chọn chức năng: ");
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 8) {
                break;
            }
            System.out.print("Chức năng vừa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return choice;
    }

    private static void showMenu () {
        System.out.println("----PHẦN MỀM QUẢN LÝ DANH SÁCH BÁN HÀNG-----");
        System.out.println("1. Nhập danh sách nhân viên mới.");
        System.out.println("2. Hiển thị danh sách nhân viên mới.");
        System.out.println("3. Nhập danh sách mặt hàng mới.");
        System.out.println("4. Hiển thị danh sách mặt hàng mới.");
        System.out.println("5. Lập bảng danh sách bán hàng.");
        System.out.println("6. Sắp xếp bảng danh sách bán hàng.");
        System.out.println("7. Bảng kê doanh thu của mỗi nhân viên.");
        System.out.println("8. Thoát.");
    }



}

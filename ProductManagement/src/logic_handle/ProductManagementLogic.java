package logic_handle;

import entity.Product;
import entity.ProductManagement;
import entity.ProductManagementDetail;
import entity.Staff;
import run.MainRun;

import java.util.Scanner;

public class ProductManagementLogic {

    public static void showProductManagement() {
    }

    public static void addNewProductManagement() {
        if (MainRun.staffs.length == 0 || MainRun.products.length == 0) {
            System.out.println("Bạn cần có thông tin về nhân viên và mặt hàng trước");
            return;
        }

        System.out.println("Lập bảng danh sách bán hàng cho bao nhiêu nhân viên: ");
        int temp = new Scanner(System.in).nextInt();
        for (int i = 0; i < temp; i++) {
            System.out.println("Nhập thông tin cho nhân viên thứ " + (i + 1));
            System.out.println("Nhập mã nhân viên: ");
            int staffId;
            Staff staff = null;
            do {
                staffId = new Scanner(System.in).nextInt();
                staff = StaffLogic.findIdByStaff(staffId);
                if (staff != null) { // CHECKKKKKKKKKKKKKK
                    break;
                }
                System.out.println("Không tìm thấy nhân viên mang mã " + staffId + ", vui lòng nhập lại");
            } while (true);


            System.out.println("Nhập số lượng mặt hàng đã bán: ");
            int productNum;
            do {
                productNum = new Scanner(System.in).nextInt();
                // chú ý: ko được vượt quá số bài trong hệ thống
                if (productNum > 0 && productNum <= 5 && productNum <= MainRun.countProduct) {
                    break;
                }
                System.out.println("Mỗi nhân viên chỉ được tham gia bán tối đa 5 mặt hàng khác nhau.");
                System.out.println("Vui lòng nhập lại.");
            } while (true);
            //Lưu số mặt hàng
            ProductManagementDetail[] productManagementDetails = new ProductManagementDetail[productNum];


            int count = 0;
            for (int j = 0; j < productNum; j++) {
                System.out.println("Nhập thông tin mặt hàng thứ " + (j + 1) + "mà nhân viên " + staff.getName() + "đã bán");
                System.out.println("Nhập mã bài viết: ");
                int productId;
                Product product = null;
                do {
                    productId = new Scanner(System.in).nextInt();
                    product = ProductLogic.findIdByProduct(productId);
                    ; // CHECKKK
                    if (product == null) {
                        System.out.println("Không tìm thấy mặt hàng mang mã " + productId + ", vui lòng nhập lại");
                        continue;
                    }
                    //chú ý: cùng một nhân viên với một mặt hàng thì không thể xuất hiện 2 lần trong bảng này
                    boolean inputOrNot = false;
                    //productManagementDetails[k] != null
                    for (int k = 0; k < productManagementDetails.length; k++) {
                        if (productManagementDetails[k] != null && productManagementDetails[k].getProduct().getId() == productId) {
                            inputOrNot = true;
                            break;
                        }
                    }
                    if (!inputOrNot) {
                        break;
                    }
                    System.out.println("Mặt hàng này bạn vừa mới nhập xong, vui lòng nhập lại.");
                } while (true);


                System.out.println("Nhập số lượng đã bán ở mặt hàng này: ");
                int quantity = new Scanner(System.in).nextInt();
                productManagementDetails[count] = new ProductManagementDetail(product, quantity);
                count++;
            }


            ProductManagement productManagement = new ProductManagement(staff, productManagementDetails);
            saveProductManagement(productManagement);

        }
    }

    public static void saveProductManagement(ProductManagement productManagement) {
        for (int j = 0; j < MainRun.productManagements.length; j++) {
            if (MainRun.productManagements[j] == null) {
                MainRun.productManagements[j] = productManagement;
                break;
            }
        }
    }


    public static void calculateSalary() {
        //Lập bảng kê thu nhập của mỗi nhân viên
        for (int i = 0; i < MainRun.productManagements.length; i++) {
            if (MainRun.productManagements[i] == null) {
                continue;
            }
            double salary = 0;
            Staff staff = MainRun.productManagements[i].getStaff();
            ProductManagementDetail[] productManagementDetails = MainRun.productManagements[i].getProductManagementDetails();
            for (int j = 0; j < productManagementDetails.length; j++) {
                salary += productManagementDetails[j].getProduct().getProductPrice() * productManagementDetails[j].getQuantity();
            }
            System.out.println("Lương của nhân viên bán hàng" + staff.getName() + "là " + salary);
        }


    }

    public static void sortbyStaffName() {
        for (int i = 0; i < MainRun.productManagements.length - 1; i++) {
            if (MainRun.productManagements[i] == null) {
                continue;
            }
            for (int j = i + 1; j < MainRun.productManagements.length ; j++) {
                if (MainRun.productManagements[j] == null) {
                    continue;
                }
                if (MainRun.productManagements[i].getStaff().getName().compareTo(MainRun.productManagements[j].getStaff().getName()) > 0 ) {
                    ProductManagement temp = MainRun.productManagements[i];
                    MainRun.productManagements[i] = MainRun.productManagements[j];
                    MainRun.productManagements[j] = temp;
                }
            }
        }
        showProductManagement();
    }

    public static void sortbyProductTypeName() {

    }
}

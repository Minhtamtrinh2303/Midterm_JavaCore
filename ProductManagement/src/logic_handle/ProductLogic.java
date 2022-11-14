package logic_handle;

import entity.Product;
import entity.Staff;
import run.MainRun;

import java.util.Scanner;

public class ProductLogic {

    public static Product findIdByProduct(int productId) {
        //MainRun.products[j] ko được rỗng
        Product product = null;
        for (int j = 0; j < MainRun.products.length; j++) {
            if (MainRun.products[j] != null && MainRun.products[j].getId() == productId) {
                product = MainRun.products[j];
                break;
            }
        }
        return product;
    }

    public static void showProduct () {
        for (int i = 0; i < MainRun.products.length; i++) {
            if (MainRun.products[i] != null) {
                System.out.println(MainRun.products[i]);
            }
        }
    }

    public static void addNewProduct () {
        System.out.println("Nhập số lượng mặt hàng muốn thêm mới: ");
        int productNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < productNum; i++) {
            Product product = new Product();
            product.inputInfo();
            saveProduct(product);
        }
        MainRun.countProduct += productNum;
    }

    public static void saveProduct (Product product){
        for (int j = 0; j < MainRun.products.length; j++) {
            if (MainRun.products[j] == null) {
                MainRun.products[j] = product;
                break;
            }
        }
    }
}

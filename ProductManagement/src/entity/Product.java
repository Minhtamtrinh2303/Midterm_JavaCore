package entity;

import constant.ProductType;

import java.util.Scanner;

public class Product implements Inputable {

    private static int AUTO_ID = 1000;
    private int id;
    private String name;
    private String productType; // nhóm hàng
    private double productPrice;
    private int productNumber;

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    @Override
    public String toString() {
        return "entity.Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productType='" + productType + '\'' +
                ", productPrice=" + productPrice +
                ", productNumber=" + productNumber +
                '}';
    }
    @Override
    public void inputInfo(){
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập tên mặt hàng: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Nhập mã mặt hàng: ");
        this.id = new Scanner(System.in).nextInt();
        System.out.print("Nhập giá bán mặt hàng: ");
        this.productPrice = new Scanner(System.in).nextDouble();
        System.out.print("Nhập số lượng mặt hàng: ");
        this.productNumber = new Scanner(System.in).nextInt();

        // Nhập tên nhóm hàng
        productTypeInput();
    }

    public void productTypeInput() {
        System.out.print("Nhập tên nhóm hàng: ");
        System.out.println("Vui lòng chọn 1 trong các nhóm dưới đây: ");
        System.out.println("1. Điện tử");
        System.out.println("2. Điện lạnh");
        System.out.println("3. Máy tính");
        System.out.println("4. Thiết bị văn phòng");
        int typeTemp;
        do {
            typeTemp = new Scanner(System.in).nextInt();
            if ( typeTemp >= 1 && typeTemp <=4 ) {
                break;
            }
            System.out.println("Không có nhóm hàng trên, vui lòng nhập lại: ");
        }while(true);
        switch (typeTemp) {
            case 1:
                this.productType = ProductType.DT.value;
                break;
            case 2:
                this.productType = ProductType.DL.value;
                break;
            case 3:
                this.productType = ProductType.MT.value;
                break;
            case 4:
                this.productType = ProductType.TBVP.value;
                break;
        }

    }


}

package entity;

import java.util.Date;
import java.util.Scanner;

public class Staff extends Person {

    private int id;
    private String date;

    private static int AUTO_ID = 0;
    public Staff() {
        if (AUTO_ID == 0) {
            AUTO_ID = 999;
        }
        AUTO_ID++;
        this.id = AUTO_ID;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        System.out.println("Nhập mã nhân viên: ");
        this.id = new Scanner(System.in).nextInt();
        System.out.println("Nhập ngày ký hợp đồng:  ");
        this.date = new Scanner(System.in).nextLine();
    }

}

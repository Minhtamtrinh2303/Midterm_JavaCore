package logic_handle;

import entity.Staff;
import run.MainRun;

import java.util.Scanner;

public class StaffLogic {

    public static void showStaff () {
        for (int i = 0; i < MainRun.staffs.length; i++) {
            if (MainRun.staffs[i] != null) {
                System.out.println(MainRun.staffs[i]);
            }
        }
    }

    public static void addNewStaff () {
        System.out.println("Nhập số lượng nhân viên muốn thêm mới: ");
        int staffNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < staffNum; i++) {
            Staff staff = new Staff();//ENTITY
            staff.inputInfo();
            saveStaff(staff);
        }
    }

    public static void saveStaff (Staff staff){
        for (int j = 0; j < MainRun.staffs.length; j++) {
            if (MainRun.staffs[j] == null) {
                MainRun.staffs[j] = staff;
                break;
            }
        }
    }

    public static Staff findIdByStaff(int staffId) { //check lỗi
        //MainRun.staffs[j] ko được rỗng
        Staff staff = null;
        for (int j = 0; j < MainRun.staffs.length; j++) {
            if (MainRun.staffs[j] != null && MainRun.staffs[j].getId() == staffId) {
                staff = MainRun.staffs[j];
                break;
            }
        }
        return staff;
    }

}

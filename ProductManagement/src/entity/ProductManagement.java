package entity;

import java.util.Arrays;

public class ProductManagement {

    private Staff staff;
    ProductManagementDetail[] productManagementDetails;

    public ProductManagement(Staff staff, ProductManagementDetail[] productManagementDetails) {
        this.staff = staff;
        this.productManagementDetails = productManagementDetails;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public ProductManagementDetail[] getProductManagementDetails() {
        return productManagementDetails;
    }

    public void setProductManagementDetails(ProductManagementDetail[] productManagementDetails) {
        this.productManagementDetails = productManagementDetails;
    }

    @Override
    public String toString() {
        return "ProductManagement{" +
                "staff=" + staff +
                ", productManagementDetails=" + Arrays.toString(productManagementDetails) +
                '}';
    }


}

package constant;

public enum ProductType {

    DT("Điện tử"),
    DL("Điện lạnh"),
    MT("Máy tính"),
    TBVP("Thiết bị văn phòng");

    public String value;

    ProductType(String value) {
        this.value = value;
    }

}

package hackerank;

public class Deal {
    private final String productName;
    private long unitPrice;
    private final int quantity;

    public Deal(String productName, long unitPrice, int quantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    //getters
    public String getProductName() {return productName;}
    public long getUnitPrice() {return unitPrice;}
    public int getQuantity() {return quantity;}

    //setters
    public void setUnitPrice(long unitPrice) {this.unitPrice = unitPrice;}
}

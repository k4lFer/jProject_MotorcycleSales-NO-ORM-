package DTOs.Objects;

/**
 *
 * @author kalfe
 */
public class DtoSalesDetails {
    private int detailID; 
    private int saleID ;
    private int productID ;
    private int quantity ;
    private double unitPrice ;
    private double subTotalPrice;

    public DtoSalesDetails() {
    }

    public DtoSalesDetails(int detailID, int saleID, int productID, int quantity, double unitPrice, double subTotalPrice) {
        this.detailID = detailID;
        this.saleID = saleID;
        this.productID = productID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subTotalPrice = subTotalPrice;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSubTotalPrice() {
        return subTotalPrice;
    }

    public void setSubTotalPrice(double subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }
    
}

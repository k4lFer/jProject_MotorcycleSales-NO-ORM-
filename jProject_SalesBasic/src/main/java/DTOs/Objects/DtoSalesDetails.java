package DTOs.Objects;

/**
 *
 * @author kalfe
 */
public class DtoSalesDetails {
    private int detailID;
    private int saleID;
    private int quantity;
    private double price;

    public DtoSalesDetails() {
    }

    public DtoSalesDetails(int detailID, int saleID, int productID, int quantity, double price) {
        this.detailID = detailID;
        this.saleID = saleID;
        this.quantity = quantity;
        this.price = price;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

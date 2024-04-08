package Objects;

import Entities.SalesDetails;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kalfe
 */
public class DtoSales {
    private int saleID;
    private int customerID;
    private int productID;
    private Date date;
    private int quantity;
    private double totalPrice;
    private List<SalesDetails> salesDetails;

    public DtoSales() {
    }

    public DtoSales(int saleID, int customerID, int productID, Date date, int quantity, double totalPrice, List<SalesDetails> salesDetails) {
        this.saleID = saleID;
        this.customerID = customerID;
        this.productID = productID;
        this.date = date;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.salesDetails = salesDetails;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<SalesDetails> getSalesDetails() {
        return salesDetails;
    }

    public void setSalesDetails(List<SalesDetails> salesDetails) {
        this.salesDetails = salesDetails;
    }
    
}

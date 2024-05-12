package Entities;

import java.util.Date;
import java.util.List;

/**
 *
 * @author kalfe
 */
public class Sales {
    private int saleID;
    private int customerID;
    private Date date;
    private double totalPrice;
    private List<SalesDetails> salesDetails;
    
    public Sales() {
    }

    public Sales(int saleID, int customerID, Date date, double totalPrice, List<SalesDetails> salesDetails) {
        this.saleID = saleID;
        this.customerID = customerID;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

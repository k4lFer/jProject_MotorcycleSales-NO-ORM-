package DTOs.Objects;

/**
 *
 * @author kalfe
 */
public class DtoProducts {
    private int productID;
    private String Cod;
    private String name;
    private String displacement;
    private double price;
    private int stockQuantity;
    private int motorcycleTypeID;
    private int brandID;

    public DtoProducts() {
    }

    public DtoProducts(int productID, String Cod, String name, String displacement, double price, int stockQuantity, int motorcycleTypeID, int brandID) {
        this.productID = productID;
        this.Cod = Cod;
        this.name = name;
        this.displacement = displacement;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.motorcycleTypeID = motorcycleTypeID;
        this.brandID = brandID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getCod() {
        return Cod;
    }

    public void setCod(String Cod) {
        this.Cod = Cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getMotorcycleTypeID() {
        return motorcycleTypeID;
    }

    public void setMotorcycleTypeID(int motorcycleTypeID) {
        this.motorcycleTypeID = motorcycleTypeID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }
    

}

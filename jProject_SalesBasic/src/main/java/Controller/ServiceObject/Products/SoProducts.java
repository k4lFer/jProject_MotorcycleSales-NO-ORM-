package Controller.ServiceObject.Products;

import DTOs.Objects.DtoProducts;
import java.util.List;

/**
 *
 * @author kalfe
 */
public class SoProducts {
    public DtoProducts dtoProducts;
    public List<DtoProducts> allProducts;

    public SoProducts() {
    }

    public SoProducts(DtoProducts dtoProducts, List<DtoProducts> allProducts) {
        this.dtoProducts = dtoProducts;
        this.allProducts = allProducts;
    }

    public DtoProducts getDtoProducts() {
        return dtoProducts;
    }

    public void setDtoProducts(DtoProducts dtoProducts) {
        this.dtoProducts = dtoProducts;
    }

    public List<DtoProducts> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<DtoProducts> allProducts) {
        this.allProducts = allProducts;
    }
    
    
}

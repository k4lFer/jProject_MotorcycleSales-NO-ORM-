package Controller;

import Controller.ServiceObject.Products.SoProducts;
import DTOs.Objects.DtoProducts;
import Queries.QProducts;
import java.util.List;

/**
 *
 * @author kalfe
 */
public class ProductController {
    private QProducts model;
    private SoProducts so;

    public ProductController(QProducts model, SoProducts so) {
        this.model = model;
        this.so = so;
    }
    
    public List<DtoProducts> allProducts(){
        return so.allProducts = model.getAll();
    }
    
    
}

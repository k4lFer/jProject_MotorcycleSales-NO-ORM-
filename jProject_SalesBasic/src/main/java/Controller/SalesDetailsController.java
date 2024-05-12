package Controller;

import Controller.ServiceObject.Products.SoProducts;
import Controller.ServiceObject.Sales.SoSalesDetails;
import DTOs.Objects.DtoSalesDetails;
import Queries.QProducts;
import Queries.QSalesDetails;
import java.util.List;

/**
 *
 * @author kalfe
 */
public class SalesDetailsController {

    private QProducts modelP;
    private QSalesDetails model;

    private SoSalesDetails so;
    
    public SalesDetailsController(){
        this.model = new QSalesDetails();
        this.so = new SoSalesDetails();
        this.modelP = new QProducts();
    }
    
     public List<DtoSalesDetails> loadSalesDetails(){
        return so.allSalesDetails = model.getAll();
    }
    
    public int insertSaleDetails(SoSalesDetails so) {
    int result = model.insert(so.dtoSalesDetails);
    int stockSale = so.dtoSalesDetails.getQuantity();
    int idProduct = so.dtoSalesDetails.getProductID();
    SoProducts soProducts = new SoProducts();
        
    soProducts.dtoProducts = modelP.getById(idProduct);
        
    int stockBase = soProducts.dtoProducts.getStockQuantity();
    int updatedStock = stockBase-stockSale;
    soProducts.dtoProducts.setStockQuantity(updatedStock);
    modelP.update(soProducts.dtoProducts);
    
    
    
    return result;
    }
}

package Controller;

import Controller.ServiceObject.Sales.SoSales;
import DTOs.Objects.DtoSales;
import Queries.QSales;
import java.util.List;

/**
 *
 * @author kalfe
 */
public class SalesController {
    private QSales model;
    private SoSales so;

    
    public SalesController(){
        this.model = new QSales();
        this.so = new SoSales();
    }
    
    public List<DtoSales> loadSales(){
        return so.allSales = model.getAll();
    }
    
    public int insertSale(SoSales so) {
    int result = model.insert(so.dtoSales);
    
    return result;
    }

}

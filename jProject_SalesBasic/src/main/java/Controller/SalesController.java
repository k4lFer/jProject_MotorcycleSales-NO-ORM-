package Controller;

import Controller.ServiceObject.Sales.SoSales;
import Controller.ServiceObject.Sales.SoSalesDetails;
import DTOs.Objects.DtoSales;
import DTOs.Objects.DtoSalesDetails;
import Entities.SalesDetails;
import Queries.QSales;
import Queries.QSalesDetails;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kalfe
 */
public class SalesController {
    private QSales model;
    private SoSales so;
    private QSalesDetails modelDetails;
    private SoSalesDetails soDetails;
    
    public SalesController(){
        this.model = new QSales();
        this.so = new SoSales();
        this.modelDetails = new QSalesDetails();
        this.soDetails = new SoSalesDetails();
    }
    
    public List<DtoSales> loadSales(){
        return so.allSales = model.getAll();
    }
    
    public int insertSale(SoSales so){
        int result = model.insert(so.dtoSales);
        if(result > 0){
            List<DtoSalesDetails> salesDetailsList = so.dtoSales.getSalesDetails();
        for (DtoSalesDetails detail : salesDetailsList) {
            modelDetails.insert(detail);
        }
            JOptionPane.showMessageDialog(null, "Venta registrada exitosamente");
        }else{
             JOptionPane.showMessageDialog(null, "Error al registrar la Venta");
        }
        return result;
    }
    
    public int deleteSale(int id){
        int result = model.delete(id);
        if (result > 0) {
            JOptionPane.showMessageDialog(null, "La Venta fue eliminado exitosamente.","Success", JOptionPane.INFORMATION_MESSAGE);
        }else {
                JOptionPane.showMessageDialog(null, "Error al eliminar la Venta.","Warning", JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
    
}

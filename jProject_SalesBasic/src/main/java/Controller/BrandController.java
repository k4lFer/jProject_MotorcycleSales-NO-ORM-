package Controller;

import Controller.ServiceObject.Brand.SoBrand;
import DTOs.Objects.DtoBrand;
import Queries.QBrand;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kalfe
 */
public class BrandController {
    private QBrand model;
    private SoBrand so;
    
    public BrandController(){
        this.model = new QBrand();
        this.so = new SoBrand();
    }
    
    public List<DtoBrand> loadBrands(){
        return so.allBrands = model.getAll();
    }
    
    public int insertBrand(SoBrand so){
        int result = model.insert(so.dtoBrand);
        
        if(result > 0){
            JOptionPane.showMessageDialog(null, "Marca registrada exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "Error al registrar la Marca");
        }
        return result;
    }
    
   public int updateBrand(SoBrand so, String currentName){
       int result = model.update(so.dtoBrand);
       
        if(result > 0){
            JOptionPane.showMessageDialog(null, "Marca actualizada exitosamente", "Success", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Error al actualizar la Marca", "Success", JOptionPane.WARNING_MESSAGE);
        }
        return result;
    } 
   
   public int deleteBrand(int id){
    int result = model.delete(id);
       
    if (result > 0) {
            JOptionPane.showMessageDialog(null, "Marca eliminado exitosamente.","Success", JOptionPane.INFORMATION_MESSAGE);
    }else {
            JOptionPane.showMessageDialog(null, "Error al eliminar la Marca.","Warning", JOptionPane.WARNING_MESSAGE);
    }
    return result;
   }
   
   public DtoBrand getBrandId(int id){
       
       return null;
   }
   
    
}

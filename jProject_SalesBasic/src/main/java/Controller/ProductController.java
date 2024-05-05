package Controller;

import static Controller.ServiceObject.Products.ProductsValidation.validateAndInsertOrEditProduct;
import Controller.ServiceObject.Products.SoProducts;
import DTOs.Objects.DtoProducts;
import Queries.QProducts;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author kalfe
 */
public class ProductController {
    private QProducts model;
    private SoProducts so;

    public ProductController() {
        this.model = new QProducts();
        this.so = new SoProducts();
    }
    
    public List<DtoProducts> loadProducts(){
        return so.allProducts = model.getAll();
    }

    public int insertProduct(SoProducts so){
        try {
            if (!validateAndInsertOrEditProduct(so.dtoProducts)) {
                return -1; 
            }

            int result = model.insert(so.dtoProducts);
            if(result > 0){
                JOptionPane.showMessageDialog(null, "Producto registrado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el Producto");
            }

            return result;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1; 
        }
    }

    public int updateProduct(SoProducts so, String currentName){
        int result = model.update(so.dtoProducts);
        if(result > 0){
            JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente", "Success", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Error al actualizar el Producto", "Success", JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
    
    public int deleteProduct(int id){
        int result = model.delete(id);
        if (result > 0) {
            JOptionPane.showMessageDialog(null, "El Producto fue eliminado exitosamente.","Success", JOptionPane.INFORMATION_MESSAGE);
        }else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el Producto.","Warning", JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }

    public DtoProducts getProductByCod(String cod){
        DtoProducts product = model.getByCod(cod);
        if (product != null){
            so.dtoProducts = product;
            return product;
        } else{
            JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
    }
    
}

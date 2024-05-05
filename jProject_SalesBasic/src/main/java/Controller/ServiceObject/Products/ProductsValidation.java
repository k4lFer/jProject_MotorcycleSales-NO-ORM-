package Controller.ServiceObject.Products;

import DTOs.Objects.DtoProducts;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kalfe
 */
public class ProductsValidation {
    
    public static boolean validateAndInsertOrEditProduct(DtoProducts product) {
    ArrayList<String> errorMessages = new ArrayList<>();

    // Validación de la marca
    if (product.getBrandID() == -1) { // Asegúrate de que -1 es el valor por defecto para brandId
        errorMessages.add("Por favor, seleccione una marca válida.");
    }

    // Validación del tipo
    if (product.getMotorcycleTypeID() == -1) { // Asegúrate de que -1 es el valor por defecto para typeId
        errorMessages.add("Por favor, seleccione un tipo válido.");
    }
    
    if (product.getName() == null || product.getName().trim().isEmpty()) {
        errorMessages.add("El campo \"nombre\" es requerido.");
    }
    
    // Validación del precio
    if (product.getPrice() <= 0) {
        errorMessages.add("El campo \"precio\" debe ser mayor que 0.");
    }

    // Validación de la cilindrada
    if (product.getDisplacement() == null || product.getDisplacement().trim().isEmpty()) {
        errorMessages.add("El campo \"cilindrada\" es requerido.");
    }
    
    // Validación de la cantidad de stock
    if (product.getStockQuantity() <= 0) {
        errorMessages.add("El campo \"stock\" no puede ser negativo.");
    }
    
    if (!errorMessages.isEmpty()) {
        JOptionPane.showMessageDialog(null, String.join("\n", errorMessages), "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
}

}

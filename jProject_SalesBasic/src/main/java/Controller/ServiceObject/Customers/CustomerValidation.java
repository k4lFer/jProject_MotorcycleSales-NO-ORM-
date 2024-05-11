package Controller.ServiceObject.Customers;

import DTOs.Objects.DtoCustomer;
import DTOs.Other.DtoMessageObject;
import Queries.QCustomer;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kalfe
 */
public class CustomerValidation {
    private static DtoMessageObject mo = new DtoMessageObject();

    // Método para acumular mensajes de error
    private static void addErrorMessage(String message) {
        mo.addMessage(message);
        mo.error();
    }
    
    public static boolean isDniExists(String dni){
        QCustomer qCustomer = new QCustomer();
        DtoCustomer dtoCustomer = qCustomer.getByDni(dni);
        if(dtoCustomer!= null){
            JOptionPane.showMessageDialog(null, "El DNI ya existe.");
            return true;
        }
        return false;
    }
    
    public static boolean updateisDniExists(String currentDni, String newDni){
        if (currentDni.equals(newDni)) {
            return false; 
        }
        QCustomer qCustomer = new QCustomer();
        DtoCustomer dtoCustomer = qCustomer.getByDni(newDni);
        /*if(dtoCustomer != null){
           addErrorMessage("El DNI ya existe. No se puede actualizar a este DNI.");
           return true;
        }*/
        /*
        JOptionPane.showMessageDialog(null, "El DNI ya existe. No se puede actualizar a este DNI.", "Error", JOptionPane.ERROR_MESSAGE);
        return dtoCustomer != null; */
        //return false;
        
        if (dtoCustomer != null) {
            JOptionPane.showMessageDialog(null, "El DNI ya existe. No se puede actualizar a este DNI.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    
        return false; 
    }
    
    public static boolean validateAndInsertOrEditCustomer(DtoCustomer customer) {
        ArrayList<String> errorMessages = new ArrayList<>();

        if (customer.getDni() == null || customer.getDni().trim().isEmpty()) {
            errorMessages.add("El campo \"dni\" es requerido.");
        } else if (!customer.getDni().matches("^[0-9]{8}$")) {
            errorMessages.add("El formato del campo \"dni\" no es correcto.");
        }
        if (customer.getFirstName() == null || customer.getFirstName().trim().isEmpty()) {
            errorMessages.add("El campo \"firstName\" es requerido.");
        }
        if (customer.getLastName() == null || customer.getLastName().trim().isEmpty()) {
            errorMessages.add("El campo \"lastName\" es requerido.");
        }
        if (customer.getAddress() == null || customer.getAddress().trim().isEmpty()) {
            errorMessages.add("El campo \"address\" es requerido.");
        }
        if (customer.getPhone() == null || customer.getPhone().trim().isEmpty()) {
            errorMessages.add("El campo \"phone\" es requerido.");
        }
        else if (!customer.getPhone().matches("^[0-9]{9}$")) {
            errorMessages.add("El formato del campo \"phone\" no es correcto.");
        }

        if (!errorMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, String.join("\n", errorMessages), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}

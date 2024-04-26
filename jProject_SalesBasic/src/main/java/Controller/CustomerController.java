package Controller;

import DTOs.Objects.DtoCustomer;
import Queries.QCustomer;
import Controller.ServiceObject.Customers.CustomerValidation;
import static Controller.ServiceObject.Customers.CustomerValidation.updateisDniExists;
import Controller.ServiceObject.Customers.SoCustomers;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kalfe
 */
public class CustomerController {
    private QCustomer model;
    private SoCustomers so;

    public CustomerController() {
        this.model = new QCustomer();
        this.so = new SoCustomers();
    }

    // Método para cargar todos los clientes
    public List<DtoCustomer> loadCustomers() {
        return so.allCustomers = model.getAll();
    }

    // Método para insertar un nuevo cliente
    public int insertCustomer(SoCustomers so) {
        if (!CustomerValidation.validateAndInsertOrEditCustomer(so.dtoCustomer)) {
          return -1;
        }
        if (CustomerValidation.isDniExists(so.dtoCustomer.getDni()) || !CustomerValidation.validateAndInsertOrEditCustomer(so.dtoCustomer)) {
            return -1; 
        }

        int result = model.insert(so.dtoCustomer);

        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al crear el cliente.");
        }
        //so.setAllCustomers(model.getAll());

        return result;
    }
    

    // Método para actualizar un cliente existente  
    public int updateCustomer(SoCustomers so, String currentDni) {
        if (!CustomerValidation.validateAndInsertOrEditCustomer(so.dtoCustomer)) {
            return -1;
        }
        if (updateisDniExists(currentDni, so.dtoCustomer.getDni())) {
            return -1;
        }        

        int result = model.update(so.dtoCustomer);

        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.","Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el cliente.","Warning", JOptionPane.WARNING_MESSAGE);
        }

        //so.setAllCustomers(model.getAll());
        return result;
    }

    // Método para eliminar un cliente por ID
    public int deleteCustomer(int id) {
        int result = model.delete(id);

        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.","Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar el cliente.","Warning", JOptionPane.WARNING_MESSAGE);
        }

        //so.setAllCustomers(model.getAll());

        return result;
        }

    // Método para obtener un cliente por DNI
    public DtoCustomer getCustomerByDni(String dni) {
        for (DtoCustomer customer : so.getAllCustomers()) {
            if (customer.getDni().equals(dni)) {
                return customer;
            }
        }
        // Si no se encuentra el cliente, retorna null
        return null;
    }

    // Método para obtener un cliente por ID
    public DtoCustomer getCustomerById(int id) {
        // Realiza la búsqueda en la lista de clientes del objeto SoCustomers
        for (DtoCustomer customer : so.getAllCustomers()) {
            if (customer.getCustomerID() == id) {
                return customer;
            }
        }
        // Si no se encuentra el cliente, retorna null
        return null;
    }
}

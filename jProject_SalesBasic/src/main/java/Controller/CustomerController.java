package Controller;

import Objects.DtoCustomer;
import Queries.QCustomer;
import Utils.CustomerValidation;
import Views.Maintenances.Customer.Customers;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kalfe
 */
public class CustomerController {
    private Customers view;
    private QCustomer model;

public CustomerController() {
        this.model = new QCustomer();
    }

    // Método para cargar todos los clientes
    public List<DtoCustomer> loadCustomers() {
        return model.getAll();
    }

    // Método para insertar un nuevo cliente
    public int insertCustomer(DtoCustomer newCustomer) {
        if (CustomerValidation.isDniExists(newCustomer.getDni())) {
            JOptionPane.showMessageDialog(null, "El DNI ya existe.");
            return 0; 
        }

        int result = model.insert(newCustomer);

        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al crear el cliente.");
        }

        return result;
    }
    

    // Método para actualizar un cliente existente
    public int updateCustomer(DtoCustomer customerToUpdate) {
        return model.update(customerToUpdate);
    }

    // Método para eliminar un cliente por ID
    public int deleteCustomer(int id) {
        return model.delete(id);
    }

    // Método para obtener un cliente por DNI
    public DtoCustomer getCustomerByDni(String dni) {
        return model.getByDni(dni);
    }

    // Método para obtener un cliente por ID
    public DtoCustomer getCustomerById(int id) {
        return model.getById(id);
    }
}

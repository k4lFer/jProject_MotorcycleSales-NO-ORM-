package Controller.ServiceObject.Customers;

import Controller.ServiceObject.Generic.SoMessageObject;
import DTOs.Objects.DtoCustomer;
import java.util.List;

/**
 *
 * @author kalfe
 */
public class SoCustomers extends SoMessageObject{
    public DtoCustomer dtoCustomer;
    public List<DtoCustomer> allCustomers;

    public SoCustomers() {
        this.dtoCustomer = new DtoCustomer();
    }

    public SoCustomers(DtoCustomer dtoCustomer, List<DtoCustomer> allCustomers) {
        this.dtoCustomer = dtoCustomer;
        this.allCustomers = allCustomers;
    }

    public DtoCustomer getDtoCustomer() {
        return dtoCustomer;
    }

    public void setDtoCustomer(DtoCustomer dtoCustomer) {
        this.dtoCustomer = dtoCustomer;
    }

    public List<DtoCustomer> getAllCustomers() {
        return allCustomers;
    }

    public void setAllCustomers(List<DtoCustomer> allCustomers) {
        this.allCustomers = allCustomers;
    }    
}

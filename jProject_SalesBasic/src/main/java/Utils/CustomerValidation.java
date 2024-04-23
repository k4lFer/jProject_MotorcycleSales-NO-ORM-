package Utils;

import Objects.DtoCustomer;
import Queries.QCustomer;

/**
 *
 * @author kalfe
 */
public class CustomerValidation {
    public static boolean  isDniExists(String dni){
        QCustomer qCustomer = new QCustomer();
        DtoCustomer dtoCustomer = qCustomer.getByDni(dni);
        return dtoCustomer != null;       
    }
    
    public static boolean updateisDniExists(String currentDni, String newDni){
        if (currentDni.equals(newDni)) {
            return false; 
        }
        QCustomer qCustomer = new QCustomer();
        DtoCustomer dtoCustomer = qCustomer.getByDni(newDni);
        return dtoCustomer != null; 
    }
}

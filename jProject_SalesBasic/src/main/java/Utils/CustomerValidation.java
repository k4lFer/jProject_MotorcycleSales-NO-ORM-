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
}

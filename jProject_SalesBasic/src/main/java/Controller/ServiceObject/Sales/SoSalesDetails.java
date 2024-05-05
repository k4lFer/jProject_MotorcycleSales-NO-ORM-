package Controller.ServiceObject.Sales;

import DTOs.Objects.DtoSalesDetails;
import java.util.List;

/**
 *
 * @author kalfe
 */
public class SoSalesDetails {
    public DtoSalesDetails dtoSalesDetails;
    public List<DtoSalesDetails> allSalesDetails;

    public SoSalesDetails() {
        this.dtoSalesDetails = new DtoSalesDetails();
    }

    public SoSalesDetails(DtoSalesDetails dtoSalesDetails, List<DtoSalesDetails> allSalesDetails) {
        this.dtoSalesDetails = dtoSalesDetails;
        this.allSalesDetails = allSalesDetails;
    }

    public DtoSalesDetails getDtoSalesDetails() {
        return dtoSalesDetails;
    }

    public void setDtoSalesDetails(DtoSalesDetails dtoSalesDetails) {
        this.dtoSalesDetails = dtoSalesDetails;
    }

    public List<DtoSalesDetails> getAllSalesDetails() {
        return allSalesDetails;
    }

    public void setAllSalesDetails(List<DtoSalesDetails> allSalesDetails) {
        this.allSalesDetails = allSalesDetails;
    }
    
}

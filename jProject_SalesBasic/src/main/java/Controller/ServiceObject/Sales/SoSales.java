package Controller.ServiceObject.Sales;

import DTOs.Objects.DtoSales;
import java.util.List;

/**
 *
 * @author kalfe
 */
public class SoSales {
    public DtoSales dtoSales;
    public List<DtoSales> allSales;

    public SoSales() {
        this.dtoSales = new DtoSales();
    }

    public SoSales(DtoSales dtoSales, List<DtoSales> allSales) {
        this.dtoSales = dtoSales;
        this.allSales = allSales;
    }

    public DtoSales getDtoSales() {
        return dtoSales;
    }

    public void setDtoSales(DtoSales dtoSales) {
        this.dtoSales = dtoSales;
    }

    public List<DtoSales> getAllSales() {
        return allSales;
    }

    public void setAllSales(List<DtoSales> allSales) {
        this.allSales = allSales;
    }
    
}

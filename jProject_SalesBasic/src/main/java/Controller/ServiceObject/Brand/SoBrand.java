package Controller.ServiceObject.Brand;

import DTOs.Objects.DtoBrand;
import java.util.List;

/**
 *
 * @author kalfe
 */
public class SoBrand {
    public DtoBrand dtoBrand;
    public List<DtoBrand> allBrands;

    public SoBrand() {
        this.dtoBrand = new DtoBrand();
    }

    public SoBrand(DtoBrand dtoBrand, List<DtoBrand> allBrands) {
        this.dtoBrand = dtoBrand;
        this.allBrands = allBrands;
    }

    public DtoBrand getDtoBrand() {
        return dtoBrand;
    }

    public void setDtoBrand(DtoBrand dtoBrand) {
        this.dtoBrand = dtoBrand;
    }

    public List<DtoBrand> getAllBrands() {
        return allBrands;
    }

    public void setAllBrands(List<DtoBrand> allBrands) {
        this.allBrands = allBrands;
    }
    
    
}

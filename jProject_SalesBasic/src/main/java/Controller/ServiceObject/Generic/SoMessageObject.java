package Controller.ServiceObject.Generic;

import DTOs.Other.DtoMessageObject;
import java.util.List;

/**
 *
 * @author kalfe
 */
public class SoMessageObject {
    public DtoMessageObject mo;

    public SoMessageObject() {
        this.mo = new DtoMessageObject();
    }

    public SoMessageObject(DtoMessageObject mo) {
        this.mo = mo;
    }

    public DtoMessageObject getMo() {
        return mo;
    }

    public void setMo(DtoMessageObject mo) {
        this.mo = mo;
    }
    
    
    
}

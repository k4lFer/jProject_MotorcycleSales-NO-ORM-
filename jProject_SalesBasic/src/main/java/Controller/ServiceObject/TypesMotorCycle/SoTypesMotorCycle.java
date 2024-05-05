package Controller.ServiceObject.TypesMotorCycle;

import java.util.List;

import DTOs.Objects.DtoMotorcycleType;

public class SoTypesMotorCycle {
    public DtoMotorcycleType dtoType;
    public List<DtoMotorcycleType> allTypes;

    public SoTypesMotorCycle(){
        this.dtoType = new DtoMotorcycleType();
    }

    public SoTypesMotorCycle(DtoMotorcycleType dtoType, List<DtoMotorcycleType> allTypes){
        this.dtoType = dtoType;
        this.allTypes = allTypes;
    }
    
    public DtoMotorcycleType getDtoType() {
        return dtoType;
    }

    public void setDtoType(DtoMotorcycleType dtoType) {
        this.dtoType = dtoType;
    }

    public List<DtoMotorcycleType> getAllTypes() {
        return allTypes;
    }

    public void setAllTypes(List<DtoMotorcycleType> allTypes) {
        this.allTypes = allTypes;
    }
}

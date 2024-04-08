package Objects;

/**
 *
 * @author kalfe
 */
public class DtoMotorcycleType {
    private int motorcycleTypeID;
    private String name;

    public DtoMotorcycleType() {
    }

    public DtoMotorcycleType(int motorcycleTypeID, String name) {
        this.motorcycleTypeID = motorcycleTypeID;
        this.name = name;
    }

    public int getMotorcycleTypeID() {
        return motorcycleTypeID;
    }

    public void setMotorcycleTypeID(int motorcycleTypeID) {
        this.motorcycleTypeID = motorcycleTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}

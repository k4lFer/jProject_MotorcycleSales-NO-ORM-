package Entities;

/**
 *
 * @author kalfe
 */
public class MotorcycleType {
    private int motorcycleTypeID;
    private String name;

    public MotorcycleType() {
    }

    public MotorcycleType(int motorcycleTypeID, String name) {
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

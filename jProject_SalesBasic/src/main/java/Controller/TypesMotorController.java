package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import Controller.ServiceObject.TypesMotorCycle.SoTypesMotorCycle;
import DTOs.Objects.DtoMotorcycleType;
import Queries.QMotorcycleType;

/**
 *
 * @author kalfe
 */
public class TypesMotorController {
    private QMotorcycleType model;
    private SoTypesMotorCycle so;

    public TypesMotorController() {
        this.model = new QMotorcycleType();
        this.so = new SoTypesMotorCycle();
    }
    

    public List<DtoMotorcycleType> loadTypesMotorcycle() {
        return so.allTypes = model.getAll();
    }

    public int insertTypes(SoTypesMotorCycle so){
        int result = model.insert(so.dtoType);

        if(result > 0){
            JOptionPane.showMessageDialog(null, "Tipo de Motocicleta registrada exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "Error al registrar el Tipo de Motocicleta");
        }
        return result;

    }

    public int updateTypes(SoTypesMotorCycle so, String currentName){
        int result = model.update(so.dtoType);
        if(result > 0){
            JOptionPane.showMessageDialog(null, "Tipo de Motocicleta actualizada exitosamente", "Success", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Error al actualizar el Tipo de Motocicleta", "Success", JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }

    public int deleteTypes(int id){
        int result = model.delete(id);
        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Tipo de Motocicleta eliminado exitosamente.","Success", JOptionPane.INFORMATION_MESSAGE);
        }else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el Tipo de Motocicleta.","Warning", JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }

    public DtoMotorcycleType getTypeId(int id){
        return null;
    }
}

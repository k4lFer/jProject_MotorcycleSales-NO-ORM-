package Views.Maintenances.Product.Products.Functions;

import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author kalfe
 */
public class MappedComboBoxModel extends DefaultComboBoxModel<String> {
    private Map<String, Integer> idMap = new HashMap<>();

    public void addItemWithId(String name, int id) {
        super.addElement(name);
        idMap.put(name, id);
    }

    public int getIdForName(String name) {
        return idMap.get(name);
    }
}

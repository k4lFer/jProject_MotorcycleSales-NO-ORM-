package Views.Maintenances.Product.TypesMotorCycle;

import java.awt.Frame;
import java.awt.JobAttributes;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controller.TypesMotorController;
import Controller.ServiceObject.TypesMotorCycle.SoTypesMotorCycle;
import DTOs.Objects.DtoMotorcycleType;

/**
 *
 * @author kalfe
 */
public class TypesMotorCycle extends javax.swing.JPanel {
    private TypesMotorController controller;
    private HashMap<Integer, Integer> rowToTypeIdMap = new HashMap();
 
    /**
     * Creates new form TypesMotroCycle
     */
    public TypesMotorCycle() {
        initComponents();
        controller = new TypesMotorController();
    }

    public void updateTable(List<DtoMotorcycleType> types){
        String[] columnName = {"Tipo de Motocicleta"};
        DefaultTableModel model = new DefaultTableModel(columnName, 0);
        rowToTypeIdMap.clear();
        for(DtoMotorcycleType type :types){
            Object[] row = new Object[2];
            row[0] = type.getName();
            model.addRow(row);
            rowToTypeIdMap.put(model.getRowCount()-1, type.getMotorcycleTypeID());
        }
        jTable_TypesMotorCycle.setModel(model);
    }

    public void insertTypes(){
        String name = typesMotorCycleTextField.getText();

        SoTypesMotorCycle newType = new SoTypesMotorCycle();
            newType.dtoType.setName(name);
        int result = controller.insertTypes(newType);
        if(result == 1){
            typesMotorCycleTextField.setText("");
            List<DtoMotorcycleType> types = controller.loadTypesMotorcycle();
            updateTable(types);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titleType = new javax.swing.JLabel();
        typesMotorCycleTextField = new javax.swing.JTextField();
        jBttn_NewType = new javax.swing.JButton();
        jBttn_EditType = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_TypesMotorCycle = new javax.swing.JTable();
        jBttn_ViewTypes = new javax.swing.JButton();
        jBttn_DeleteType = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titleType.setText("Tipo de Motocicleta:");
        add(jLabel_titleType, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));
        add(typesMotorCycleTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 110, -1));

        jBttn_NewType.setText("Crear");
        jBttn_NewType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_NewTypeActionPerformed(evt);
            }
        });
        add(jBttn_NewType, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        jBttn_EditType.setText("Editar");
        jBttn_EditType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_EditTypeActionPerformed(evt);
            }
        });
        add(jBttn_EditType, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        jTable_TypesMotorCycle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_TypesMotorCycle);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, 230));

        jBttn_ViewTypes.setText("Mostrar");
        jBttn_ViewTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_ViewTypesActionPerformed(evt);
            }
        });
        add(jBttn_ViewTypes, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, -1, -1));

        jBttn_DeleteType.setText("Eliminar");
        jBttn_DeleteType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_DeleteTypeActionPerformed(evt);
            }
        });
        add(jBttn_DeleteType, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jBttn_ViewTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_ViewTypesActionPerformed
        // TODO add your handling code here:
        List<DtoMotorcycleType> types = controller.loadTypesMotorcycle();
        updateTable(types);
    }//GEN-LAST:event_jBttn_ViewTypesActionPerformed

    private void jBttn_NewTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_NewTypeActionPerformed
        // TODO add your handling code here:
        insertTypes();
    }//GEN-LAST:event_jBttn_NewTypeActionPerformed

    private void jBttn_EditTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_EditTypeActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable_TypesMotorCycle.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Selecciona un Tipo de Motocicleta para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int typeID = rowToTypeIdMap.get(selectedRow);
        String name = (String) jTable_TypesMotorCycle.getValueAt(selectedRow, 0);

        Frame f = JOptionPane.getFrameForComponent(this);

        UpdateTypes updateDialog = new UpdateTypes(f, true, controller, this);
        
        updateDialog.setTypeData(name, typeID);
        updateDialog.setVisible(true);
        

    }//GEN-LAST:event_jBttn_EditTypeActionPerformed

    private void jBttn_DeleteTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_DeleteTypeActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable_TypesMotorCycle.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Selecciona un Tipo para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int typeID = rowToTypeIdMap.get(selectedRow);
        String name = (String) jTable_TypesMotorCycle.getValueAt(selectedRow, 0);

        Frame f = JOptionPane.getFrameForComponent(this);
        DeleteTypes deleteDialog = new DeleteTypes(f, true,controller, this);

        deleteDialog.setTypeData(name, typeID);
        deleteDialog.setVisible(true);
    }//GEN-LAST:event_jBttn_DeleteTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttn_DeleteType;
    private javax.swing.JButton jBttn_EditType;
    private javax.swing.JButton jBttn_NewType;
    private javax.swing.JButton jBttn_ViewTypes;
    private javax.swing.JLabel jLabel_titleType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_TypesMotorCycle;
    private javax.swing.JTextField typesMotorCycleTextField;
    // End of variables declaration//GEN-END:variables
}
package Views.Maintenances.Product.TypesMotorCycle;

import java.util.List;

import Controller.TypesMotorController;
import Controller.ServiceObject.TypesMotorCycle.SoTypesMotorCycle;
import DTOs.Objects.DtoMotorcycleType;

/**
 *
 * @author kalfe
 */
public class UpdateTypes extends java.awt.Dialog {
    private TypesMotorController controller;
    private int ID;
    private String currentName;
    private TypesMotorCycle form;

    /**
     * Creates new form UpdateTypes
     */
    public UpdateTypes(java.awt.Frame parent, boolean modal, TypesMotorController controller, TypesMotorCycle form) {
        super(parent, modal);
        this.ID = ID;
        this.form = form;
        this.controller = controller;
        setLocationRelativeTo(null);
        initComponents();
    }
    
    public void setTypeData(String name, int typeID){
        this.currentName = name;
        jTextField_type.setText(name);
        ID = typeID;
    }

    public void updateType(){
        String name = jTextField_type.getText();
        String currentName = "";
        SoTypesMotorCycle typeToUpdate = new SoTypesMotorCycle();
        typeToUpdate.dtoType.setMotorcycleTypeID(ID);
        typeToUpdate.dtoType.setName(name);

        int result = controller.updateTypes(typeToUpdate, this.currentName);
        if(result > 0){
           List<DtoMotorcycleType> types = controller.loadTypesMotorcycle();
           form.updateTable(types);
           dispose();
       } 
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_titleT = new javax.swing.JLabel();
        jLabel_nameType = new javax.swing.JLabel();
        jTextField_type = new javax.swing.JTextField();
        jBttn_update = new javax.swing.JButton();
        jBttn_cancel = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titleT.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel_titleT.setText("Actualizar Tipo de Moto");
        jPanel1.add(jLabel_titleT, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 190, -1));

        jLabel_nameType.setText("Nombre:");
        jPanel1.add(jLabel_nameType, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jTextField_type.setText("jTextField1");
        jPanel1.add(jTextField_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 110, -1));

        jBttn_update.setText("Actualizar");
        jBttn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_updateActionPerformed(evt);
            }
        });
        jPanel1.add(jBttn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        jBttn_cancel.setText("Cancelar");
        jBttn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_cancelActionPerformed(evt);
            }
        });
        jPanel1.add(jBttn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jBttn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_updateActionPerformed
        // TODO add your handling code here:
        updateType();
    }//GEN-LAST:event_jBttn_updateActionPerformed

    private void jBttn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_cancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBttn_cancelActionPerformed

    /**
     * @param args the command line arguments
     */
   // public static void main(String args[]) {
        //java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TypesMotorCycle typesForm = new TypesMotorCycle();
                TypesMotorController controller = new TypesMotorController();
                UpdateTypes dialog = new UpdateTypes(new java.awt.Frame(), true, controller, typesForm);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        //});
    //}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttn_cancel;
    private javax.swing.JButton jBttn_update;
    private javax.swing.JLabel jLabel_nameType;
    private javax.swing.JLabel jLabel_titleT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_type;
    // End of variables declaration//GEN-END:variables
}

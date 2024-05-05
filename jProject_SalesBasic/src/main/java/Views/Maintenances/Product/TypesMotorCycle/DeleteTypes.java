package Views.Maintenances.Product.TypesMotorCycle;

import java.util.List;

import javax.swing.JOptionPane;

import Controller.TypesMotorController;
import DTOs.Objects.DtoBrand;
import DTOs.Objects.DtoMotorcycleType;
import DTOs.Other.DtoMessageObject;

/**
 *
 * @author kalfe
 */
public class DeleteTypes extends java.awt.Dialog {
    private TypesMotorController controller;
    private int ID;
    private TypesMotorCycle form;

    /**
     * Creates new form DeleteTypes
     */
    public DeleteTypes(java.awt.Frame parent, boolean modal, TypesMotorController controller, TypesMotorCycle form) {
        super(parent, modal);
        this.ID = ID;
        this.form = form;
        this.controller = controller;
        setLocationRelativeTo(null);
        initComponents();
    }
    public void setTypeData(String name, int typeID){
        jLabel_viewDataType.setText("<html>Está seguro que desea eliminar el Tipo de Moto: <b>"+name+ "</b></html>");
        ID = typeID;
    }

    public void deleteType(){
        int id = ID;
        int result = controller.deleteTypes(id);
        if(result > 0){
            JOptionPane.showMessageDialog(null, "Tipo de Motocicleta eliminada exitosamente");
            List<DtoMotorcycleType> types = controller.loadTypesMotorcycle();
            form.updateTable(types);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "No se puedo eliminar el Tipo.");
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_titleT = new javax.swing.JLabel();
        jLabel_viewDataType = new javax.swing.JLabel();
        jBttn_delete = new javax.swing.JButton();
        jBttn_cancel = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titleT.setText("Eliminar Tipo de Moto");
        jPanel1.add(jLabel_titleT, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 130, -1));

        jLabel_viewDataType.setText("jLabel1");
        jPanel1.add(jLabel_viewDataType, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 290, 100));

        jBttn_delete.setText("Eliminar");
        jBttn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(jBttn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jBttn_cancel.setText("Cancelar");
        jBttn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_cancelActionPerformed(evt);
            }
        });
        jPanel1.add(jBttn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jBttn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_deleteActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este Tipo", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            deleteType();
        }
    }//GEN-LAST:event_jBttn_deleteActionPerformed

    private void jBttn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_cancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBttn_cancelActionPerformed

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
        //java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TypesMotorCycle typesForm = new TypesMotorCycle();
                TypesMotorController controller = new TypesMotorController();
                DeleteTypes dialog = new DeleteTypes(new java.awt.Frame(), true, controller, typesForm);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
       // });
    //}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttn_cancel;
    private javax.swing.JButton jBttn_delete;
    private javax.swing.JLabel jLabel_titleT;
    private javax.swing.JLabel jLabel_viewDataType;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
package Views.Maintenances.Customer;

import Controller.CustomerController;
import DTOs.Objects.DtoCustomer;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kalfe
 */
public class CustomerDelete extends java.awt.Dialog {
    private CustomerController controller;
    private int ID;
    private CustomersMain form;
    /**
     * Creates new form CustomerDelete
     */
    public CustomerDelete(java.awt.Frame parent, boolean modal, CustomerController controller, CustomersMain form) {
        super(parent, modal);
        this.ID = ID;
        this.controller = controller;
        this.form = form;
        setLocationRelativeTo(null);
        initComponents();
        
    }
    public void setCustomerData(String dni, String firstName, String lastName, String address, String phone,int customerID) {
        jLabel_Customer.setText("<html>Está seguro que desea eliminar al Cliente: <b>" + firstName + " " + lastName + "</b>?<br>"
            + "<b>N° Dni: " + dni + "</b></html>");

        ID = customerID;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_background = new javax.swing.JPanel();
        jLabel_title = new javax.swing.JLabel();
        jLabel_Customer = new javax.swing.JLabel();
        jBttn_delete = new javax.swing.JButton();
        jBttn_close = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_title.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel_title.setText("Eliminar Cliente");
        jPanel_background.add(jLabel_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));
        jPanel_background.add(jLabel_Customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 300, 70));

        jBttn_delete.setText("Eliminar");
        jBttn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_deleteActionPerformed(evt);
            }
        });
        jPanel_background.add(jBttn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        jBttn_close.setText("Cancelar");
        jBttn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_closeActionPerformed(evt);
            }
        });
        jPanel_background.add(jBttn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_background, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_background, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
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

    private void jBttn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_closeActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBttn_closeActionPerformed

    public void deleteCustomer(){
        int id = (ID);
        int result = controller.deleteCustomer(id);
        if(result > 0){
            //JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.");
            List<DtoCustomer> customers = controller.loadCustomers();
            form.updateTable(customers);
            dispose();
        }
        
        
    }
    private void jBttn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_deleteActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar a este cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            deleteCustomer();
        }
        
    }//GEN-LAST:event_jBttn_deleteActionPerformed

    /**
     * @param args the command line arguments
     */
   // public static void main(String args[]) {
        //java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustomersMain customersForm = new CustomersMain();
                CustomerController controller = new CustomerController();
                CustomerDelete dialog = new CustomerDelete(new java.awt.Frame(), true, controller, customersForm);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        //});
   // }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttn_close;
    private javax.swing.JButton jBttn_delete;
    private javax.swing.JLabel jLabel_Customer;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JPanel jPanel_background;
    // End of variables declaration//GEN-END:variables
}

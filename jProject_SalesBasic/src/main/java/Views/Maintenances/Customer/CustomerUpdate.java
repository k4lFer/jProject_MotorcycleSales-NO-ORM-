package Views.Maintenances.Customer;

import Controller.CustomerController;
import Controller.ServiceObject.Customers.SoCustomers;
import DTOs.Objects.DtoCustomer;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kalfe
 */
public class CustomerUpdate extends java.awt.Dialog {
    private CustomerController controller;
    private int ID;
    private String currentDni;
    private CustomersMain form;

    /**
     * Creates new form CustomerEdit
     */
    public CustomerUpdate(java.awt.Frame parent, boolean modal, CustomerController controller,  CustomersMain form) {
        super(parent, modal);
        this.ID = ID;
        this.form = form;
        this.controller = controller;
        initComponents();
        setLocationRelativeTo(null);
 
    }
    
    public void setCustomerData(String dni, String firstName, String lastName, String address, String phone,int customerID) {
        this.currentDni = dni;
        jTextField_dni.setText(dni);
        jTextField_firstName.setText(firstName);
        jTextField_lastName.setText(lastName);
        jTextField_Address.setText(address);
        jTextField_phone.setText(phone);
        ID = customerID;
    }
    public void updateCustomer(){
        /*if (jTextField_dni.getText().isEmpty() || jTextField_firstName.getText().isEmpty() ||
            jTextField_lastName.getText().isEmpty() || jTextField_Address.getText().isEmpty() ||
            jTextField_phone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        } */
        
        String dni = jTextField_dni.getText();
        String firstName = jTextField_firstName.getText();
        String lastName = jTextField_lastName.getText();
        String address = jTextField_Address.getText();
        String phone = jTextField_phone.getText();
 
        String currentDni = "";
        SoCustomers customerToUpdate = new SoCustomers();
        //customerToUpdate.dtoCustomer = new DtoCustomer();
            customerToUpdate.dtoCustomer.setDni(dni);
            customerToUpdate.dtoCustomer.setFirstName(firstName);
            customerToUpdate.dtoCustomer.setLastName(lastName);
            customerToUpdate.dtoCustomer.setAddress(address);
            customerToUpdate.dtoCustomer.setPhone(phone);
            customerToUpdate.dtoCustomer.setCustomerID(ID);
             
        int result = controller.updateCustomer(customerToUpdate, this.currentDni);
        
        if (result > 0) {
                List<DtoCustomer> customers = controller.loadCustomers();
                form.updateTable(customers);
                dispose();
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_background = new javax.swing.JPanel();
        jLabel_dni = new javax.swing.JLabel();
        jTextField_dni = new javax.swing.JTextField();
        jLabel_firstName = new javax.swing.JLabel();
        jTextField_firstName = new javax.swing.JTextField();
        jLabel_lastName = new javax.swing.JLabel();
        jTextField_lastName = new javax.swing.JTextField();
        jLabel_address = new javax.swing.JLabel();
        jTextField_Address = new javax.swing.JTextField();
        jLabel_phone = new javax.swing.JLabel();
        jTextField_phone = new javax.swing.JTextField();
        jBttn_update = new javax.swing.JButton();
        jBttn_cancel = new javax.swing.JButton();
        jLabel_title = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_dni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_dni.setText("N° DNI:");
        jPanel_background.add(jLabel_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jTextField_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_dniKeyTyped(evt);
            }
        });
        jPanel_background.add(jTextField_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 90, -1));

        jLabel_firstName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_firstName.setText("Nombre:");
        jPanel_background.add(jLabel_firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        jPanel_background.add(jTextField_firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 90, -1));

        jLabel_lastName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_lastName.setText("Apellido:");
        jPanel_background.add(jLabel_lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel_background.add(jTextField_lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 90, -1));

        jLabel_address.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_address.setText("Dirección:");
        jPanel_background.add(jLabel_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));
        jPanel_background.add(jTextField_Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 110, -1));

        jLabel_phone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_phone.setText("N° Telefono:");
        jPanel_background.add(jLabel_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        jTextField_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_phoneKeyTyped(evt);
            }
        });
        jPanel_background.add(jTextField_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 90, -1));

        jBttn_update.setText("Actualizar");
        jBttn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_updateActionPerformed(evt);
            }
        });
        jPanel_background.add(jBttn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));

        jBttn_cancel.setText("Cancelar");
        jBttn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_cancelActionPerformed(evt);
            }
        });
        jPanel_background.add(jBttn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        jLabel_title.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel_title.setText("Editar Cliente");
        jPanel_background.add(jLabel_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_background, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_background, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        updateCustomer();
    }//GEN-LAST:event_jBttn_updateActionPerformed

    private void jTextField_dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_dniKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || jTextField_dni.getText().length() >= 8) {
            evt.consume();
        } 
    }//GEN-LAST:event_jTextField_dniKeyTyped

    private void jTextField_phoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_phoneKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || jTextField_phone.getText().length() >= 9) {
            evt.consume(); 
        }         
    }//GEN-LAST:event_jTextField_phoneKeyTyped

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
                CustomersMain customersForm = new CustomersMain();
                CustomerController controller = new CustomerController();
                CustomerUpdate dialog = new CustomerUpdate(new java.awt.Frame(), true, controller, customersForm);
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
    javax.swing.JButton jBttn_cancel;
    javax.swing.JButton jBttn_update;
    javax.swing.JLabel jLabel_address;
    javax.swing.JLabel jLabel_dni;
    javax.swing.JLabel jLabel_firstName;
    javax.swing.JLabel jLabel_lastName;
    javax.swing.JLabel jLabel_phone;
    javax.swing.JLabel jLabel_title;
    javax.swing.JPanel jPanel_background;
    javax.swing.JTextField jTextField_Address;
    javax.swing.JTextField jTextField_dni;
    javax.swing.JTextField jTextField_firstName;
    javax.swing.JTextField jTextField_lastName;
    javax.swing.JTextField jTextField_phone;
    // End of variables declaration//GEN-END:variables
}

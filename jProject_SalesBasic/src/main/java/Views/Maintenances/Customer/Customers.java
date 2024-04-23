package Views.Maintenances.Customer;

import Controller.CustomerController;
import Objects.DtoCustomer;
import java.util.List;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kalfe
 */
public class Customers extends javax.swing.JFrame {
    private CustomerController controller;
    private HashMap<Integer, Integer> rowToCustomerIdMap = new HashMap<>();

    /**
     * Creates new form jFrame_Customers
     */
    public Customers() {
        initComponents();
        controller = new CustomerController();            
    }
    public void updateTable(List<DtoCustomer> customers) {      
    String[] columnNames = {"DNI", "Nombre y Apellido", "Dirección", "Teléfono"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        rowToCustomerIdMap.clear(); 
        for (DtoCustomer customer : customers) {
            Object[] row = new Object[4]; 
            row[0] = customer.getDni();
            row[1] = customer.getFirstName() + ", " + customer.getLastName();
            row[2] = customer.getAddress();
            row[3] = customer.getPhone();
            model.addRow(row);
           
            rowToCustomerIdMap.put(model.getRowCount() - 1, customer.getCustomerID());
        }
        jTable_Customers.setModel(model);
    
    }

    public void insertCustomer(){
        if (dniTextField.getText().isEmpty() || firstNameTextField.getText().isEmpty() ||
            lastNameTextField.getText().isEmpty() || addressTextField.getText().isEmpty() ||
            phoneTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }        
        String dni = dniTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String address = addressTextField.getText();
        String phone = phoneTextField.getText();
        
       DtoCustomer newCustomer = new DtoCustomer();
        newCustomer.setDni(dni);
        newCustomer.setFirstName(firstName);
        newCustomer.setLastName(lastName);
        newCustomer.setAddress(address);
        newCustomer.setPhone(phone);
        int result = controller.insertCustomer(newCustomer);
        if(result == 1){
            dniTextField.setText("");
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            addressTextField.setText("");
            phoneTextField.setText("");
            List<DtoCustomer> customers = controller.loadCustomers();
            updateTable(customers);
        }
        else{
            JOptionPane.showMessageDialog(null, "Error al crear el cliente.");
        }
        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_BackGround = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Customers = new javax.swing.JTable();
        jBttn_load = new javax.swing.JButton();
        jLabel_dni = new javax.swing.JLabel();
        jLabel_firstName = new javax.swing.JLabel();
        jLabel_lastName = new javax.swing.JLabel();
        jLabel_address = new javax.swing.JLabel();
        jLabel_phone = new javax.swing.JLabel();
        dniTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        jBttn_NewCustomer = new javax.swing.JButton();
        jBttn_EditCustomer = new javax.swing.JButton();
        jBttn_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_BackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_Customers);

        jPanel_BackGround.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 460, 190));

        jBttn_load.setText("Mostrar");
        jBttn_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_loadActionPerformed(evt);
            }
        });
        jPanel_BackGround.add(jBttn_load, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, -1, -1));

        jLabel_dni.setText("N° DNI:");
        jPanel_BackGround.add(jLabel_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel_firstName.setText("Nombre:");
        jPanel_BackGround.add(jLabel_firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        jLabel_lastName.setText("Apellido:");
        jPanel_BackGround.add(jLabel_lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jLabel_address.setText("Direccion:");
        jPanel_BackGround.add(jLabel_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel_phone.setText("N° Telefono:");
        jPanel_BackGround.add(jLabel_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        dniTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dniTextFieldKeyTyped(evt);
            }
        });
        jPanel_BackGround.add(dniTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 110, -1));
        jPanel_BackGround.add(firstNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 110, -1));
        jPanel_BackGround.add(lastNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 110, -1));
        jPanel_BackGround.add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 100, -1));

        phoneTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneTextFieldKeyTyped(evt);
            }
        });
        jPanel_BackGround.add(phoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 90, -1));

        jBttn_NewCustomer.setText("Crear");
        jBttn_NewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_NewCustomerActionPerformed(evt);
            }
        });
        jPanel_BackGround.add(jBttn_NewCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        jBttn_EditCustomer.setText("Editar");
        jBttn_EditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_EditCustomerActionPerformed(evt);
            }
        });
        jPanel_BackGround.add(jBttn_EditCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        jBttn_delete.setText("Eliminar");
        jBttn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_deleteActionPerformed(evt);
            }
        });
        jPanel_BackGround.add(jBttn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttn_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_loadActionPerformed
        List<DtoCustomer> customers = controller.loadCustomers();
        updateTable(customers);
    }//GEN-LAST:event_jBttn_loadActionPerformed

    private void jBttn_NewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_NewCustomerActionPerformed
        // TODO add your handling code here:
        insertCustomer();
    }//GEN-LAST:event_jBttn_NewCustomerActionPerformed

    private void jBttn_EditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_EditCustomerActionPerformed
    int selectedRow = jTable_Customers.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un cliente para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int customerID = rowToCustomerIdMap.get(selectedRow);

        String dni = (String) jTable_Customers.getValueAt(selectedRow, 0);
        String[] fullName = ((String) jTable_Customers.getValueAt(selectedRow, 1)).split(", ");
        String firstName = fullName[0];
        String lastName = fullName[1];
        String address = (String) jTable_Customers.getValueAt(selectedRow, 2);
        String phone = (String) jTable_Customers.getValueAt(selectedRow, 3);

        CustomerUpdate updatedialog = new CustomerUpdate(this, true, controller, this);
        updatedialog.setCustomerData(dni, firstName, lastName, address, phone, customerID);
        updatedialog.setVisible(true);
    }//GEN-LAST:event_jBttn_EditCustomerActionPerformed

    private void dniTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniTextFieldKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || dniTextField.getText().length() >= 8) {
            evt.consume(); 
        }        
    }//GEN-LAST:event_dniTextFieldKeyTyped

    private void phoneTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneTextFieldKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || phoneTextField.getText().length() >= 9) {
            evt.consume(); 
        } 
    }//GEN-LAST:event_phoneTextFieldKeyTyped

    private void jBttn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_deleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable_Customers.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un cliente para Eliminarlo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int customerID = rowToCustomerIdMap.get(selectedRow);

        String dni = (String) jTable_Customers.getValueAt(selectedRow, 0);
        String[] fullName = ((String) jTable_Customers.getValueAt(selectedRow, 1)).split(", ");
        String firstName = fullName[0];
        String lastName = fullName[1];
        String address = (String) jTable_Customers.getValueAt(selectedRow, 2);
        String phone = (String) jTable_Customers.getValueAt(selectedRow, 3);
        
        CustomerDelete deletedialog = new CustomerDelete(this, true, controller, this);
        deletedialog.setCustomerData(dni, firstName, lastName, address, phone, customerID);
        deletedialog.setVisible(true);
    }//GEN-LAST:event_jBttn_deleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTextField;
    private javax.swing.JTextField dniTextField;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JButton jBttn_EditCustomer;
    private javax.swing.JButton jBttn_NewCustomer;
    private javax.swing.JButton jBttn_delete;
    private javax.swing.JButton jBttn_load;
    private javax.swing.JLabel jLabel_address;
    private javax.swing.JLabel jLabel_dni;
    private javax.swing.JLabel jLabel_firstName;
    private javax.swing.JLabel jLabel_lastName;
    private javax.swing.JLabel jLabel_phone;
    private javax.swing.JPanel jPanel_BackGround;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Customers;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTextField phoneTextField;
    // End of variables declaration//GEN-END:variables
}

package Views.Maintenances.Customer;

import Controller.CustomerController;
import Controller.ServiceObject.Customers.SoCustomers;
import DTOs.Objects.DtoCustomer;
import java.awt.Frame;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kalfe
 */
public class CustomersMain extends javax.swing.JInternalFrame {
    private CustomerController controller;
    private HashMap<Integer, Integer> rowToCustomerIdMap = new HashMap<>();


    /**
     * Creates new form CustomersMain
     */
    public CustomersMain() {
        initComponents();
        setClosable(true); 
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

    private void insertCustomer(){   
        String dni = dniTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String address = addressTextField.getText();
        String phone = phoneTextField.getText();
        
        SoCustomers newCustomer = new SoCustomers();
            newCustomer.dtoCustomer.setDni(dni);
            newCustomer.dtoCustomer.setFirstName(firstName);
            newCustomer.dtoCustomer.setLastName(lastName);
            newCustomer.dtoCustomer.setAddress(address);
            newCustomer.dtoCustomer.setPhone(phone);
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
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dniTextField = new javax.swing.JTextField();
        jLabel_dni = new javax.swing.JLabel();
        jLabel_address = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        jLabel_phone = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        jLabel_lastName = new javax.swing.JLabel();
        jLabel_firstName = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        jBttn_NewCustomer = new javax.swing.JButton();
        jBttn_EditCustomer = new javax.swing.JButton();
        jBttn_load = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Customers = new javax.swing.JTable();
        jBttn_delete = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dniTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dniTextFieldKeyTyped(evt);
            }
        });
        jPanel1.add(dniTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 110, -1));

        jLabel_dni.setText("N° DNI:");
        jPanel1.add(jLabel_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel_address.setText("Direccion:");
        jPanel1.add(jLabel_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        jPanel1.add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 100, -1));

        jLabel_phone.setText("N° Telefono:");
        jPanel1.add(jLabel_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        phoneTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneTextFieldKeyTyped(evt);
            }
        });
        jPanel1.add(phoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 90, -1));

        jLabel_lastName.setText("Apellido:");
        jPanel1.add(jLabel_lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jLabel_firstName.setText("Nombre:");
        jPanel1.add(jLabel_firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));
        jPanel1.add(firstNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 110, -1));
        jPanel1.add(lastNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 110, -1));

        jBttn_NewCustomer.setText("Crear");
        jBttn_NewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_NewCustomerActionPerformed(evt);
            }
        });
        jPanel1.add(jBttn_NewCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        jBttn_EditCustomer.setText("Editar");
        jBttn_EditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_EditCustomerActionPerformed(evt);
            }
        });
        jPanel1.add(jBttn_EditCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        jBttn_load.setText("Mostrar");
        jBttn_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_loadActionPerformed(evt);
            }
        });
        jPanel1.add(jBttn_load, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 460, 190));

        jBttn_delete.setText("Eliminar");
        jBttn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(jBttn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        
        Frame f = JOptionPane.getFrameForComponent(this);
        CustomerUpdate updatedialog = new CustomerUpdate(f, true, controller, this);
        
        updatedialog.setCustomerData(dni, firstName, lastName, address, phone, customerID);
        updatedialog.setVisible(true);
        
    }//GEN-LAST:event_jBttn_EditCustomerActionPerformed

    private void jBttn_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_loadActionPerformed
        List<DtoCustomer> customers = controller.loadCustomers();
        updateTable(customers);
    }//GEN-LAST:event_jBttn_loadActionPerformed

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
        
        Frame f = JOptionPane.getFrameForComponent(this);
        CustomerDelete deletedialog = new CustomerDelete(f, true, controller, this);
        deletedialog.setCustomerData(dni, firstName, lastName, address, phone, customerID);
        deletedialog.setVisible(true);
    }//GEN-LAST:event_jBttn_deleteActionPerformed


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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Customers;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTextField phoneTextField;
    // End of variables declaration//GEN-END:variables
}

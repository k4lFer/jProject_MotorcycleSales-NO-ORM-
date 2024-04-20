package Views.Maintenances.Customer;

import Controller.CustomerController;
import Objects.DtoCustomer;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kalfe
 */
public class Customers extends javax.swing.JFrame {
    private CustomerController controller;

    /**
     * Creates new form jFrame_MainCustomers
     */
    public Customers() {

        initComponents();
        controller = new CustomerController();
                    
    }
    public void updateTable(List<DtoCustomer> customers) {      
    String[] columnNames = {"ID", "DNI", "Nombre y Apellido", "Dirección", "Teléfono"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (DtoCustomer customer : customers) {
            Object[] row = new Object[6];
            row[0] = customer.getCustomerID();
            row[1] = customer.getDni();
            row[2] = customer.getFirstName() + ", " + customer.getLastName();
            row[3] = customer.getAddress();
            row[4] = customer.getPhone();
            model.addRow(row);
        }
        jTable_Customers.setModel(model);
}

    public void insertCustomer(){
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dniTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        jBttn_NewCustomer = new javax.swing.JButton();
        jBttn_Update = new javax.swing.JButton();

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

        jPanel_BackGround.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 440, 250));

        jBttn_load.setText("Mostrar");
        jBttn_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_loadActionPerformed(evt);
            }
        });
        jPanel_BackGround.add(jBttn_load, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, -1));

        jLabel1.setText("N° DNI:");
        jPanel_BackGround.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setText("Nombre:");
        jPanel_BackGround.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jLabel3.setText("Apellido:");
        jPanel_BackGround.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        jLabel4.setText("Direccion:");
        jPanel_BackGround.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel5.setText("N° Telefono:");
        jPanel_BackGround.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        jPanel_BackGround.add(dniTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 110, -1));
        jPanel_BackGround.add(firstNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 110, -1));
        jPanel_BackGround.add(lastNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 110, -1));
        jPanel_BackGround.add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 100, -1));
        jPanel_BackGround.add(phoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 90, -1));

        jBttn_NewCustomer.setText("Crear");
        jBttn_NewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_NewCustomerActionPerformed(evt);
            }
        });
        jPanel_BackGround.add(jBttn_NewCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        jBttn_Update.setText("Editar");
        jBttn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_UpdateActionPerformed(evt);
            }
        });
        jPanel_BackGround.add(jBttn_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void jBttn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_UpdateActionPerformed

    }//GEN-LAST:event_jBttn_UpdateActionPerformed

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
    private javax.swing.JButton jBttn_NewCustomer;
    private javax.swing.JButton jBttn_Update;
    private javax.swing.JButton jBttn_load;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel_BackGround;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Customers;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTextField phoneTextField;
    // End of variables declaration//GEN-END:variables
}

package Views.Maintenances.Product.Brands;

import Controller.BrandController;
import Controller.ServiceObject.Brand.SoBrand;
import DTOs.Objects.DtoBrand;
import java.awt.Frame;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kalfe
 */
public class Brands extends javax.swing.JPanel {
    private BrandController controller;
    private HashMap<Integer, Integer> rowToBrandIdMap = new HashMap();

    /**
     * Creates new form Brands
     */
    public Brands() {
        initComponents();
        controller = new BrandController();
    }
    
    public void updateTable(List<DtoBrand> brands){
        String[] columnName = {"Nombre de la marca"};
        DefaultTableModel model = new DefaultTableModel(columnName,0);
        rowToBrandIdMap.clear();
        for(DtoBrand brand : brands){
            Object[] row = new Object[2];
            row[0] = brand.getName();
            model.addRow(row);
            
            rowToBrandIdMap.put(model.getRowCount() - 1, brand.getBrandID());
        }
        jTable_Brands.setModel(model);     
    }
    
    private void insertBrand(){
        String name = brandTextField.getText();
        
        SoBrand newBrand = new SoBrand();
            newBrand.dtoBrand.setName(name);
        int result = controller.insertBrand(newBrand);
        if(result == 1){
            brandTextField.setText("");
            List<DtoBrand> brands = controller.loadBrands();
            updateTable(brands);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_brand = new javax.swing.JLabel();
        jBttn_NewBrand = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Brands = new javax.swing.JTable();
        jBttn_EditBrand = new javax.swing.JButton();
        jBttn_ViewBrand = new javax.swing.JButton();
        jBttn_DeleteBrand = new javax.swing.JButton();
        brandTextField = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_brand.setText("Marcas de Motocicletas:");
        add(jLabel_brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jBttn_NewBrand.setText("Crear");
        jBttn_NewBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_NewBrandActionPerformed(evt);
            }
        });
        add(jBttn_NewBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        jTable_Brands.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_Brands);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, 256));

        jBttn_EditBrand.setText("Editar");
        jBttn_EditBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_EditBrandActionPerformed(evt);
            }
        });
        add(jBttn_EditBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        jBttn_ViewBrand.setText("Mostrar");
        jBttn_ViewBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_ViewBrandActionPerformed(evt);
            }
        });
        add(jBttn_ViewBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, -1));

        jBttn_DeleteBrand.setText("Eliminar");
        jBttn_DeleteBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_DeleteBrandActionPerformed(evt);
            }
        });
        add(jBttn_DeleteBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 350, -1, -1));
        add(brandTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 110, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jBttn_ViewBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_ViewBrandActionPerformed
        // TODO add your handling code here:
        List<DtoBrand> brands = controller.loadBrands();
        updateTable(brands);
    }//GEN-LAST:event_jBttn_ViewBrandActionPerformed

    private void jBttn_NewBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_NewBrandActionPerformed
        // TODO add your handling code here:
        insertBrand();
    }//GEN-LAST:event_jBttn_NewBrandActionPerformed

    private void jBttn_EditBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_EditBrandActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable_Brands.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Selecciona una Marca para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int brandID = rowToBrandIdMap.get(selectedRow);
        String name = (String) jTable_Brands.getValueAt(selectedRow, 0);
        
        Frame f = JOptionPane.getFrameForComponent(this);
        
        UpdateBrand updateDialog = new UpdateBrand(f, true, controller, this);
        
        updateDialog.setBrandData(name, brandID);
        updateDialog.setVisible(true);
        
    }//GEN-LAST:event_jBttn_EditBrandActionPerformed

    private void jBttn_DeleteBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_DeleteBrandActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable_Brands.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Selecciona una Marca para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int brandID = rowToBrandIdMap.get(selectedRow);
        String name = (String) jTable_Brands.getValueAt(selectedRow, 0);
        
        Frame f = JOptionPane.getFrameForComponent(this);
        DeleteBrand deletedialog = new DeleteBrand(f, true, controller, this);
        
        deletedialog.setBrandData(name, brandID);
        deletedialog.setVisible(true);
        
    }//GEN-LAST:event_jBttn_DeleteBrandActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField brandTextField;
    private javax.swing.JButton jBttn_DeleteBrand;
    private javax.swing.JButton jBttn_EditBrand;
    private javax.swing.JButton jBttn_NewBrand;
    private javax.swing.JButton jBttn_ViewBrand;
    private javax.swing.JLabel jLabel_brand;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Brands;
    // End of variables declaration//GEN-END:variables
}

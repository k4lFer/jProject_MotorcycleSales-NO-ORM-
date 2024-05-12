package Views.Maintenances.Product.Brands;

import Controller.BrandController;
import Controller.ServiceObject.Brand.SoBrand;
import DTOs.Objects.DtoBrand;
import java.util.List;

/**
 *
 * @author kalfe
 */
public class UpdateBrand extends java.awt.Dialog {
    private BrandController controller;
    private int id;
    private String currentName;
    private Brands form;
    /**
     * Creates new form UpdateBrand
     */
    public UpdateBrand(java.awt.Frame parent, boolean modal, BrandController controller, Brands form) {
        super(parent, modal);
        this.id = id;
        this.form = form;
        this.controller = controller;
        initComponents();
        setLocationRelativeTo(null);
    }

    
    public void setBrandData(String name, int brandID){
        this.currentName = name;
        jTextField_nameBrand.setText(name);
        id = brandID;
    }
    
    private void updateBrand(){
       String name = jTextField_nameBrand.getText();
       String currentName = "";
       SoBrand brandToUpdate = new SoBrand();
        brandToUpdate.dtoBrand.setName(name);
        brandToUpdate.dtoBrand.setBrandID(id);
       
       int result = controller.updateBrand(brandToUpdate, this.currentName);
       if(result > 0){
           List<DtoBrand> brands = controller.loadBrands();
           form.updateTable(brands);
           dispose();
       }               
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_Title = new javax.swing.JLabel();
        jLabel_nameBrand = new javax.swing.JLabel();
        jTextField_nameBrand = new javax.swing.JTextField();
        jBttn_update = new javax.swing.JButton();
        jBttn_close = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel_Title.setText("Actualizar Marca");

        jLabel_nameBrand.setText("Nombre de la Marca:");

        jTextField_nameBrand.setText("jTextField1");

        jBttn_update.setText("Actualizar");
        jBttn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_updateActionPerformed(evt);
            }
        });

        jBttn_close.setText("Cancelar");
        jBttn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel_Title))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel_nameBrand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBttn_update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBttn_close))
                            .addComponent(jTextField_nameBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel_Title)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_nameBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_nameBrand))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBttn_update)
                    .addComponent(jBttn_close))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        updateBrand();
        
    }//GEN-LAST:event_jBttn_updateActionPerformed

    private void jBttn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_closeActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBttn_closeActionPerformed

    /**
     * @param args the command line arguments
     */
   // public static void main(String args[]) {
        //java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Brands brandsForm = new Brands();
                BrandController controller = new BrandController();
                UpdateBrand dialog = new UpdateBrand(new java.awt.Frame(), true, controller, brandsForm);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                //dialog.setVisible(false);
            }
        //});
   // }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttn_close;
    private javax.swing.JButton jBttn_update;
    private javax.swing.JLabel jLabel_Title;
    private javax.swing.JLabel jLabel_nameBrand;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_nameBrand;
    // End of variables declaration//GEN-END:variables
}

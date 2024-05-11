package Views.Maintenances.Product.Brands;

import Controller.BrandController;
import DTOs.Objects.DtoBrand;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kalfe
 */
public class DeleteBrand extends java.awt.Dialog {
    private BrandController controller;
    private int ID;
    private Brands form;

    /**
     * Creates new form DeleteBrand
     */
    public DeleteBrand(java.awt.Frame parent, boolean modal, BrandController controller, Brands form) {
        super(parent, modal);
        this.ID = ID;
        this.form = form;
        this.controller = controller;
        setLocationRelativeTo(null);
        initComponents();
    }
    
    public void setBrandData(String name, int brandID){
        jLabel_viewData.setText("<html>Está seguro que desea eliminar la Marca: <b>"+name+ "</b></html>");

        ID = brandID;
    }
    
    public void deleteBrand(){
        int id = ID;
        int result = controller.deleteBrand(id);
        if(result > 0){
            //JOptionPane.showMessageDialog(null, "Marca eliminada exitosamente");
            List<DtoBrand> brands = controller.loadBrands();
            form.updateTable(brands);
            dispose();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_background = new javax.swing.JPanel();
        jLabel_title = new javax.swing.JLabel();
        jLabel_viewData = new javax.swing.JLabel();
        jBttn_delete = new javax.swing.JButton();
        jBttn_cancel = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_title.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel_title.setText("Eliminar Marca");
        jPanel_background.add(jLabel_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 120, -1));
        jPanel_background.add(jLabel_viewData, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 300, 70));

        jBttn_delete.setText("Eliminar");
        jBttn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_deleteActionPerformed(evt);
            }
        });
        jPanel_background.add(jBttn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        jBttn_cancel.setText("Cancelar");
        jBttn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_cancelActionPerformed(evt);
            }
        });
        jPanel_background.add(jBttn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_background, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_background, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar esta Marca?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            deleteBrand();
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
                Brands brandForm = new Brands();
                BrandController controller = new BrandController();
                DeleteBrand dialog = new DeleteBrand(new java.awt.Frame(), true, controller, brandForm);
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
    private javax.swing.JButton jBttn_cancel;
    private javax.swing.JButton jBttn_delete;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JLabel jLabel_viewData;
    private javax.swing.JPanel jPanel_background;
    // End of variables declaration//GEN-END:variables
}

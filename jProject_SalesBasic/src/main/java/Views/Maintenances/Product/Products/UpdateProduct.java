package Views.Maintenances.Product.Products;

import Controller.BrandController;
import Controller.ProductController;
import Controller.TypesMotorController;
import Controller.ServiceObject.Products.SoProducts;
import DTOs.Objects.DtoBrand;
import DTOs.Objects.DtoMotorcycleType;
import DTOs.Objects.DtoProducts;
import Views.Maintenances.Product.Products.Functions.MappedComboBoxModel;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author kalfe
 */
public class UpdateProduct extends java.awt.Dialog {
    private BrandController brandController;
    private TypesMotorController typeController;
    private ProductController controller;
    private int id;
    private Products form;
    /**
     * Creates new form UpdateProduct
     */
    public UpdateProduct(java.awt.Frame parent, boolean modal, ProductController controller, Products form) {
        super(parent, modal);
        
        brandController = new BrandController();
        typeController = new TypesMotorController();
        this.id = id;
        this.controller = controller;
        this.form = form;
        setLocationRelativeTo(null);
        initComponents();
       

    }
  /*  public void setDataBrand(){
    List<DtoBrand> brands = brandController.loadBrands();
    MappedComboBoxModel brandModel = new MappedComboBoxModel();
    for (DtoBrand brand : brands) {
        brandModel.addItemWithId(brand.getName(), brand.getBrandID());
    }
    jComboBox_brands.setModel(brandModel);
}

    public void setDataTypes(){
        List<DtoMotorcycleType> types = typeController.loadTypesMotorcycle();
        MappedComboBoxModel typeModel = new MappedComboBoxModel();
        for (DtoMotorcycleType type : types) {
            typeModel.addItemWithId(type.getName(), type.getMotorcycleTypeID());
        }
        jComboBox_types.setModel(typeModel);
    }
*/
    private String findBrandNameById(int brandId) {
        List<DtoBrand> brands = brandController.loadBrands();
        for (DtoBrand brand : brands) {
            if (brand.getBrandID() == brandId) {
                return brand.getName();
            }
        }
        return "Unknown"; 
    }
    
    private String findTypeNameById(int typeId) {
        List<DtoMotorcycleType> types = typeController.loadTypesMotorcycle();
        for (DtoMotorcycleType type : types) {
            if (type.getMotorcycleTypeID() == typeId) {
                return type.getName();
            }
        }
        return "Unknown"; 
    }
    public void setDataBrandAndType(int productId) {
        List<DtoBrand> brands = brandController.loadBrands();
        List<DtoMotorcycleType> types = typeController.loadTypesMotorcycle();

        MappedComboBoxModel brandModel = new MappedComboBoxModel();
        MappedComboBoxModel typeModel = new MappedComboBoxModel();

        for (DtoBrand brand : brands) {
            brandModel.addItemWithId(brand.getName(), brand.getBrandID());
        }

        for (DtoMotorcycleType type : types) {
            typeModel.addItemWithId(type.getName(), type.getMotorcycleTypeID());
        }

        jComboBox_brands.setModel(brandModel);
        jComboBox_types.setModel(typeModel);

        String brandName = findBrandNameById(productId);
        String typeName = findTypeNameById(productId);

        jComboBox_brands.setSelectedItem(brandName);
        jComboBox_types.setSelectedItem(typeName);
    }


    public void setProductData(String name, int productID, String displacement, double price, int stockQuantity, String brandName, String typeName){
        id = productID;
        nameTextField.setText(name);
        displacementTextField.setText(displacement);
        priceFormattedTextField.setValue(price);
        stockQuantitySpinner.setValue(stockQuantity);

        setDataBrandAndType(productID);

        jComboBox_brands.setSelectedItem(brandName);

        jComboBox_types.setSelectedItem(typeName);
             
    }

    private void updateProduct(){
        String name = nameTextField.getText();
        String displacement = displacementTextField.getText();
        double price = ((Number) priceFormattedTextField.getValue()).doubleValue();
        int stockQuantity = (Integer) stockQuantitySpinner.getValue();
        int brandId = ((MappedComboBoxModel) jComboBox_brands.getModel()).getIdForName((String) jComboBox_brands.getSelectedItem());
        int typeId = ((MappedComboBoxModel) jComboBox_types.getModel()).getIdForName((String) jComboBox_types.getSelectedItem());
        
        String currentName = "";

        SoProducts productToUpdate = new SoProducts();
        productToUpdate.dtoProducts.setName(name); 
        productToUpdate.dtoProducts.setDisplacement(displacement);
        productToUpdate.dtoProducts.setPrice(price);
        productToUpdate.dtoProducts.setStockQuantity(stockQuantity);
        productToUpdate.dtoProducts.setBrandID(brandId);
        productToUpdate.dtoProducts.setMotorcycleTypeID(typeId);
        productToUpdate.dtoProducts.setProductID(id);

        int result = controller.updateProduct(productToUpdate, currentName);
        if(result > 0){
            List<DtoProducts> products = controller.loadProducts();
            form.updateTable(products);
            dispose();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_back = new javax.swing.JPanel();
        jLabel_brand = new javax.swing.JLabel();
        jComboBox_brands = new javax.swing.JComboBox<>();
        jLabel_type = new javax.swing.JLabel();
        jComboBox_types = new javax.swing.JComboBox<>();
        jLabel_name = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        displacementTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        priceFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        stockQuantitySpinner = new javax.swing.JSpinner();
        jLabel_title = new javax.swing.JLabel();
        jBttn_update = new javax.swing.JButton();
        jBttn_cancel = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel_brand.setText("Marca:");

        jComboBox_brands.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel_type.setText("Tipo de Motocicleta:");

        jComboBox_types.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel_name.setText("Nombre:");

        jLabel4.setText("Cilindrada (CC):");

        jLabel5.setText("Precio:");

        priceFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        priceFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        priceFormattedTextField.setToolTipText("");
        priceFormattedTextField.setValue(0);

        jLabel6.setText("Stock:");

        stockQuantitySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel_title.setText("Actualizar Producto");

        jBttn_update.setText("Actualizar");
        jBttn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_updateActionPerformed(evt);
            }
        });

        jBttn_cancel.setText("Cancelar");
        jBttn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_backLayout = new javax.swing.GroupLayout(jPanel_back);
        jPanel_back.setLayout(jPanel_backLayout);
        jPanel_backLayout.setHorizontalGroup(
            jPanel_backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_backLayout.createSequentialGroup()
                .addGroup(jPanel_backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_backLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel_backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_backLayout.createSequentialGroup()
                                .addComponent(jLabel_brand)
                                .addGap(5, 5, 5)
                                .addComponent(jComboBox_brands, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel_type))
                            .addGroup(jPanel_backLayout.createSequentialGroup()
                                .addComponent(jLabel_name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_backLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(7, 7, 7)
                                .addComponent(priceFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_backLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stockQuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_backLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(displacementTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox_types, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_backLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel_title)))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_backLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBttn_update)
                .addGap(37, 37, 37)
                .addComponent(jBttn_cancel)
                .addGap(32, 32, 32))
        );
        jPanel_backLayout.setVerticalGroup(
            jPanel_backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_backLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel_title)
                .addGap(32, 32, 32)
                .addGroup(jPanel_backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_type)
                    .addComponent(jComboBox_types, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_brand)
                    .addComponent(jComboBox_brands, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel_backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_name)
                    .addComponent(displacementTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(49, 49, 49)
                .addGroup(jPanel_backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(priceFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(stockQuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel_backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBttn_update)
                    .addComponent(jBttn_cancel))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        updateProduct();

    }//GEN-LAST:event_jBttn_updateActionPerformed

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
                Products productForm = new Products();
                ProductController controller = new ProductController();
                UpdateProduct dialog = new UpdateProduct(new java.awt.Frame(), true, controller, productForm);
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
    private javax.swing.JTextField displacementTextField;
    private javax.swing.JButton jBttn_cancel;
    private javax.swing.JButton jBttn_update;
    private javax.swing.JComboBox<String> jComboBox_brands;
    private javax.swing.JComboBox<String> jComboBox_types;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_brand;
    private javax.swing.JLabel jLabel_name;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JLabel jLabel_type;
    private javax.swing.JPanel jPanel_back;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JFormattedTextField priceFormattedTextField;
    private javax.swing.JSpinner stockQuantitySpinner;
    // End of variables declaration//GEN-END:variables
}

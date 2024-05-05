package Views.Maintenances.Product.Products;
import Views.Maintenances.Product.Products.Functions.MappedComboBoxModel;
import Controller.BrandController;
import Controller.ProductController;
import Controller.ServiceObject.Products.SoProducts;
import Controller.TypesMotorController;
import DTOs.Objects.DtoBrand;
import DTOs.Objects.DtoMotorcycleType;
import DTOs.Objects.DtoProducts;

import java.awt.Frame;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kalfe
 */
public class Products extends javax.swing.JPanel {
    private BrandController brandController;
    private TypesMotorController typeController;
    private ProductController productController;
    private HashMap<Integer, Integer> rowToProductIdMap = new HashMap();
    /**
     * Creates new form Products
     */
    public Products() {
        initComponents();
        brandController = new BrandController();
        typeController = new TypesMotorController();
        productController = new ProductController();
        data();
    }
    public void data(){
        setDataBrand();
        setDataTypes();
    }
    
    public void setDataBrand(){
        List<DtoBrand> brands = brandController.loadBrands();
        MappedComboBoxModel brandModel = new MappedComboBoxModel();
        brandModel.addItemWithId("--Seleccione una marca--", -1);
        for (DtoBrand brand : brands) {
            brandModel.addItemWithId(brand.getName(), brand.getBrandID());
        }
        jComboBox_brands.setModel(brandModel);
    }
    public void setDataTypes(){
        List<DtoMotorcycleType> types = typeController.loadTypesMotorcycle();
        MappedComboBoxModel typeModel = new MappedComboBoxModel();
        typeModel.addItemWithId("--Seleccione un tipo--", -1);
        for (DtoMotorcycleType type : types) {
            typeModel.addItemWithId(type.getName(), type.getMotorcycleTypeID());
        }
        jComboBox_types.setModel(typeModel);
    }
    public void updateTable(List<DtoProducts> products){
        String[] columnNames = {"Marca", "Tipo de Motocicleta","Codigo","Nombre","Cilindrada","Stock","Precio U"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        rowToProductIdMap.clear();
        for(DtoProducts product : products){
            Object[] row = new Object[7];
            
            String brandName = findBrandNameById(product.getBrandID());
            
            String typeName = findTypeNameById(product.getMotorcycleTypeID());
            row[0] = brandName; 
            row[1] = typeName; 
            row[2] = product.getCod(); 
            row[3] = product.getName(); 
            row[4] = product.getDisplacement(); 
            row[5] = product.getStockQuantity(); 
            row[6] = product.getPrice(); 
    
            model.addRow(row);
            rowToProductIdMap.put(model.getRowCount()-1, product.getProductID());
        }
        jTable_products.setModel(model);        
    }
    
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


    private void insertProduct() {
        String name = nameTextField.getText();
        String displacement = (displacementTextField.getText());
        double price = ((Number) priceFormattedTextField.getValue()).doubleValue();
        int stockQuantity = (int) stockQuantitySpinner.getValue();
        int brandId = ((MappedComboBoxModel) jComboBox_brands.getModel()).getIdForName((String) jComboBox_brands.getSelectedItem());
        int typeId = ((MappedComboBoxModel) jComboBox_types.getModel()).getIdForName((String) jComboBox_types.getSelectedItem());

        SoProducts newProduct = new SoProducts();
        newProduct.dtoProducts.setName(name);
        newProduct.dtoProducts.setDisplacement(displacement);
        newProduct.dtoProducts.setPrice(price);
        newProduct.dtoProducts.setStockQuantity(stockQuantity);
        newProduct.dtoProducts.setBrandID(brandId);
        newProduct.dtoProducts.setMotorcycleTypeID(typeId);
        
        int isInserted = productController.insertProduct(newProduct);

        if (isInserted == 1) {
            List<DtoProducts> products = productController.loadProducts();
            updateTable(products);
            clearFields();
            //JOptionPane.showMessageDialog(this, "Producto insertado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } 
    }

    private void clearFields() {
        nameTextField.setText("");
        displacementTextField.setText("");
        //priceSpinner.setValue(0);
        priceFormattedTextField.setValue(0);
        stockQuantitySpinner.setValue(0);
        jComboBox_brands.setSelectedIndex(0);
        jComboBox_types.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_brand = new javax.swing.JLabel();
        jComboBox_brands = new javax.swing.JComboBox<>();
        jLabel_type = new javax.swing.JLabel();
        jComboBox_types = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_products = new javax.swing.JTable();
        jLabel_name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        displacementTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        stockQuantitySpinner = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jBttn_edit = new javax.swing.JButton();
        jBttn_viewProducts = new javax.swing.JButton();
        jBttn_delete = new javax.swing.JButton();
        jBttn_newProduct = new javax.swing.JButton();
        priceFormattedTextField = new javax.swing.JFormattedTextField();

        jLabel_brand.setText("Marca:");

        jComboBox_brands.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel_type.setText("Tipo de Motocicleta:");

        jComboBox_types.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTable_products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_products);

        jLabel_name.setText("Nombre:");

        jLabel4.setText("Cilindrada (CC):");

        jLabel5.setText("Precio:");

        stockQuantitySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel6.setText("Stock:");

        jBttn_edit.setText("Editar");
        jBttn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_editActionPerformed(evt);
            }
        });

        jBttn_viewProducts.setText("Mostrar");
        jBttn_viewProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_viewProductsActionPerformed(evt);
            }
        });

        jBttn_delete.setText("Eliminar");
        jBttn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_deleteActionPerformed(evt);
            }
        });

        jBttn_newProduct.setText("Crear");
        jBttn_newProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_newProductActionPerformed(evt);
            }
        });

        priceFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        priceFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        priceFormattedTextField.setToolTipText("");
        priceFormattedTextField.setValue(0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBttn_delete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_brand)
                                .addGap(5, 5, 5)
                                .addComponent(jComboBox_brands, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel_type)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_types, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(stockQuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBttn_newProduct))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(displacementTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel5)
                                    .addGap(7, 7, 7)
                                    .addComponent(priceFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 21, Short.MAX_VALUE)
                                .addComponent(jBttn_edit)
                                .addGap(352, 352, 352)
                                .addComponent(jBttn_viewProducts))
                            .addComponent(jScrollPane1))))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_brand)
                    .addComponent(jComboBox_brands, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_type)
                    .addComponent(jComboBox_types, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displacementTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(priceFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(stockQuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBttn_newProduct))
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBttn_edit)
                    .addComponent(jBttn_viewProducts))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBttn_delete)
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBttn_newProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_newProductActionPerformed
        // TODO add your handling code here:
        insertProduct();
    }//GEN-LAST:event_jBttn_newProductActionPerformed

    private void jBttn_viewProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_viewProductsActionPerformed
        // TODO add your handling code here:
        List<DtoProducts> products = productController.loadProducts();
        updateTable(products);
    }//GEN-LAST:event_jBttn_viewProductsActionPerformed

    private void jBttn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_editActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable_products.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Selecciona un Producto para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int productID = rowToProductIdMap.get(selectedRow);
         
        String name = (String) jTable_products.getValueAt(selectedRow, 3);
        String displacement = (String) jTable_products.getValueAt(selectedRow, 4);
        double price = (Double) jTable_products.getValueAt(selectedRow, 6);
        int stockQuantity = (int)jTable_products.getValueAt(selectedRow, 5);
        String brand = (String) jTable_products.getValueAt(selectedRow, 0);
        String type = (String) jTable_products.getValueAt(selectedRow, 1);
        
    
        Frame f = JOptionPane.getFrameForComponent(this);
        UpdateProduct updateDialog = new UpdateProduct(f, true, productController, this);
        updateDialog.setProductData(name, productID, displacement, price, stockQuantity, brand, type);
        updateDialog.setVisible(true);

    }//GEN-LAST:event_jBttn_editActionPerformed

    private void jBttn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_deleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable_products.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Selecciona un Producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int productID = rowToProductIdMap.get(selectedRow);
        String name = (String) jTable_products.getValueAt(selectedRow, 2);
        
        Frame f = JOptionPane.getFrameForComponent(this);
        DeleteProduct deletedialog = new DeleteProduct(f, true, productController, this);
        
        deletedialog.setProductData(name,productID);
        deletedialog.setVisible(true);

    }//GEN-LAST:event_jBttn_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField displacementTextField;
    private javax.swing.JButton jBttn_delete;
    private javax.swing.JButton jBttn_edit;
    private javax.swing.JButton jBttn_newProduct;
    private javax.swing.JButton jBttn_viewProducts;
    private javax.swing.JComboBox<String> jComboBox_brands;
    private javax.swing.JComboBox<String> jComboBox_types;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_brand;
    private javax.swing.JLabel jLabel_name;
    private javax.swing.JLabel jLabel_type;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_products;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JFormattedTextField priceFormattedTextField;
    private javax.swing.JSpinner stockQuantitySpinner;
    // End of variables declaration//GEN-END:variables
}

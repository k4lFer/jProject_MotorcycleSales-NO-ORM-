package Views.Sales;

import Controller.CustomerController;
import Controller.ProductController;
import Controller.SalesController;
import Controller.SalesDetailsController;
import Controller.ServiceObject.Customers.SoCustomers;
import Controller.ServiceObject.Products.SoProducts;
import Controller.ServiceObject.Sales.SoSales;
import Controller.ServiceObject.Sales.SoSalesDetails;
import DTOs.Objects.DtoSales;
import DTOs.Objects.DtoSalesDetails;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kalfe
 */
public class SalesMain extends javax.swing.JInternalFrame {
    private CustomerController customerController;
    private int idCustomer;
    private int idProduct;
    private double priceU;
    private double subTotal;
    private double priceTotal;
    private String codProduct;
    private String nameProduct;
    private ProductController productController;
    private SalesController salesController;
    private SalesDetailsController salesDetailsController;
    private SoSales currentSale = new SoSales();
    private SoCustomers customer = new SoCustomers();
    private SoProducts product = new SoProducts();
    private SoSalesDetails soDetail = new SoSalesDetails();
    private List<DtoSalesDetails> salesDetailsList = new ArrayList<>();

    
    /**
     * Creates new form SalesMain
     */
    public SalesMain() {
        setClosable(true); 
        productController = new ProductController();
        customerController = new CustomerController();
        salesController = new SalesController();
        salesDetailsController = new SalesDetailsController();
        this.idProduct = 0;
        this.idCustomer = 0;
        initComponents();
        dateView();
        currentSale.dtoSales.setSalesDetails(new ArrayList<>());

    }

    private void addProductToTable(int productId, String productCode, String productName, double unitPrice) {
        int quantity = (int) quantitySpinner.getValue();
        subTotal = priceU * quantity;
        priceTotal += subTotal;
        jLabel_viewPriceTotal.setText("$" + priceTotal);
        DtoSalesDetails saleDetail = new DtoSalesDetails();
        saleDetail.setProductID(productId);
        saleDetail.setQuantity(quantity);
        saleDetail.setUnitPrice(unitPrice);
        saleDetail.setSubTotalPrice(subTotal); 

        salesDetailsList.add(saleDetail);

        DefaultTableModel model = (DefaultTableModel) jTable_viewDataSale.getModel();
        Object[] rowData = {productCode, productName, saleDetail.getQuantity(), saleDetail.getUnitPrice(), saleDetail.getSubTotalPrice()};
        model.addRow(rowData); 
        
            System.out.println("Detalles de la venta después de agregar producto:");
            for (DtoSalesDetails detail : salesDetailsList) {
                System.out.println(detail.getProductID());
            }
    }

    public void dateView(){
        Date date = new Date(); 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        jLabel_date.setText(sdf.format(date));
    }
    
    protected void getCustomer(){
        //SoCustomers customer = new SoCustomers();
        String nDni = numberDniTextField.getText();
        customer.dtoCustomer = customerController.getCustomerByDni(nDni);
        if(customer.dtoCustomer != null){
            idCustomer = customer.dtoCustomer.getCustomerID();
            String name = customer.dtoCustomer.getFirstName();
            String lastName = customer.dtoCustomer.getLastName();
            jLabel_viewCustomer.setText(name+", " +lastName);
        }
        else{
            jLabel_viewCustomer.setText("No se encontró el Cliente");
        }
    }

    protected void getProduct(){
        //SoProducts product = new SoProducts();
        String nCode = codProductTextField.getText();
        product.dtoProducts = productController.getProductByCod(nCode);
        
        if(product.dtoProducts != null){
            idProduct = product.dtoProducts.getProductID();
            codProduct = product.dtoProducts.getCod();
            nameProduct = product.dtoProducts.getName();
            jLabel_viewProduct.setText(nameProduct);
            priceU = product.dtoProducts.getPrice();
            jLabel_viewPrice.setText("$"+" "+priceU);
            int stock = product.dtoProducts.getStockQuantity();
            jLabel_viewStock.setText(""+stock);
            int maxStock = stock;
            int minStock = 1;
            quantitySpinner.setModel(new SpinnerNumberModel(minStock, minStock, maxStock, 1));

        } else{
            jLabel_viewProduct.setText("No se encontró el Producto");
        }
    }
    
    private int insertSale() {
        int customerID = idCustomer;
        double TotalPrice = priceTotal; 
        currentSale.dtoSales.setCustomerID(customerID);
        currentSale.dtoSales.setTotalPrice(TotalPrice);
        int result = salesController.insertSale(currentSale);

        if (result > 0) {
            System.out.println("Venta insertada correctamente.");
            List<DtoSales> allSales = salesController.loadSales();
            DtoSales lastSale = allSales.get(allSales.size() - 1);
            int lastSaleID = lastSale.getSaleID();

            return lastSaleID;
        } else {
            System.out.println("Error al insertar la venta.");
            return -1;
        }
    }
    private void insertSaleDetail(int ventaID) {
        for (DtoSalesDetails detail : salesDetailsList) {
            detail.setSaleID(ventaID);
            soDetail.dtoSalesDetails = detail;
            //SalesDetailsController salesDetailsController = new SalesDetailsController();
            int result = salesDetailsController.insertSaleDetails(soDetail);
            
            if (result > 0) {
                System.out.println("Detalle de venta insertado correctamente.");
            } else {
                System.out.println("Error al insertar el detalle de venta.");
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_back = new javax.swing.JPanel();
        jLabel_title = new javax.swing.JLabel();
        jPanel_search = new javax.swing.JPanel();
        jLabel_dni = new javax.swing.JLabel();
        numberDniTextField = new javax.swing.JTextField();
        jBttn_searchDni = new javax.swing.JButton();
        jLabel_cod = new javax.swing.JLabel();
        codProductTextField = new javax.swing.JTextField();
        jBttn_searchCod = new javax.swing.JButton();
        jLabel_customer = new javax.swing.JLabel();
        jLabel_viewCustomer = new javax.swing.JLabel();
        jLabel_viewProduct = new javax.swing.JLabel();
        jLabel_product = new javax.swing.JLabel();
        jLabel_date = new javax.swing.JLabel();
        jLabel_stock = new javax.swing.JLabel();
        jLabel_viewStock = new javax.swing.JLabel();
        jLabel_priceU = new javax.swing.JLabel();
        jLabel_viewPrice = new javax.swing.JLabel();
        jLabel_quantity = new javax.swing.JLabel();
        quantitySpinner = new javax.swing.JSpinner();
        jBttn_add = new javax.swing.JButton();
        jPanel_viewSales = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_viewDataSale = new javax.swing.JTable();
        jPanel_actions = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jBttn_generateSale = new javax.swing.JButton();
        jPanel_viewPrice = new javax.swing.JPanel();
        jLabel_totalPrice = new javax.swing.JLabel();
        jLabel_viewPriceTotal = new javax.swing.JLabel();

        jPanel_back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_title.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel_title.setText("Punto de venta");
        jPanel_back.add(jLabel_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jPanel_search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel_dni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_dni.setText("DNI Cliente:");

        jBttn_searchDni.setText("Buscar");
        jBttn_searchDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_searchDniActionPerformed(evt);
            }
        });

        jLabel_cod.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_cod.setText("COD Producto:");

        jBttn_searchCod.setText("Buscar");
        jBttn_searchCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_searchCodActionPerformed(evt);
            }
        });

        jLabel_customer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_customer.setText("Cliente:");

        jLabel_viewCustomer.setFont(new java.awt.Font("Segoe UI Semibold", 2, 12)); // NOI18N
        jLabel_viewCustomer.setForeground(new java.awt.Color(0, 0, 204));

        jLabel_viewProduct.setFont(new java.awt.Font("Segoe UI Semibold", 2, 12)); // NOI18N
        jLabel_viewProduct.setForeground(new java.awt.Color(0, 0, 204));

        jLabel_product.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_product.setText("Producto:");

        jLabel_date.setFont(new java.awt.Font("Segoe UI Semibold", 2, 12)); // NOI18N
        jLabel_date.setForeground(new java.awt.Color(0, 0, 204));
        jLabel_date.setText("fecha");

        jLabel_stock.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_stock.setText("Stock:");

        jLabel_viewStock.setFont(new java.awt.Font("Segoe UI Semibold", 2, 12)); // NOI18N
        jLabel_viewStock.setForeground(new java.awt.Color(0, 0, 204));

        jLabel_priceU.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_priceU.setText("Precio:");

        jLabel_viewPrice.setFont(new java.awt.Font("Segoe UI Semibold", 2, 12)); // NOI18N
        jLabel_viewPrice.setForeground(new java.awt.Color(0, 0, 204));

        jLabel_quantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_quantity.setText("Cantidad:");

        jBttn_add.setText("Agregar");
        jBttn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_searchLayout = new javax.swing.GroupLayout(jPanel_search);
        jPanel_search.setLayout(jPanel_searchLayout);
        jPanel_searchLayout.setHorizontalGroup(
            jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_searchLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_searchLayout.createSequentialGroup()
                        .addComponent(jLabel_cod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codProductTextField))
                    .addGroup(jPanel_searchLayout.createSequentialGroup()
                        .addComponent(jLabel_dni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numberDniTextField))
                    .addGroup(jPanel_searchLayout.createSequentialGroup()
                        .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_searchLayout.createSequentialGroup()
                                .addComponent(jLabel_priceU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_viewPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_searchLayout.createSequentialGroup()
                                .addComponent(jLabel_quantity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBttn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(26, 26, 26)
                .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBttn_searchCod, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBttn_searchDni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel_searchLayout.createSequentialGroup()
                            .addComponent(jLabel_stock)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel_viewStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel_searchLayout.createSequentialGroup()
                            .addComponent(jLabel_product)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel_viewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_searchLayout.createSequentialGroup()
                        .addComponent(jLabel_customer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_viewCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(112, 112, 112))
        );
        jPanel_searchLayout.setVerticalGroup(
            jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_searchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_searchLayout.createSequentialGroup()
                        .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_dni)
                            .addComponent(numberDniTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_cod)
                            .addComponent(codProductTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_viewPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_priceU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel_quantity)
                                .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_searchLayout.createSequentialGroup()
                                .addComponent(jBttn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))))
                    .addGroup(jPanel_searchLayout.createSequentialGroup()
                        .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBttn_searchDni)
                                .addComponent(jLabel_customer))
                            .addComponent(jLabel_viewCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBttn_searchCod)
                            .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel_viewProduct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_product, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_stock)
                            .addComponent(jLabel_viewStock, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );

        jPanel_back.add(jPanel_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 810, 150));

        jPanel_viewSales.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTable_viewDataSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Cantidad", "Precio Unitario", "SubTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_viewDataSale);

        javax.swing.GroupLayout jPanel_viewSalesLayout = new javax.swing.GroupLayout(jPanel_viewSales);
        jPanel_viewSales.setLayout(jPanel_viewSalesLayout);
        jPanel_viewSalesLayout.setHorizontalGroup(
            jPanel_viewSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_viewSalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_viewSalesLayout.setVerticalGroup(
            jPanel_viewSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_viewSalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_back.add(jPanel_viewSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 810, 150));

        jPanel_actions.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton4.setText("Cancelar");

        jBttn_generateSale.setText("Generar Venta");
        jBttn_generateSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttn_generateSaleActionPerformed(evt);
            }
        });

        jPanel_viewPrice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel_totalPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_totalPrice.setText("Total a Pagar:");

        jLabel_viewPriceTotal.setFont(new java.awt.Font("Segoe UI Semibold", 2, 12)); // NOI18N

        javax.swing.GroupLayout jPanel_viewPriceLayout = new javax.swing.GroupLayout(jPanel_viewPrice);
        jPanel_viewPrice.setLayout(jPanel_viewPriceLayout);
        jPanel_viewPriceLayout.setHorizontalGroup(
            jPanel_viewPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_viewPriceLayout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(jLabel_viewPriceTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel_viewPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_viewPriceLayout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jLabel_totalPrice)
                    .addContainerGap(131, Short.MAX_VALUE)))
        );
        jPanel_viewPriceLayout.setVerticalGroup(
            jPanel_viewPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_viewPriceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_viewPriceTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel_viewPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_viewPriceLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel_totalPrice)
                    .addContainerGap(6, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel_actionsLayout = new javax.swing.GroupLayout(jPanel_actions);
        jPanel_actions.setLayout(jPanel_actionsLayout);
        jPanel_actionsLayout.setHorizontalGroup(
            jPanel_actionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_actionsLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBttn_generateSale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                .addComponent(jPanel_viewPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        jPanel_actionsLayout.setVerticalGroup(
            jPanel_actionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_actionsLayout.createSequentialGroup()
                .addGroup(jPanel_actionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_actionsLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel_actionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jBttn_generateSale)))
                    .addGroup(jPanel_actionsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel_viewPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_back.add(jPanel_actions, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 810, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_back, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_back, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBttn_generateSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_generateSaleActionPerformed
    int ventaID = insertSale();
        if (ventaID > 0) {
            insertSaleDetail(ventaID);
            System.out.println("Venta generada correctamente.");
        } else {
            System.out.println("Error al generar la venta.");
        }
    }//GEN-LAST:event_jBttn_generateSaleActionPerformed

    private void jBttn_searchDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_searchDniActionPerformed
        // TODO add your handling code here:
        getCustomer();
    }//GEN-LAST:event_jBttn_searchDniActionPerformed

    private void jBttn_searchCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_searchCodActionPerformed
        // TODO add your handling code here:
        getProduct();
    }//GEN-LAST:event_jBttn_searchCodActionPerformed

    private void jBttn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttn_addActionPerformed
    // TODO add your handling code here:
        addProductToTable(idProduct, codProduct, nameProduct, priceU);
    }//GEN-LAST:event_jBttn_addActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codProductTextField;
    private javax.swing.JButton jBttn_add;
    private javax.swing.JButton jBttn_generateSale;
    private javax.swing.JButton jBttn_searchCod;
    private javax.swing.JButton jBttn_searchDni;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel_cod;
    private javax.swing.JLabel jLabel_customer;
    private javax.swing.JLabel jLabel_date;
    private javax.swing.JLabel jLabel_dni;
    private javax.swing.JLabel jLabel_priceU;
    private javax.swing.JLabel jLabel_product;
    private javax.swing.JLabel jLabel_quantity;
    private javax.swing.JLabel jLabel_stock;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JLabel jLabel_totalPrice;
    private javax.swing.JLabel jLabel_viewCustomer;
    private javax.swing.JLabel jLabel_viewPrice;
    private javax.swing.JLabel jLabel_viewPriceTotal;
    private javax.swing.JLabel jLabel_viewProduct;
    private javax.swing.JLabel jLabel_viewStock;
    private javax.swing.JPanel jPanel_actions;
    private javax.swing.JPanel jPanel_back;
    private javax.swing.JPanel jPanel_search;
    private javax.swing.JPanel jPanel_viewPrice;
    private javax.swing.JPanel jPanel_viewSales;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_viewDataSale;
    private javax.swing.JTextField numberDniTextField;
    private javax.swing.JSpinner quantitySpinner;
    // End of variables declaration//GEN-END:variables
}

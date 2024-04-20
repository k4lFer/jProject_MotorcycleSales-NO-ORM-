package Services;

import Objects.DtoSales;
import Objects.DtoSalesDetails;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author kalfe
 */
public class SaleService {
    private SaleCreationService saleCreationService;
    private SaleDetailService saleDetailService;
    private ProductStockService productStockService;


    public SaleService(Connection connection) {
        this.saleCreationService = new SaleCreationService(connection);
        this.saleDetailService = new SaleDetailService(connection);
        this.productStockService = new ProductStockService(connection);
    }

    /*public void processSale(DtoSales dtoSale, List<DtoSalesDetails> dtoSaleDetails) throws SQLException {
        int saleID = saleCreationService.createSale(dtoSale);
        for (DtoSalesDetails detailDTO : dtoSaleDetails) {
            detailDTO.setSaleID(saleID); // Asegúrate de que cada detalle de venta esté asociado con la venta correcta
            saleDetailService.addSaleDetail(detailDTO);
            productStockService.updateProductStock(detailDTO); // Corrección aquí
        }
    }*/
    
    public void processSale(DtoSales dtoSale, List<DtoSalesDetails> dtoSaleDetails) throws SQLException {
    int saleID = saleCreationService.createSale(dtoSale);
    for (DtoSalesDetails detailDTO : dtoSaleDetails) {
        detailDTO.setSaleID(saleID); 
        saleDetailService.addSaleDetail(detailDTO);
        productStockService.updateProductStock(detailDTO);
    }
}
    
}

package Services;

import Objects.DtoSalesDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author kalfe
 */
public class ProductStockService {
    private Connection connection;

    public ProductStockService(Connection connection) {
        this.connection = connection;
    }

    public void updateProductStock(DtoSalesDetails dtoSaleDetail) throws SQLException {
        String sql = "UPDATE Products SET StockQuantity = StockQuantity - ? WHERE ProductID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, dtoSaleDetail.getQuantity());
            //statement.setInt(2, dtoSaleDetail.getProductID());
            statement.executeUpdate();
        }
    }
    
}

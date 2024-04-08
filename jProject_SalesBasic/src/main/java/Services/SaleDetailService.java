package Services;

import Entities.SalesDetails;
import Objects.DtoSalesDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kalfe
 */
public class SaleDetailService {
    private Connection connection;

    public SaleDetailService(Connection connection) {
        this.connection = connection;
    }

    public void addSaleDetail(DtoSalesDetails  saleDetail) throws SQLException {
        String sql = "INSERT INTO SalesDetails (SaleID, ProductID, Quantity, Price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, saleDetail.getSaleID());
           //statement.setInt(2, saleDetail.getProductID());
            statement.setInt(3, saleDetail.getQuantity());
            statement.setDouble(4, saleDetail.getPrice());
            statement.executeUpdate();
        }
    }    
}

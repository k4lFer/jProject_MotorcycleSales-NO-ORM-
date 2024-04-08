package Services;

import Entities.Sales;
import Objects.DtoSales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
/**
 *
 * @author kalfe
 */
public class SaleCreationService {
    private Connection connection;

    public SaleCreationService(Connection connection) {
        this.connection = connection;
    }

    public int createSale(DtoSales sale) throws SQLException {
        String sql = "INSERT INTO Sales (CustomerID, Date, TotalPrice) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, sale.getCustomerID());
            statement.setDate(2, new java.sql.Date(sale.getDate().getTime()));
            statement.setDouble(3, sale.getTotalPrice());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating sale failed, no ID obtained.");
                }
            }
        }
    }    
}

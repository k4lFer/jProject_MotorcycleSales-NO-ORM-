package Queries;

import Connection.ConnectionContext;
import Objects.DtoSales;
import Repository.Objects.RepoSales;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kalfe
 */
public class QSales implements RepoSales {
    private Connection connection;
    
    public QSales(){
        ConnectionContext connectionContext = new ConnectionContext();
        this.connection = connectionContext.DataBaseContext();
    }

    @Override
    public List<DtoSales> getAll() {
        List<DtoSales> dtosales = new ArrayList<>();
        String query = "SELECT * FROM sales";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                DtoSales sales = new DtoSales();
                sales.setSaleID(rs.getInt("saleID"));
                sales.setCustomerID(rs.getInt("customerID"));
                sales.setProductID(rs.getInt("productID"));
                sales.setQuantity(rs.getInt("quantity"));
                sales.setDate(rs.getDate("date"));
                sales.setTotalPrice(rs.getDouble("price"));
 
                dtosales.add(sales);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtosales;
    }

    @Override
    public int insert(DtoSales dto) {
        String query = "INSERT INTO sales (customerID, productID, date, quantity, totalprice) VALUES (?, ?, GETDATE(), ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, dto.getCustomerID());
            stmt.setInt(2, dto.getProductID());
            //stmt.setDate(3, dto.getDate("GETDATE()"));
            stmt.setInt(4, dto.getQuantity());
            stmt.setDouble(5, dto.getTotalPrice());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(DtoSales dto) {
        String query = "UPDATE sales SET customerID = ?, productID = ?, quantity = ?, totalprice = ? WHERE SaleID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, dto.getCustomerID());
            stmt.setInt(2, dto.getProductID());
            stmt.setInt(3, dto.getQuantity());
            stmt.setDouble(4, dto.getTotalPrice());
            stmt.setInt(5, dto.getSaleID());
            return stmt.executeUpdate();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;      
                
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM sales WHERE saleID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return 0;
    }

    @Override
    public DtoSales getById(int id) {
      DtoSales dtosales = null;
      String query = "SELECT * FROM sales WHERE saleID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if(rs.next()){
                    dtosales = new DtoSales();
                    dtosales.setSaleID(rs.getInt("saleID"));
                    dtosales.setCustomerID(rs.getInt("customerID"));
                    dtosales.setProductID(rs.getInt("productID"));
                    dtosales.setQuantity(rs.getInt("quantity"));
                    dtosales.setDate(rs.getDate("date"));
                    dtosales.setTotalPrice(rs.getDouble("price"));
                } 
            } 
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtosales;
    }
}

package Queries;

import Connection.ConnectionContext;
import DTOs.Objects.DtoSales;
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
                sales.setDate(rs.getDate("date"));
                sales.setTotalPrice(rs.getDouble("totalPrice"));
 
                dtosales.add(sales);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtosales;
    }

    @Override
    public int insert(DtoSales dto) {
        String query = "INSERT INTO sales (customerID, date, totalprice) VALUES (?, GETDATE(), ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, dto.getCustomerID());
            //stmt.setDate(2, dto.getDate("GETDATE()"));
            stmt.setDouble(2, dto.getTotalPrice());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(DtoSales dto) {
        String query = "UPDATE sales SET customerID = ?, totalprice = ? WHERE SaleID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, dto.getCustomerID());
            stmt.setDouble(2, dto.getTotalPrice());
            stmt.setInt(3, dto.getSaleID());
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
                    dtosales.setDate(rs.getDate("date"));
                    dtosales.setTotalPrice(rs.getDouble("totalPrice"));
                } 
            } 
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtosales;
    }
   
}

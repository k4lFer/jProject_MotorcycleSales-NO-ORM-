package Queries;

import Connection.ConnectionContext;
import DTOs.Objects.DtoSalesDetails;
import Repository.Objects.RepoSalesDetails;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kalfe
 */
public class QSalesDetails implements RepoSalesDetails{
    private Connection connection;
    
    public QSalesDetails(){
        ConnectionContext connectionContext = new ConnectionContext();
        this.connection = connectionContext.DataBaseContext();
    }
    
    @Override
    public List<DtoSalesDetails> getAll() {
        List<DtoSalesDetails> salesdetails = new ArrayList<>();
        String query = "SELECT * FROM SalesDetails";
        try (PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()){
                DtoSalesDetails dtosalesdetails = new DtoSalesDetails();
                dtosalesdetails.setDetailID(rs.getInt("detailID"));
                dtosalesdetails.setSaleID(rs.getInt("SaleID"));
                dtosalesdetails.setProductID(rs.getInt("productID"));
                dtosalesdetails.setUnitPrice(rs.getDouble("UnitPrice"));
                dtosalesdetails.setQuantity(rs.getInt("quantity"));
                dtosalesdetails.setSubTotalPrice(rs.getDouble("SubTotalPrice"));
                                
                salesdetails.add(dtosalesdetails);        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesdetails;
    }

    @Override
    public int insert(DtoSalesDetails dto) {
        String query = "INSERT INTO salesdetails (saleid, productID, quantity, UnitPrice, SubTotalPrice) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getSaleID());
            stmt.setInt(2, dto.getProductID());
            stmt.setInt(3, dto.getQuantity());
            stmt.setDouble(4, dto.getUnitPrice());
            stmt.setDouble(5, dto.getSubTotalPrice());

            return stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(DtoSalesDetails dto) {
       String query = "UPDATE SalesDetails SET saleID = ?, productID = ?, quantity = ?, unitPrice = ? , SubTotalPrice = ? WHERE detailID = ?" ; 
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, dto.getSaleID());
            stmt.setInt(2, dto.getProductID());
            stmt.setInt(3, dto.getQuantity());
            stmt.setDouble(4, dto.getUnitPrice());
            stmt.setDouble(5, dto.getSubTotalPrice());
            stmt.setDouble(6, dto.getDetailID());
            return stmt.executeUpdate();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM SalesDetails WHERE detailID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public DtoSalesDetails getById(int id) {
        DtoSalesDetails dtosalesdetails = null;
        String query = "SELECT * FROM SalesDetails WHERE detailID =?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    dtosalesdetails = new DtoSalesDetails();
                    dtosalesdetails.setDetailID(rs.getInt("detailID"));
                    dtosalesdetails.setSaleID(rs.getInt("SaleID"));
                    dtosalesdetails.setProductID(rs.getInt("productID"));
                    dtosalesdetails.setUnitPrice(rs.getDouble("UnitPrice"));
                    dtosalesdetails.setQuantity(rs.getInt("quantity"));
                    dtosalesdetails.setSubTotalPrice(rs.getDouble("SubtotalPrice"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtosalesdetails;
    }
    
}

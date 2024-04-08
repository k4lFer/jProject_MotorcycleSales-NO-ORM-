package Queries;

import Connection.ConnectionContext;
import Objects.DtoSalesDetails;
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
                dtosalesdetails.setPrice(rs.getDouble("price"));
                dtosalesdetails.setQuantity(rs.getInt("quantity"));
                dtosalesdetails.setSaleID(rs.getInt("saleID"));
                                
                salesdetails.add(dtosalesdetails);        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesdetails;
    }

    @Override
    public int insert(DtoSalesDetails dto) {
        String query = "INSERT INTO salesdetails (saleid, quantity, price)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getSaleID());
            stmt.setInt(2, dto.getQuantity());
            stmt.setDouble(3, dto.getPrice());
            return stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(DtoSalesDetails dto) {
       String query = "UPDATE SalesDetails SET saleID = ?, quantity = ?, price = ? WHERE detailID = ?" ; 
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, dto.getSaleID());
            stmt.setInt(2, dto.getQuantity());
            stmt.setDouble(3, dto.getPrice());
            stmt.setInt(4, dto.getDetailID());
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
        String query = "SELECT * FROM SalesDetails WHERE detailID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    dtosalesdetails = new DtoSalesDetails();
                    dtosalesdetails.setDetailID(rs.getInt("detailID"));
                    dtosalesdetails.setSaleID(rs.getInt("saleID"));
                    dtosalesdetails.setQuantity(rs.getInt("quantity"));
                    dtosalesdetails.setPrice(rs.getDouble("price"));
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtosalesdetails;
    }
    
}

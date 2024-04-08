package Queries;

import Connection.ConnectionContext;
import Objects.DtoBrand;
import Repository.Objects.RepoBrand;
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
public class QBrand implements RepoBrand{
    private Connection connection;
    
    public QBrand(){
        ConnectionContext connectionContext = new ConnectionContext();
        this.connection = connectionContext.DataBaseContext();
    }

    @Override
    public List<DtoBrand> getAll() {
        List<DtoBrand> dtobrand = new ArrayList<>();
        String query = "SELECT * FROM brands";
        try (PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()){
                DtoBrand brand = new DtoBrand();
                brand.setBrandID(rs.getInt("brandid"));
                brand.setName(rs.getString("name"));
                
                dtobrand.add(brand);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtobrand;
    }

    @Override
    public int insert(DtoBrand dto) {
        String query = "INSERT INTO brands (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, dto.getName());
            return stmt.executeUpdate();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(DtoBrand dto) {
        String query = "INSERT INTO brands set name=? WHERE brandid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, dto.getName());
            stmt.setInt(2,dto.getBrandID());
            return stmt.executeUpdate();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;       
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM brands WHERE brandid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public DtoBrand getById(int id) {
        DtoBrand dtobrand = null;
        String query = "SELECT * FROM brands WHERE brandid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                dtobrand = new DtoBrand();  
                dtobrand.setBrandID(rs.getInt("brandid"));
                dtobrand.setName(rs.getString("name"));   
                } 
                
            }             
        } catch (Exception e) {
            e.printStackTrace();
        }
    return dtobrand;
    }
    
}

package Queries;

import Connection.ConnectionContext;
import java.sql.Connection;
import DTOs.Objects.DtoMotorcycleType;
import Repository.Objects.RepoMotorcycleType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kalfe
 */
public class QMotorcycleType implements RepoMotorcycleType {
    private Connection connection;
    
    public QMotorcycleType(){
        ConnectionContext connectionContext = new ConnectionContext();
        this.connection = connectionContext.DataBaseContext();
    }
    

    @Override
    public List<DtoMotorcycleType> getAll() {
        List<DtoMotorcycleType> motorcycletype = new ArrayList<>();
        String query = "SELECT * FROM MotorcycleTypes";
        try (PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()){
            while (rs.next()){
                DtoMotorcycleType dtomotorcycletype = new DtoMotorcycleType();
                dtomotorcycletype.setMotorcycleTypeID(rs.getInt("MotorcycleTypeID")); 
                dtomotorcycletype.setName(rs.getString("name"));
                motorcycletype.add(dtomotorcycletype);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return motorcycletype;
    }

    @Override
    public int insert(DtoMotorcycleType dto) {
        String query = "INSERT INTO MotorcycleTypes (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, dto.getName());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(DtoMotorcycleType dto) {
       String query = "UPDATE MotorcycleTypes SET name = ? WHERE MotorcycleTypeID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, dto.getName());
            stmt.setInt(2, dto.getMotorcycleTypeID());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return 0;
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM MotorcycleTypes WHERE MotorcycleTypeID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public DtoMotorcycleType getById(int id) {
        DtoMotorcycleType dtomotorcycletype = null;
        String query = "SELECT * FROM MotorcycleTypes WHERE MotorcycleTypeID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    dtomotorcycletype = new DtoMotorcycleType();
                    dtomotorcycletype.setMotorcycleTypeID(rs.getInt("MotorcycleTypeID"));
                    dtomotorcycletype.setName(rs.getString("name"));
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtomotorcycletype;
    }   
}

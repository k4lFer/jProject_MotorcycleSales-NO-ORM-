package Queries;

import Connection.ConnectionContext;
import DTOs.Objects.DtoProducts;
import Repository.Objects.RepoProducts;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author kalfe
 */
public class QProducts implements RepoProducts {
    private Connection connection;
    
    public QProducts(){
        ConnectionContext connectionContext = new ConnectionContext();
        this.connection = connectionContext.DataBaseContext();
    }
    
    @Override
    public List<DtoProducts> getAll() {
        List<DtoProducts> product = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()){
                DtoProducts dtoProducts = new DtoProducts();
                dtoProducts.setProductID(rs.getInt("productid"));
                dtoProducts.setBrandID(rs.getInt("brandID"));
                dtoProducts.setMotorcycleTypeID(rs.getInt("motorcycletypeID"));
                dtoProducts.setName(rs.getString("name"));
                dtoProducts.setDisplacement(rs.getString("displacement"));
                dtoProducts.setStockQuantity(rs.getInt("stockquantity"));
                dtoProducts.setPrice(rs.getDouble("price"));
                product.add(dtoProducts);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public int insert(DtoProducts dto) {
       String query = "INSERT INTO products (brandID, motorcycletypeID, name, displacement, stockquantity, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, dto.getBrandID());
            stmt.setInt(2, dto.getMotorcycleTypeID());
            stmt.setString(3, dto.getName());
            stmt.setString(4, dto.getDisplacement());
            stmt.setInt(5, dto.getStockQuantity());
            stmt.setDouble(6, dto.getPrice());
            return stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
       return 0;
    }

    @Override
    public int update(DtoProducts dto) {
        String query = "UPDATE products SET brandID = ?, motorcycletypeID = ?, "
                + "name = ?, displacement = ?, stockquantity = ?, price = ? WHERE productID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, dto.getBrandID());
            stmt.setInt(2, dto.getMotorcycleTypeID());
            stmt.setString(3, dto.getName());
            stmt.setString(4, dto.getDisplacement());
            stmt.setInt(5, dto.getStockQuantity());
            stmt.setDouble(6, dto.getPrice());
            stmt.setInt(7, dto.getProductID());
            return stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM products WHERE productID";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public DtoProducts getById(int id) {
        DtoProducts dtoproducts = null;
        String query = "SELECT * FROM products WHERE productID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    dtoproducts = new DtoProducts();
                    dtoproducts.setProductID(rs.getInt("productID"));
                    dtoproducts.setBrandID(rs.getInt("brandID"));
                    dtoproducts.setMotorcycleTypeID(rs.getInt("motorcycletypeID"));
                    dtoproducts.setName(rs.getString("name"));
                    dtoproducts.setDisplacement(rs.getString("displacement"));
                    dtoproducts.setStockQuantity(rs.getInt("stockquantity"));
                    dtoproducts.setPrice(rs.getDouble("price"));   
                }    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtoproducts;
    }  
}

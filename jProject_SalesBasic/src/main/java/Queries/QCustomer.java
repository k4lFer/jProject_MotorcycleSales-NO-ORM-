package Queries;

import Connection.ConnectionContext;
import DTOs.Objects.DtoCustomer;
import Repository.Objects.RepoCustomer;
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
public class QCustomer implements RepoCustomer{
    private Connection connection;

    public QCustomer() {
        ConnectionContext connectionContext = new ConnectionContext();
        this.connection = connectionContext.DataBaseContext();
    }
    @Override
    public List<DtoCustomer> getAll() {
        List<DtoCustomer> customers = new ArrayList<>();
        String query = "SELECT * FROM customers";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DtoCustomer customer = new DtoCustomer();
                customer.setCustomerID(rs.getInt("customerid"));
                customer.setDni(rs.getString("dni"));
                customer.setFirstName(rs.getString("firstname"));
                customer.setLastName(rs.getString("lastname"));
                customer.setAddress(rs.getString("address"));
                customer.setPhone(rs.getString("phone"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;        
    }
 @Override
    public DtoCustomer getByDni(String dni) {
        DtoCustomer customer = null;
        String query = "SELECT * FROM customers WHERE dni = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dni);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    customer = new DtoCustomer();
                    customer.setCustomerID(rs.getInt("customerid"));
                    customer.setDni(rs.getString("dni"));
                    customer.setFirstName(rs.getString("firstname"));
                    customer.setLastName(rs.getString("lastname"));
                    customer.setAddress(rs.getString("address"));
                    customer.setPhone(rs.getString("phone"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public int insert(DtoCustomer dto) {
        String query = "INSERT INTO customers (dni, firstname, lastname, address, phone) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getDni());
            stmt.setString(2, dto.getFirstName());
            stmt.setString(3, dto.getLastName());
            stmt.setString(4, dto.getAddress());
            stmt.setString(5, dto.getPhone());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(DtoCustomer dto) {
        String query = "UPDATE customers SET dni = ?, firstname = ?, lastname = ?, address = ?, phone = ? WHERE customerID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getDni());
            stmt.setString(2, dto.getFirstName());
            stmt.setString(3, dto.getLastName());
            stmt.setString(4, dto.getAddress());
            stmt.setString(5, dto.getPhone());
            stmt.setInt(6, dto.getCustomerID());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM customers WHERE customerID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public DtoCustomer getById(int id) {
        DtoCustomer customer = null;
        String query = "SELECT * FROM customers WHERE customerID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    customer = new DtoCustomer();
                    customer.setCustomerID(rs.getInt("customerid"));
                    customer.setDni(rs.getString("dni"));
                    customer.setFirstName(rs.getString("firstname"));
                    customer.setLastName(rs.getString("lastname"));
                    customer.setAddress(rs.getString("address"));
                    customer.setPhone(rs.getString("phone"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
    
}

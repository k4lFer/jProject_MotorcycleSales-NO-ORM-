package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionContext {
    private String user = "";
    private String password = "";
    private String db = "DB_SalesMotorcycle";
    private String ip = "localhost";
    private String port = "1433";
    
    public Connection DataBaseContext() {
        Connection conect = null;
        try {
            String url = "jdbc:sqlserver://" + ip + ":" + port + ";databaseName=" + db + ";encrypt=true;trustServerCertificate=true;";
            conect = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos, ERROR:" + e.getMessage());
        } 
        return conect;
    }
}

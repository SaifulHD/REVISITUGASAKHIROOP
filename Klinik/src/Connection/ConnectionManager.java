package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
    private Connection conn;
    private String driver = "com.sql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/klinik";
    private String Username ="root";
    private String Password ="";
    
    public Connection Logon(){
        try {
            conn = DriverManager.getConnection(url,Username,Password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE,null,ex);
        }
        return conn;
    }
    
    public void Logoff(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}

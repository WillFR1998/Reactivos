
package reactivos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conectar {
    public Connection connection = null;
    public String v_user;
    public String v_password;
    public String v_server;
    public String v_db;

    public String getV_user() {
        return v_user;
    }

    public void setV_user(String v_user) {
        this.v_user = v_user;
    }

    public String getV_password() {
        return v_password;
    }

    public void setV_password(String v_password) {
        this.v_password = v_password;
    }

    public String getV_server() {
        return v_server;
    }

    public void setV_server(String v_server) {
        this.v_server = v_server;
    }

    public String getV_db() {
        return v_db;
    }

    public void setV_db(String v_db) {
        this.v_db = v_db;
    }
    
    
    public Connection ConexionDB()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver en MySQL" + ex);
            return connection;
        }
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(v_user);
        dataSource.setPassword(v_password);
        dataSource.setServerName(v_server);
        dataSource.setDatabaseName(v_db);
        try{
            connection = (Connection) dataSource.getConnection();
            return connection;
        }
        catch (SQLException ex){
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
            return connection;
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactivos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Will Figueroa
 */
public class Conectar {
    
    public Connection connection=null;
    
    public Connection ConexionDB()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException ex){
            System.out.println("Error al registrar el driver en MySQL"+ ex);
            return connection;
        }
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("biologia");
        try{
            connection=(Connection) dataSource.getConnection();
            return connection;
        }
        catch(SQLException ex){
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
            return connection;
        }
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author CowherRM
 */
public class DataStore {
    
    public static Connection createDatabaseConnection()
    throws SQLException, ClassNotFoundException {
    String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    Class.forName(driver);
    String url = "jdbc:derby://localhost:1527/remotemanager";
    Connection c = DriverManager.getConnection(url);
    return c;
}

}

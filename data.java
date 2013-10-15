/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotemanager;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author CowherRM
 */
public class data{
    
    //JDBC Driver and database url
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    static final String DB_URL = "jdbc:derby:test1; create = true";
    
    static final String USER = "APP";
    static final String PASS = "test1";
    
    public static String getHost(){
        Connection conn;
        Statement stmt;
        String hostname = null;
        try{
            //Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            
            //Opening a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            //Execute query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT HOSTNAME FROM SERVERS WHERE ID = 1";
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
            //Extract data from result set
            
            while(rs.next()){    
            hostname = rs.getString("HOSTNAME");
            System.out.printf("Hostname is %s inside the try statement\n", hostname);
            }
            
            //Close connection and clean up the environment
            rs.close();
            stmt.close();
            conn.close();
            
           
        
    }
       catch(SQLException se){
           se.printStackTrace();
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(data.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.printf("Hostname = %s", hostname);
    return(hostname);
    
}
    
    public static String getUser(){
        Connection conn = null;
        Statement stmt = null;
        String username = null;
        try{
            //Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            
            //Opening a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            //Execute query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT USERNAME FROM SERVERS WHERE ID = 1";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                //while(rs.next()){    
                username = rs.getString("USERNAME");
                //}
            }
            stmt.close();
            conn.close();
            
           
        
    }
        catch(ClassNotFoundException | SQLException e){
        }
    System.out.printf("Username = %s", username);
    return(username);
    
}
    
    public static String getPass(){
        Connection conn = null;
        Statement stmt = null;
        String password = null;
        try{
            //Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            
            //Opening a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            //Execute query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT PASSWORD FROM SERVERS WHERE ID = 1";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                //while(rs.next()){    
                password = rs.getString("PASSWORD");
                //}
            }
            stmt.close();
            conn.close();
            
           
        
    }
        catch(ClassNotFoundException | SQLException e){
        }
    System.out.printf("Username = %s", password);
    return(password);
    
}
    
        public static Integer getPort(){
        Connection conn = null;
        Statement stmt = null;
        int port = 0;
        try{
            //Register the JDBC driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            
            //Opening a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            //Execute query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT PORT FROM SERVERS WHERE ID = 1";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                //while(rs.next()){    
                port = rs.getInt("PORT");
                //}
            }
            stmt.close();
            conn.close();
            
           
        
    }
        catch(ClassNotFoundException | SQLException e){
        }
    System.out.printf("Port = %d", port);
    return(port);
    
}
    
}



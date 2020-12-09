/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watch.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThinkPad T440s
 */
public class ConnectionDB {
    private static final String DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL ="jdbc:sqlserver://localhost:1433;databaseName=ManageWatch";
    private static final String USER ="admin";
    private static final String PASS ="abc123!@#";
    
    public  static Connection openConnectionDB(){

        
           //Khai bao doi tuong Connection tra ve
           Connection conn = null;
        try {
            //B1. Set Driver cho ket noi
            Class.forName(DRIVER);
            //B2. Khoi tao ket noi - mo ket noi
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn; 
    }
    
    public static void closeConnection(Connection conn,CallableStatement cast){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(cast!=null){
            try {
                cast.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

   
}

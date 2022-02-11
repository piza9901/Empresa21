/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebastian piza
 */
public class DriverDB {
    private static final String BDNAME = "PizaMotors";
    private static final String USER = "sebastian";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:sqlserver://localhost;databaseName=" +
            BDNAME + ";user=" + USER + ";password=" + PASSWORD + ";";
    
    
    static{
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        } catch (Exception ex) {
            Logger.getLogger(dataBase.DriverDB.class.getName()).log(Level.SEVERE, "Falló en encontrar el driver", ex);
            System.exit(1);
        }
    }
    
    private DriverDB() {
    }
    
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException ex) {
            Logger.getLogger(dataBase.DriverDB.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        
        return null;
    } 
}

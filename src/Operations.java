
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author melih sahin
 */
public class Operations {
   
    Connection con = null;
    Statement sta = null;
    PreparedStatement psta = null;
    
    public Operations () {
            
        String url = "jdbc:mysql://"+ Database.host+":"+Database.port+"/"+Database.db_name;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,Database.id,Database.password); 
            System.out.println("Connection successfull");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Driver not working:/");
            
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection not working");
        }
    }
    
    public static void main(String[] args) {
        Operations  op = new Operations();
        
    }
    
}

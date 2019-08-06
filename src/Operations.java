
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Operations {
   
    Connection con = null;
    Statement sta = null;
    PreparedStatement psta = null;
    
   public ArrayList<Book> getBook()
   {
       ArrayList<Book> list = new ArrayList<Book>();
       String query = "select * from book";
        try {
            sta = con.createStatement();
            ResultSet rs = sta.executeQuery(query);
            
            while(rs.next() ){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String type = rs.getString("type");
                String publisher = rs.getString("publisher");
                list.add(new Book(id,name,author,type,publisher));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       
   }
    
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
    
   public boolean Login(String username, String password)
   {
       String query = "select * from admin where username= ? and password= ?";
        try  {
            psta = con.prepareStatement(query);
            psta.setString(1,username);
            psta.setString(2,password);
            ResultSet rs = psta.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
   }
    
    
    
    public static void main(String[] args) {
        Operations  op = new Operations();
        
    }
    
}

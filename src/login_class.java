
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author uxer
 */
public class login_class {
    conn con = new conn();
    protected String uname;
    protected int usertype;
    
    public int login(String username, String password){
        int x = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
        
            String sql = "SELECT * FROM users WHERE username = ? AND PASSWORD = MD5(?);";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                x = 1;
                uname = rs.getString("username");
                usertype = rs.getInt("type");
              //  System.out.println(id);
            }else{
                x = 0;
            }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login_class.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login_class.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return x;
    }
    
}

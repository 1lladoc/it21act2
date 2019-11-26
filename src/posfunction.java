
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author uxer
 */
public class posfunction {
    
     conn con = new conn();
    
    public void getProduct(String id, JTable table){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url, con.username, con.password);

            String sql = "SELECT * FROM products WHERE id = ?;";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);

            pstmt.setString(1,id);
            
            ResultSet rs = pstmt.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            
            while (rs.next()) {
                int qty = 1;
                float subTotal = qty * rs.getFloat("price");
                model.addRow(new Object[]{rs.getString("id"),  qty, rs.getString("product_name"), rs.getString("price"), subTotal});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

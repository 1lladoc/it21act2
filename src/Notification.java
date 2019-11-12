
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
 * @author uxer
 */
public class Notification {
    
    conn con = new conn();
    
    public void checkLowProduct(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url, con.username, con.password);

            String sql = "select * from products";
            String status_sql = "UPDATE products SET status=? WHERE id=?;";
            Statement stmt = (Statement) conn.prepareCall(sql);
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(status_sql);
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                int qty = rs.getInt("quantity");
                int status = rs.getInt("status");
                String product = rs.getString("product_name");
                String id = rs.getString("id");
                
                if(qty < 5 && status != 1){
                    pstmt.setInt(1, 1);
                    pstmt.setString(2, id);
                    pstmt.executeUpdate();
                    displayNotification(product);
                }else if(qty >= 5 && status == 1){
                    pstmt.setInt(1, 2);
                    pstmt.setString(2, id);
                    pstmt.executeUpdate();
                }
                
                
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AWTException ex) {
            Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void displayNotification(String product) throws AWTException{
        
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("img/warning.png");
        
        TrayIcon trayIcon = new TrayIcon(image,"");
        trayIcon.setImageAutoSize(true);
        tray.add(trayIcon);
        trayIcon.displayMessage("LOW QUANTITY", product+" product low on quantity", TrayIcon.MessageType.WARNING);
    }
    
}

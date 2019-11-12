
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author uxer
 */
public class mainpage extends javax.swing.JFrame {

    /**
     * Creates new form mainpage
     */
    public mainpage() {
        initComponents();
        this.setLocationRelativeTo(null);
        refreshThread.start();
        checkLowQuantity.start();
    }

    public mainpage(String username) {
        initComponents();
        jLabel1.setText("Welcome " + username);
        this.setLocationRelativeTo(null);
        refreshThread.start();
        checkLowQuantity.start();
    }

    product product_obj = new product();
    conn con = new conn();

    Object id = null;
    
    void clearAddProductField() {
        proname.setText(null);
        proqty.setValue(0);
        proprice.setText(null);
        proname.requestFocus();
        xst_qty.setText(null);
    }
    
    void enableAndClearFields(){
        proname.setEnabled(true);
        proqty.setEnabled(true);
        proprice.setEnabled(true);
        clearAddProductField();
    }

    final void refresh() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url, con.username, con.password);

            String sql = "select * from products";
            Statement stmt = (Statement) conn.prepareCall(sql);

            ResultSet rs = stmt.executeQuery(sql);

            DefaultTableModel model = (DefaultTableModel) product_table.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("id"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("price")});
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Thread refreshThread = new Thread(new Runnable(){
    
        @Override
        public void run(){
            try{
                while(true){
                    refresh();
                    Thread.sleep(5000);
                } 
            } catch (InterruptedException ex) {
                Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    });
    
    Thread checkLowQuantity = new Thread(new Runnable(){
       Notification n = new Notification();
       @Override
       public void run(){
           try{
               while(true){
                   n.checkLowProduct();
                   Thread.sleep(5000);
               }
           } catch (InterruptedException ex) {
               Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    });

    final void search(String keyword) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url, con.username, con.password);

            String sql = "SELECT * FROM products WHERE id LIKE ? OR product_name LIKE ? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);

            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            
            ResultSet rs = pstmt.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) product_table.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("id"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("price")});
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addproductframe = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        proname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        proqty = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        proprice = new javax.swing.JFormattedTextField();
        add_btn = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        xst_qty = new javax.swing.JLabel();
        addqty_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        product_table = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        keyword_tf = new javax.swing.JTextField();
        search_btn = new javax.swing.JButton();
        add_qty = new javax.swing.JButton();

        addproductframe.setMinimumSize(new java.awt.Dimension(400, 300));

        jLabel2.setText("Product Name:");

        jLabel3.setText("Quantity:");

        proqty.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel4.setText("Price:");

        proprice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        add_btn.setText("Add Product");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        save_btn.setText("Save");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        addqty_btn.setText("Add Quantity");
        addqty_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addqty_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addproductframeLayout = new javax.swing.GroupLayout(addproductframe.getContentPane());
        addproductframe.getContentPane().setLayout(addproductframeLayout);
        addproductframeLayout.setHorizontalGroup(
            addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addproductframeLayout.createSequentialGroup()
                .addGroup(addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addproductframeLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(proname)
                            .addComponent(proprice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addproductframeLayout.createSequentialGroup()
                                .addComponent(xst_qty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(proqty, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(addproductframeLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(save_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addqty_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(114, 114, 114))
        );
        addproductframeLayout.setVerticalGroup(
            addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addproductframeLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(proname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xst_qty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(proqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(proprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addComponent(addqty_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(save_btn)
                .addGap(17, 17, 17))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Add Product");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        product_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "product", "qty", "price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        product_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(product_table);

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Edit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        keyword_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keyword_tfKeyReleased(evt);
            }
        });

        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        add_qty.setText("Add Quantity");
        add_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_qtyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add_qty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(keyword_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(keyword_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(search_btn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(129, 129, 129)
                        .addComponent(add_qty))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        // TODO add your handling code here:
        String pn = proname.getText();
        int qty = (int) proqty.getValue();
        Object price = proprice.getValue();
        //float price = Float.parseFloat(proprice.getValue().toString());
        //System.out.println(price);
        int r = product_obj.addProduct(pn, qty, price);
        if (r == 1) {
            JOptionPane.showMessageDialog(addproductframe, "New Product Added Successfully");
            clearAddProductField();
            refresh();
        }
    }//GEN-LAST:event_add_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        addproductframe.setVisible(true);
        addproductframe.setAlwaysOnTop(true);
        addproductframe.setLocationRelativeTo(null);
        save_btn.setVisible(false);
        add_btn.setVisible(true);
        addqty_btn.setVisible(false);
        
        this.enableAndClearFields();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int r = product_table.getSelectedRow();

        if (r == -1) {
            JOptionPane.showMessageDialog(rootPane, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            id = product_table.getValueAt(r, 0);
            Object product_name = product_table.getValueAt(r, 1);
            int c = JOptionPane.showConfirmDialog(rootPane, "This will delete " + product_name + ".\nClick OK to continue", "Confirm Delete", JOptionPane.OK_CANCEL_OPTION);

            if (c == JOptionPane.OK_OPTION) {
                int cc = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete " + product_name + "?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (cc == JOptionPane.YES_OPTION) {
                    int re = product_obj.deleteProduct(id);
                    if (re == 1) {
                        JOptionPane.showMessageDialog(rootPane, "Product " + product_name + " deleted!", "Product Deleted", JOptionPane.WARNING_MESSAGE);
                        refresh();
                    }
                }
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        this.enableAndClearFields();
        int row = product_table.getSelectedRow();

        if (row != -1) {
            addproductframe.setVisible(true);
            addproductframe.setAlwaysOnTop(true);
            addproductframe.setLocationRelativeTo(null);
            add_btn.setVisible(false);
            save_btn.setVisible(true);
            addqty_btn.setVisible(false);
            proqty.setEnabled(false);

            id = product_table.getValueAt(row, 0);
            Object pname = product_table.getValueAt(row, 1);
            Object pqty = product_table.getValueAt(row, 2);
            Object pprice = product_table.getValueAt(row, 3);

            proname.setText((String) pname);
            proqty.setValue(Integer.valueOf(pqty.toString()));
            proprice.setValue(Double.valueOf(pprice.toString()));

        } else {
            JOptionPane.showMessageDialog(rootPane, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        // TODO add your handling code here:
        String name = proname.getText();
        Object price = proprice.getValue();

        int r = product_obj.editProduct(id, name, price);
        if (r == 1) {
            JOptionPane.showMessageDialog(addproductframe, "Product Edited");
            addproductframe.setVisible(false);
            this.refresh();
        } else {
            JOptionPane.showMessageDialog(addproductframe, "Problem Editing a product", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_save_btnActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        // TODO add your handling code here:
        String keyword = keyword_tf.getText();
        this.search(keyword);
    }//GEN-LAST:event_search_btnActionPerformed

    private void keyword_tfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyword_tfKeyReleased
        // TODO add your handling code here:
        String keyword = keyword_tf.getText();
        this.search(keyword);
    }//GEN-LAST:event_keyword_tfKeyReleased

    private void add_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_qtyActionPerformed
        // TODO add your handling code here:
           this.enableAndClearFields();
           int row = product_table.getSelectedRow();
           if(row != -1){
                addproductframe.setVisible(true);
                addproductframe.setAlwaysOnTop(true);
                addproductframe.setLocationRelativeTo(this);
                add_btn.setVisible(false);
                save_btn.setVisible(false);
                addqty_btn.setVisible(true);
                
                id = product_table.getValueAt(row, 0);
                Object pn = product_table.getValueAt(row, 1);
                Object qt = product_table.getValueAt(row, 2);
                Object pr = product_table.getValueAt(row, 3);
                
                proname.setText(pn.toString());
                xst_qty.setText(qt.toString());
                proprice.setValue(Double.valueOf(pr.toString()));
                
                proname.setEnabled(false);
                proprice.setEnabled(false);
                
           }else{
               JOptionPane.showMessageDialog(rootPane, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
           }
        
    }//GEN-LAST:event_add_qtyActionPerformed

    private void addqty_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addqty_btnActionPerformed
        // TODO add your handling code here:
        Object pn = proname.getText();
        Object qty = proqty.getValue();
        int c = JOptionPane.showConfirmDialog(addproductframe, "Would you like to add\n"+qty+ "\nto the product\n"+pn+"?", "Add Quantity", JOptionPane.YES_NO_OPTION);
        if(c==JOptionPane.YES_OPTION){
            int r = product_obj.addQuantity(id, qty);
            if(r==1){
                JOptionPane.showMessageDialog(addproductframe, "Product Quantity Updated!");
                addproductframe.setVisible(false);
                this.refresh();
            }else{
                JOptionPane.showMessageDialog(addproductframe, "Problem Updating a product", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_addqty_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JButton add_qty;
    private javax.swing.JFrame addproductframe;
    private javax.swing.JButton addqty_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keyword_tf;
    private javax.swing.JTable product_table;
    private javax.swing.JTextField proname;
    private javax.swing.JFormattedTextField proprice;
    private javax.swing.JSpinner proqty;
    private javax.swing.JButton save_btn;
    private javax.swing.JButton search_btn;
    private javax.swing.JLabel xst_qty;
    // End of variables declaration//GEN-END:variables
}

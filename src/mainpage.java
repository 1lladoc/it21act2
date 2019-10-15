
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
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
public class mainpage extends javax.swing.JFrame {

    /**
     * Creates new form mainpage
     */
    public mainpage() {
        initComponents();
        refresh();
    }
    
    public mainpage(String username) {
        initComponents();
        jLabel1.setText("Welcome "+username);
        refresh();
    }
    
    product product_obj = new product();
    conn con = new conn();
    
    Object id = null;
    
    void clearAddProductField(){
        proname.setText(null);
        proqty.setValue(0);
        proprice.setText(null);
        proname.requestFocus();
    }
    
    final void refresh(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url, con.username, con.password);
            
            String sql = "select * from products";
            Statement stmt = (Statement) conn.prepareCall(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            
            DefaultTableModel model = (DefaultTableModel) product_table.getModel();
            model.setRowCount(0);
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("id"),rs.getString("product_name"),rs.getString("quantity"),rs.getString("price")});
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        product_table = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

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

        javax.swing.GroupLayout addproductframeLayout = new javax.swing.GroupLayout(addproductframe.getContentPane());
        addproductframe.getContentPane().setLayout(addproductframeLayout);
        addproductframeLayout.setHorizontalGroup(
            addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addproductframeLayout.createSequentialGroup()
                .addGroup(addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addproductframeLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(save_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(addproductframeLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(proname)
                            .addComponent(proprice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(proqty, javax.swing.GroupLayout.Alignment.TRAILING))))
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
                .addGroup(addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(proqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addproductframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(proprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
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
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
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
        if(r==1){
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
        proqty.setEnabled(true);
        this.clearAddProductField();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int r = product_table.getSelectedRow();
        
        if(r == -1){
            JOptionPane.showMessageDialog(rootPane, "Please select a row","Warning",JOptionPane.WARNING_MESSAGE);
        }else{
            id = product_table.getValueAt(r, 0);
            Object product_name = product_table.getValueAt(r, 1);
            int c = JOptionPane.showConfirmDialog(rootPane, "This will delete "+product_name+".\nClick OK to continue","Confirm Delete",JOptionPane.OK_CANCEL_OPTION);
            
            if(c==JOptionPane.OK_OPTION){
                int cc = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete "+product_name+"?", "Delete", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                if(cc == JOptionPane.YES_OPTION){
                    int re = product_obj.deleteProduct(id);
                    if(re == 1){
                        JOptionPane.showMessageDialog(rootPane, "Product "+product_name+" deleted!","Product Deleted",JOptionPane.WARNING_MESSAGE);
                        refresh();
                    }
                }
            }
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        int row = product_table.getSelectedRow();
        
        if(row != -1){
            addproductframe.setVisible(true);
            addproductframe.setAlwaysOnTop(true);
            addproductframe.setLocationRelativeTo(null);
            add_btn.setVisible(false);
            save_btn.setVisible(true);
            proqty.setEnabled(false);
            
            id = product_table.getValueAt(row, 0);
            Object pname = product_table.getValueAt(row, 1);
            Object pqty = product_table.getValueAt(row, 2);
            Object pprice = product_table.getValueAt(row, 3);
            
            proname.setText((String) pname);
            proqty.setValue(Integer.valueOf(pqty.toString()));
            proprice.setValue(Double.valueOf(pprice.toString()));
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Please select a row","Warning",JOptionPane.WARNING_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        // TODO add your handling code here:
        String name = proname.getText();
        Object price = proprice.getValue();
        
        int r = product_obj.editProduct(id, name, price);
        if(r==1){
            JOptionPane.showMessageDialog(addproductframe, "Product Edited");
            addproductframe.setVisible(false);
            this.refresh();
        }else{
            JOptionPane.showMessageDialog(addproductframe, "Problem Editing a product","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_save_btnActionPerformed

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
    private javax.swing.JFrame addproductframe;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable product_table;
    private javax.swing.JTextField proname;
    private javax.swing.JFormattedTextField proprice;
    private javax.swing.JSpinner proqty;
    private javax.swing.JButton save_btn;
    // End of variables declaration//GEN-END:variables
}

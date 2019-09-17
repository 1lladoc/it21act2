/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author uxer
 */
public class product {
    
    public void addProduct(String product, int quantity, Object price){
        String sql = "insert into products values(null,'"+product+"',"+quantity+","+price+");";
        System.out.println(sql);
    }
    
}

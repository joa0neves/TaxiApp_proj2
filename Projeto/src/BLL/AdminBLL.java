/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import projeto.Admin;

/**
 *
 * @author Utilizador
 */
public class AdminBLL {
    
    public static Admin read(String username){
        Admin admin = new Admin();
        String sql = "select * from ADMIN where USERNAME=?";
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  

            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");  

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                admin.setUsername(username);
                admin.setAdminID(rs.getInt("ADMIN_ID"));
                admin.setPassword(rs.getString("PASSWORD"));
            }
            
            con.close();
            
        }catch (Exception e) {
            System.out.println(e);
        }
        return admin;
    
}
    
}

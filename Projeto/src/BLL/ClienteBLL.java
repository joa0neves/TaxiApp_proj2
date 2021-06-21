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
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.Cliente;

/**
 *
 * @author Joao
 */
public class ClienteBLL {
    
    public static void create(Cliente cliente) {
        String sql="insert into cliente (USERNAME,PASSWORD,EMAIL,NIF,DATA_NASCIMENTO) values(?,?,?,?,?)";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,cliente.getUsername());
            stmt.setString(2,cliente.getPassword());
            stmt.setString(3,cliente.getEmail());
            stmt.setInt(4, cliente.getNIF());
            stmt.setDate(5,new java.sql.Date(cliente.getData_nascimento().getTime()));
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void delete(int cliente_id){
        String sql="delete from CLIENTE where CLIENTE_ID=?";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1,cliente_id);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public static void update(Cliente cliente){
        String sql="update cliente set USERNAME=? , PASSWORD=? , EMAIL=?, NIF=?, DATA_NASCIMENTO=? where CLIENTEID=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,cliente.getUsername());
            stmt.setString(2,cliente.getPassword());
            stmt.setString(3,cliente.getEmail());
            stmt.setInt(4, cliente.getNIF());
            stmt.setDate(5,new java.sql.Date(cliente.getData_nascimento().getTime()));
            stmt.setInt(6, cliente.getCliente_id());
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            
             con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static Cliente read(String username){
        String sql="select * from CLIENTE where USERNAME=?";
        Cliente cliente=new Cliente();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");  

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                cliente.setUsername(username);
                cliente.setPassword(rs.getString("PASSWORD"));
                cliente.setCliente_id(rs.getInt("CLIENTE_ID"));
                cliente.setEmail(rs.getString("EMAIL"));
                cliente.setData_nascimento(new Date(rs.getTime("DATA_NASCIMENTO").getTime()));
                cliente.setNIF(rs.getInt("NIF"));
            }
            
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        
        return cliente;
    }
    
    public static Boolean checkUsername(String username){
        String sql="select * from CLIENTE where USERNAME=?";
        Boolean result = false;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");  

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result=true;
            }
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        
        return result;
    }
    
}

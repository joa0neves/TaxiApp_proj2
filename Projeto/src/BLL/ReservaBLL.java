/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.Reserva;

/**
 *
 * @author Joao
 */
public class ReservaBLL {
    
    public void create(Date Datapartida,int clienteID,String destino,String partida){
        String sql="insert into RESERVA (DATA_PARTIDA,CLIENTE_ID,DESTINO,PARTIDA) values(?,?,?,?);";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(Datapartida.getTime()));
            stmt.setInt(2,clienteID);
            stmt.setString(3, destino);
            stmt.setString(4,partida);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void delete(int viagemID){
        String sql="delete from RESERVA where VIAGEM_ID=?;";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, viagemID);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void update(int viagemID,Date Datapartida,int clienteID,String destino,String partida){
        String sql="update RESERVA DATA_PARTIDA=?,CLIENTE_ID=?,DESTINO=?,PARTIDA=? where VIAGEM_ID=?;";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(Datapartida.getTime()));
            stmt.setInt(2,clienteID);
            stmt.setString(3, destino);
            stmt.setString(4,partida);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}

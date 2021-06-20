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
import projeto.Viagem;

/**
 *
 * @author Joao
 */
public class ViagemBLL {
    
    public void create(int taxiID,int taxistaID,int clienteID,Date inicio,Date fim,float custo,double distancia,String estado,String formapagamento,String localpartida, String localchegado){
        String sql="insert into viagem (TAXI_ID,TAXISTA_ID,CLIENTE_ID,INICIO,FIM,CUSTO,DISTANCIA,ESTADO,FORMA_PAGAMENTO,PARTIDA,CHEGADA) values(?,?,?,?,?,?,?,?,?,?,?)";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, taxiID);
            stmt.setInt(2, taxistaID);
            stmt.setInt(3,clienteID);
            stmt.setDate(4,new java.sql.Date(inicio.getTime()));
            stmt.setDate(5,new java.sql.Date(fim.getTime()));
            stmt.setFloat(6, custo);
            stmt.setFloat(7,Double.valueOf(distancia).floatValue());
            stmt.setString(8,estado);
            stmt.setString(9,formapagamento);
            stmt.setString(10,localpartida);
            stmt.setString(11,localchegado);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void delete(int viagemID){
        String sql="delete from VIAGEM where VIAGEM_ID=?";
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
    
    public void update(int viagemID,int taxiID,int taxistaID,int clienteID,Date inicio,Date fim,float custo,double distancia,String estado,String formapagamento,String localpartida, String localchegado){
        String sql="update viagem set TAXI_ID=?,TAXISTA_ID=?,CLIENTE_ID=?,INICIO=?,FIM=?,CUSTO=?,DISTANCIA=?,ESTADO=?,FORMA_PAGAMENTO=?,PARTIDA=?,CHEGADA=? where VIAGEM_ID=?;";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, taxiID);
            stmt.setInt(2, taxistaID);
            stmt.setInt(3,clienteID);
            stmt.setDate(4,new java.sql.Date(inicio.getTime()));
            stmt.setDate(5,new java.sql.Date(fim.getTime()));
            stmt.setFloat(6, custo);
            stmt.setFloat(7,Double.valueOf(distancia).floatValue());
            stmt.setString(8,estado);
            stmt.setString(9,formapagamento);
            stmt.setString(10,localpartida);
            stmt.setString(11,localchegado);
            stmt.setInt(12,viagemID);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        
    }
}

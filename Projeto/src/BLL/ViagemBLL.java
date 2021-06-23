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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.Reserva;
import projeto.Viagem;

/**
 *
 * @author Joao
 */
public class ViagemBLL {
    
    /*public void create(Viagem viagem){
        String sql="insert into viagem (TAXI_ID,TAXISTA_ID,CLIENTE_ID,INICIO,FIM,CUSTO,DISTANCIA,ESTADO,FORMA_PAGAMENTO,PARTIDA,CHEGADA) values(?,?,?,?,?,?,?,?,?,?,?)";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, viagem.getTaxiID());
            stmt.setInt(2, viagem.getTaxistaID());
            stmt.setInt(3,viagem.getClienteID());
            stmt.setDate(4,new java.sql.Date(viagem.getInicio().getTime()));
            stmt.setDate(5,new java.sql.Date(viagem.getFim().getTime()));
            stmt.setFloat(6, viagem.getCusto());
            stmt.setFloat(7,Double.valueOf(viagem.getDistancia()).floatValue());
            stmt.setString(8,viagem.getEstado());
            stmt.setString(9,viagem.getFormapagamento());
            stmt.setString(10,viagem.getLocalpartida());
            stmt.setString(11,viagem.getLocalchegado());
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }*/
    
    public static void create(Viagem viagem){
        String sql="insert into viagem (CLIENTE_ID,INICIO,ESTADO,PARTIDA,CHEGADA) values(?,?,?,?,?)";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,viagem.getClienteID());
            long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis);  
            stmt.setDate(2,date);
            stmt.setString(3,"espera");
            stmt.setString(4,viagem.getLocalpartida());
            stmt.setString(5,viagem.getLocalchegado());
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void delete(int viagemID){
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
    
    public static void update(int viagemID,int taxiID,int taxistaID,int clienteID,Date inicio,Date fim,float custo,double distancia,String estado,String formapagamento,String localpartida, String localchegado){
        String sql="update viagem set TAXI_ID=?,TAXISTA_ID=?,CLIENTE_ID=?,INICIO=?,FIM=?,CUSTO=?,DISTANCIA=?,ESTADO=?,FORMA_PAGAMENTO=?,PARTIDA=?,CHEGADA=? where VIAGEM_ID=?";
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
    
    public static List<Viagem> readByUser(int id){
        List<Viagem> lista = new ArrayList<>();
        String sql = "select * from RESERVA where CLIENTE_ID=?";
        Viagem temp;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");  
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                temp=new Viagem();
                temp.setViagemID(rs.getInt("VIAGEM_ID"));
                temp.setClienteID(rs.getInt("CLIENTE_ID"));
                temp.setTaxistaID(rs.getInt("TAXISTA_ID"));
                temp.setTaxiID(rs.getInt("TAXI_ID"));
                temp.setInicio(new Date(rs.getTime("INICIO").getTime()));
                temp.setFim(new Date(rs.getTime("FIM").getTime()));
                temp.setLocalpartida(rs.getString("PARTIDA"));
                temp.setLocalchegado(rs.getString("CHEGADA"));
                temp.setCusto(rs.getFloat("CUSTO"));
                temp.setDistancia(rs.getDouble("DISTANCIA"));
                temp.setFormapagamento(rs.getString("FORMA_PAGAMENTO"));
                temp.setEstado(rs.getString("ESTADO"));
                lista.add(temp);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return lista;
    }
    
    public static List<Viagem> readAllEspera(){
        List<Viagem> lista = new ArrayList<>();
        String sql = "select * from VIAGEM where ESTADO=?";
        Viagem temp;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");  
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "espera");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                temp=new Viagem();
                temp.setViagemID(rs.getInt("VIAGEM_ID"));
                temp.setClienteID(rs.getInt("CLIENTE_ID"));
                temp.setLocalpartida(rs.getString("PARTIDA"));
                temp.setLocalchegado(rs.getString("CHEGADA"));
                lista.add(temp);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return lista;
    }
}

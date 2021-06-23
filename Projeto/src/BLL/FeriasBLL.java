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
import projeto.Ferias;
import projeto.Taxista;

/**
 *
 * @author Joao
 */
public class FeriasBLL {
    
    public static void create(Ferias ferias){
        String sql="insert into PEDIDO_FERIAS (ID_TAXISTA,DATA_INICIO,DATA_FIM,ESTADO) VALUES(?,?,?,?)";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, ferias.getTaxistaID());
            stmt.setDate(2, new java.sql.Date(ferias.getInicio().getTime()));
            stmt.setDate(3, new java.sql.Date(ferias.getFim().getTime()));
            stmt.setString(4,ferias.getEstado());
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void delete(int pedidoID){
        String sql="delete from PEDIDO_FERIAS where PEDIDO_ID=?;";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pedidoID);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void update(int pedidoID,Date inicio,Date fim, int adminID,int taxistaID, String estado){
        String sql="update PEDIDO_FERIAS ID_TAXISTA=?,DATA_INICIO=?,DATA_FIM=?,ESTADO=?) where PEDIDO_ID=? ;";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, taxistaID);
            stmt.setDate(2, new java.sql.Date(inicio.getTime()));
            stmt.setDate(3, new java.sql.Date(fim.getTime()));
            stmt.setString(4,estado);
            stmt.setInt(5,pedidoID);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static List<Ferias> readAll(){
        List<Ferias> lista = new ArrayList<>();
        String sql = "select * from PEDIDO_FERIAS";
        Ferias temp;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");  
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                temp=new Ferias();
                temp.setPedidoID(rs.getInt("PEDIDO_ID"));
                temp.setTaxistaID(rs.getInt("ID_TAXISTA"));
                temp.setInicio(new Date(rs.getTime("DATA_INICIO").getTime()));
                temp.setFim(new Date(rs.getTime("DATA_FIM").getTime()));
                temp.setEstado(rs.getString("ESTADO"));
                lista.add(temp);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return lista;
    }
}

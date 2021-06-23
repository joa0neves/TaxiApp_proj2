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
import projeto.Taxi;

/**
 *
 * @author Joao
 */
public class TaxiBLL {
    public static void create(Taxi taxi){
        String sql="insert into TAXI (ALVARÁ,MODELO,MARCA,MATRICULA) values(?,?,?,?)";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, taxi.getAlvara());
            stmt.setString(2, taxi.getModelo());
            stmt.setString(3, taxi.getMarca());
            stmt.setString(4, taxi.getMatricula());
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void delete(int taxi_ID){
        String sql="delete from TAXI where TAXI_ID=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, taxi_ID);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void update(Taxi taxi){
        String sql="update TAXI set ALVARA=?,MODELO=?,MARCA=?,MATRICULA? where TAXI_ID=?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, taxi.getAlvara());
            stmt.setString(2, taxi.getModelo());
            stmt.setString(3, taxi.getMarca());
            stmt.setString(4, taxi.getMatricula());
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static List<Taxi> readAll(){
        List<Taxi> lista = new ArrayList<>();
        String sql = "select * from TAXI";
        Taxi temp;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");  
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                temp=new Taxi();
                temp.setTaxi_ID(rs.getInt("TAXI_ID"));
                temp.setAlvara(rs.getString("ALVARÁ"));
                temp.setMarca(rs.getString("MARCA"));
                temp.setModelo(rs.getString("MODELO"));
                temp.setMatricula(rs.getString("MATRICULA"));
                lista.add(temp);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return lista;
    }
}

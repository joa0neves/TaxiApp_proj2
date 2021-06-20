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
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.Taxi;

/**
 *
 * @author Joao
 */
public class TaxiBLL {
    public void create(Taxi taxi){
        String sql="insert into TAXI (ALVARA,MODELO,MARCA,MATRICULA) values(?,?,?,?);";
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
    
    public void delete(int taxi_ID){
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
    
    public void update(Taxi taxi){
        String sql="update TAXI set ALVARA=?,MODELO=?,MARCA=?,MATRICULA? where TAXI_ID=?;";
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
}

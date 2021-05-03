/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Joao
 */
public class Projeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

    
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "projeto_taxi", "12346579");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from admin");
            while (rs.next()) {
                System.out.println(rs.getString("USERNAME"));
            }
  
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.Connection;
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
    public void create(Connection con,Taxi taxi){
        String sql="insert into TAXI (ALVARÁ,MODELO,MARCA,MATRICULA) values(?,?,?,?);";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, taxi.getAlvara());
            stmt.setString(2, taxi.getModelo());
            stmt.setString(3, taxi.getMarca());
            stmt.setString(4, taxi.getMatricula());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Connection con,int taxi_ID){
        String sql="delete from TAXI where TAXI_ID=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, taxi_ID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Connection con, Taxi taxi){
        String sql="update TAXI set ALVARÁ=?,MODELO=?,MARCA=?,MATRICULA? where TAXI_ID=?;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, taxi.getAlvara());
            stmt.setString(2, taxi.getModelo());
            stmt.setString(3, taxi.getMarca());
            stmt.setString(4, taxi.getMatricula());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

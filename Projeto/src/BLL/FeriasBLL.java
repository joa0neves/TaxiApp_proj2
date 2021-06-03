/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.Ferias;

/**
 *
 * @author Joao
 */
public class FeriasBLL {
    
    public void create(Connection con,Date inicio,Date fim, int adminID,int taxistaID, String estado){
        String sql="insert into PEDIDO_FERIAS (ID_TAXISTA,DATA_INICIO,DATA_FIM,ESTADO) VALUES(?,?,?,?);";
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, taxistaID);
            stmt.setDate(2, new java.sql.Date(inicio.getTime()));
            stmt.setDate(3, new java.sql.Date(fim.getTime()));
            stmt.setString(4,estado);
            stmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Ferias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Connection con,int pedidoID){
        String sql="delete from PEDIDO_FERIAS where PEDIDO_ID=?;";
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pedidoID);
            stmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Ferias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Connection con,int pedidoID,Date inicio,Date fim, int adminID,int taxistaID, String estado){
        String sql="update PEDIDO_FERIAS ID_TAXISTA=?,DATA_INICIO=?,DATA_FIM=?,ESTADO=?) where PEDIDO_ID=? ;";
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, taxistaID);
            stmt.setDate(2, new java.sql.Date(inicio.getTime()));
            stmt.setDate(3, new java.sql.Date(fim.getTime()));
            stmt.setString(4,estado);
            stmt.setInt(5,pedidoID);
            stmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Ferias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

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
import projeto.Reserva;

/**
 *
 * @author Joao
 */
public class ReservaBLL {
    
    public void create(Connection con,Date Datapartida,int clienteID,String destino,String partida){
        String sql="insert into RESERVA (DATA_PARTIDA,CLIENTE_ID,DESTINO,PARTIDA) values(?,?,?,?);";
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(Datapartida.getTime()));
            stmt.setInt(2,clienteID);
            stmt.setString(3, destino);
            stmt.setString(4,partida);
            stmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Connection con,int viagemID){
        String sql="delete from RESERVA where VIAGEM_ID=?;";
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, viagemID);
            stmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Connection con,int viagemID,Date Datapartida,int clienteID,String destino,String partida){
        String sql="update RESERVA DATA_PARTIDA=?,CLIENTE_ID=?,DESTINO=?,PARTIDA=? where VIAGEM_ID=?;";
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(Datapartida.getTime()));
            stmt.setInt(2,clienteID);
            stmt.setString(3, destino);
            stmt.setString(4,partida);
            stmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

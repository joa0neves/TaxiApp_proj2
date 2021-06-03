/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
/**
 *
 * @author Joao
 */
public class Reserva implements Serializable{
    private Date Datapartida;
    private int clienteID;
    private int viagemID;
    private String destino;
    private String partida;

    public Reserva() {
    }
    
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
    

    public Date getDatapartida() {
        return Datapartida;
    }

    public void setDatapartida(Date Datapartida) {
        this.Datapartida = Datapartida;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public int getViagemID() {
        return viagemID;
    }

    public void setViagemID(int viagemID) {
        this.viagemID = viagemID;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }
    
    
}

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
public class Ferias implements Serializable{
    private Date inicio;
    private Date fim;
    private int adminID;
    private int taxistaID;
    private int pedidoID;
    private String estado;

    public Ferias() {
    }
    
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
    
    

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public int getTaxistaID() {
        return taxistaID;
    }

    public void setTaxistaID(int taxistaID) {
        this.taxistaID = taxistaID;
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
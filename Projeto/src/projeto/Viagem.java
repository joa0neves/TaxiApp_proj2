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
import javax.xml.bind.annotation.XmlTransient;*/
/**
 *
 * @author Joao
 */
public class Viagem implements Serializable{
    private Date inicio;
    private Date fim;
    private float custo;
    private double distancia;
    private int taxistaID;
    private int clienteID;
    private int taxiID;
    private int viagemID;
    private String estado;
    private String formapagamento;
    private String localpartida;
    private String localchegado;
    
    public void create(Connection con,int taxiID,int taxistaID,int clienteID,Date inicio,Date fim,float custo,double distancia,String estado,String formapagamento,String localpartida, String localchegado){
        String sql="insert into viagem (TAXI_ID,TAXISTA_ID,CLIENTE_ID,INICIO,FIM,CUSTO,DISTANCIA,ESTADO,FORMA_PAGAMENTO,PARTIDA,CHEGADA) values(?,?,?,?,?,?,?,?,?,?,?)";
        try{
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
            stmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Viagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Connection con,int viagemID){
        String sql="delete from VIAGEM where VIAGEM_ID=?";
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, viagemID);
            stmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Viagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Connection con,int viagemID,int taxiID,int taxistaID,int clienteID,Date inicio,Date fim,float custo,double distancia,String estado,String formapagamento,String localpartida, String localchegado){
        String sql="update viagem set TAXI_ID=?,TAXISTA_ID=?,CLIENTE_ID=?,INICIO=?,FIM=?,CUSTO=?,DISTANCIA=?,ESTADO=?,FORMA_PAGAMENTO=?,PARTIDA=?,CHEGADA=? where VIAGEM_ID=?;";
        try{
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
        }catch (SQLException ex) {
            Logger.getLogger(Viagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Viagem() {
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

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getTaxistaID() {
        return taxistaID;
    }

    public void setTaxistaID(int taxistaID) {
        this.taxistaID = taxistaID;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public int getTaxiID() {
        return taxiID;
    }

    public void setTaxiID(int taxiID) {
        this.taxiID = taxiID;
    }

    public int getViagemID() {
        return viagemID;
    }

    public void setViagemID(int viagemID) {
        this.viagemID = viagemID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public String getLocalpartida() {
        return localpartida;
    }

    public void setLocalpartida(String localpartida) {
        this.localpartida = localpartida;
    }

    public String getLocalchegado() {
        return localchegado;
    }

    public void setLocalchegado(String localchegado) {
        this.localchegado = localchegado;
    }
    
    
}

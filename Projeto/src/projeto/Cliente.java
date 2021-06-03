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

public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    
    private int cliente_id;
    private String username;
    private String email;
    private int NIF;
    private Date data_nascimento;

    public Cliente() {
    }

    public Cliente(int cliente_id, String username, String email, int NIF, Date data_nascimento) {
        this.cliente_id = cliente_id;
        this.username = username;
        this.email = email;
        this.NIF = NIF;
        this.data_nascimento = data_nascimento;
    }
    
    

    
    public void create(Connection con,int cliente_id, String username, String password, String email, int NIF, Date data_nascimento) {
        String sql="insert into cliente (USERNAME,PASSWORD,EMAIL,NIF,DATA_NASCIMENTO) values(?,?,?,?,?);";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            stmt.setString(3,email);
            stmt.setInt(4, NIF);
            stmt.setDate(5,new java.sql.Date(data_nascimento.getTime()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Connection con,int cliente_id){
        String sql="delete from CLIENTE where CLIENTEID=?;";
        try{
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1,cliente_id);
            stmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void update(Connection con,int cliente_id, String username, String password, String email, int NIF, Date data_nascimento){
        String sql="update cliente set USERNAME=? , PASSWORD=? , EMAIL=?, NIF=?, DATA_NASCIMENTO=? where CLIENTEID=? );";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            stmt.setString(3,email);
            stmt.setInt(4, NIF);
            stmt.setDate(5,new java.sql.Date(data_nascimento.getTime()));
            stmt.setInt(6, cliente_id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getNIF() {
        return NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    
    
}

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
    private String password;
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

    public int getCliente_id() {
        return cliente_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getNIF() {
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

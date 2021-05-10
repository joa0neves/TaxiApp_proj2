/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Taxista implements Serializable{
    private Date datanascimento;
    private int telefone;
    private int numeroemergencia;
    private int NIF;
    private char sexo;
    private String morada;
    private String certificado;
    private String username;
    private String email;

    public Taxista() {
    }

    public Taxista(Connection con,Date datanascimento, int telefone, int numeroemergencia, int NIF, char sexo, String morada, String certificado, String password, String username, String email) {
        /*this.datanascimento = datanascimento;
        this.telefone = telefone;
        this.numeroemergencia = numeroemergencia;
        this.NIF = NIF;
        this.sexo = sexo;
        this.morada = morada;
        this.certificado = certificado;
        this.password = password;
        this.username = username;
        this.email = email;*/
        String sql="insert into taxista (USERNAME,PASSWORD,EMAIL,DATA_NASCIMENTO,NUMERO_EMERGENCIA,TELEFONE,NIF,SEXO,MORADA,CERTIFICADO) values (?,?,?,?,?,?,?,?,?,?);";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setDate(4, new java.sql.Date(datanascimento.getTime()));
            stmt.setInt(5, numeroemergencia);
            stmt.setInt(6,telefone);
            stmt.setInt(7,NIF);
            
            stmt.setString(9,morada);
            stmt.setString(10,certificado);
            stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getNumeroemergencia() {
        return numeroemergencia;
    }

    public void setNumeroemergencia(int numeroemergencia) {
        this.numeroemergencia = numeroemergencia;
    }

    public int getNIF() {
        return NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
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
    
    
}

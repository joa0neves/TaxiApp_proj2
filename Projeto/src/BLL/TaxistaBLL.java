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
import projeto.Taxista;

/**
 *
 * @author Joao
 */
public class TaxistaBLL {
    public void create(Connection con,Date datanascimento, int telefone, int numeroemergencia, int NIF, String sexo, String morada, String certificado, String password, String username, String email) {
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
            stmt.setString(8, sexo);
            stmt.setString(9,morada);
            stmt.setString(10,certificado);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Connection con,int taxistaID){
        String sql="delete from TAXISTA where TAXISTA_ID=?";
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, taxistaID);
            stmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Connection con,int taxistaID,Date datanascimento, int telefone, int numeroemergencia, int NIF, String sexo, String morada, String certificado, String password, String username, String email) {
        String sql="update taxista set USERNAME=?,PASSWORD=?,EMAIL=?,DATA_NASCIMENTO=?,NUMERO_EMERGENCIA=?,TELEFONE=?,NIF=?,SEXO=?,MORADA=?,CERTIFICADO=? where TAXISTA_ID=?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setDate(4, new java.sql.Date(datanascimento.getTime()));
            stmt.setInt(5, numeroemergencia);
            stmt.setInt(6,telefone);
            stmt.setInt(7,NIF);
            stmt.setString(8, sexo);
            stmt.setString(9,morada);
            stmt.setString(10,certificado);
            stmt.setInt(11, taxistaID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

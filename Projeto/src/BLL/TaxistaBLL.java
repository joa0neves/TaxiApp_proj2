/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    
    public List<Taxista> readAll(Connection con){
        List<Taxista> lista = new ArrayList<>();
        String sql = "select * from TAXISTA";
        Taxista temp;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                temp=new Taxista();
                temp.setTaxistaID(rs.getInt("TAXISTA_ID"));
                temp.setUsername(rs.getString("USERNAME"));
                temp.setEmail(rs.getString("EMAIL"));
                temp.setNIF(rs.getInt("NIF"));
                temp.setDatanascimento(new Date(rs.getTime("DATA_NASCIMENTO").getTime()));
                temp.setNumeroemergencia(rs.getInt("NUMERO_EMERGENCIA"));
                temp.setSexo(rs.getString("SEXO"));
                temp.setMorada(rs.getString("MORADA"));
                temp.setCertificado(rs.getString("CERTIFICADO"));
                temp.setTelefone(rs.getInt("TELEFONE"));
                lista.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
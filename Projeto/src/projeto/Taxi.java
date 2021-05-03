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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Taxi implements Serializable{
    private String modelo;
    private String marca;
    private String alvara;
    private String matricula;

    public Taxi() {
    }

    public Taxi(Connection con,String modelo, String marca, String alvara, String matricula) {
        String sql="insert into taxi (MODELO,MARCA,ALVARÁ,MATRICULA) values (?,?,?,?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,modelo);
            stmt.setString(2,marca);
            stmt.setString(3,alvara);
            stmt.setString(4, matricula);
            stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAlvara() {
        return alvara;
    }

    public void setAlvara(String alvara) {
        this.alvara = alvara;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
}

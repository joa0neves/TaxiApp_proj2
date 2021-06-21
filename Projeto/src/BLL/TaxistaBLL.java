/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.Connection;
import java.sql.DriverManager;
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
public  class TaxistaBLL {
    public static void create(Taxista taxista) {
        String sql="insert into taxista (USERNAME,PASSWORD,EMAIL,DATA_NASCIMENTO,NUMERO_EMERGENCIA,TELEFONE,NIF,SEXO,MORADA,CERTIFICADO) values (?,?,?,?,?,?,?,?,?,?)";
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,taxista.getUsername());
            stmt.setString(2, taxista.getPassword());
            stmt.setString(3, taxista.getEmail());
            stmt.setDate(4, new java.sql.Date(taxista.getDatanascimento().getTime()));
            stmt.setInt(5, taxista.getNumeroemergencia());
            stmt.setInt(6,taxista.getTelefone());
            stmt.setInt(7,taxista.getNIF());
            stmt.setString(8, taxista.getSexo());
            stmt.setString(9,taxista.getMorada());
            stmt.setString(10,taxista.getCertificado());
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery(); 
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void delete(int taxistaID){
        String sql="delete from TAXISTA where TAXISTA_ID=?";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, taxistaID);
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
            con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void update(int taxistaID,Date datanascimento, int telefone, int numeroemergencia, int NIF, String sexo, String morada, String certificado, String password, String username, String email) {
        String sql="update taxista set USERNAME=?,PASSWORD=?,EMAIL=?,DATA_NASCIMENTO=?,NUMERO_EMERGENCIA=?,TELEFONE=?,NIF=?,SEXO=?,MORADA=?,CERTIFICADO=? where TAXISTA_ID=?";
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");
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
            
            stmt = con.prepareStatement("COMMIT;");
            stmt.executeQuery();
             con.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public static List<Taxista> readAll(){
        List<Taxista> lista = new ArrayList<>();
        String sql = "select * from TAXISTA";
        Taxista temp;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");  
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
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return lista;
    }
    
    
    public static Taxista read(String username){
        String sql = "select * from TAXISTA where USERNAME=?";
        Taxista temp;
        temp=new Taxista();
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","projeto_taxi","12346579");  

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                temp.setTaxistaID(rs.getInt("TAXISTA_ID"));
                temp.setUsername(rs.getString("USERNAME"));
                temp.setPassword(rs.getString("PASSWORD"));
                temp.setEmail(rs.getString("EMAIL"));
                temp.setNIF(rs.getInt("NIF"));
                temp.setDatanascimento(new Date(rs.getTime("DATA_NASCIMENTO").getTime()));
                temp.setNumeroemergencia(rs.getInt("NUMERO_EMERGENCIA"));
                temp.setSexo(rs.getString("SEXO"));
                temp.setMorada(rs.getString("MORADA"));
                temp.setCertificado(rs.getString("CERTIFICADO"));
                temp.setTelefone(rs.getInt("TELEFONE"));
                
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return temp;
    }
}

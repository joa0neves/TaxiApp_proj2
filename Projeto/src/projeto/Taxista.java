/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.io.Serializable;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
    private String password;
    private String username;
    private String email;
}

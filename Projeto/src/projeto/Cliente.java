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
public class Cliente implements Serializable{
    
    private int cliente_id;
    private String username;
    private String password;
    private String email;
    private float NIF;
    private Date data_nascimento;

    
    
}

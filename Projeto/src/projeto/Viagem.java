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
}

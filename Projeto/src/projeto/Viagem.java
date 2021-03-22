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

    public Viagem() {
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getTaxistaID() {
        return taxistaID;
    }

    public void setTaxistaID(int taxistaID) {
        this.taxistaID = taxistaID;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public int getTaxiID() {
        return taxiID;
    }

    public void setTaxiID(int taxiID) {
        this.taxiID = taxiID;
    }

    public int getViagemID() {
        return viagemID;
    }

    public void setViagemID(int viagemID) {
        this.viagemID = viagemID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public String getLocalpartida() {
        return localpartida;
    }

    public void setLocalpartida(String localpartida) {
        this.localpartida = localpartida;
    }

    public String getLocalchegado() {
        return localchegado;
    }

    public void setLocalchegado(String localchegado) {
        this.localchegado = localchegado;
    }
    
    
}

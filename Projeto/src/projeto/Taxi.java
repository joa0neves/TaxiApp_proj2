/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

/**
 *
 * @author Joao
 */
public class Taxi {
    private int taxi_ID;
    private String alvara;
    private String modelo;
    private String marca;
    private String matricula;

    public Taxi() {
    }

    public int getTaxi_ID() {
        return taxi_ID;
    }

    public void setTaxi_ID(int taxi_ID) {
        this.taxi_ID = taxi_ID;
    }

    public String getAlvara() {
        return alvara;
    }

    public void setAlvara(String alvara) {
        this.alvara = alvara;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
}

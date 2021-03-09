/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.io.Serializable;
import java.util.List;
import javax.*;

/**
 *
 * @author Joao
 */
public class Cliente implements Serializable{
    
    @Column(name = "CLIENTE_ID")
    private Integer cliente_id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NIF")
    private float NIF;
    @Column(name = "DATA_NASCIMENTO")
    private DateTime data_nascimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    
}

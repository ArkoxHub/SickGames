/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.domain;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Adri
 */

@Entity
@Table(name = "comanda")
public class Comanda implements Serializable {
   
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "codi_Comanda", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codi_Comanda;
    
    @Column(name = "data_Comanda", nullable = false)
    private java.sql.Date data_Comanda;
    
    @Column(name = "total", nullable = false, precision = 2)
    private double total;
    
    @Column(name = "usuari_Client")
    private Client client;

    public Comanda() {
    }

    public Comanda(int codi_Comanda, Date data_Comanda, double total, Client client) {
        this.codi_Comanda = codi_Comanda;
        this.data_Comanda = data_Comanda;
        this.total = total;
        this.client = client;
    }

    public int getCodi_Comanda() {
        return codi_Comanda;
    }

    public void setCodi_Comanda(int codi_Comanda) {
        this.codi_Comanda = codi_Comanda;
    }

    public Date getData_Comanda() {
        return data_Comanda;
    }

    public void setData_Comanda(Date data_Comanda) {
        this.data_Comanda = data_Comanda;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}

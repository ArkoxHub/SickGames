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
 * @version 1.0
 * Classe Entitat que defineix els atributs de la taula Comanda que pertany a la
 * Base de Dades sickgames.sql.
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
    
    @Column(name = "id_Usuari")
    private int id_Usuari;

    public Comanda() {
    }

    public Comanda(int codi_Comanda, Date data_Comanda, double total, int id_Usuari) {
        this.codi_Comanda = codi_Comanda;
        this.data_Comanda = data_Comanda;
        this.total = total;
        this.id_Usuari = id_Usuari;
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

    public int getUsuari_Client() {
        return id_Usuari;
    }

    public void setUsuari_Client(int id_Usuari) {
        this.id_Usuari = id_Usuari;
    }
 
}

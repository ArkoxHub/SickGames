/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Adri
 * @version 1.0
 * Classe Entitat que defineix els atributs de la taula Detall que pertany a la
 * Base de Dades sickgames.sql.
 */

@Entity
@Table(name = "detall")
public class Detall implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "codi_Detall", nullable = false)
    private int codi_Detall;
    
    @Column(name = "preu", nullable = false)
    private double preu;
    
    @Column(name = "joc", nullable = false)
    private int codi_Joc;
    
    @Column(name = "comanda", nullable = false)
    private int codi_Comanda;
    
    @Column(name = "serial", nullable = false)
    private String serial;
    
    @Column (name = "plataforma", nullable = false)
    private int plataforma;
    
    @Column (name = "id_Usuari", nullable = false)
    private int id_Usuari;

    public Detall() {
    }

    public Detall(int codi_Detall, double preu, int codi_Joc, int codi_Comanda, String serial, int plataforma, int id_Usuari) {
        this.codi_Detall = codi_Detall;
        this.preu = preu;
        this.codi_Joc = codi_Joc;
        this.codi_Comanda = codi_Comanda;
        this.serial = serial;
        this.plataforma = plataforma;
        this.id_Usuari = id_Usuari;
    }

    public int getCodi_Detall() {
        return codi_Detall;
    }

    public void setCodi_Detall(int codi_Detall) {
        this.codi_Detall = codi_Detall;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public int getCodi_Joc() {
        return codi_Joc;
    }

    public void setCodi_Joc(int codi_Joc) {
        this.codi_Joc = codi_Joc;
    }

    public int getCodi_Comanda() {
        return codi_Comanda;
    }

    public void setCodi_Comanda(int codi_Comanda) {
        this.codi_Comanda = codi_Comanda;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(int plataforma) {
        this.plataforma = plataforma;
    }

    public int getId_Usuari() {
        return id_Usuari;
    }

    public void setId_Usuari(int id_Usuari) {
        this.id_Usuari = id_Usuari;
    }

}

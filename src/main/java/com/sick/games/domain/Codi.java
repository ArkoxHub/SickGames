/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Adri
 */
@Entity
@Table(name = "codi")
public class Codi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "codi")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codi;

    @NotNull
    @Size(max = 19)
    @Column(name = "serial", unique = true)
    private String serial;

    @NotNull
    @Column(name = "oferta")
    private int oferta;

    @NotNull
    @Column(name = "preu")
    private float preu;

    @NotNull
    @Column(name = "plataforma")
    private int plataforma;
 
    @NotNull
    @Column(name = "codi_Joc")
    private int codi_Joc;

    @ManyToOne
    private Videojoc joc;

    // Empty Constructor
    public Codi() {
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getOferta() {
        return oferta;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }
    
        public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public int getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(int plataforma) {
        this.plataforma = plataforma;
    }

    public int getCodi_Joc() {
        return codi_Joc;
    }

    public void setCodi_Joc(int codi_Joc) {
        this.codi_Joc = codi_Joc;
    }

    public Videojoc getJoc() {
        return joc;
    }

    public void setJoc(Videojoc joc) {
        this.joc = joc;
    }

}

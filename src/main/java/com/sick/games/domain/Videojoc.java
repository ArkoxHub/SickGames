/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Adri
 */
@Entity
@Table(name = "videojoc")
public class Videojoc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "codi_Joc")
    private int codi_Joc;

    @NotNull
    @Size(max = 50)
    @Column(name = "nom")
    private String nom;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "data_Llançament")
    private Date data_Llançament;

    @NotNull
    @Column(name = "preu")
    private float preu;

    @Column(name = "idioma")
    @Size(max = 50)
    private String idioma;

    @Column(name = "oferta")
    private int oferta;
    
    @Column(name = "descripcio", columnDefinition = "TEXT")
    private String descripcio;

    @NotNull
    @Column(name = "qty_Available")
    private int qty_Available;

    @NotNull
    @Column(name = "plataforma")
    private int plataforma;

    public Videojoc() {
    };

    public Videojoc(int codi_Joc, String nom, Date data_Llançament, float preu, String idioma, int oferta, String descripcio, int qty_Available, int plataforma) {
        this.codi_Joc = codi_Joc;
        this.nom = nom;
        this.data_Llançament = data_Llançament;
        this.preu = preu;
        this.idioma = idioma;
        this.oferta = oferta;
        this.descripcio = descripcio;
        this.qty_Available = qty_Available;
        this.plataforma = plataforma;
    }

    public int getCodi_Joc() {
        return codi_Joc;
    }

    public void setCodi_Joc(int codi_Joc) {
        this.codi_Joc = codi_Joc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getData_Llançament() {
        return data_Llançament;
    }

    public void setData_Llançament(Date data_Llançament) {
        this.data_Llançament = data_Llançament;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getOferta() {
        return oferta;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getQty_Available() {
        return qty_Available;
    }

    public void setQty_Available(int qty_Available) {
        this.qty_Available = qty_Available;
    }

    public int getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(int plataforma) {
        this.plataforma = plataforma;
    }

}

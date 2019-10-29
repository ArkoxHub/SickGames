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
import javax.persistence.Id;
import javax.persistence.Table;
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
    @NotNull
    @Column(name = "codi_Joc")
    private int codi_Joc;

    @NotNull
    @Size(max = 50)
    @Column(name = "nom", unique = true)
    private String nom;

    @Column(name = "data_Llançament")
    private java.sql.Date data_Llançament;

    @NotNull
    @Column(name = "pvp")
    private float pvp;

    @NotNull
    @Column(name = "idioma")
    @Size(max = 50)
    private String idioma;

    @NotNull
    @Column(name = "generes")
    @Size(max = 100)
    private String generes;
    
    @Column(name = "descripcio", columnDefinition = "TEXT")
    private String descripcio;

    // Empty Constructor
    public Videojoc() {
    };

    public Videojoc(int codi_Joc, String nom, java.sql.Date data_Llançament, float pvp, String idioma, String generes, String descripcio) {
        this.codi_Joc = codi_Joc;
        this.nom = nom;
        this.data_Llançament = data_Llançament;
        this.pvp = pvp;
        this.idioma = idioma;
        this.generes = generes;
        this.descripcio = descripcio;
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

    public java.sql.Date getData_Llançament() {
        return data_Llançament;
    }

    public void setData_Llançament(java.sql.Date data_Llançament) {
        this.data_Llançament = data_Llançament;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getGeneres() {
        return generes;
    }

    public void setGeneres(String generes) {
        this.generes = generes;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    
    
}

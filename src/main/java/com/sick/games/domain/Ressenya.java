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
 * Classe Entitat que defineix els atributs de la taula Ressenya que pertany a la
 * Base de Dades sickgames.sql.
 */
@Entity
@Table(name = "ressenya")
public class Ressenya implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Puntuacio", nullable = false)
    private int id_Ressenya;

    @Column(name = "estrelles", nullable = false)
    private int estrelles;
    
    @Column(name = "data_Publicacio", nullable = false)
    private java.sql.Date data_Publicacio;

    @Column(name = "comentari", nullable = false)
    private String comentari;

    @Column(name = "autor", nullable = false)
    private int codi_Usuari;
    
    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "codi_Joc", nullable = false)
    private int codi_Videojoc;

    public Ressenya() {
    }

    public Ressenya(int id_Ressenya, int estrelles, Date data_Publicacio, String comentari, int codi_Usuari, String nickname, int codi_Videojoc) {
        this.id_Ressenya = id_Ressenya;
        this.estrelles = estrelles;
        this.data_Publicacio = data_Publicacio;
        this.comentari = comentari;
        this.codi_Usuari = codi_Usuari;
        this.nickname = nickname;
        this.codi_Videojoc = codi_Videojoc;
    }

    public int getId_Ressenya() {
        return id_Ressenya;
    }

    public void setId_Ressenya(int id_Ressenya) {
        this.id_Ressenya = id_Ressenya;
    }

    public int getEstrelles() {
        return estrelles;
    }

    public void setEstrelles(int estrelles) {
        this.estrelles = estrelles;
    }
    
    public Date getData_Publicacio() {
        return data_Publicacio;
    }

    public void setData_Publicacio(Date data_Publicacio) {
        this.data_Publicacio = data_Publicacio;
    }

    public String getComentari() {
        return comentari;
    }

    public void setComentari(String comentari) {
        this.comentari = comentari;
    }

    public int getCodi_Usuari() {
        return codi_Usuari;
    }

    public void setCodi_Usuari(int codi_Usuari) {
        this.codi_Usuari = codi_Usuari;
    }

    public int getCodi_Vdeojoc() {
        return codi_Videojoc;
    }

    public void setCodi_Videojoc(int codi_Videojoc) {
        this.codi_Videojoc = codi_Videojoc;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}

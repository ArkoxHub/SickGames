/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.domain;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Adri
 * @version 1.0
 * Classe Entitat que defineix els atributs de la taula Partner que pertany a la
 * Base de Dades sickgames.sql.
 * 
 * Aquesta classe entitat hereta de la classe User i afegeix els atributs propis.
 */
@Entity
@Table(name = "partner")
public class Partner extends User {
    
    @NotNull
    @Column(name = "id_Partner")
    private int id_Partner;
    
    @NotNull
    @Size(max = 20)
    @Column(name = "userName")
    private String userName;

    public Partner() {
    }

    public Partner(int id_Partner, String userName, float sou, int id_Usuari, String nom, String cognoms, String nickname, Date data_Alta, String direccio, String email, String contrasenya, int telefon) {
        super(id_Usuari, nom, cognoms, nickname, data_Alta, direccio, email, contrasenya, telefon);
        this.id_Partner = id_Partner;
        this.userName = userName;
        this.sou = sou;
    }
   
    @Column(name = "sou")
    private float sou;

    public int getId_Partner() {
        return id_Partner;
    }

    public void setId_Partner(int id_Partner) {
        this.id_Partner = id_Partner;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getSou() {
        return sou;
    }

    public void setSou(float sou) {
        this.sou = sou;
    }
    
    
   
}

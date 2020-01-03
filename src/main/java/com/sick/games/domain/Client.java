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

/**
 *
 * @author Adri
 * @version 1.0
 * Classe Entitat que defineix els atributs de la taula Client que pertany a la 
 * Base de Dades sickgames.sql.
 * 
 * Aquesta classe entitat hereta de la classe User i afegeix els atributs propis.
 */
@Entity
@Table(name = "client")
public class Client extends User {
    
    @NotNull
    @Column(name = "id_Client")
    private int id_Client;
    
    @Column(name = "punts")
    private int punts;
    
    @NotNull
    @Column(name = "compte_Bancari", unique = true)
    private String compte_Bancari;

    // Empty constructor
    public Client() {
    }

    public Client(int id_Client, int punts, String compte_Bancari, int id_Usuari, String nom, String cognoms, String nickname, Date data_Alta, String direccio, String email, String contrasenya, int telefon) {
        super(id_Usuari, nom, cognoms, nickname, data_Alta, direccio, email, contrasenya, telefon);
        this.id_Client = id_Client;
        this.punts = punts;
        this.compte_Bancari = compte_Bancari;
    }

    public int getId_Client() {
        return id_Client;
    }

    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
    }

    public int getPunts() {
        return punts;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }

    public String getCompte_Bancari() {
        return compte_Bancari;
    }

    public void setCompte_Bancari(String compte_Bancari) {
        this.compte_Bancari = compte_Bancari;
    }

}

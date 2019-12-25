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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Adri
 * @version 1.0
 * Classe Entitat que defineix els atributs de la taula Wishlist que pertany a la
 * Base de Dades sickgames.sql.
 */
@Entity
@Table(name = "wishlist")
public class Wishlist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "codi_Llista")
    private int codi_Llista;

    @NotNull
    @Column(name = "id_Usuari")
    private int id_Usuari;

    @NotNull
    @Column(name = "codi_Joc", unique = true)
    private int codi_Joc;


    // Empty constructor
    public Wishlist() {
    }

    public int getCodi_Llista() {
        return codi_Llista;
    }

    public void setCodi_Llista(int codi_Llista) {
        this.codi_Llista = codi_Llista;
    }

    public int getId_Usuari() {
        return id_Usuari;
    }

    public void setId_Usuari(int id_Usuari) {
        this.id_Usuari = id_Usuari;
    }

    public int getCodi_Joc() {
        return codi_Joc;
    }

    public void setCodi_Joc(int codi_Joc) {
        this.codi_Joc = codi_Joc;
    }


}

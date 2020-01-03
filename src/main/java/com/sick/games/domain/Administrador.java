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
 * Classe Entitat que defineix els atributs de la taula Administrador que pertany a la 
 * Base de Dades sickgames.sql.
 * 
 * Aquesta classe entitat hereta de la classe User i afegeix els atributs propis.
 */
@Entity
@Table(name = "administrador")
public class Administrador extends User {
    
    @NotNull
    @Column(name = "id_Administrador")
    private int id_Administrador;
    
    @NotNull
    @Column(name = "sou")
    private float sou;
    
    @NotNull
    @Size(max = 15)
    @Column(name = "rol")
    private String rol;

    // Empty constructor
    public Administrador() {
    }
   
    public Administrador(int id_Administrador, float sou, String rol, int id_Usuari, String nom, String cognoms, String nickname, Date data_Alta, String direccio, String email, String contrasenya, int telefon) {
        super(id_Usuari, nom, cognoms, nickname, data_Alta, direccio, email, contrasenya, telefon);
        this.id_Administrador = id_Administrador;
        this.sou = sou;
        this.rol = rol;
    }
    
    public int getId_Administrador() {
        return id_Administrador;
    }

    public void setId_Administrador(int id_Administrador) {
        this.id_Administrador = id_Administrador;
    }

    public float getSou() {
        return sou;
    }

    public void setSou(float sou) {
        this.sou = sou;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
   
}

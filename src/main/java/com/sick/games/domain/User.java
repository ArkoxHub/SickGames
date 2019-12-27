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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Adri
 * @version 1.0
 * Classe Entitat que defineix els atributs de la taula Usuari que pertany a la
 * Base de Dades sickgames.sql.
 * 
 * Aquesta classe entitat és la super classe de les derivades, que concretament són:
 * -Administrador
 * -Client
 * -Partner
 */
@Entity
@Table(name = "usuari")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id_Usuari")
    private int id_Usuari;

    @NotNull
    @Size(max = 20)
    @Column(name = "nom")
    private String nom;

    @NotNull
    @Size(max = 50)
    @Column(name = "cognoms")
    private String cognoms;

    @Size(max = 20)
    @Column(name = "nickname", unique = true)
    private String nickname;

    @NotNull
    @Column(name = "data_Alta")
    private java.sql.Date data_Alta;

    @Size(max = 50)
    @Column(name = "direccio")
    private String direccio;

    @NotNull
    @Size(max = 100)
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Column(name = "contrasenya")
    private String contrasenya;

    @Column(name = "telefon")
    private int telefon;
    
    public User() {
    }
    
    public User(int id_Usuari, String nom, String cognoms, String nickname, Date data_Alta, String direccio, String email, String contrasenya, int telefon) {
        this.id_Usuari = id_Usuari;
        this.nom = nom;
        this.cognoms = cognoms;
        this.nickname = nickname;
        this.data_Alta = data_Alta;
        this.direccio = direccio;
        this.email = email;
        this.contrasenya = contrasenya;
        this.telefon = telefon;
    }

    public int getId_Usuari() {
        return id_Usuari;
    }

    public void setId_Usuari(int id_Usuari) {
        this.id_Usuari = id_Usuari;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getData_Alta() {
        return data_Alta;
    }

    public void setData_Alta(Date data_Alta) {
        this.data_Alta = data_Alta;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

}

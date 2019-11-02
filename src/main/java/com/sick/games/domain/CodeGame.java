/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.domain;

/**
 *
 * @author Adri
 */
public class CodeGame {
    
    private int codi_Joc;
    
    private String nom;
    
    private String generes;
    
    private int oferta;
    
    private long stock;
    
    public CodeGame() {
    }

    public CodeGame(int codi_Joc, String nom, int oferta, String generes, long stock) {
        this.codi_Joc = codi_Joc;
        this.nom = nom;
        this.oferta = oferta;
        this.generes = generes;
        this.stock = stock;
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

    public int getOferta() {
        return oferta;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }

    public String getGeneres() {
        return generes;
    }

    public void setGeneres(String generes) {
        this.generes = generes;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

}

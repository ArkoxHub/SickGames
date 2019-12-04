/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Adri
 */

@Entity
@Table(name = "detall")
public class Detall implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "codi_Detall", nullable = false)
    private int codi_Detall;
    
    @Column(name = "preu", nullable = false)
    private double preu;
    
    @Column(name = "quantitat", nullable = false)
    private int quantitat;
    
    @Column(name = "import_Total", nullable = false)
    private double total;
    
    @Column(name = "joc", nullable = false)
    private int codi_Joc;
    
    @Column(name = "comanda", nullable = false)
    private int codi_Comanda;

    public Detall() {
    }

    public Detall(int codi_Detall, double preu, int quantitat, double total, int codi_Joc, int codi_Comanda) {
        this.codi_Detall = codi_Detall;
        this.preu = preu;
        this.quantitat = quantitat;
        this.total = total;
        this.codi_Joc = codi_Joc;
        this.codi_Comanda = codi_Comanda;
    }

    public int getCodi_Detall() {
        return codi_Detall;
    }

    public void setCodi_Detall(int codi_Detall) {
        this.codi_Detall = codi_Detall;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCodi_Joc() {
        return codi_Joc;
    }

    public void setCodi_Joc(int codi_Joc) {
        this.codi_Joc = codi_Joc;
    }

    public int getCodi_Comanda() {
        return codi_Comanda;
    }

    public void setCodi_Comanda(int codi_Comanda) {
        this.codi_Comanda = codi_Comanda;
    }

}

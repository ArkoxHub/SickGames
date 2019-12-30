/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository;

import com.sick.games.domain.Ressenya;
import java.util.List;

/**
 *
 * @author Adri
 * @version 1.0 Interfície que subministra els mètodes Data Access Object per
 * accedir a les dades de la Classe Entitat Ressenya
 */
public interface RessenyaDAO {
    
    public void addRessenya(Ressenya ressenya);
    
    public void updateRessenya(Ressenya ressenya);
    
    public void removeRessenya(Ressenya ressenya);
    
    public Ressenya getRessenyaById(int id_Ressenya);
    
    public List<Ressenya> getRessenyesByJoc(int codi_Joc);
    
    public List<Ressenya> getRessenyesByPuntuacio(int estrelles);
    
    public List<Ressenya> getRessenyesByUser(int id_User);
}

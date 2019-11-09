/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository;

import com.sick.games.domain.Codi;
import java.util.List;

/**
 *
 * @author Adri
 */

public interface CodiDAO {
    
    public void addCodi(Codi codi);
    
    public void updateCodi(Codi codi);
    
    public void removeCodi(Codi codi);
    
    public List<Codi> getNextCodeByCodiJoc(int codi_Joc);
    
    public List<Codi> getPlataformesByCodiJoc(int plataforma);
    
    public long getTotalCodisByJoc(int codi_Joc);
    
}

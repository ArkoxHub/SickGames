/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.service.impl;

import com.sick.games.domain.Codi;
import com.sick.games.repository.CodiDAO;
import com.sick.games.service.CodiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adri
 */
@Service
public class CodiServiceImpl implements CodiService {
    
    @Autowired
    CodiDAO codiDAO;

    @Override
    public void addCodi(Codi codi) {
        codiDAO.addCodi(codi);
    }

    @Override
    public void updateCodi(Codi codi) {
        codiDAO.updateCodi(codi);
    }

    @Override
    public void removeCodi(Codi codi) {
        codiDAO.removeCodi(codi);
    }

    // Retornem el següent codi més barat retornat per la query
    @Override
    public Codi getNextCodeByCodiJoc(int codi_Joc) {
        List<Codi> codis = codiDAO.getNextCodeByCodiJoc(codi_Joc);
        return codis.get(0);
    }

    @Override
    public List<Codi> getPlataformesByCodiJoc(int codi_Joc) {
        return codiDAO.getPlataformesByCodiJoc(codi_Joc);
    }

    @Override
    public long getTotalCodisByJoc(int codi_Joc) {
        return codiDAO.getTotalCodisByJoc(codi_Joc);
    }
    
}

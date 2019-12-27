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
 * @version 1.0 Classe Service que implementa i sobreescriu els mètodes de
 * l'interfície CodiService
 *
 * Simplement es fan crides als mètodes del repositori a través del objecte DAO
 * instanciat gràcies a l'annotació Autowired.
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

    @Override
    public Codi getCodi(int codi) {
        return codiDAO.getCodi(codi);
    }

    @Override
    public List<Codi> getCodisByCodiJoc(int codi) {
        return codiDAO.getCodisByCodiJoc(codi);
    }

    /**
     * Retorna el següent codi disponible en stock Si no hi ha codi, es retorna
     * un codi buit.
     *
     * @param codi_Joc
     * @return el següent codi disponible a la venta més barat.
     */
    @Override
    public Codi getNextCodeByCodiJoc(int codi_Joc) {
        Codi codi = new Codi();
        try {
            List<Codi> codis = codiDAO.getNextCodeByCodiJoc(codi_Joc);
            codi = codis.get(0);
        } catch (Exception ex) {
            System.out.println("Stock 0");

        }
        return codi;
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

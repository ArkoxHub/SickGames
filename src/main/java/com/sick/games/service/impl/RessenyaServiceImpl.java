/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.service.impl;

import com.sick.games.domain.Ressenya;
import com.sick.games.repository.RessenyaDAO;
import com.sick.games.service.RessenyaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adri
 * @version 1.0 Classe Service que implementa i sobreescriu els mètodes de
 * l'interfície DetallService
 * 
 * Simplement es fan crides als mètodes del repositori a través del objecte DAO
 * instanciat gràcies a l'annotació Autowired.
 */
@Service
public class RessenyaServiceImpl implements RessenyaService {
    
    @Autowired
    RessenyaDAO ressenyaDAO;

    @Override
    public void addRessenya(Ressenya ressenya) {
        ressenyaDAO.addRessenya(ressenya);
    }

    @Override
    public void updateRessenya(Ressenya ressenya) {
        ressenyaDAO.updateRessenya(ressenya);
    }

    @Override
    public void removeRessenya(Ressenya ressenya) {
        ressenyaDAO.removeRessenya(ressenya);
    }

    @Override
    public Ressenya getRessenyaById(int id_Ressenya) {
        return ressenyaDAO.getRessenyaById(id_Ressenya);
    }

    @Override
    public List<Ressenya> getRessenyesByJoc(int codi_Joc) {
        return ressenyaDAO.getRessenyesByJoc(codi_Joc);
    }

    @Override
    public List<Ressenya> getRessenyesByPuntuacio(int estrelles) {
        return ressenyaDAO.getRessenyesByPuntuacio(estrelles);
    }

    @Override
    public List<Ressenya> getRessenyesByUser(int id_User) {
        return ressenyaDAO.getRessenyesByUser(id_User);
    }
    
}

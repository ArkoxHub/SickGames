/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.service.impl;

import com.sick.games.domain.Detall;
import com.sick.games.repository.DetallDAO;
import com.sick.games.service.DetallService;
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
public class DetallServiceImpl implements DetallService {
    
    @Autowired
    DetallDAO detallDAO;

    @Override
    public void addDetall(Detall detall) {
        detallDAO.addDetall(detall);
    }

    @Override
    public void updateDetall(Detall detall) {
        detallDAO.updateDetall(detall);
    }

    @Override
    public void removeDetall(Detall detall) {
        detallDAO.removeDetall(detall);
    }

    @Override
    public Detall getDetallByCodiDetall(int codi) {
        return detallDAO.getDetallByCodiDetall(codi);
    }

    @Override
    public List<Detall> getDetallsByCodiComanda(int codi) {
        return detallDAO.getDetallsByCodiComanda(codi);
    }

    @Override
    public List<Detall> getDetallsByCodiJoc(int codi) {
        return detallDAO.getDetallsByCodiJoc(codi);
    }
    
    @Override
    public List<Detall> getDetallsByCodiClient(int codi) {
        return detallDAO.getDetallsByCodiClient(codi);
    }

    @Override
    public List<Detall> getAllDetalls() {
        return detallDAO.getAllDetalls();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.service.impl;

import com.sick.games.domain.Comanda;
import com.sick.games.repository.ComandaDAO;
import com.sick.games.service.ComandaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adri
 * @version 1.0 Classe Service que implementa i sobreescriu els mètodes de
 * l'interfície ComandaService
 * 
 * Simplement es fan crides als mètodes del repositori a través del objecte DAO
 * instanciat gràcies a l'annotació Autowired.
 * 
 */
@Service
public class ComandaServiceImpl implements ComandaService {
    
    @Autowired
    ComandaDAO comandaDAO;

    @Override
    public void addComanda(Comanda comanda) {
        comandaDAO.addComanda(comanda);
    }

    @Override
    public void updateComanda(Comanda comanda) {
        comandaDAO.updateComanda(comanda);
    }

    @Override
    public void removeComanda(Comanda comanda) {
        comandaDAO.removeComanda(comanda);
    }

    @Override
    public Comanda getComandaByCodiComanda(int codi) {
        return comandaDAO.getComandaByCodiComanda(codi);
    }

    @Override
    public List<Comanda> getComandesByClient(int codi) {
        return comandaDAO.getComandesByClient(codi);
    }

    @Override
    public List<Comanda> getAllComandes() {
        return comandaDAO.getAllComandes();
    }
    
}

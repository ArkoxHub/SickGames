/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.service.impl;

import com.sick.games.domain.CodeGame;
import com.sick.games.domain.Videojoc;
import com.sick.games.repository.CodiDAO;
import com.sick.games.repository.VideojocDAO;
import com.sick.games.service.VideojocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adri
 */
@Service
public class VideojocServiceImpl implements VideojocService {

    @Autowired
    private VideojocDAO videojocDAO;

    @Autowired
    private CodiDAO codiDAO;

    @Override
    public void addGame(Videojoc videojoc) {
        videojocDAO.addGame(videojoc);
    }

    @Override
    public void removeGame(Videojoc videojoc) {
        videojocDAO.removeGame(videojoc);
    }

    @Override
    public void updateGame(Videojoc videojoc) {
        videojocDAO.updateGame(videojoc);
    }

    @Override
    public int getMaxID() {
        return videojocDAO.getMaxID();
    }

    @Override
    public Videojoc getGameByCode(int codi) {
        return videojocDAO.getGameByCode(codi);
    }

    @Override
    public List<Videojoc> getGamesByName(String name) {
        return videojocDAO.getGamesByName(name);
    }

    @Override
    public List<Videojoc> getAllGames() {
        return videojocDAO.getAllGames();
    }

    @Override
    public List<Videojoc> getGamesByGenere(String genere) {
        return videojocDAO.getGamesByGenere(genere);
    }

    @Override
    public List<CodeGame> getGamesByOferta() {
        return videojocDAO.getGamesByOferta();
    }
    
    @Override
    public List<CodeGame> getGamesByPrice() {
        return videojocDAO.getGamesByPrice();
    }

    @Override
    public List<CodeGame> getGamesUpcoming() {
        return videojocDAO.getGamesUpcoming();
    }
    
    @Override
    public List<CodeGame> getGamesCataleg() {
        return videojocDAO.getGamesCataleg();
    }

}

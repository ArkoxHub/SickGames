/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.service.impl;

import com.sick.games.domain.Videojoc;
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

    @Override
    public void addVideojoc(Videojoc videojoc) {
        videojocDAO.addVideojoc(videojoc);
    }

    @Override
    public void removeVideojoc(Videojoc videojoc) {
        videojocDAO.removeVideojoc(videojoc);
    }

    @Override
    public void updateVideojoc(Videojoc videojoc) {
        videojocDAO.updateVideojoc(videojoc);
    }
    
    @Override
    public int getMaxID() {
        return videojocDAO.getMaxID();
    }

    @Override
    public Videojoc getVideojocByCode(int codi) {
        return videojocDAO.getVideojocByCode(codi);
    }

    @Override
    public List<Videojoc> getVideojocsByName(String name) {
        return videojocDAO.getVideojocsByName(name);
    }

    @Override
    public List<Videojoc> getAllVideojocs() {
        return videojocDAO.getAllVideojocs();
    }

    @Override
    public List<Videojoc> getGamesByOfert(int ofertaStart, int ofertaEnd) {
        return videojocDAO.getGamesByOfert(ofertaStart, ofertaEnd);
    }
    
}

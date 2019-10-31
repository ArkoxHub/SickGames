/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.service.impl;

import com.sick.games.domain.Videojoc;
import com.sick.games.domain.Codi;
import com.sick.games.repository.CodiDAO;
import com.sick.games.repository.VideojocDAO;
import com.sick.games.service.VideojocService;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
    public List<Videojoc> getVideojocsByGenere(String genere) {
        return videojocDAO.getVideojocsByGenere(genere);
    }

    @Override
    public List<Videojoc> getJocsByOferta() {
        return videojocDAO.getJocsByOferta();
    }

    @Override
    public List<Videojoc> testingJocs() {
        List<Videojoc> videojocs = videojocDAO.getAllVideojocs();

        for (Videojoc joc : videojocs) {
            List<Codi> codis = codiDAO.getCodisByCodisJoc(joc.getCodi_Joc());
            Set<Codi> c = new HashSet<Codi>(codis);
            joc.setCodis(c);
        }

        return videojocs;
    }
}

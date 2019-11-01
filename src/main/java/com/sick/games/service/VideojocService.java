/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.service;

import com.sick.games.domain.CodeGame;
import com.sick.games.domain.Videojoc;
import java.util.List;

/**
 *
 * @author Adri
 */
public interface VideojocService {

    public void addVideojoc(Videojoc videojoc);
    
    public void removeVideojoc(Videojoc videojoc);
    
    public void updateVideojoc(Videojoc videojoc);
    
    public int getMaxID();
    
    public List<Videojoc> getAllVideojocs();
    
    public Videojoc getVideojocByCode(int codi);
    
    public List<Videojoc> getVideojocsByName(String name);
    
    public List<Videojoc> getVideojocsByGenere(String genere);
    
    public List<CodeGame> getJocsByOferta();

}

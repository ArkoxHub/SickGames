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
 * @version 1.0 Interfície que defineix quins seràn els mètodes que es
 * criden del repositori VideojocDAO
 */
public interface VideojocService {

    public void addGame(Videojoc videojoc);
    
    public void removeGame(Videojoc videojoc);
    
    public void updateGame(Videojoc videojoc);
    
    public int getMaxID();
    
    public List<Videojoc> getAllGames();
    
    public Videojoc getGameByCode(int codi);
    
    public List<Videojoc> getGamesByName(String name);
    
    public List<Videojoc> getGamesByGenere(String genere);
    
    public List<CodeGame> getGamesByOferta();
    
    public List<CodeGame> getGamesByPrice();
    
    public List<CodeGame> getGamesUpcoming();
    
    public List<CodeGame> getGamesCataleg();

}

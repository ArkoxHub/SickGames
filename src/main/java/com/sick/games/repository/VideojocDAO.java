/**
 * Interfície repositori
 */
package com.sick.games.repository;

import com.sick.games.domain.CodeGame;
import com.sick.games.domain.Videojoc;
import java.util.List;

/**
 *
 * @author Adri
 */
public interface VideojocDAO {
    
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
    
}

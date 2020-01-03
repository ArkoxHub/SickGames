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
 * @version 1.0 Interfície que subministra els mètodes Data Access Object per
 * accedir a les dades de la Classe Entitat Videojoc
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

    public List<CodeGame> getGamesCataleg();

}

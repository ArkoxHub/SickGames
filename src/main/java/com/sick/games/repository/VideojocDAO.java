/**
 * Interfície repositori
 */
package com.sick.games.repository;

import com.sick.games.domain.Videojoc;
import java.util.List;

/**
 *
 * @author Adri
 */
public interface VideojocDAO {
    
    public void addVideojoc(Videojoc videojoc);
    
    public void removeVideojoc(Videojoc videojoc);
    
    public Videojoc updateVideojoc(Videojoc videojoc);
    
    public Videojoc getVideojocByCode(String codi);
    
    public List<Videojoc> getVideojocsByName(String name);
    
    public List<Videojoc> getAllVideojocs();
    
    public List<Videojoc> getGamesByOfert(int oferta);
    
}

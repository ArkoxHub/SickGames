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
    
    public void updateVideojoc(Videojoc videojoc);
    
    public int getMaxID();
    
    public List<Videojoc> getAllVideojocs();
    
    public Videojoc getVideojocByCode(int codi);
    
    public List<Videojoc> getVideojocsByName(String name);
    
    public List<Videojoc> getVideojocsByGenere(String genere);
    
    public List<Videojoc> getJocsByOferta();
    
}

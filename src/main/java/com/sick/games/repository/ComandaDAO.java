/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository;

import com.sick.games.domain.Comanda;
import java.util.List;

/**
 *
 * @author Adri
 */
public interface ComandaDAO {
    
    public void addComanda(Comanda comanda);
    
    public void updateComanda(Comanda comanda);
    
    public void removeComanda(Comanda comanda);
    
    public Comanda getComandaByCodiComanda(int codi);
    
    public List<Comanda> getComandesByClient(int codi);
    
    public List<Comanda> getAllComandes();
    
}

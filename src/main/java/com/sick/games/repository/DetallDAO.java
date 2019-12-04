/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository;

import com.sick.games.domain.Detall;
import java.util.List;

/**
 *
 * @author Adri
 */
public interface DetallDAO {
    
    public void addDetall(Detall detall);
    
    public void updateDetall(Detall detall);
    
    public void removeDetall(Detall detall);
    
    public Detall getDetallByCodiDetall(int codi);
    
    public List<Detall> getDetallsByCodiComanda(int codi);
    
    public List<Detall> getDetallsByCodiJoc(int codi);
    
    public List<Detall> getAllDetalls();
    
}

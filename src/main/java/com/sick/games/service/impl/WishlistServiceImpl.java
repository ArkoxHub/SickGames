/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.service.impl;

import com.sick.games.domain.Wishlist;
import com.sick.games.repository.WishlistDAO;
import com.sick.games.service.WishlistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adri
 * @version 1.0 Classe Service que implementa i sobreescriu els mètodes de
 * l'interfície WishlistService
 * 
 * Simplement es fan crides als mètodes del repositori a través del objecte DAO
 * instanciat gràcies a l'annotació Autowired.
 */
@Service
public class WishlistServiceImpl implements WishlistService {
    
    @Autowired
    WishlistDAO wishlistDAO;

    @Override
    public void addWishlist(Wishlist wishlist) {
        wishlistDAO.addWishlist(wishlist);
    }

    @Override
    public void updateWishlist(Wishlist wishlist) {
        wishlistDAO.updateWishlist(wishlist);
    }

    @Override
    public void removeWishlist(Wishlist wishlist) {
        wishlistDAO.removeWishlist(wishlist);
    }

    @Override
    public List<Wishlist> getWishlistByUserId(int codi) {
        return wishlistDAO.getWishlistByUserId(codi);
    }
    
}

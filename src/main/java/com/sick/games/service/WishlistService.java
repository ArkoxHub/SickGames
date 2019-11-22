/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.service;

import com.sick.games.domain.Wishlist;
import java.util.List;

/**
 *
 * @author Adri
 */
public interface WishlistService {
    
    public void addWishlist(Wishlist wishlist);
    
    public void updateWishlist(Wishlist wishlist);
    
    public void removeWishlist(Wishlist wishlist);
    
    public List<Wishlist> getWishlistByUserId(int codi);
    
}

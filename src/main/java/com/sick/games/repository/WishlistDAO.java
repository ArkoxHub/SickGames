/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository;

import com.sick.games.domain.Wishlist;
import java.util.List;

/**
 *
 * @author Adri
 * @version 1.0 Interfície que subministra els mètodes Data Access Object per
 * accedir a les dades de la Classe Entitat Videojoc
 */
public interface WishlistDAO {

    public void addWishlist(Wishlist wishlist);

    public void updateWishlist(Wishlist wishlist);

    public void removeWishlist(Wishlist wishlist);

    public List<Wishlist> getWishlistByUserId(int codi);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository.impl;

import com.sick.games.domain.Wishlist;
import com.sick.games.repository.WishlistDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Adri
 */
@Transactional
@Repository("wishlistHibernateDAO")
public class WishlistHibernateDAO implements WishlistDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(Wishlist.class);

    @Override
    public void addWishlist(Wishlist wishlist) {
        getSession().saveOrUpdate(wishlist);
    }

    @Override
    public void updateWishlist(Wishlist wishlist) {
        getSession().merge(wishlist);
    }

    @Override
    public void removeWishlist(Wishlist wishlist) {
        getSession().remove(wishlist);
    }

    @Override
    public List<Wishlist> getWishlistByUserId(int codi) {
        List<Wishlist> wishlists = getSession().createQuery("FROM Wishlist WHERE id_Usuari = :codi ").setParameter("codi", codi).list();
        return wishlists;
    }
    
    // Connecta amb la Base de Dades
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
}

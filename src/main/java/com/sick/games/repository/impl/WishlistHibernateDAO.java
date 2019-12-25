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
 * @version 1.0 Classe que implementa l'interfície WishlistDAO i especifíca la
 * funcionalitat de cada mètode.
 *
 * Tots els mètodes treballen sobre la Taula Wishlist de la Base de Dadaes
 * sickgames.sql
 */
@Transactional
@Repository("wishlistHibernateDAO")
public class WishlistHibernateDAO implements WishlistDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(Wishlist.class);

    /**
     * Afegeix una wishlist a la Taula Wishlist.
     *
     * @param wishlist objecte wishlist a afegir.
     */
    @Override
    public void addWishlist(Wishlist wishlist) {
        getSession().saveOrUpdate(wishlist);
    }

    /**
     * Modifica una wishlist existent de la Taula Wishlist.
     *
     * @param wishlist objecte wishlist a modificar.
     */
    @Override
    public void updateWishlist(Wishlist wishlist) {
        getSession().merge(wishlist);
    }

    /**
     * Elimina una wishlist existent de la Taula Wishlist.
     *
     * @param wishlist objecte wishlist a eliminar.
     */
    @Override
    public void removeWishlist(Wishlist wishlist) {
        getSession().remove(wishlist);
    }

    /**
     * Obté tots els jocs afegits a la Wishlist donat el codi d'un usuari.
     *
     * @param codi PK de l'Usuari.
     * @return ArrayList de Wishlist amb tots els objectes Wishlist que té un
     * usuari afegits a la base de dades per tal de consultar tots els jocs que
     * vol.
     */
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

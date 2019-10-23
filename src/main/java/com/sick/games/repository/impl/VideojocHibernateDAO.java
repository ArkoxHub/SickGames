/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository.impl;

import com.sick.games.domain.Videojoc;
import com.sick.games.repository.VideojocDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Adri
 */
@Transactional
@Repository
public class VideojocHibernateDAO implements VideojocDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void addVideojoc(Videojoc videojoc) {
        getSession().saveOrUpdate(videojoc);
    }

    @Override
    public void removeVideojoc(Videojoc videojoc) {
        getSession().remove(videojoc);
    }

    @Override
    public Videojoc getVideojocByCode(int codi) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("codi_Joc", codi));
        return (Videojoc) criteria.uniqueResult();
    }

    @Override
    public List<Videojoc> getVideojocsByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nom", name));
        return (List<Videojoc>) criteria.list();
    }

    @Override
    public void updateVideojoc(Videojoc videojoc) {
        getSession().merge(videojoc);
    }

    @Override
    public List<Videojoc> getAllVideojocs() {
        Criteria criteria = createEntityCriteria();
        return (List<Videojoc>) criteria.list();
    }

    @Override
    public List<Videojoc> getGamesByOfert(int ofertaStart, int ofertaEnd) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.between("oferta", ofertaStart, ofertaEnd));
        criteria.addOrder(Order.desc("oferta"));
        return (List<Videojoc>) criteria.list();
    }

    // Connecta amb la Base de Dades
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    // Connecta amb la BD i crea un objecte Criteria de Videojoc
    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(Videojoc.class);
    }

}

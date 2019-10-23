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
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Adri
 */
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
    public Videojoc getVideojocByCode(String codi) {
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
    public Videojoc updateVideojoc(Videojoc videojoc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Videojoc> getAllVideojocs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Videojoc> getGamesByOfert(int oferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

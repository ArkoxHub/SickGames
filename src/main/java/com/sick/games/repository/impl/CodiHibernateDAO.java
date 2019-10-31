/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository.impl;

import com.sick.games.domain.Codi;
import com.sick.games.domain.Videojoc;
import com.sick.games.repository.CodiDAO;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Adri
 */
@Transactional
@Repository("codiHibernateDAO")
public class CodiHibernateDAO implements CodiDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCodi(Codi codi) {
        getSession().saveOrUpdate(codi);
    }

    @Override
    public void updateCodi(Codi codi) {
        getSession().merge(codi);
    }

    @Override
    public void removeCodi(Codi codi) {
        getSession().remove(codi);
    }

    @Override
    public List<Codi> getCodisByCodisJoc(int codi) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("codi_Joc", codi));
        return (List<Codi>) criteria.list();
    }

    @Override
    public Set<Codi> getCodisByCodiPlataforma(int plataforma) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("plataforma", plataforma));
        return (Set<Codi>) criteria.list();
    }

    @Override
    public long getTotalCodisByJoc(int codi) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("codi_Joc", codi));
        return (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }
    
    // Connecta amb la Base de Dades
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    // Connecta amb la BD i crea un objecte Criteria de Videojoc
    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(Codi.class);
    }
    
}

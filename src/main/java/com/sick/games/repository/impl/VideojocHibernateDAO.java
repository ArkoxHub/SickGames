/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository.impl;

import com.sick.games.domain.CodeGame;
import com.sick.games.domain.Codi;
import com.sick.games.domain.Videojoc;
import com.sick.games.repository.VideojocDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Adri
 */
@Transactional
@Repository("videoJocHibernateDAO")
public class VideojocHibernateDAO implements VideojocDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    private static final Logger logger = LoggerFactory.getLogger(VideojocHibernateDAO.class);

    @Override
    public void addVideojoc(Videojoc videojoc) {
        getSession().saveOrUpdate(videojoc);
    }

    @Override
    public void removeVideojoc(Videojoc videojoc) {
        getSession().remove(videojoc);
    }

    @Override
    public void updateVideojoc(Videojoc videojoc) {
        getSession().merge(videojoc);
    }

    @Override
    public int getMaxID() {
        Criteria criteria = createEntityCriteria();
        criteria.setProjection(Projections.max("codi_Joc"));
        return (Integer) criteria.uniqueResult();
    }

    @Override
    public List<Videojoc> getAllVideojocs() {
        return (List<Videojoc>) getSession().createQuery("FROM Videojoc").getResultList();
    }

    @Override
    public Videojoc getVideojocByCode(int codi) {
        Videojoc videojoc = getSession().load(Videojoc.class, codi);
        logger.info("Videojoc carregat correctament" + videojoc);
        return videojoc;
    }

    @Override
    public List<Videojoc> getVideojocsByName(String name) {
        return (List<Videojoc>) getSession().load(Videojoc.class, name);
    }

    @Override
    public List<Videojoc> getVideojocsByGenere(String genere) {
        return (List<Videojoc>) getSession().load(Videojoc.class, genere);
    }

    @Override
    public List<CodeGame> getJocsByOferta() {
        return (List<CodeGame>) getSession().createQuery("SELECT v.codi_Joc, v.nom, v.generes, c.oferta, COUNT(v.nom) FROM Videojoc v, Codi c WHERE v.codi_Joc = c.codi_Joc GROUP BY v.codi_Joc ORDER BY c.oferta DESC").getResultList();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository.impl;

import com.sick.games.domain.Codi;
import com.sick.games.repository.CodiDAO;
import java.util.List;
import org.hibernate.Criteria;
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
@Repository("codiHibernateDAO")
public class CodiHibernateDAO implements CodiDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(CodiHibernateDAO.class);

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
    public List<Codi> getNextCodeByCodiJoc(int codi_Joc) {
        List <Codi> codi = (List<Codi>) getSession().createQuery("FROM Codi WHERE codi_Joc = :codi ORDER BY preu ASC").setParameter("codi", codi_Joc).list();
        return codi;
    }

    // Retorna els codis d'un joc concret
    @Override
    public List<Codi> getPlataformesByCodiJoc(int plataforma) {
        return (List<Codi>) getSession().load(Codi.class, plataforma);
    }

    // Retorna el STOCK de codis que tenim d'un videojoc concret
    @Override
    public long getTotalCodisByJoc(int codi_Joc) {
        Long codis = (long) getSession().createQuery("SELECT COUNT(codi.codi_Joc) FROM Codi codi WHERE codi.codi_Joc = :codi")
                .setParameter("codi", codi_Joc).uniqueResult();
        return codis;
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

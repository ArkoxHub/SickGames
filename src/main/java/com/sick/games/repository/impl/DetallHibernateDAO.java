/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository.impl;

import com.sick.games.domain.Detall;
import com.sick.games.repository.DetallDAO;
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
@Repository("detallHibernateDAO")
public class DetallHibernateDAO implements DetallDAO {
    
    @Autowired
    SessionFactory sessionFactory;
    
    private static final Logger logger = LoggerFactory.getLogger(DetallHibernateDAO.class);

    // Connecta amb la Base de Dades
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addDetall(Detall detall) {
        getSession().save(detall);
    }

    @Override
    public void updateDetall(Detall detall) {
        getSession().merge(detall);
    }

    @Override
    public void removeDetall(Detall detall) {
        getSession().remove(detall);
    }

    @Override
    public Detall getDetallByCodiDetall(int codi) {
        return (Detall) getSession().createQuery("FROM Detall WHERE codi_Detall = :codi").setParameter("codi", codi).uniqueResult();
    }

    @Override
    public List<Detall> getDetallsByCodiComanda(int codi) {
        return (List<Detall>) (Detall) getSession().createQuery("FROM Detall WHERE comanda = :codi").setParameter("codi", codi).getResultList();
    }

    @Override
    public List<Detall> getDetallsByCodiJoc(int codi) {
        return (List<Detall>) (Detall) getSession().createQuery("FROM Detall WHERE joc = :codi").setParameter("codi", codi).getResultList();
    }

    @Override
    public List<Detall> getAllDetalls() {
        return (List<Detall>) (Detall) getSession().createQuery("FROM Detall").getResultList();
    }

}

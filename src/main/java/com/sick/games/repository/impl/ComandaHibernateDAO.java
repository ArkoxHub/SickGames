/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository.impl;

import com.sick.games.domain.Comanda;
import com.sick.games.repository.ComandaDAO;
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
@Repository("comandaHibernateDAO")
public class ComandaHibernateDAO implements ComandaDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(ComandaHibernateDAO.class);

    
    // Connecta amb la Base de Dades
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addComanda(Comanda comanda) {
        getSession().save(comanda);
    }

    @Override
    public void updateComanda(Comanda comanda) {
        getSession().merge(comanda);
    }

    @Override
    public void removeComanda(Comanda comanda) {
        getSession().remove(comanda);
    }

    @Override
    public Comanda getComandaByCodiComanda(int codi) {
        return (Comanda) getSession().createQuery("FROM Comanda WHERE codi_Comanda = :codi").setParameter("codi", codi).uniqueResult();
    }

    @Override
    public List<Comanda> getComandesByClient(int codi) {
        return (List<Comanda>) (Comanda) getSession().createQuery("FROM Comanda WHERE usuari_Client = :codi").setParameter("codi", codi).uniqueResult();
    }

    @Override
    public List<Comanda> getAllComandes() {
        return (List<Comanda>) (Comanda) getSession().createQuery("FROM Comanda").getResultList();
    }
    
}

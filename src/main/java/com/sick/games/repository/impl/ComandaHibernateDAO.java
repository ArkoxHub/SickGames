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
 * @version 1.0 Classe que implementa l'interfície ComandaDAO i especifíca la
 * funcionalitat de cada mètode.
 *
 * Tots els mètodes treballen sobre la Taula Comanda de la Base de Dadaes
 * sickgames.sql.
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

    /**
     * Afegeix una nova comanda a la Taula Comanda.
     *
     * @param comanda objecte comanda a afegir.
     */
    @Override
    public void addComanda(Comanda comanda) {
        getSession().save(comanda);
    }

    /**
     * Modifica una comanda existent de la Taula Comanda.
     *
     * @param comanda objecte comanda a modificar.
     */
    @Override
    public void updateComanda(Comanda comanda) {
        getSession().merge(comanda);
    }

    /**
     * Elimina una comanda existent de la Taula Comanda.
     *
     * @param comanda objecte comanda a eliminar.
     */
    @Override
    public void removeComanda(Comanda comanda) {
        getSession().remove(comanda);
    }

    /**
     * Permet obtenir un objecte comanda concret a partir del seu codi.
     *
     * @param codi PK de la comanda.
     * @return objecte comanda resultant.
     */
    @Override
    public Comanda getComandaByCodiComanda(int codi) {
        return (Comanda) getSession().createQuery("FROM Comanda WHERE codi_Comanda = :codi").setParameter("codi", codi).uniqueResult();
    }

    /**
     * Permet obtenir totes les comandes que ha fet un client donat el
     * codiClient.
     *
     * @param codi PK del Client.
     * @return ArrayList de Comandes amb totes les comandes que ha realitzat un
     * client.
     */
    @Override
    public List<Comanda> getComandesByClient(int codi) {
        return (List<Comanda>) (Comanda) getSession().createQuery("FROM Comanda WHERE usuari_Client = :codi").setParameter("codi", codi).uniqueResult();
    }

    /**
     * Permet obtenir totes les comandes que hi ha a la Taula Comanda.
     *
     * @return ArrayList de Comandes amb totes les comandes de la Base de Dades.
     */
    @Override
    public List<Comanda> getAllComandes() {
        return (List<Comanda>) (Comanda) getSession().createQuery("FROM Comanda").getResultList();
    }

}

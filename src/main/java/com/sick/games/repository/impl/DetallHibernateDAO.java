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
 * @version 1.0 Classe que implementa l'interfície DetallDAO i especifíca la
 * funcionalitat de cada mètode.
 *
 * Tots els mètodes treballen sobre la Taula Detall de la Base de Dadaes
 * sickgames.sql
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

    /**
     * Afegeix un nou detall a la Taula Detall.
     *
     * @param detall objecte detall a afegir.
     */
    @Override
    public void addDetall(Detall detall) {
        getSession().save(detall);
    }

    /**
     * Modifica un detall de la Taula Detall.
     *
     * @param detall objecte detall a modificar.
     */
    @Override
    public void updateDetall(Detall detall) {
        getSession().merge(detall);
    }

    /**
     * Elimina un detall de la Taula Eliminar.
     *
     * @param detall objecte detall a eliminar.
     */
    @Override
    public void removeDetall(Detall detall) {
        getSession().remove(detall);
    }

    /**
     * Permet obtenir un detall concret donat un codi de Detall.
     *
     * @param codi PK codi del detall.
     * @return objecte detall cercat.
     */
    @Override
    public Detall getDetallByCodiDetall(int codi) {
        return (Detall) getSession().createQuery("FROM Detall WHERE codi_Detall = :codi").setParameter("codi", codi).uniqueResult();
    }

    /**
     * Permet obtenir tots els detalls que hi ha d'una Comanda concreta.
     *
     * @param codi PK de la Comanda de la que es vol obtenir tots els seus
     * detalls.
     * @return ArrayList de Detalls de tots els detalls que fan referència a una
     * comanda concreta.
     */
    @Override
    public List<Detall> getDetallsByCodiComanda(int codi) {
        return (List<Detall>) getSession().createQuery("FROM Detall WHERE comanda = :codi").setParameter("codi", codi).getResultList();
    }

    /**
     * Permet obtenir tots els detalls que hi ha d'un Videojoc concret.
     *
     * @param codi PK del Videojoc del que es vol obtenir tots els seus detalls.
     * @return ArrayList de Detalls de tots els detalls que fan referència al
     * Videojoc passa't per paràmetre.
     */
    @Override
    public List<Detall> getDetallsByCodiJoc(int codi) {
        return (List<Detall>) getSession().createQuery("FROM Detall WHERE joc = :codi").setParameter("codi", codi).getResultList();
    }

    /**
     * Permet obtenir tots els detalls que hi ha d'un Client concret.
     *
     * @param codi PK del Client del que es vol obtenir tots els seus detalls.
     * @return ArrayList de Detalls de tots els detalls que fan referència al
     * Client passa't per paràmetre.
     */
    @Override
    public List<Detall> getDetallsByCodiClient(int codi) {
        return (List<Detall>) getSession().createQuery("FROM Detall WHERE id_Usuari = :codi").setParameter("codi", codi).getResultList();
    }

    /**
     * Obté tots els detalls de la Taula Detalls.
     *
     * @return ArrayList de Detalls de tots els resultats.
     */
    @Override
    public List<Detall> getAllDetalls() {
        return (List<Detall>) getSession().createQuery("FROM Detall").getResultList();
    }

}

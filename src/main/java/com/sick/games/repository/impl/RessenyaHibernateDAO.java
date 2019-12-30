/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository.impl;

import com.sick.games.domain.Ressenya;
import com.sick.games.repository.RessenyaDAO;
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
 * @version 1.0 Classe que implementa l'interfície RessenyaHibernateDAO i
 * especifíca la funcionalitat de cada mètode.
 *
 * Tots els mètodes treballen sobre la Taula Ressenya de la Base de Dadaes
 * sickgames.sql
 */
@Transactional
@Repository(value = "ressenyaHibernateDAO")
public class RessenyaHibernateDAO implements RessenyaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(RessenyaHibernateDAO.class);

    /**
     * Afegeix una nova Ressenya
     *
     * @param ressenya objecte ressenya a afegir
     */
    @Override
    public void addRessenya(Ressenya ressenya) {
        getSession().save(ressenya);
    }

    /**
     * Actualitza una ressenya existent
     *
     * @param ressenya ressenya a modificar
     */
    @Override
    public void updateRessenya(Ressenya ressenya) {
        getSession().merge(ressenya);
    }

    /**
     * Elimina una ressenya existent
     *
     * @param ressenya ressenya a eliminar
     */
    @Override
    public void removeRessenya(Ressenya ressenya) {
        getSession().remove(ressenya);
    }

    /**
     * Consulta una ressenya específica de la base de dades i obté la
     * coincidència en cas de que existeixi
     *
     * @param id_Ressenya id de la ressenya
     * @return objecte ressenya
     */
    @Override
    public Ressenya getRessenyaById(int id_Ressenya) {
        return (Ressenya) getSession().createQuery("FROM Ressenya WHERE id_Puntuacio = :id_Ressenya").setParameter("id_Ressenya", id_Ressenya).uniqueResult();
    }

    /**
     * Retorna totes les ressenyes d'un joc
     *
     * @param codi_Joc codi del joc
     * @return Array de ressenyes
     */
    @Override
    public List<Ressenya> getRessenyesByJoc(int codi_Joc) {
        return (List<Ressenya>) getSession().createQuery("FROM Ressenya WHERE codi_Joc = :codi_Joc").setParameter("codi_Joc", codi_Joc).getResultList();
    }

    /**
     * Retorna totes les puntuacions d'un joc
     *
     * @param estrelles estrelles a consultar
     * @return Array List de ressenyes d'una ressenya amb estrelles entre 1 i
     * 5...
     */
    @Override
    public List<Ressenya> getRessenyesByPuntuacio(int estrelles) {
        return (List<Ressenya>) getSession().createQuery("FROM Ressenya WHERE estrelles = :estrelles").setParameter("estrelles", estrelles).getResultList();
    }

    /**
     * Retorna totes les ressenyes d'un usuari
     *
     * @param id_User id de l'usuari
     * @return Array List de ressentes que ha fet un usuari
     */
    @Override
    public List<Ressenya> getRessenyesByUser(int id_User) {
        return (List<Ressenya>) getSession().createQuery("FROM Ressenya WHERE autor = :id_User").setParameter("id_User", id_User).getResultList();
    }

    /**
     * Connecta amb la Base de Dades Hibernate
     *
     * @return Objecte de sessió
     */
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}

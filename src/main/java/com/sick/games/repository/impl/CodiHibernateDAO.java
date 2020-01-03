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
 * @version 1.0 Classe que implementa l'interfície CodiDAO i especifíca la
 * funcionalitat de cada mètode.
 *
 * Tots els mètodes treballen sobre la Taula Codi de la Base de Dadaes
 * sickgames.sql.
 */
@Transactional
@Repository("codiHibernateDAO")
public class CodiHibernateDAO implements CodiDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(CodiHibernateDAO.class);

    /**
     * Permet afegir un codi a la Taula Codi.
     *
     * @param codi Objecte a afegir.
     */
    @Override
    public void addCodi(Codi codi) {
        getSession().save(codi);
    }

    /**
     * Permet modificar un codi existent de la Taula Codi.
     *
     * @param codi Objecte codi a modificar.
     */
    @Override
    public void updateCodi(Codi codi) {
        getSession().merge(codi);
    }

    /**
     * Elimina un codi existent de la Taula Codi.
     *
     * @param codi Objecte codi a eliminar.
     */
    @Override
    public void removeCodi(Codi codi) {
        getSession().remove(codi);
    }

    /**
     * Permet obtenir un codi existent de la Taula Codi.
     *
     * @param codi PK codi de l'objecte codi a obtenir.
     * @return l'objecte Codi recuperat de la base de dades.
     */
    @Override
    public Codi getCodi(int codi) {
        return (Codi) getSession().createQuery("FROM Codi WHERE codi = :codi").setParameter("codi", codi).uniqueResult();
    }

    /**
     * Obté tots els objectes Codi que té un Videojoc concret.
     *
     * @param codi PK del Videojoc que es vol obtenir els seus codis.
     * @return ArrayList de Codi amb tots els resultats.
     */
    @Override
    public List<Codi> getCodisByCodiJoc(int codi) {
        return (List<Codi>) getSession().createQuery("FROM Codi WHERE codi_Joc = :codi").setParameter("codi", codi).getResultList();
    }

    /**
     * Permet obtenir el següent codi més barat que té un joc disponible.
     *
     * @param codi_Joc PK del Videojoc que es vol obtenir.
     * @return ArrayList de Codis amb els codis ordenats de més barats a més
     * cars.
     */
    @Override
    public List<Codi> getNextCodeByCodiJoc(int codi_Joc) {
        List<Codi> codi = (List<Codi>) getSession().createQuery("FROM Codi WHERE codi_Joc = :codi ORDER BY preu ASC").setParameter("codi", codi_Joc).list();
        return codi;
    }

    /**
     * Obté tots els codis que té un codi segons la plataforma passada per
     * paràmetre.
     *
     * @param plataforma ID de la plataforma.
     * @return ArrayList de Codis de tots els codis resultants de la cerca.
     */
    @Override
    public List<Codi> getPlataformesByCodiJoc(int plataforma) {
        return (List<Codi>) getSession().load(Codi.class, plataforma);
    }

    /**
     * MÈTODE CLAU Permet obtenir l'STOCK TOTAL que tenim d'un Videojoc concret.
     *
     * @param codi_Joc PK del Videojoc que volem consultar quants codis té
     * disponible a la venta.
     * @return Quantitat total de codis que té un Videojoc.
     */
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

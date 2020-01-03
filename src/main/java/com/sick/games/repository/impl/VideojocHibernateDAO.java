/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository.impl;

import com.sick.games.domain.CodeGame;
import com.sick.games.domain.Videojoc;
import com.sick.games.repository.VideojocDAO;
import java.util.Collections;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Adri
 * @version 1.0 Classe que implementa l'interfície VideojocDAO i especifíca la
 * funcionalitat de cada mètode.
 *
 * Tots els mètodes treballen sobre la Taula Videojoc de la Base de Dadaes
 * sickgames.sql
 */
@Transactional
@Repository("videoJocHibernateDAO")
public class VideojocHibernateDAO implements VideojocDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(VideojocHibernateDAO.class);

    /**
     * Afegeix un videojoc a la Taula Videojoc.
     *
     * @param videojoc objecte videojoc a afegir.
     */
    @Override
    public void addGame(Videojoc videojoc) {
        getSession().saveOrUpdate(videojoc);
    }

    /**
     * Elimina un videojoc existent a la taula Videojoc.
     *
     * @param videojoc objecte videojoc a eliminar.
     */
    @Override
    public void removeGame(Videojoc videojoc) {
        getSession().remove(videojoc);
    }

    /**
     * Modifica un videojoc existent de la Taula Videojoc.
     *
     * @param videojoc objecte videojoc a modificar.
     */
    @Override
    public void updateGame(Videojoc videojoc) {
        getSession().merge(videojoc);

    }

    /**
     * Obté següent ID disponible per tal d'afegir un videojoc
     *
     * @return el número d'ID disponible.
     */
    @Override
    public int getMaxID() {
        Criteria criteria = createEntityCriteria();
        criteria.setProjection(Projections.max("codi_Joc"));
        return (Integer) criteria.uniqueResult();
    }

    /**
     * Obté tots els videojocs de la Taula Videojoc.
     *
     * @return ArrayList de tots els videojocs.
     */
    @Override
    public List<Videojoc> getAllGames() {
        return (List<Videojoc>) getSession().createQuery("FROM Videojoc").getResultList();
    }

    /**
     * Permet obtenir un videojoc donat el seu codi.
     *
     * @param codi PK del videojoc.
     * @return objecte videojoc de la cerca.
     */
    @Override
    public Videojoc getGameByCode(int codi) {
        Videojoc videojoc = getSession().load(Videojoc.class, codi);
        logger.info("Videojoc carregat correctament" + videojoc);
        return videojoc;
    }

    /**
     * Permet obtenir tots els videojocs que hi ha a la Taula Videojoc donat un
     * nom de videojoc.
     *
     * @param name nom del videojoc.
     * @return ArrayList de videojocs resultants.
     * @deprecated
     */
    @Override
    public List<Videojoc> getGamesByName(String name) {
        return (List<Videojoc>) getSession().load(Videojoc.class, name);
    }

    /**
     * Permet obtenir tots els videojocs que hi ha a la Taula Videojoc donat un
     * gènere de videojoc.
     *
     * @param genere genere dels videojocs que es vol obtenir.
     * @return ArrayList de Videojocs amb els resultats de la cerca.
     */
    @Override
    public List<Videojoc> getGamesByGenere(String genere) {
        return (List<Videojoc>) getSession().load(Videojoc.class, genere);
    }

    /**
     * Permet obtenir una barreja dels videojocs i codis que hi ha a les Taules
     * Videojoc i Codi ordenats pel % d'Oferta de més gran a l'oferta més baixa.
     *
     * @return ArrayList de la classe CodeGame amb els resultats de la cerca.
     */
    @Override
    public List<CodeGame> getGamesByOferta() {
        List<CodeGame> codeGames;
        codeGames = getSession().createQuery("SELECT v.codi_Joc, v.nom, v.generes, c.oferta, COUNT(v.nom), c.preu FROM Videojoc v, Codi c WHERE v.codi_Joc = c.codi_Joc GROUP BY v.codi_Joc ORDER BY c.oferta DESC").list();
        return codeGames;
    }

    /**
     * Permet obtenir una barreja dels videojocs i codis que hi ha a les Taules
     * Videojoc i Codi ordenats per l'oferta més gran aplicada a la que menys.
     *
     * @return ArrayList de la classe CodeGame amb els resultats de la cerca.
     */
    @Override
    public List<CodeGame> getGamesByPrice() {
        List<CodeGame> codeGames;
        codeGames = getSession().createQuery("SELECT v.codi_Joc, v.nom, v.generes, c.oferta, COUNT(v.nom), c.preu FROM Videojoc v, Codi c WHERE v.codi_Joc = c.codi_Joc GROUP BY v.codi_Joc ORDER BY c.preu ASC").list();
        return codeGames;
    }

    /**
     * Permet obtenir una barreja dels videojocs i codis que hi ha a les Taules
     * Videojoc i Codi de tots els videojocs que estan per sortir al mercat en
     * els pròxims dies / mesos / anys a partir de la data en el moment que es
     * fa la petició.
     *
     * @return ArrayList de la classe CodeGame amb els resultats de la cerca.
     */
    @Override
    public List<CodeGame> getGamesUpcoming() {
        List<CodeGame> codeGames;
        codeGames = getSession().createQuery("SELECT v.codi_Joc, v.nom, v.generes, c.oferta, COUNT(v.nom), c.preu FROM Videojoc v, Codi c WHERE v.codi_Joc = c.codi_Joc and v.data_Llançament > CURDATE() GROUP BY v.codi_Joc").list();
        return codeGames;
    }

    /**
     * Permet obtenir absolutament tots els videojocs que tenim disponibles a la
     * base de dades sickgames conjuntament amb la informació dels seus codis.
     *
     * Aquest mètode es fa servir per visualitzar el catàleg de la pàgina web.
     *
     * @return ArrayList de la classe CodeGame amb els resultats de la cerca.
     */
    @Override
    public List<CodeGame> getGamesCataleg() {
        List<CodeGame> codeGames;
        codeGames = getSession().createQuery("SELECT v.codi_Joc, v.nom, v.generes, c.oferta, COUNT(v.nom), c.preu FROM Videojoc v, Codi c WHERE v.codi_Joc = c.codi_Joc GROUP BY v.codi_Joc").list();
        Collections.shuffle(codeGames);
        return codeGames;
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

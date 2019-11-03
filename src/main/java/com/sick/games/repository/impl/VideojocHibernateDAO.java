/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository.impl;

import com.sick.games.domain.CodeGame;
import com.sick.games.domain.Videojoc;
import com.sick.games.repository.VideojocDAO;
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
 */
@Transactional
@Repository("videoJocHibernateDAO")
public class VideojocHibernateDAO implements VideojocDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(VideojocHibernateDAO.class);

    @Override
    public void addGame(Videojoc videojoc) {
        getSession().saveOrUpdate(videojoc);
    }

    @Override
    public void removeGame(Videojoc videojoc) {
        getSession().remove(videojoc);
    }

    @Override
    public void updateGame(Videojoc videojoc) {
        getSession().merge(videojoc);
    }

    @Override
    public int getMaxID() {
        Criteria criteria = createEntityCriteria();
        criteria.setProjection(Projections.max("codi_Joc"));
        return (Integer) criteria.uniqueResult();
    }

    @Override
    public List<Videojoc> getAllGames() {
        return (List<Videojoc>) getSession().createQuery("FROM Videojoc").getResultList();
    }

    @Override
    public Videojoc getGameByCode(int codi) {
        Videojoc videojoc = getSession().load(Videojoc.class, codi);
        logger.info("Videojoc carregat correctament" + videojoc);
        return videojoc;
    }

    @Override
    public List<Videojoc> getGamesByName(String name) {
        return (List<Videojoc>) getSession().load(Videojoc.class, name);
    }

    @Override
    public List<Videojoc> getGamesByGenere(String genere) {
        return (List<Videojoc>) getSession().load(Videojoc.class, genere);
    }

    @Override
    public List<CodeGame> getGamesByOferta() {
        List<CodeGame> codeGames;
        codeGames = getSession().createQuery("SELECT v.codi_Joc, v.nom, v.generes, c.oferta, COUNT(v.nom), c.preu FROM Videojoc v, Codi c WHERE v.codi_Joc = c.codi_Joc GROUP BY v.codi_Joc ORDER BY c.oferta DESC").list();
        return codeGames;
    }

    @Override
    public List<CodeGame> getGamesByPrice() {
        List<CodeGame> codeGames;
        codeGames = getSession().createQuery("SELECT v.codi_Joc, v.nom, v.generes, c.oferta, COUNT(v.nom), c.preu FROM Videojoc v, Codi c WHERE v.codi_Joc = c.codi_Joc GROUP BY v.codi_Joc ORDER BY v.pvp ASC").list();
        return codeGames;
    }

    @Override
    public List<CodeGame> getGamesUpcoming() {
        List<CodeGame> codeGames;
        codeGames = getSession().createQuery("SELECT v.codi_Joc, v.nom, v.generes, c.oferta, COUNT(v.nom), c.preu FROM Videojoc v, Codi c WHERE v.codi_Joc = c.codi_Joc and v.data_Llançament > CURDATE() GROUP BY v.codi_Joc").list();
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

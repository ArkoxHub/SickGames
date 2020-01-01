/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository.impl;

import com.sick.games.domain.Administrador;
import com.sick.games.domain.Client;
import com.sick.games.domain.Partner;
import com.sick.games.domain.User;
import com.sick.games.domain.Videojoc;
import com.sick.games.repository.UsersDAO;
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
 * @version 1.0 Classe que implementa l'interfície UsersDAO i especifíca la
 * funcionalitat de cada mètode.
 *
 * Tots els mètodes treballen sobre la Taula Usuari de la Base de Dadaes
 * sickgames.sql
 */
@Transactional
@Repository("usersHibernateDAO")
public class UsersHibernateDAO implements UsersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(UsersHibernateDAO.class);

    /**
     * Afegeix un usuari a la Taula Usuari.
     *
     * @param user objecte usuari a afegir.
     */
    @Override
    public void addUser(User user) {
        getSession().save(user);
    }

    /**
     * Afegeix un administrador a la Taula Administrador.
     *
     * @param admin objecte administrador a afegir.
     */
    @Override
    public void addAdministrador(Administrador admin) {
        getSession().save(admin);
    }

    /**
     * Afegeix un client a la Taula CLient.
     *
     * @param client objecte client a afegir.
     */
    @Override
    public void addClient(Client client) {
        getSession().save(client);
    }

    /**
     * Afegeix un partner a la Taula Partner.
     *
     * @param partner objecte partner a afegir.
     * @deprecated 
     */
    @Override
    public void addPartner(Partner partner) {
        getSession().save(partner);
    }

    /**
     * Elimina un usuari de la Taula Usuari
     *
     * @param user objecte usuari a eliminar
     */
    @Override
    public void removeUser(User user) {
        getSession().remove(user);
    }

    /**
     * Elimina a un administrador de la Taula Administrador.
     *
     * @param admin objecte administrador a eliminar.
     */
    @Override
    public void removeAdministrador(Administrador admin) {
        getSession().remove(admin);
    }

    /**
     * Elimina a un client de la Taula Client.
     *
     * @param client objecte client a eliminar.
     */
    @Override
    public void removeClient(Client client) {
        getSession().remove(client);
    }

    /**
     * Elimina a un partner de la Taula Partner.
     *
     * @param partner objecte partner a eliminar.
     * @deprecated 
     */
    @Override
    public void removePartner(Partner partner) {
        getSession().remove(partner);
    }

    /**
     * Modifica un usuari de la Taula Usuari.
     *
     * @param user objecte usuari a modificar.
     */
    @Override
    public void updateUser(User user) {
        getSession().merge(user);
    }

    /**
     * Modifica un administrador de la Taula Administrador.
     *
     * @param admin objecte administrador a modificar.
     */
    @Override
    public void updateAdministrador(Administrador admin) {
        getSession().merge(admin);
    }

    /**
     * Modifica un client de la Taula Client.
     *
     * @param client objecte client a modificar.
     */
    @Override
    public void updateClient(Client client) {
        getSession().merge(client);
    }

    /**
     * Modifica a un partner de la Taula Partner.
     *
     * @param partner objecte partner a modificar.
     * @deprecated 
     */
    @Override
    public void updatePartner(Partner partner) {
        getSession().merge(partner);
    }

    /**
     * Permet obtenir un Usuari donat un email de la Taula Usuari
     *
     * @param email email de l'usuari
     * @return objecte usuari cercat
     */
    @Override
    public User getUserByeMail(String email) {
        User user = (User) getSession().createQuery("FROM User user WHERE email = :mail").setParameter("mail", email).uniqueResult();
        logger.info("Usuari obtingut correctament" + user);
        return user;
    }

    /**
     * Permet obtenir un Administrador donat un email de la Taula Administrador
     *
     * @param email email de l'usuari administrador
     * @return objecte administrador cercat
     */
    @Override
    public Administrador getAdminByEmail(String email) {
        Administrador admin = (Administrador) getSession().createQuery("FROM Administrador admin WHERE email = :mail").setParameter("mail", email).uniqueResult();
        logger.info("Usuari admin obtingut correctament" + admin);
        return admin;
    }

    /**
     * Permet obtenir un Client donat un email de la Taula Client.
     *
     * @param email email de l'usuari client.
     * @return objecte client cercat.
     */
    @Override
    public Client getClientByEmail(String email) {
        Client client = (Client) getSession().createQuery("FROM Client client WHERE email = :mail").setParameter("mail", email).uniqueResult();
        logger.info("Usuari client obtingut correctament" + client);
        return client;
    }

    /**
     * Permet obtenir un Partner donat un email de la Taula Partner.
     *
     * @param email email de l'usuari Partner.
     * @return objecte partner cercat.
     * @deprecated 
     */
    @Override
    public Partner getPartnerByEmail(String email) {
        Partner partner = (Partner) getSession().createQuery("FROM Partner partner WHERE email = :mail").setParameter("mail", email).uniqueResult();
        logger.info("Usuari partner obtingut correctament" + partner);
        return partner;
    }

    /**
     * Permet obtenir un usuari donat el seu nickname.
     *
     * @param nickname Nickname de l'usuari. És unívoc.
     * @return objecte usuari cercat
     */
    @Override
    public User getUserByNick(String nickname) {
        User user = (User) getSession().createQuery("FROM User user WHERE nickname = :nick").setParameter("nick", nickname).uniqueResult();
        logger.info("Usuari obtingut correctament" + user);
        return user;
    }

    /**
     * Permet obtenir un llistat de TOTS els usuaris de la Taula Usuari
     *
     * @return ArrayList d'Usuaris que tenim a la Base de Dades.
     */
    @Override
    public List<User> getAllUsers() {
        return (List<User>) getSession().createQuery("FROM Users").getResultList();
    }
    
    /**
     * Permet obtenir un usuari mitjançant el seu ID
     * @param id id de l'usuari
     * @return Objecte usuari
     */
    @Override
    public User getUserById(int id) {
        return (User) getSession().createQuery("FROM Users WHERE id_Usuari = :id").setParameter("id", id).uniqueResult();
    }

    // Connecta amb la Base de Dades
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    // Connecta amb la BD i crea un objecte Criteria de Videojoc
    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(Videojoc.class);
    }

}

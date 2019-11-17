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
 */
@Transactional
@Repository("usersHibernateDAO")
public class UsersHibernateDAO implements UsersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(UsersHibernateDAO.class);

    @Override
    public void addUser(User user) {
        getSession().save(user);
    }

    @Override
    public void addAdministrador(Administrador admin) {
        getSession().saveOrUpdate(admin);
    }

    @Override
    public void addClient(Client client) {
        getSession().save(client);
    }

    @Override
    public void addPartner(Partner partner) {
        getSession().saveOrUpdate(partner);
    }

    @Override
    public void removeUser(User user) {
        getSession().remove(user);
    }

    @Override
    public void removeAdministrador(Administrador admin) {
        getSession().remove(admin);
    }

    @Override
    public void removeClient(Client client) {
        getSession().remove(client);
    }

    @Override
    public void removePartner(Partner partner) {
        getSession().remove(partner);
    }

    @Override
    public void updateUser(User user) {
        getSession().merge(user);
    }

    @Override
    public void updateAdministrador(Administrador admin) {
        getSession().merge(admin);
    }

    @Override
    public void updateClient(Client client) {
        getSession().merge(client);
    }

    @Override
    public void updatePartner(Partner partner) {
        getSession().merge(partner);
    }

    @Override
    public User getUserByeMail(String email) {
        User user = (User) getSession().createQuery("FROM User user WHERE email = :mail").setParameter("mail", email).uniqueResult();
        logger.info("Usuari obtingut correctament" + user);
        return user;
    }

    @Override
    public Administrador getAdminByEmail(String email) {
        User user = getSession().load(User.class, email);
        Administrador admin = getSession().load(Administrador.class, user.getId_Usuari());
        logger.info("Administrador obtingut correctament" + admin);
        return admin;
    }

    @Override
    public Client getClientByEmail(String email) {
        User user = getSession().load(User.class, email);
        Client client = getSession().load(Client.class, user.getId_Usuari());
        logger.info("Client obtingut correctament" + client);
        return client;
    }

    @Override
    public Partner getPartnerByEmail(String email) {
        User user = getSession().load(User.class, email);
        Partner partner = getSession().load(Partner.class, user.getId_Usuari());
        logger.info("Partner obtingut correctament" + partner);
        return partner;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) getSession().createQuery("FROM Users").getResultList();
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

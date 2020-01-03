/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.service.impl;

import com.sick.games.domain.Administrador;
import com.sick.games.domain.Client;
import com.sick.games.domain.Partner;
import com.sick.games.domain.User;
import com.sick.games.repository.UsersDAO;
import com.sick.games.service.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adri
 * @version 1.0 Classe Service que implementa i sobreescriu els mètodes de
 * l'interfície UsersService
 * 
 * Simplement es fan crides als mètodes del repositori a través del objecte DAO
 * instanciat gràcies a l'annotació Autowired.
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersDAO usersDAO;

    @Override
    public void addUser(User user) {
        usersDAO.addUser(user);
    }

    @Override
    public void addAdministrador(Administrador admin) {
        usersDAO.addAdministrador(admin);
    }

    @Override
    public void addClient(Client client) {
        usersDAO.addClient(client);
    }

    @Override
    public void addPartner(Partner partner) {
        usersDAO.addPartner(partner);
    }

    @Override
    public void removeUser(User user) {
        usersDAO.removeUser(user);
    }

    @Override
    public void removeAdministrador(Administrador admin) {
        usersDAO.removeAdministrador(admin);
    }

    @Override
    public void removeClient(Client client) {
        usersDAO.removeClient(client);
    }

    @Override
    public void removePartner(Partner partner) {
        usersDAO.removePartner(partner);
    }

    @Override
    public void updateUser(User user) {
        usersDAO.updateUser(user);
    }

    @Override
    public void updateAdministrador(Administrador admin) {
        usersDAO.updateAdministrador(admin);
    }

    @Override
    public void updateClient(Client client) {
        usersDAO.updateClient(client);
    }

    @Override
    public void updatePartner(Partner partner) {
        usersDAO.updatePartner(partner);
    }

    @Override
    public User getUserByeMail(String email) {
        return usersDAO.getUserByeMail(email);
    }

    @Override
    public Administrador getAdminByEmail(String email) {
        return usersDAO.getAdminByEmail(email);
    }

    @Override
    public Client getClientByEmail(String emial) {
        return usersDAO.getClientByEmail(emial);
    }

    @Override
    public Partner getPartnerByEmail(String email) {
        return usersDAO.getPartnerByEmail(email);
    }
    
    @Override
    public User getUserByNick(String nickname) {
        return usersDAO.getUserByNick(nickname);
    }

    @Override
    public List<User> getAllUsers() {
        return usersDAO.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return usersDAO.getUserById(id);
    }

}

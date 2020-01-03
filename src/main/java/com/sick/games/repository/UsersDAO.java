/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.repository;

import com.sick.games.domain.Administrador;
import com.sick.games.domain.Client;
import com.sick.games.domain.Partner;
import com.sick.games.domain.User;
import java.util.List;

/**
 *
 * @author Adri
 * @version 1.0 Interfície que subministra els mètodes Data Access Object per
 * accedir a les dades de les següents classes - Users - Admins - Clients -
 * Partners
 */
public interface UsersDAO {

    /**
     * ADD users / admins / clients / partners
     */
    public void addUser(User user);

    public void addAdministrador(Administrador admin);

    public void addClient(Client client);

    public void addPartner(Partner partner);

    /**
     * REMOVE users / admins / clients / partners
     */
    public void removeUser(User user);

    public void removeAdministrador(Administrador admin);

    public void removeClient(Client client);

    public void removePartner(Partner partner);

    /**
     * UPDATE users / admins / clients / partners
     */
    public void updateUser(User user);

    public void updateAdministrador(Administrador admin);

    public void updateClient(Client client);

    public void updatePartner(Partner partner);

    // GET users / admins / clients / partners by email
    public User getUserByeMail(String email);

    public Administrador getAdminByEmail(String email);

    public Client getClientByEmail(String emial);

    public Partner getPartnerByEmail(String email);

    // GET users / admins / clients / partners by nickname
    public User getUserByNick(String nickname);

    // GET ALL USERS
    public List<User> getAllUsers();
    
    // GET USER BY ID
    public User getUserById(int id);

}

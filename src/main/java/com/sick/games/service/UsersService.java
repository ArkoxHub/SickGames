/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.service;

import com.sick.games.domain.Administrador;
import com.sick.games.domain.Client;
import com.sick.games.domain.Partner;
import com.sick.games.domain.User;
import java.util.List;

/**
 *
 * @author Adri
 * @version 1.0 Interfície que defineix quins seràn els mètodes que es
 * criden del repositori UsersDAO
 */
public interface UsersService {

    public void addUser(User user);

    public void addAdministrador(Administrador admin);

    public void addClient(Client client);

    public void addPartner(Partner partner);

    public void removeUser(User user);

    public void removeAdministrador(Administrador admin);

    public void removeClient(Client client);

    public void removePartner(Partner partner);

    public void updateUser(User user);

    public void updateAdministrador(Administrador admin);

    public void updateClient(Client client);

    public void updatePartner(Partner partner);

    public User getUserByeMail(String email);

    public Administrador getAdminByEmail(String email);

    public Client getClientByEmail(String emial);

    public Partner getPartnerByEmail(String email);
    
    public User getUserByNick(String nickname);

    public List<User> getAllUsers();
    
    public User getUserById(int id);
}

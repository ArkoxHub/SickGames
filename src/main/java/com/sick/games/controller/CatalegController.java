/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.controller;

import com.sick.games.domain.User;
import com.sick.games.service.UsersService;
import com.sick.games.service.VideojocService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adri
 */
@Controller
@RequestMapping("/cataleg")
public class CatalegController {

    @Autowired
    VideojocService videojocService;

    @Autowired
    UsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initCataleg(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("cataleg");
        model.getModelMap().addAttribute("videojocs", videojocService.getGamesCataleg());

        // Obtenim l'objecte Usuari de les cookies
        User user = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userNick")) {
                // Add user to Model Response
                user = usersService.getUserByNick(cookie.getValue());
                model.getModelMap().addAttribute("user", user);
            }
        }

        return model;
    }
}

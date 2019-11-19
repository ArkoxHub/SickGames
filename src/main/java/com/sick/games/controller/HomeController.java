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
@RequestMapping("/")
public class HomeController {

    @Autowired
    VideojocService videojocService;

    @Autowired
    UsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView homePage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("index");
        model.getModelMap().addAttribute("upcoming", videojocService.getGamesUpcoming());
        model.getModelMap().addAttribute("ofertes", videojocService.getGamesByOferta());
        model.getModelMap().addAttribute("preus", videojocService.getGamesByPrice());

        // Si l'usuari té la cookie conforma ha iniciat sessió alguna vegada, comprovem que existeixi encara a la base de dades...
        // Si no està a la base de dades, li fem el favor d'eliminar la seva cookie :D
        User user = null;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("userMail")) {
                    try {
                        user = usersService.getUserByeMail(cookie.getValue());
                        model.getModelMap().addAttribute("user", user);
                    } catch (NullPointerException e) {
                        System.out.println("No s'ha trobat usuari equivalent a la base de dades actual");
                    }
                }
            }
        }
        if (user == null) {
            Cookie cookieMail = new Cookie("userMail", "");
            cookieMail.setMaxAge(0);
            cookieMail.setPath("/");
            response.addCookie(cookieMail);

            Cookie cookieNick = new Cookie("userNick", "");
            cookieNick.setMaxAge(0);
            cookieNick.setPath("/");
            response.addCookie(cookieNick);

            Cookie cookiePwd = new Cookie("userPwd", "");
            cookiePwd.setMaxAge(0);
            cookiePwd.setPath("/");
            response.addCookie(cookiePwd);
        }

        return model;
    }
}

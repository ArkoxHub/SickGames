/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.controller;

import com.sick.games.domain.User;
import com.sick.games.service.UsersService;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adri
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView userMainPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("user");
        return model;
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ModelAndView userRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        ModelAndView model = new ModelAndView("signIn");
        model.getModelMap().addAttribute("user", user);
        return model;
    }

    /**
     * Rep les dades introduides al formulari d'alta d'usuari i el guarda a la
     * base de dades Crea una cookie per tal de fer l'experiència d'usuari més
     * cómode.
     *
     * @param newUser Objecte resultant de les dades introduides per l'usuari al
     * formulari
     * @param request
     * @param response
     * @return redirecció a l'inici de la pàgina web
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String userSignIn(@ModelAttribute("user") User newUser, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Afegim a l'usuari la data d'alta equivalent al moment de crear-la.
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        newUser.setData_Alta(date);
        usersService.addUser(newUser);

        Cookie cookieMail = new Cookie("userMail", newUser.getEmail());
        cookieMail.setMaxAge(60 * 60 * 24 * 365 * 10); // 10 anys expiració
        cookieMail.setPath("/");
        response.addCookie(cookieMail);

        Cookie cookieNick = new Cookie("userNick", newUser.getNickname());
        cookieNick.setMaxAge(60 * 60 * 24 * 365 * 10); // 10 anys expiració
        cookieNick.setPath("/");
        response.addCookie(cookieNick);

        Cookie cookiePwd = new Cookie("userPwd", newUser.getContrasenya());
        cookiePwd.setMaxAge(60 * 60 * 24 * 365 * 10); // 10 anys expiració
        cookiePwd.setPath("/");
        response.addCookie(cookiePwd);

        return "redirect:/";
    }

    /**
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/logoff", method = RequestMethod.GET)
    public String userLogOff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        return "redirect:/";
    }

    /**
     * 
     * @param userNick
     * @param userPwd
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(@RequestParam(name = "nickname") String userNick, @RequestParam(name = "password") String userPwd,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            User user = usersService.getUserByNick(userNick);

            if (user.getContrasenya().equals(userPwd)) {
                Cookie cookieMail = new Cookie("userMail", user.getEmail());
                cookieMail.setMaxAge(60 * 60 * 24 * 365 * 10); // 10 anys expiració
                cookieMail.setPath("/");
                response.addCookie(cookieMail);

                Cookie cookieNick = new Cookie("userNick", user.getNickname());
                cookieNick.setMaxAge(60 * 60 * 24 * 365 * 10); // 10 anys expiració
                cookieNick.setPath("/");
                response.addCookie(cookieNick);

                Cookie cookiePwd = new Cookie("userPwd", user.getContrasenya());
                cookiePwd.setMaxAge(60 * 60 * 24 * 365 * 10); // 10 anys expiració
                cookiePwd.setPath("/");
                response.addCookie(cookiePwd);
            } else {
                System.out.println("LA CONTRASEÑA NO COINCIDEIX");
            }
        } catch (NullPointerException e) {
            System.out.println("NO S'HA TROBAT CAP USUARI AMB AQUEST NICK");
        }

        return "redirect:/";
    }
}

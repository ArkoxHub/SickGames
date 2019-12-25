/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.controller;

import com.sick.games.domain.User;
import com.sick.games.service.UsersService;
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
 * @author Kevin
 * @version 1.0 Controlador principal que rep les peticions que es fan a
 * wwww.sickgames.com/suport
 */
@Controller
@RequestMapping("/suport")
public class SuportController {

    @Autowired
    UsersService userService;

    /**
     * Rep les peticions que es fan a suport i retorna la vista de suport, vista
     * que otorga la tota la informació que necessita un usuari saber sobre
     * nosaltres.
     *
     * @param request
     * @param response
     * @return suport.jsp
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initSuport(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("suport");

        try {
            Cookie[] cookies = request.getCookies();
            String nickname = "";
            String password = "";
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userNick")) {
                        nickname = cookie.getValue();
                    } else if (cookie.getName().equals(("userPwd"))) {
                        password = cookie.getValue();
                    }
                }
            }

            if (nickname != "" && password != "") {
                User user = userService.getUserByNick(nickname);
                if (user.getContrasenya().equals(password)) {
                    model.getModelMap().addAttribute("user", user);
                }
            }
        } catch (Error e) {
            System.out.println("No hi ha usuari loguejat");
        }
        return model;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.controller;

import com.sick.games.domain.Codi;
import com.sick.games.domain.User;
import com.sick.games.domain.Videojoc;
import com.sick.games.service.CodiService;
import com.sick.games.service.UsersService;
import com.sick.games.service.VideojocService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
 * @version 1.0 Controlador de la pàgina principal que rep les peticions a
 * l'index HTML. www.sickgames.com
 */
@Controller
@RequestMapping("/")
public class HomeController {
    
    @Autowired
    VideojocService videojocService;
    
    @Autowired
    UsersService usersService;
    
    @Autowired
    CodiService codiService;

    /**
     * Mètode main que rep les peticions que es fan a la pàgina inicial.
     *
     * Obté de la base de dades els próxims llançaments dels jocs que sortiràn
     * en els pròxims dies en el moment de fer la consulta i les adjunta al
     * model. Obté les ofertes majors dels jocs i les adjunta al model. Obté els
     * jocs amb els preus més baixos i els adjunta al model.
     *
     * Si l'atribut de sessió "carro" no té valor en el moment d'entrar a la
     * web, el crea. Si l'atribut de sessió "carro" existeix, per cada joc,
     * actualitzem els preus dels codis. Adjuntem al model l'atribut carro.
     *
     * Mitjanánt les cookies de sickgames, es comprova amb els seus credencials
     * (userMail) si està encara a la nostra base de dades. Si està, adjuntem al
     * model el seu usuari. Si no ho està li eliminem totes les cookies.
     *
     * @param request
     * @param response
     * @return index.jsp
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView homePage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ModelAndView model = new ModelAndView("index");
        model.getModelMap().addAttribute("upcoming", videojocService.getGamesUpcoming());
        model.getModelMap().addAttribute("ofertes", videojocService.getGamesByOferta());
        model.getModelMap().addAttribute("preus", videojocService.getGamesByPrice());

        // Iniciem la variable de sessio carro si no ho està un cop l'usuari carrega l'index
        if (request.getSession().getAttribute("carro") == null) {
            List<Videojoc> carro = new ArrayList();
            request.getSession().setAttribute("carro", carro);
        } else {
            List<Codi> codis = new ArrayList();
            List<Videojoc> videojocs = (List<Videojoc>) request.getSession().getAttribute("carro");
            for (Videojoc joc : videojocs) {
                codis.add(codiService.getNextCodeByCodiJoc(joc.getCodi_Joc()));
            }

            // Retornem els codis de cada joc a la vista (estan en el mateix ordre).
            model.getModelMap().addAttribute("codis", codis);
        }

        // Retornem els jocs que l'usuari a fet clic en comprar.
        model.getModelMap().addAttribute("carro", request.getSession().getAttribute("carro"));

        /**
         * Si l'usuari té les cookies conforma ha iniciat sessió alguna vegada,
         * comprovem que existeixi encara a la base de dades... Si no està a la
         * base de dades, li fem el favor d'eliminar la seva cookie :D
         */
        User user = null;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("userMail")) {
                    try {
                        user = usersService.getUserByeMail(cookie.getValue());
                        model.getModelMap().addAttribute("user", user);
                    } catch (NullPointerException e) {
                        System.out.println("No s'ha trobat usuari amb aquest mail a la base de dades");
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
        
        if (request.getSession().getAttribute("loginError") != null) {
            String error = (String) request.getSession().getAttribute("loginError");
            model.getModelMap().addAttribute("loginError", error);
            request.getSession().removeAttribute("loginError");
        }
        
        return model;
    }
}

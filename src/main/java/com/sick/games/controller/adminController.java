
package com.sick.games.controller;

import com.sick.games.domain.Videojoc;
import com.sick.games.service.VideojocService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adri
 */
@Controller
@RequestMapping("/admin")
public class adminController {
    
    @Autowired
    VideojocService videojocService;
    
    @RequestMapping(value = "addGame", method = RequestMethod.GET)
    public ModelAndView addGame(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {     
        ModelAndView model = new ModelAndView("addGameForm");
        Videojoc game = new Videojoc();
        model.getModelMap().addAttribute("game", game);
        return model;
    }
    
    /**
     * Rep l'objecte vinculat al formulari model vinculat amb spring i l'afegeix a la BD
     * @param newGame
     * @return L'URL del nou objecte creat
     */
    @RequestMapping(value = "addGame", method = RequestMethod.POST)
    public String processAddGameForm(@ModelAttribute("game") Videojoc newGame) {
        videojocService.addVideojoc(newGame);
        return "redirect:/product?id=" + newGame.getCodi_Joc();
    }
}
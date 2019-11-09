package com.sick.games.controller;

import com.sick.games.domain.Videojoc;
import com.sick.games.service.CodiService;
import com.sick.games.service.VideojocService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

    @Autowired
    CodiService codiService;

    @RequestMapping(value = "addGame", method = RequestMethod.GET)
    public ModelAndView addGame(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("addGameForm");
        Videojoc game = new Videojoc();
        model.getModelMap().addAttribute("game", game);
        return model;
    }

    @RequestMapping(value = "addGame", method = RequestMethod.POST)
    public String processAddGameForm(@ModelAttribute("game") Videojoc newGame,
            @RequestParam("file") MultipartFile file, HttpServletRequest request,
            HttpServletResponse response) {

        // Add game to DB
        newGame.setCodi_Joc(videojocService.getMaxID() + 1);
        videojocService.addGame(newGame);

        // Obtenim la imatge i la guardem al servidor
        try {
            byte[] bytes = file.getBytes();
            String rootPath = request.getServletContext().getRealPath("WEB-INF/resources/img/portades");
            File pathFile = new File(rootPath + File.separator + file.getOriginalFilename());
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(pathFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            System.out.println("Error al carregar la imatge: " + e.getMessage());
        }

        return "redirect:/product/noStock?id=" + newGame.getCodi_Joc();
    }

    // UPDATE GAME CREATE NEW MODEL ATTRIBUTE
    @RequestMapping(value = "updateGame", method = RequestMethod.GET)
    public ModelAndView updateGame(@RequestParam("id") int codi, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("updateGameForm");
        Videojoc game = videojocService.getGameByCode(codi);
        model.getModelMap().addAttribute("game", game);
        return model;
    }

    // UPDATE GAME RECEIVE MODEL ATTRIBUTE FORM
    @RequestMapping(value = "updateGame", method = RequestMethod.POST)
    public String processUpdateGameForm(@ModelAttribute("game") Videojoc newGame,
            @RequestParam("file") MultipartFile file, HttpServletRequest request,
            HttpServletResponse response) {

        // Update Game
        videojocService.updateGame(newGame);

        // Obtenim la imatge i la guardem al servidor
        try {
            byte[] bytes = file.getBytes();
            String rootPath = request.getServletContext().getRealPath("WEB-INF/resources/img/portades");
            File pathFile = new File(rootPath + File.separator + file.getOriginalFilename());
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(pathFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            System.out.println("Error al carregar la imatge: " + e.getMessage());
        }

        long stock = codiService.getTotalCodisByJoc(newGame.getCodi_Joc());
        if (stock == 0) {
            return "redirect:/product/noStock?id=" + newGame.getCodi_Joc();
        }

        return "redirect:/product?id=" + newGame.getCodi_Joc();
    }
}

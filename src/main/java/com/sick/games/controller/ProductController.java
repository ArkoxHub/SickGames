/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.controller;

import com.sick.games.service.CodiService;
import com.sick.games.service.VideojocService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adri
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    VideojocService videojocService;

    @Autowired
    CodiService codiService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView product(@RequestParam(name = "id") String codi, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codi_Joc = Integer.parseInt(codi);
        ModelAndView model = new ModelAndView("product");
        model.getModelMap().addAttribute("joc", videojocService.getGameByCode(codi_Joc));
        model.getModelMap().addAttribute("codi", codiService.getNextCodeByCodiJoc(codi_Joc));
        model.getModelMap().addAttribute("stock", codiService.getTotalCodisByJoc(codi_Joc));
        return model;
    }

    @RequestMapping(value = "/noStock" ,method = RequestMethod.GET)
    public ModelAndView videoJocInfo(@RequestParam(name = "id") String codi, 
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codi_Joc = Integer.parseInt(codi);
        ModelAndView model = new ModelAndView("productNoStock");
        model.getModelMap().addAttribute("joc", videojocService.getGameByCode(codi_Joc));
        return model;
    }
}

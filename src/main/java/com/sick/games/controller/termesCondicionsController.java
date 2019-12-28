/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Kevin-PC
 */
@Controller
@RequestMapping("/termes-i-condicions")
public class termesCondicionsController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initTermes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("termes-i-condicions");
        return model;
    }
}
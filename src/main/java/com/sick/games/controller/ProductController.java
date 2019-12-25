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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adri
 * @version 1.0
 * Controlador encarregat de tractar totes les peticions que tenen a veure en 
 * llistar un producte.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    VideojocService videojocService;

    @Autowired
    CodiService codiService;

    @Autowired
    UsersService usersService;

    /**
     * Mètode que rep les peticions que es fan a www.sickgames.com?id=codiJoc
     * Donat el codi d'un joc, consulta a la base de dades el joc, el seu pròxim
     * codi més barat i l'stock i els adjunta com a atributs al model de resposta.
     * 
     * Es comprova que l'usuari que fa la consulta sigui una persona existent
     * consultant la base de dades a través de les Cookies. Si existeix l'adjuntem
     * al model de resposta per si vol afegir el producte a la WishList.
     * @param codi paràmetre URL que identifica el videojoc amb el seu codi
     * @param request
     * @param response
     * @return product.jsp
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView product(@RequestParam(name = "id") String codi, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Afegim informació sobre el joc que vol consultar a la vista (El joc, el seu pròxim codi i l'stock)
        int codi_Joc = Integer.parseInt(codi);
        ModelAndView model = new ModelAndView("product");
        model.getModelMap().addAttribute("joc", videojocService.getGameByCode(codi_Joc));
        model.getModelMap().addAttribute("codi", codiService.getNextCodeByCodiJoc(codi_Joc));
        model.getModelMap().addAttribute("stock", codiService.getTotalCodisByJoc(codi_Joc));

        // Iniciem la variable de sessio carro si no ho està
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

        // Mirem si esta loguejat, si ho està retornem a la vista l'usuari (s'usa pel Wishlist)
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

        return model;
    }

    /**
     * Aquest mètode és un prototip. S'ha de millorar.
     * Al un joc des de la pantalla administrador, aquest inicialment no té cap
     * codi, per lo tant, es retorna automàticament aquest mètode sense stock.
     * @param codi
     * @param request
     * @param response
     * @return productNoStock.jsp
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/noStock", method = RequestMethod.GET)
    public ModelAndView videoJocInfo(@RequestParam(name = "id") String codi,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Iniciem la variable de sessio carro si no ho està
        if (request.getSession().getAttribute("carro") == null) {
            List<Videojoc> carro = new ArrayList();
            request.getSession().setAttribute("carro", carro);
        }

        int codi_Joc = Integer.parseInt(codi);
        ModelAndView model = new ModelAndView("productNoStock");
        model.getModelMap().addAttribute("joc", videojocService.getGameByCode(codi_Joc));
        return model;
    }
}

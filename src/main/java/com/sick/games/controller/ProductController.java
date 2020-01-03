/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.controller;

import com.sick.games.domain.Client;
import com.sick.games.domain.Codi;
import com.sick.games.domain.Detall;
import com.sick.games.domain.Ressenya;
import com.sick.games.domain.User;
import com.sick.games.domain.Videojoc;
import com.sick.games.service.CodiService;
import com.sick.games.service.DetallService;
import com.sick.games.service.RessenyaService;
import com.sick.games.service.UsersService;
import com.sick.games.service.VideojocService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
 * @version 1.0 Controlador encarregat de tractar totes les peticions que tenen
 * a veure en llistar un producte.
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

    @Autowired
    DetallService detallService;

    @Autowired
    RessenyaService ressenyaService;

    /**
     * Mètode que rep les peticions que es fan a www.sickgames.com?id=codiJoc
     * Donat el codi d'un joc, consulta a la base de dades el joc, el seu pròxim
     * codi més barat i l'stock i els adjunta com a atributs al model de
     * resposta.
     *
     * Es comprova que l'usuari que fa la consulta sigui una persona existent
     * consultant la base de dades a través de les Cookies. Si existeix
     * l'adjuntem al model de resposta per si vol afegir el producte a la
     * WishList.
     *
     * Es mira si l'usuari pot o no comentar aquest joc.
     *
     * Carrega tots els comentaris que té aquest videojoc a la vista
     *
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
        Videojoc videojoc = videojocService.getGameByCode(codi_Joc);
        model.getModelMap().addAttribute("joc", videojoc);
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

        /**
         * Mira si la persona que ha fet la petició a la visualització d'aquest
         * videojoc pot o no comentar (si l'ha comprat i no ha comentat abans
         * aquest: podrà,sino no
         */
        boolean trobat = false;
        if (user != null) {
            List<Ressenya> ressenyes = ressenyaService.getRessenyesByUser(user.getId_Usuari());
            for (Ressenya ressenya : ressenyes) {
                if (ressenya.getCodi_Vdeojoc() == codi_Joc) {
                    trobat = true;
                }
            }
        }

        /**
         * Si l'usuari no és null, es instància de client i no ha escrit cap comentari
         * d'aquest videojoc, li activem la possibilitat de fer-ho
         */
        if (user != null && user instanceof Client && !trobat) {
            List<Detall> detalls = detallService.getDetallsByCodiClient(user.getId_Usuari());

            for (Detall detall : detalls) {
                if (detall.getCodi_Joc() == videojoc.getCodi_Joc()) {
                    model.getModelMap().addAttribute("comment", "yes");
                }
            }
        }

        // Carrega tots els comentaris que té aquest joc i els retorna a la vista
        List<Ressenya> comentaris = ressenyaService.getRessenyesByJoc(codi_Joc);
        model.getModelMap().addAttribute("comentaris", comentaris);
        
        return model;
    }

    /**
     * Rep el formulari que fa un client quan comenta un videojoc que ha comprat
     * i rep tots els paràmetres que ha introduït més els ocults per tal
     * d'afegir les dades a la base de dades - Taula Ressenya
     * 
     * Se li sumen 2 punts a l'usuari
     *
     * @param request
     * @param response
     * @param comentari text del comentari
     * @param estrelles puntuació del 1 al 5 sobre el joc
     * @param id_Usuari id de l'usuari client
     * @param email email de l'usuari client
     * @param nickname nick de l'usuari client
     * @param codi_Joc codi del joc que està valorant
     * @return redirecció a la mateixa pàgina
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String saveComment(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(name = "comentari") String comentari,
            @RequestParam(name = "estrelles") int estrelles,
            @RequestParam(name = "id_Usuari") int id_Usuari,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "nickname") String nickname,
            @RequestParam(name = "codi_Joc") int codi_Joc)
            throws ServletException, IOException {

        Ressenya ressenya = new Ressenya();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        ressenya.setComentari(comentari);
        ressenya.setEstrelles(estrelles);
        ressenya.setData_Publicacio(date);
        ressenya.setCodi_Videojoc(codi_Joc);
        ressenya.setCodi_Usuari(id_Usuari);
        ressenya.setNickname(nickname);

        ressenyaService.addRessenya(ressenya);

        // Sumem 2 punts a l'usuari client
        Client client = usersService.getClientByEmail(email);
        client.setPunts(client.getPunts() + 2);
        usersService.updateClient(client);

        return "redirect:/product?id=" + codi_Joc;
    }

}

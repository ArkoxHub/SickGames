/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.controller;

import com.sick.games.domain.Codi;
import com.sick.games.domain.User;
import com.sick.games.domain.Videojoc;
import com.sick.games.domain.Wishlist;
import com.sick.games.service.CodiService;
import com.sick.games.service.UsersService;
import com.sick.games.service.VideojocService;
import com.sick.games.service.WishlistService;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

    @Autowired
    VideojocService videojocSercice;

    @Autowired
    CodiService codiService;

    @Autowired
    WishlistService wishlistService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView userMainPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("user");

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

        // Obtenim l'objecte Usuari de les cookies | Ha fet el login abans d'entrar aquí!
        User user = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userNick")) {
                // Add user to Model Response
                user = usersService.getUserByNick(cookie.getValue());
                model.getModelMap().addAttribute("user", user);
            }
        }

        // Carreguem el Wishlist
        List<Videojoc> wishlistgames = new ArrayList();
        List<Codi> wishlidtCodes = new ArrayList();
        for (Wishlist list : wishlistService.getWishlistByUserId(user.getId_Usuari())) {
            wishlistgames.add(videojocSercice.getGameByCode(list.getCodi_Joc()));
            wishlidtCodes.add(codiService.getNextCodeByCodiJoc(list.getCodi_Joc()));
        }
        model.getModelMap().addAttribute("wishlistgames", wishlistgames);
        model.getModelMap().addAttribute("wishlistcodes", wishlidtCodes);

        return model;
    }

    // Quan l'usuari prem sobre "Nou Usuari" li retornem la vista per a que ompli el formulari
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

        // Afegim les 3 cookies per a una navegació més cómode a l'usuari
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
     * Quan l'usuari prem sobre "Tancar sessió" li eliminem totes les cookies
     * referents a sickgames i el valor de les variables de sessió referents al
     * carro de compra.
     *
     * @param request
     * @param response
     * @return redirecció a la pàgina d'inici
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

        // Esborrem la variable de sessio carro, l'usuari perdrà tot el carro
        if (request.getSession().getAttribute("carro") != null) {
            request.getSession().removeAttribute("carro");
        }
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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGameCar(@RequestParam(name = "jocId") String jocId, @RequestParam(name = "nickname") String nickname,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            User user = usersService.getUserByNick(nickname);

            // CARRO DE COMPRA USING SESSION ATTRIBUTES
            List<Videojoc> carro = (List<Videojoc>) request.getSession().getAttribute("carro");
            carro.add(videojocSercice.getGameByCode(Integer.parseInt(jocId)));
            request.getSession().setAttribute("carro", carro);

        } catch (NullPointerException e) {
            System.out.println("Aquest usuari no està a la base de dades");
        }

        return "redirect:/user";
    }

    @RequestMapping(value = "/addWishlist", method = RequestMethod.GET)
    public String addGameWishlist(@RequestParam(name = "item") String jocId,
            @RequestParam(name = "nickname") String nickname,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = usersService.getUserByNick(nickname);
        Wishlist wishlist = new Wishlist();
        wishlist.setCodi_Joc(Integer.parseInt(jocId));
        wishlist.setId_Usuari(user.getId_Usuari());

        try {
            wishlistService.addWishlist(wishlist);
            throw new SQLIntegrityConstraintViolationException();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error intern, torna a intentar-ho si us plau.");
        }

        return "redirect:/user";
    }

    @RequestMapping(value = "/removeWishlist", method = RequestMethod.GET)
    public String removeGameWishlist(@RequestParam(name = "item") String jocId,
            @RequestParam(name = "nickname") String nickname,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = usersService.getUserByNick(nickname);
        List<Wishlist> wishlist = wishlistService.getWishlistByUserId(user.getId_Usuari());
        for (Wishlist item : wishlist) {
            if (item.getCodi_Joc() == Integer.parseInt(jocId)) {
                wishlistService.removeWishlist(item);
            }
        }
        
        return "redirect:/user";
    }
}

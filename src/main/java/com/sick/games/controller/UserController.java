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

    /**
     * - Es crea la variable de sessio carro que guardarà objectes Videojoc -
     * Paral·lelament es crea un Arralist de carros que contindrà en el mateix
     * ordre que els videojocs, el següent codi disponible a la venta. - Llegin
     * els valors de les cookies per obtenir les seves dades - Carreguem de la
     * base de dades la wishlist de l'usuari i instanciem els valors a les
     * llistes wishlistgames, wishlistcodes.
     *
     * @param request
     * @param response
     * @return s'adjunta al model les variables "carro", "codis, "user",
     * "wishlistgames", "wishlistcodes"
     * @throws ServletException
     * @throws IOException
     */
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
     * Rep el formulari empleat per l'usuari per a fer LOG IN Comprova si la
     * password introduida per l'usuari coincideix amb la del usuari de la base
     * de dades Crea les cookies si no ho estàn per tal d'indentificar-lo i fer
     * una navegació millor (UX)
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

    /**
     * Afegeix un joc a la variable llista sessió "carro"
     *
     * @param jocId id del joc
     * @param nickname nickname de l'usuari
     * @param request
     * @param response
     * @return redirecció a pàgina principal o bé perfil d'usuari
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGameCar(@RequestParam(name = "jocId") String jocId, @RequestParam(name = "nickname") String nickname,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Es comprova que l'usuari existeixi a la base de dades
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

    /**
     * Elimina el joc de la variable llista carro Si es prem eliminar des de la
     * pàgina de perfil d'usuari, farà redirect a aquesta secció. En canvi, si
     * es fa des de el carro, farà redirect a l'inici (que és on se suposa que
     * està en aquest moment)
     *
     * @param jocId id del joc
     * @param nickname nickname de l'usuari
     * @param request
     * @param response
     * @return redirecció a pàgina principal o bé perfil d'usuari
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeGameCar(@RequestParam(name = "item") int jocId, @RequestParam(name = "nickname") String nickname,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String redirect = "redirect:/user";
        if (request.getRequestURI() != redirect) {
            redirect = "redirect:/";
        }

        try {
            // Es comprova que l'usuari existeixi a la base de dades
            User user = usersService.getUserByNick(nickname);

            // CARRO DE COMPRA USING SESSION ATTRIBUTES
            List<Videojoc> carro = (List<Videojoc>) request.getSession().getAttribute("carro");

            for (Videojoc joc : carro) {
                if (joc.getCodi_Joc() == jocId) {
                    carro.remove(joc);
                    break;
                }
            }

            request.getSession().setAttribute("carro", carro);

        } catch (NullPointerException e) {
            System.out.println("Aquest usuari no està a la base de dades");
        }

        return redirect;
    }

    /**
     * Afegeix un joc a la base de dades amb les dades de l'usuari i el joc
     * concret
     *
     * @param jocId id del joc
     * @param nickname nickname de l'usuari
     * @param request
     * @param response
     * @return redirecció pàgina perfil d'usuari
     * @throws ServletException
     * @throws IOException
     */
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

    /**
     * Elimina el joc passat per la URL de la base de dades de l'usuari concret
     *
     * @param jocId id del joc
     * @param nickname nickanem de l'usuari
     * @param request
     * @param response
     * @return redirecció a la pàgina perfil de l'usuari
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/removeWishlist", method = RequestMethod.GET)
    public String removeGameWishlist(@RequestParam(name = "item") String jocId,
            @RequestParam(name = "nickname") String nickname,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int codi_Joc = Integer.parseInt(jocId);

        User user = usersService.getUserByNick(nickname);
        List<Wishlist> wishlist = wishlistService.getWishlistByUserId(user.getId_Usuari());
        for (Wishlist item : wishlist) {
            if (item.getCodi_Joc() == codi_Joc) {
                wishlistService.removeWishlist(item);
            }
        }

        return "redirect:/user";
    }

    //Llista productes comprats
    @RequestMapping(value = "/comandes", method = RequestMethod.GET)
    public ModelAndView comandes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("comandes");

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

        return model;
    }

    //Realitzar pagament
    @RequestMapping(value = "/buyout", method = RequestMethod.GET)
    public ModelAndView realitzarPagament(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double total = 0;
        ModelAndView model = new ModelAndView("realitzarPagament");

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

        // Obtenim els items del carro de l'usuari i els punts que guanyarà
        List<Videojoc> videojocs = new ArrayList();
        if (request.getSession().getAttribute("carro") != null) {
            videojocs = (List<Videojoc>) request.getSession().getAttribute("carro");

            // Obtenim els codis de cada joc
            List<Codi> codis = new ArrayList();
            for (Videojoc joc : videojocs) {
                Codi codi = codiService.getNextCodeByCodiJoc(joc.getCodi_Joc());
                codis.add(codi);
                total += codi.getPreu();
            }

            // Càlcul dels punts guanyats per la transició
            int punts = 0;
            if (total >= 60) {
                punts = 30;
            } else if (total >= 40) {
                punts = 10;
            } else if (total >= 20) {
                punts = 5;
            } else if (total >= 5) {
                punts = 2;
            }

            model.getModelMap().addAttribute("carro", videojocs);
            model.getModelMap().addAttribute("codis", codis);
            model.getModelMap().addAttribute("total", total);
            model.getModelMap().addAttribute("punts", punts);
        }

        return model;
    }

    @RequestMapping(value = "/buyout", method = RequestMethod.POST)
    public String finalitzarPagament(@RequestParam("punts") int punts, @RequestParam("factura") double factura)
            throws ServletException, IOException {
        System.out.println("PUNTTTTTS" + punts);
        System.out.println("A PAGAR NINIO" + factura);
        return "redirect:/user/comandes";
    }

}

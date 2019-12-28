/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.controller;

import com.sick.games.domain.Client;
import com.sick.games.domain.Codi;
import com.sick.games.domain.Comanda;
import com.sick.games.domain.Detall;
import com.sick.games.domain.User;
import com.sick.games.domain.Videojoc;
import com.sick.games.domain.Wishlist;
import com.sick.games.service.CodiService;
import com.sick.games.service.ComandaService;
import com.sick.games.service.DetallService;
import com.sick.games.service.UsersService;
import com.sick.games.service.VideojocService;
import com.sick.games.service.WishlistService;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Adri
 * @version 1.0 Controladir principal de rebre i gestionar totes les peticions
 * que fem sobre l'URL www.sickgames.com/user... i que tenen a veure amb
 * l'usuari client de la web
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

    @Autowired
    ComandaService comandaService;

    @Autowired
    DetallService detallService;

    /**
     * - Es crea la variable de sessio carro que guardarà objectes Videojoc -
     * Paral·lelament es crea un Arraylist de codis que contindrà en el mateix
     * ordre que els videojocs, el següent codi disponible a la venta.
     *
     * Llegeix els valors de les cookies per obtenir els credencials de l'usuari
     * i carregar-lo sobre el model si existeix.
     *
     * Es carrega de la base de dades la wishlist de l'usuari i instanciem els
     * valors a les llistes wishlistgames, wishlistcodes.
     *
     * @param request
     * @param response
     * @return s'adjunta al model les variables "carro", "codis, "user",
     * "wishlistgames", "wishlistcodes" i retorna user.jsp
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

    /**
     * Aquest mètode té com a objectiu retornar la vista que mostra el formulari
     * que ha d'omplir l'usuari per tal de d'enregistrar-se a la web. Adjunta un
     * objecte user buit al model.
     *
     * @param request
     * @param response
     * @return signIn.jsp
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ModelAndView userRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        ModelAndView model = new ModelAndView("signIn");
        model.getModelMap().addAttribute("user", user);
        return model;
    }

    /**
     * Mètode que escolta els formularis d'enregistrament d'un usuari nou
     * mitjançant POST.
     *
     * Afegeix la data actual a l'objecte user en el moment d'enviar el
     * formulari.
     *
     * Al crear l'usuari, afegeix les 3 cookies prinipals de sickgames, que són:
     * - userMail: emmagatzema el email de l'usuari. - userNick: emmagatzema el
     * nickname unívoc de l'usuari. - userPwd: emmagatzema el password de
     * l'usuari.
     *
     * @param newUser Objecte user amb les dades introduides per l'usuari.
     * @param request
     * @param response
     * @return redirecció a l'index de la pàgina web
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String userSignIn(@ModelAttribute("user") User newUser, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Afegim a l'usuari la data d'alta equivalent al moment de crear-la.
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        newUser.setData_Alta(date);
        
        // Encriptació password usuari
        String password = newUser.getContrasenya();
        password = DigestUtils.md5Hex(password);
        newUser.setContrasenya(password);
        
        // Afegim l'usuari a la base de dades
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
     * @return redirecció a l'index de la pàgina web
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
     * Rep el formulari empleat per l'usuari per a fer LOG IN method POST.
     * Comprova si la password introduida per l'usuari coincideix amb la del
     * usuari de la base de dades.
     *
     * Crea les cookies si no ho estàn per tal d'indentificar-lo i fer una
     * navegació millor (UX)
     *
     * @param userNick Nickname de l'usuari (input)
     * @param userPwd Password de l'usuari (input)
     * @param request
     * @param response
     * @return redirecció a l'index
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(@RequestParam(name = "nickname") String userNick,
            @RequestParam(name = "password") String userPwd,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.removeAttribute("loginError");

        try {

            User user = usersService.getUserByNick(userNick);

            if (user != null) {
                userPwd = DigestUtils.md5Hex(userPwd);
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
                    request.getSession().removeAttribute("loginError");
                } else {
                    System.out.println("LA CONTRASEÑA NO COINCIDEIX");
                    request.getSession().setAttribute("loginError", "password");
                }
            } else {
                System.out.println("USUARI NO TROBAT A LA BBDD");
                request.getSession().setAttribute("loginError", "user");
            }
        } catch (Error e) {
            System.out.println("ERROR " + e.getMessage());
        }

        return "redirect:/";
    }

    /**
     * Afegeix un joc a l'atribut de sessió "carro" i retorna la llista
     * modificada.
     *
     * @param jocId id del videojoc
     * @param nickname Nickname de l'usuari
     * @param request
     * @param response
     * @return redirecció a www.sickgames.com/user
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
     * Elimina el joc de l'atribut de sessió carro i retorna la llista
     * modificada. Si es prem eliminar des de la pàgina de perfil d'usuari, farà
     * redirect a aquesta secció. En canvi, si es fa des de el carro, farà
     * redirect a l'inici.
     *
     * @param jocId id del joc
     * @param nickname Nickname de l'usuari
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
     * Mètode que afegeix videojocs a la taula Wishlist de la base de dades fent
     * referència a l'usuari que ha realitzat la petició.
     *
     * @param jocId id del Videojoc
     * @param nickname Nickname de l'usuari
     * @param request
     * @param response
     * @return redirecció a www.sickgames.com/user
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/addWishlist", method = RequestMethod.GET)
    public String addGameWishlist(@RequestParam(name = "item") String jocId,
            @RequestParam(name = "nickname") String nickname,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            // Obteinim l'usuari que fa la petició de la base de dades
            User user = usersService.getUserByNick(nickname);
            // Es crea l'objecte Wishlist amb els valor codiJoc i idUsuari.
            Wishlist wishlist = new Wishlist();
            wishlist.setCodi_Joc(Integer.parseInt(jocId));
            wishlist.setId_Usuari(user.getId_Usuari());

            wishlistService.addWishlist(wishlist);

        } catch (NullPointerException ex) {
            System.out.println("Usuari no existent a la base de dades" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error intern, torna a intentar-ho si us plau." + ex.getMessage());
        }

        return "redirect:/user";
    }

    /**
     * Elimina el videojoc de la taula Wishlist de l'usuari
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

        try {
            User user = usersService.getUserByNick(nickname);
            List<Wishlist> wishlist = wishlistService.getWishlistByUserId(user.getId_Usuari());
            for (Wishlist item : wishlist) {
                if (item.getCodi_Joc() == codi_Joc) {
                    wishlistService.removeWishlist(item);
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("No s'ha trobat cap usuari a la base de dades" + ex.getMessage());
        }

        return "redirect:/user";
    }

    /**
     * Mètode encarregat d'atendre les peticions que es fan a
     * www.sickgames.com/user/comandes Obté l'usuari que fa la petició de la
     * base de dades a través de les cookies i els seus credencials (valors)
     *
     * Si aquest usuari és un usuari client, obté de la base de dades els
     * detalls de totes les comandes que ha realitzat amb el videojoc que
     * pertany. Adjunta al model l'atribut detalls, videojocs i l'usuari pel
     * nav.
     *
     * @param request
     * @param response
     * @return comandes.jsp
     * @throws ServletException
     * @throws IOException
     */
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
                if (user instanceof Client) {
                    List<Detall> detalls = detallService.getDetallsByCodiClient(user.getId_Usuari());
                    model.getModelMap().addAttribute("detalls", detalls);

                    List<Videojoc> videojocs = new ArrayList();
                    for (Detall detall : detalls) {
                        videojocs.add(videojocSercice.getGameByCode(detall.getCodi_Joc()));
                    }
                    model.getModelMap().addAttribute("videojocs", videojocs);
                }
                model.getModelMap().addAttribute("user", user);
            }
        }

        return model;
    }

    /**
     * Obté mitjançant les Cookies l'usuari de la base de dades i l'adjunta al
     * model.
     *
     * Recull l'atribut de sessió "carro" amb tots els Videjocs.
     *
     * Mitjançant consultes a la base de dades sobtenen els Codis d'aquests
     * Videojocs, i es calcula el total de la compra. A través d'aquest import
     * calculem quants punts acumularà l'usuari al realitzar aquesta transacció.
     *
     * S'adjunta els Videojocs i Codis, els punts que guanyarà i el preu total
     * de l'operació al model.
     *
     * @param request
     * @param response
     * @return realitzarPagament.jsp
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/buyout", method = RequestMethod.GET)
    public ModelAndView realitzarPagament(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double total = 0;
        ModelAndView model = new ModelAndView("realitzarPagament");
        try {
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

        } catch (Exception ex) {
            System.out.println("Hi ha hagut un error en la petició..." + ex.getMessage());
        }

        return model;
    }

    /**
     * Mètode POST que rep el formulari que ha omplert prèviament l'usuari amb
     * les seves dades bancàries.
     *
     * Accions que s'implementen en aquest mètode: 1. S'obté l'usuari que està
     * fent la compra de la base de dades a través de les cookies 2. Es comprova
     * si l'usuari és client (ja ha fet una compra anteriorment) o bé només és
     * un usuari (no ha fet cap compra) 3. Si és client, obté les seves dades
     * consultant la base de dades i modifica els punts totals tot sumant els
     * que acaba d'obtenir i torna a guardar-ho. 3.1 Si no és client, crea un
     * nou usuari client amb les seves dades d'usuari. 4. Un cop ens assegurem
     * que ja és client si o si, creem la nova comanda amb la informació
     * d'aquesta transacció i la data que s'importa la del moment de realitzar
     * la compra. 5. Es crea tot el detall de la comanda, videojoc per videojoc
     * que està adquirint l'usuari client. 6. Retirem una unitat de l'stock per
     * a cada joc comprat. 7. Buidem l'atribut de sessió "carro" per tal de
     * reinicialitzar-lo.
     *
     * @param punts punts adquirits al fer la transacció
     * @param factura import total que ha pagat l'usuari client
     * @param tarjeta nº de compte bancari
     * @param request
     * @param response
     * @return redirecció a pàgina principal.
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/buyout", method = RequestMethod.POST)
    public String finalitzarPagament(
            @RequestParam("punts") int punts,
            @RequestParam("factura") double factura,
            @RequestParam("numTarjeta") String tarjeta,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userMail")) {

                try {
                    User user = usersService.getUserByeMail(cookie.getValue());
                    if (user instanceof Client) {
                        // Client existent | Li augmentem els punts i l'actualitzem
                        Client client = usersService.getClientByEmail(cookie.getValue());
                        client.setPunts(client.getPunts() + punts);
                        usersService.updateClient(client);

                        // Nova comanda
                        Comanda comanda = new Comanda();
                        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                        comanda.setTotal(factura);
                        comanda.setData_Comanda(date);
                        comanda.setUsuari_Client(client.getId_Usuari());
                        comandaService.addComanda(comanda);

                        // Detall comanda
                        if (request.getSession().getAttribute("carro") != null) {
                            List<Videojoc> jocs = (List<Videojoc>) request.getSession().getAttribute("carro");
                            for (Videojoc joc : jocs) {
                                Codi codi = codiService.getNextCodeByCodiJoc(joc.getCodi_Joc());

                                Detall detall = new Detall();
                                detall.setCodi_Comanda(comanda.getCodi_Comanda());
                                detall.setCodi_Joc(joc.getCodi_Joc());
                                detall.setPreu(codi.getPreu());
                                detall.setSerial(codi.getSerial());
                                detall.setPlataforma(codi.getPlataforma());
                                detall.setId_Usuari(client.getId_Usuari());
                                detallService.addDetall(detall);

                                // Retirem de l'stock el codi!
                                codiService.removeCodi(codi);
                            }
                            request.getSession().removeAttribute("carro");
                        }

                    } else if (user instanceof User) {
                        // Primera compra que realitza a la web.
                        Client client = new Client(user.getId_Usuari(), punts, tarjeta, user.getId_Usuari(),
                                user.getNom(), user.getCognoms(), user.getNickname(), user.getData_Alta(),
                                user.getDireccio(), user.getEmail(), user.getContrasenya(), user.getTelefon());
                        usersService.removeUser(user);
                        usersService.addClient(client);

                        // Nova comanda
                        Comanda comanda = new Comanda();
                        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                        comanda.setTotal(factura);
                        comanda.setData_Comanda(date);
                        comanda.setUsuari_Client(client.getId_Usuari());
                        comandaService.addComanda(comanda);

                        // Detall comanda
                        if (request.getSession().getAttribute("carro") != null) {
                            List<Videojoc> jocs = (List<Videojoc>) request.getSession().getAttribute("carro");
                            for (Videojoc joc : jocs) {
                                Codi codi = codiService.getNextCodeByCodiJoc(joc.getCodi_Joc());

                                Detall detall = new Detall();
                                detall.setCodi_Comanda(comanda.getCodi_Comanda());
                                detall.setCodi_Joc(joc.getCodi_Joc());
                                detall.setPreu(codi.getPreu());
                                detall.setSerial(codi.getSerial());
                                detall.setPlataforma(codi.getPlataforma());
                                detall.setId_Usuari(client.getId_Usuari());
                                detallService.addDetall(detall);

                                // Retirem de l'stock el codi!
                                codiService.removeCodi(codi);
                            }
                            request.getSession().removeAttribute("carro");
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Error al carregar o actualitzar client " + e.getMessage());
                }
            }
        }

        return "redirect:/";

    }

}

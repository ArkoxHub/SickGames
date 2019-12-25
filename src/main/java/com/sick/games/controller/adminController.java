package com.sick.games.controller;

import com.sick.games.domain.Codi;
import com.sick.games.domain.Videojoc;
import com.sick.games.service.CodiService;
import com.sick.games.service.VideojocService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adri
 * @version 1.0
 * Controlador encarregat d'atendre a les peticions que tenen a veure amb l'administrador
 * i que correspon a totes les accions que un administrador de la web pot fer, tal
 * com accedir al menú d'administradors, CRUD de Videojocs, Codis, Usuaris...
 */
@Controller
public class adminController {

    @Autowired
    VideojocService videojocService;

    @Autowired
    CodiService codiService;

    /**
     * Mètode que s'encarrega de rebre les peticions a www.sickgames.com/admin
     * Gràcies als arxius de configuració fet a security-context.xml, aquest mètode
     * serà inaccesible fins que la persona que intenta accedir no validi els seus
     * credencials a la pàgina interceptada que correspon amb el mètode adminLogin
     * d'aquesta mateixa classe
     * @param request
     * @param response
     * @return admin.jsp
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminMainPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("admin");
        return model;
    }

    /**
     * Mètode que és interceptat per qualsevol persona que intenti accedir a
     * www.sickgames.com/admin/**.
     * Retorna un model que demanarà els credencials d'administrador per a poder 
     * accedir a la pàgina d'admin.
     * @param request
     * @param response
     * @return adminLogin.jsp
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/spring/login", method = RequestMethod.GET)
    public ModelAndView adminLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("adminLogin");
        return model;
    }

    /**
     * Aquest mètode és l'encarregat d'interceptar una petició errònea d'un intent
     * de login d'administrador incorrecte.
     * Afegeix l'atribut error = true a la resposta.
     * @param model
     * @return /spring/login per a tornar a intentar validar credencials d'admin,
     * aquest cop li mostrarà un missatge d'error
     */
    @RequestMapping(value = "/admin/loginfailed", method = RequestMethod.GET)
    public String adminLoginFailed(Model model) {
        model.addAttribute("error", "true");
        return "/adminLogin";
    }

    /**
     * Mètode encarregat de rebre les peticions a www.sickgames.com/admin/logout
     * que deslogueja a l'admin i li redirecciona a l'index.jsp
     * @param model
     * @return redirecció a index.jsp
     */
    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
    public String adminLogout(Model model) {
        return "redirect:/";
    }

    /**
     * Afegeix al l'atribut del model un objecte Videojoc buit per tal de que
     * l'usuari Administrador l'ompli.
     * @param request
     * @param response
     * @return formulari addGameForm.jsp
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/admin/addGame", method = RequestMethod.GET)
    public ModelAndView addGame(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("addGameForm");
        Videojoc game = new Videojoc();
        model.getModelMap().addAttribute("game", game);
        return model;
    }

    /**
     * Mètode que rep les dades del formulari per a crear un videojoc omplert per
     * un administrador mitjançant POST.
     * 
     * Afegeix el joc a la base de dades.
     * 
     * Obté l'imatge de l'usuari i l'emmatgatzema al servidor en el path
     * "WEB-INF/resources/img/portades" tot dibuixant la imatge en aquest path.

     * @param newGame Objecte Videojoc omplert per l'administrador
     * @param file Imatge caràtula del videojoc creat.
     * @param request
     * @param response
     * @return redirecció a la pàgina principal del producte sense stock.
     */
    @RequestMapping(value = "/admin/addGame", method = RequestMethod.POST)
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

    /**
     * Quan l'administrador vol modificar un videojoc existent, aquest mètode
     * serà l'encarregat de rebre aquesta petició.
     * Obté el joc en qüestió a través del seu ID passat per paràmetre i l'afegeix
     * a l'atribut del model que veurà en la vista formulari retornat.
     * @param codi codi del videojoc a modificar
     * @param request
     * @param response
     * @return formulare updateGameForm
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/admin/updateGame", method = RequestMethod.GET)
    public ModelAndView updateGame(@RequestParam("id") int codi, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("updateGameForm");
        Videojoc game = videojocService.getGameByCode(codi);
        model.getModelMap().addAttribute("game", game);
        return model;
    }

    /**
     * Rep el formulari d'un videojoc modificat per par de l'administrador.
     * Emmagatzema amb les noves dades el videojoc a la base de dades.
     * 
     * Realitza el tractament per guardar la imatge de la caràtula en el servidor.
     * 
     * @param newGame l'objecte videojoc modificat per l'administrador
     * @param file Imatge caràtula del joc modificat.
     * @param request
     * @param response
     * @return redirecció a la pàrgina del producte tot just modificat.
     */
    @RequestMapping(value = "/admin/updateGame", method = RequestMethod.POST)
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

    /**
     * Obté tot el llistat de jocs disponibles a la pàgina web de la base de dades
     * i l'adjunta al model.
     * Se li pot passar per URL si vol procedir a modificar o eliminar aquests jocs
     * al fer click en un d'ells.
     * @param option valor que pot variar entre "modify" o "delete"
     * @param request
     * @param response
     * @return gameList.jsp
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/admin/gameList/{option}", method = RequestMethod.GET)
    public ModelAndView listGames(@PathVariable String option, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ModelAndView model = new ModelAndView("gameList");
        model.getModelMap().addAttribute("option", option);
        model.getModelMap().addAttribute("videojocs", videojocService.getAllGames());
        return model;
    }

    /**
     * Quan l'administrador selecciona un videojoc per a ser eliminat de la llista,
     * aquest mètode s'encarrega de procedir amb aquesta petició.
     * 
     * Elimina el videojoc de la base de dades.
     * 
     * Adjunta al model la llista de tots els jocs tot just actualitzada després
     * d'eliminar el videojoc.
     * 
     * @param codi codi del videojoc a eliminar
     * @param option valor que pot variar entre "modify" o "delete"
     * @param request
     * @param response
     * @return gameList.jsp
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/admin/deleteGame/{option}", method = RequestMethod.GET)
    public ModelAndView deleteGame(@RequestParam("id") int codi,
            @PathVariable String option, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("gameList");
        videojocService.removeGame(videojocService.getGameByCode(codi));
        model.getModelMap().addAttribute("videojocs", videojocService.getAllGames());
        model.getModelMap().addAttribute("option", option);
        return model;
    }

    /**
     * Si l'administrador vol crear un joc, aquest mètode és l'encarregat de crear
     * un objecte codi nou que l'adjuntarà al model retornat per tal de que procedeixi
     * amb la escriptura de les seves dades.
     * @param request
     * @param response
     * @return addCodeForm.jsp
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/admin/addCode", method = RequestMethod.GET)
    public ModelAndView addCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("addCodeForm");
        Codi codi = new Codi();
        model.getModelMap().addAttribute("codi", codi);
        return model;
    }

    /**
     * Rep el formulari de creació d'un codi de joc nou omplert per l'administrador
     * mitjançant el mètode POST.
     * 
     * Es calcula el preu del codi mitjançant el PVP del Videojoc i el % d'Oferta
     * aplicada al codi en qüestió.
     * 
     * Es guarda el codi a la base de dades.
     * 
     * @param newCode objecte Codi omplert per l'admin
     * @param request
     * @param response
     * @return addCodeform.jsp per si vol seguir afegint codis amb el OK o ERROR
     * de com ha anat l'últim intent d'afegir un codi a la base de dades.
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/admin/addCode", method = RequestMethod.POST)
    public ModelAndView processAddCodiForm(@ModelAttribute("codi") Codi newCode,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("addCodeForm");
        String status = "";
        try {
            // Càlcul preu del codi joc
            Videojoc joc = videojocService.getGameByCode(newCode.getCodi_Joc());
            float preu = (joc.getPvp() * newCode.getOferta()) / 100;
            preu = joc.getPvp() - preu;
            preu = (float) (Math.round(preu * 100.0) / 100.0);
            newCode.setPreu(preu);

            // Per consistència en les dades, posem el Serial en majúscules
            newCode.setSerial(newCode.getSerial().toUpperCase());
            codiService.addCodi(newCode);
            status = "OK";

        } catch (ConstraintViolationException e) {
            System.out.println("Serial duplicat a la base de dades" + e);
            status = "DUPLICATE";
        } catch (Exception e) {
            System.out.println("Error al pujar el codi a la base de dades" + e);
            status = "ERROR";
        }

        model.getModelMap().addAttribute("status", status);
        return model;
    }

    /**
     * Rep la petició quan un administrador vol modificar o eliminar codis retornant
     * la vista codeList.jsp.
     * @param option valor que pot variar entre "modify" o "delete"
     * @param request
     * @param response
     * @return codeList.jsp
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/admin/codeList/{option}", method = RequestMethod.GET)
    public ModelAndView inputCode(@PathVariable String option, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ModelAndView model = new ModelAndView("codeList");
        model.getModelMap().addAttribute("option", option);
        return model;
    }

    /**
     * Rep les peticiones fetes a la vista codeList.jsp, en la que l'administrador
     * ha especificat quins codis de videojoc vol modificar o eliminar a través 
     * del codi del videojoc mitjançant mètode POST.
     * 
     * Consulta a la Base de Dades tots els codis que tenim referents al Videojoc
     * especificat. Si tenim resultat, s'afegeixen a l'atribut del model. Si no,
     * es mostra un error.
     * 
     * @param option
     * @param codi
     * @param request
     * @param response
     * @return codeList.jsp
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/admin/codeList/{option}", method = RequestMethod.POST)
    public ModelAndView listCodes(@PathVariable String option, @RequestParam("codi") int codi,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("codeList");
        List<Codi> codis = codiService.getCodisByCodiJoc(codi);
        model.getModelMap().addAttribute("codis", codis);
        model.getModelMap().addAttribute("option", option);

        if (codis.isEmpty()) {
            model.getModelMap().addAttribute("error", "No hi ha codis amb aquest codi de Videojoc");
        } else {
            model.getModelMap().addAttribute("videojoc", videojocService.getGameByCode(codi));
        }

        return model;
    }

    /**
     * Si l'administrador des codeList.jsp clica sobre un codi a modificar, aquest
     * mètode obté de la base de dades l'objecte codi en qüestió i l'adjunta al model.
     * @param codi
     * @param request
     * @param response
     * @return Formulari updateCodeForm.jsp per tal de modificar les dades del codi
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/admin/updateCode", method = RequestMethod.GET)
    public ModelAndView updateCode(@RequestParam("id") int codi, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ModelAndView model = new ModelAndView("updateCodeForm");
        model.getModelMap().addAttribute("codi", codiService.getCodi(codi));
        return model;
    }
    
    /**
     * Rep el codi modificat per part de l'admin en el formulari mitjançant POST.
     * 
     * Es calcula el preu del codi mitjançant el PVP del Videojoc i el % d'Oferta
     * aplicada al codi en qüestió.
     * 
     * S'actualitza el codi a la base de dades.
     * @param newCode
     * @param request
     * @param response
     * @return addCodeForm.jsp
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/admin/updateCode", method = RequestMethod.POST)
    public ModelAndView updateCodeForm(@ModelAttribute("codi") Codi newCode,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("addCodeForm");
        String status = "";
        try {
            // Càlcul preu del codi joc
            Videojoc joc = videojocService.getGameByCode(newCode.getCodi_Joc());
            float preu = (joc.getPvp() * newCode.getOferta()) / 100;
            preu = joc.getPvp() - preu;
            preu = (float) (Math.round(preu * 100.0) / 100.0);
            newCode.setPreu(preu);

            // Per consistència en les dades, posem el Serial en majúscules
            newCode.setSerial(newCode.getSerial().toUpperCase());
            codiService.updateCodi(newCode);
            status = "OK";

        } catch (ConstraintViolationException e) {
            System.out.println("Serial duplicat a la base de dades" + e);
            status = "DUPLICATE";
        } catch (Exception e) {
            System.out.println("Error al pujar el codi a la base de dades" + e);
            status = "ERROR";
        }

        model.getModelMap().addAttribute("status", status);
        return model;
    }
    
    /**
     * Elimina de la base de dades el codi que es rep a través de l'URL un cop
     * l'administrador fa clic sobre algun codi del llistat de codis.
     * @param option
     * @param codi Codi_ID del codi que es vol eliminar
     * @param codi_Joc Codi del Videojoc que fa referència el codi que es vol eliminar
     * @param request
     * @param response
     * @return codeList.jsp
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = "/admin/{option}/deleteCode", method = RequestMethod.GET)
    public ModelAndView deleteCode(@PathVariable String option, @RequestParam("id") int codi,
            @RequestParam("codi_Joc") int codi_Joc, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("codeList");
        String status = "";
        try {
        codiService.removeCodi(codiService.getCodi(codi));
        model.getModelMap().addAttribute("codis", codiService.getCodisByCodiJoc(codi_Joc));
        status = "Codi eliminat";
        model.getModelMap().addAttribute("status", status);
        } catch (Exception e) {
            model.getModelMap().addAttribute("error", "No s'ha pogut eliminar aquest codi");
            System.out.println("No s'ha pogut eliminar aquest codi");
        }
        
        return model;
    }

}

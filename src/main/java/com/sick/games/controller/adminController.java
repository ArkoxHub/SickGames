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
 */
@Controller
public class adminController {

    @Autowired
    VideojocService videojocService;

    @Autowired
    CodiService codiService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminMainPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("admin");
        return model;
    }

    @RequestMapping(value = "/spring/login", method = RequestMethod.GET)
    public ModelAndView adminLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("adminLogin");
        return model;
    }

    @RequestMapping(value = "/admin/loginfailed", method = RequestMethod.GET)
    public String adminLoginFailed(Model model) {
        model.addAttribute("error", "true");
        return "/adminLogin";
    }

    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
    public String adminLogout(Model model) {
        return "redirect:/";
    }

    @RequestMapping(value = "/admin/addGame", method = RequestMethod.GET)
    public ModelAndView addGame(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("addGameForm");
        Videojoc game = new Videojoc();
        model.getModelMap().addAttribute("game", game);
        return model;
    }

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

    // UPDATE GAME CREATE NEW MODEL ATTRIBUTE
    @RequestMapping(value = "/admin/updateGame", method = RequestMethod.GET)
    public ModelAndView updateGame(@RequestParam("id") int codi, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("updateGameForm");
        Videojoc game = videojocService.getGameByCode(codi);
        model.getModelMap().addAttribute("game", game);
        return model;
    }

    // UPDATE GAME RECEIVE MODEL ATTRIBUTE FORM
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

    @RequestMapping(value = "/admin/gameList/{option}", method = RequestMethod.GET)
    public ModelAndView listGames(@PathVariable String option, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ModelAndView model = new ModelAndView("gameList");
        model.getModelMap().addAttribute("option", option);
        model.getModelMap().addAttribute("videojocs", videojocService.getAllGames());
        return model;
    }

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

    // CODE ADMIN FUNCTIONS:
    @RequestMapping(value = "/admin/addCode", method = RequestMethod.GET)
    public ModelAndView addCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView model = new ModelAndView("addCodeForm");
        Codi codi = new Codi();
        model.getModelMap().addAttribute("codi", codi);
        return model;
    }

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

    @RequestMapping(value = "/admin/codeList/{option}", method = RequestMethod.GET)
    public ModelAndView inputCode(@PathVariable String option, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ModelAndView model = new ModelAndView("codeList");
        model.getModelMap().addAttribute("option", option);
        return model;
    }

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

    @RequestMapping(value = "/admin/updateCode", method = RequestMethod.GET)
    public ModelAndView updateCode(@RequestParam("id") int codi, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ModelAndView model = new ModelAndView("updateCodeForm");
        model.getModelMap().addAttribute("codi", codiService.getCodi(codi));
        return model;
    }
    
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

<%-- 
    Document   : updateGameForm
    Created on : 27-oct-2019, 01:31:59
    Author     : Adri
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulari addGame</title>
        <!--WebIcon-->
        <link rel="icon" href="<c:url value="/resources/img/logo_icon.png"/>" alt="Favicon">
        <!--My css-->
        <link href="<c:url value="/resources/css/afegirJoc.css"/>" rel="stylesheet" type="text/css"/>
        <!--FontsGoogle-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="true">
        <link href="https://fonts.googleapis.com/css?family=Archivo&display=swap" rel="stylesheet">
        <!--Jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <!--My javascript-->
        <script src="<c:url value="/resources/js/afegirJoc.js"/>" type="text/javascript" ></script>
    </head>
    <body>

        <!-- Hidden by default -->
        <div class="helpForm1">
            <h4>Valors vàlits pel camp "IDIOMA"</h4>
            <li>ESP - ESPANYOL</li>
            <li>ENG - ANGLÈS</li>
            <li>ALM - ALEMANY</li>
            <li>FR  - FRANCÉS</li>
            <li>ITL - ITALIÀ</li>
            <li>JPN - JAPONÉS</li>
            <li>Multillengua</li>
        </div>

        <!-- Hidden by default -->
        <div class="helpForm2">
            <h4>Generes pel camp "Gèneres"</h4>
            <li>FPS</li>
            <li>RPG</li>
            <li>MMO</li>
            <li>Acció</li>
            <li>Deportiu</li>
            <li>Aventura</li>
            <li>Construcció</li>
            <li>Conducció</li>
            <li>Cooperació</li>
            <li>Plataforma</li>
            <li>Simulador</li>
            <li>Survival</li>
            <li>Gestió</li>
            <li>Estratègia</li>
            <li>Indies</li>
            <li>Lluita</li>
            <li>SinglePlayer</li>
            <li>Multijugador</li>       
        </div>

        <div class="wrap">
            
            <h2 class="center">Formulari per afegir joc a la Base de Dades</h2>
            <form:form modelAttribute="game" id="form" method="post" onsubmit="return validacio();" enctype="multipart/form-data">
                <label for="codi_Joc"></label>
                <form:input path="codi_Joc" style="display:none" type="number" class="form-control" id="codi_Joc" name="codi_Joc" placeholder="Codi del joc"/>
                
                <label for="nom">Nom</label><br>
                <form:input path="nom" type="text" maxlength="50" class="form-control" id="nom" name="nom" placeholder="Nom del joc"/>

                <label for="data_Llançament">Data de llançament</label>
                <form:input path="data_Llançament" type="date" class="form-control" id="data_Llançament" name="data_Llançament"/>

                <label for="pvp">Preu de Venta al públic</label>
                <form:input path="pvp" type="number" step="0.01" class="form-control" id="pvp" name="pvp" placeholder="Preu en €"/>

                <label for="idioma">Idioma</label>
                <form:input path="idioma" type="text" maxlength="50" class="form-control" id="idioma" name="idioma" placeholder="ESP | ENG | ALM | ITL | FR"/>
                
                <label for="generes">Gèneres</label>
                <form:input path="generes" type="text" maxlength="100" class="form-control" id="generes" name="generes" placeholder="Acció, Aventures, MMO, RPG, FPS..."/>

                <label for="descripcio">Descripció</label>
                <form:textarea path="descripcio"  class="form-control" id="descripcio" name="descripcio" placeholder="El mon necesita herois..."/>

                <label for="logo">Imatge portada</label>
                <input type="file" name="file" id="logo" class="form-control" onchange="loadFile(event)" accept="jpg">
                <img id="preview" style="max-width: 100%"/>

                <input type="submit" id="submit" class="btn btn-primary" value="Actualitzar Videojoc">
                <a class="btn btn-primary" id="back" href="<c:url value="/"/>">Cancel·lar</a>
            </form:form>
                
        </div>
    </body>
</html>

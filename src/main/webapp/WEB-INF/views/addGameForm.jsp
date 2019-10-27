<%-- 
    Document   : agregarjuego
    Created on : 24-oct-2019, 15:27:31
    Author     : Kevin
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
            <h4>Codis vàlits pel camp "PLATAFORMA"</h4>
            <li>1 - Battle.Net</li>
            <li>2 - Steam</li>
            <li>3 - Uplay</li>
            <li>4 - Origin</li>
            <li>5 - Nintendo</li>
            <li>6 - XBOX</li>
            <li>7 - PlayStation</li>
            <li>8 - Rockstar</li>
            <li>9 - GOG</li>
            <li>10 - Microsoft</li>
            <li>11 - Mac</li>
            <li>12 - Epic Games</li>
        </div>

        <div class="wrap">
            
            <h2 class="center">Formulari per afegir joc a la Base de Dades</h2>
            <form:form modelAttribute="game" id="form" method="post" onsubmit="return validacio();" enctype="multipart/form-data">
                <label for="nom">Nom</label><br>
                <form:input path="nom" type="text" maxlength="50" class="form-control" id="nom" name="nom" placeholder="Nom del joc"/>

                <label for="data_Llançament">Data de llançament</label>
                <form:input path="data_Llançament" type="date" class="form-control" id="data_Llançament" name="data_Llançament"/>

                <label for="preu">Preu</label>
                <form:input path="preu" type="number" step="0.01" class="form-control" id="preu" name="preu" placeholder="Preu en €"/>

                <label for="idioma">Idioma</label>
                <form:input path="idioma" type="text" maxlength="50" class="form-control" id="idioma" name="idioma" placeholder="ESP | ENG | ALM | ITL | FR"/>

                <label for="oferta">Oferta</label>
                <form:input path="oferta" type="number" step="0.1" class="form-control" id="oferta" name="oferta" max="99" placeholder="Oferta %"/>

                <label for="qty_Available">Stock</label>
                <form:input path="qty_Available" type="number" class="form-control" id="qty_Available" name="qty_Available" placeholder="Quantiat inicial en Stock"/>

                <label for="plataforma">Plataforma</label>
                <form:input path="plataforma" type="number" class="form-control" id="plataforma" name="plataforma" min="1" max="12" placeholder="Codi de la plataforma"/>

                <label for="descripcio">Descripció</label>
                <form:textarea path="descripcio"  class="form-control" id="descripcio" name="descripcio" placeholder="El mon necesita herois..."/>

                <label for="logo">Imatge portada</label>
                <input type="file" name="file" id="logo" class="form-control" onchange="loadFile(event)" accept="jpg">
                <img id="preview" style="max-width: 100%"/>

                <input type="submit" id="submit" class="btn btn-primary" value="Crear Videojoc">
                <a class="btn btn-primary" id="back" href="<c:url value="/"/>">Cancel·lar</a>
            </form:form>
                
        </div>
    </body>
</html>
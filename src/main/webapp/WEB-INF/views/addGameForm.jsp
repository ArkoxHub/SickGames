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
        <div class="wrap">
            <a class="btn btn-primary" href="<c:url value="/"/>">Tornar a la web</a>
            <form:form modelAttribute="game" id="form" method="post" onsubmit="return validacio();">
                <label for="codi_Joc">Codi del joc</label><br>
                <form:input path="codi_Joc" type="number" class="form-control" id="codi_Joc" name="codi_Joc" placeholder="Introdueix el codi"/>
                
                <label for="nom">Nom</label><br>
                <form:input path="nom" type="text" maxlength="50" class="form-control" id="nom" name="nom" placeholder="Nom del joc"/>
                
                <label for="data_Llançament">Data de llançament</label>
                <form:input path="data_Llançament" type="date" class="form-control" id="data_Llançament" name="data_Llançament"/>

                <label for="preu">Preu</label>
                <form:input path="preu" type="number" step="0.01" class="form-control" id="preu" name="preu" placeholder="5%, 10%, 15%..."/>

                <label for="idioma">Idioma</label>
                <form:input path="idioma" type="text" maxlength="50" class="form-control" id="idioma" name="idioma" placeholder="ESP ENG ALM"/>

                <label for="oferta">Oferta</label>
                <form:input path="oferta" type="number" step="0.1" class="form-control" id="oferta" name="oferta" placeholder="Oferta %"/>

                <label for="qty_Available">Stock</label>
                <form:input path="qty_Available" type="number" class="form-control" id="qty_Available" name="qty_Available" placeholder="Quantiat inicial en Stock"/>

                <label for="plataforma">Plataforma</label>
                <form:input path="plataforma" type="number" class="form-control" id="plataforma" name="plataforma" placeholder="Codi de la plataforma"/>

                <label for="descripcio">Descripció</label>
                <form:textarea path="descripcio"  class="form-control" id="descripcio" name="descripcio" placeholder="El mon necesita herois..."/>
                <!--
                <label for="logo">Imatge portada</label>
                <input type="file" id="logo" class="form-control" name="logo" onchange="loadFile(event)" accept="jpg">
                <img id="preview" src="#" alt="" style="max-width: 100%"/>
                -->
                <input type="submit" id="submit" class="btn btn-primary" value="Crear Videojoc">
                </form:form>
            </div>
        </body>
    </html>

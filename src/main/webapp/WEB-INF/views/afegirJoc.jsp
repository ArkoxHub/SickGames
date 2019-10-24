<%-- 
    Document   : agregarjuego
    Created on : 24-oct-2019, 15:27:31
    Author     : Kevin
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulari afegir joc</title>
        
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
            <form action="" name="pujarJoc" id="form" onsubmit="return validacio();">
                <p>Nom</p><input type="text" class="form-control" id="nom" name="nom" placeholder="Overwatch" value="">
                Data de llançament<input type="text" class="form-control" id="data_Llançament" name="data_Llançament" placeholder="2019-05-04" value="">
                Preu<input type="text" class="form-control" id="preu" name="preu" placeholder="20" value="">
                Idioma<input type="text" class="form-control" id="idioma" name="idioma" placeholder="ESP ENG ALM" value="">
                Oferta<input type="text" class="form-control" id="oferta" name="oferta" placeholder="20" value="">
                Quantitat avaible<input type="text" class="form-control" id="qty_Available" name="qty_Available" placeholder="50" value="">
                Generes<input type="text" class="form-control" id="plataforma" name="plataforma" placeholder="Introduir numero (mirar bd)" value="">
                Descripció<textarea class="form-control" id="descripcio" name="descripcio" placeholder="El mon necesita herois..."></textarea>
                Logo 
                <input type="file" id="logo" class="form-control" name="logo" onchange="loadFile(event)" accept="png">
                <img id="preview" src="#" alt="" style="max-width: 100%" />
                
                <input type="submit" name="submit" id="submit" class="btn btn-primary" value="Pujar joc">
                
            </form>
        </div>
    </body>
</html>

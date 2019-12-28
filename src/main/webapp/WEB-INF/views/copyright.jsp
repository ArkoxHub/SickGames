<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="cat">
    <head>
        <title>SickGames</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--Jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <!--This css-->
        <link href="<c:url value='../resources/css/copyright.css'/>" rel="stylesheet" type="text/css"/>
        <!--This javascript-->
        <script src="<c:url value='../resources/js/copyright.js'/>" type="text/javascript" ></script>
        
        
    <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
    <!--Fi Secció top-->
        <section class="section-body">
            <div class="container-cataleg">
                <div class="texto">
                    <i class="ultimaModificacio">Última modificació: 25/12/2019</i>
                    <div class="text-center">
                        <u><h2>Copyright SickGames</h2></u>
                    </div>
                    <p>SickGames utilitza la llicència <a href="https://creativecommons.org/licenses/by-sa/4.0/legalcode.es" target="_blank">Reconeixement - Compartir Igual (CC BY-SA)</a></p>
                    <ul class="textoUl">
                        <li>Aquesta llicència permet a altres editar, modificar i desenvolupar sobre la teva obra fins i tot per a propòsits comercials, sempre que t'atribueixin el crèdit i llicencien les seves noves obres sota idèntics termes. Aquesta llicència és a menuda comparada amb les llicències de "copyleft" i les de programari "codi obert". Qualsevol obra nova basada en la teva, ho serà amb la mateixa llicència, de manera que qualsevol obra derivada permetrà també el seu ús comercial. </li>
                    </ul>
                </div>
            </div>
        </section>
    <!--Fi secció body-->
    <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>
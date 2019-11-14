<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--Secció top: Buscador, conta, logo....--> 
<section class="section-top">
    <a href="<c:url value='/'/>"><img src="<c:url value='/resources/img/logo_icon.png'/>" alt="SickGames,  ofertes jocs, codis jocs online, tenda de codis" class="logoMvl"></a>
    <nav class="container" id="container-top">
        <div class="d-flex flex-row">
            <div class="col-2">
                <a href="<c:url value='/'/>"><img src="<c:url value='/resources/img/logo_sick.png'/>" alt="SickGames,  ofertes jocs, codis jocs online, tenda de codis" class="logo"></a>
            </div>
            <div class="col-6" id="colbuscador">
                <form action="/product" form="GET">
                    <input autocomplete="off"  class="buscador" type="text" placeholder=" Cerca" name="search">
                    <button class="botonBuscador" type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
            <div class="col-4" id="colbuscador">
                <div class="d-flex flex-row" id="cuenta">
                    <div class="col-4">
                        <a href="#" class="soporte" >Suport 24/7</a>
                        <a href="#" class="soporteMvl" ><i class="fa fa-comment fa-lg" aria-hidden="true"></i></a>
                    </div>
                    <div class="col-5">
                        <div id="test" style="position: relative;">
                            <a href="#" class="soporte" id="compte">El meu compte</a>
                            <a href="#" class="soporteMvl" id="compteMvl"><i class="fa fa-user fa-lg" aria-hidden="true"></i></a>
                            <ul  class="menuCompte">
                                <a href="<c:url value='/user'/>">
                                    <li>Perfil</li>
                                </a>
                                <a href="<c:url value='/user'/>">
                                    <li>Comandes</li>
                                </a>
                                <a href="<c:url value='/user'/>">
                                    <li>Llista desitjos</li>
                                </a>
                                <a href="<c:url value='/user'/>">
                                    <li>Tancar sessió</li>
                                </a>
                            </ul>
                        </div>
                    </div> 
                    <div class="col-1">
                        <a href="#" class="darkMode"><i class="fa fa-moon fa-lg" aria-hidden="true"></i></a>
                        <a href="#" class="lightMode"><i class="fa fa-sun fa-lg" aria-hidden="true"></i></a>
                    </div>                                                                               
                </div>
            </div>
        </div>
    </nav>
</section>
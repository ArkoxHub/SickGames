<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Cookies div fixed-->
<div class="cookiesAccept">
    <div class="container-cataleg">
        <h3 id="titleCookie">La teva privacitat és important</h3>
        <p id="textCookie">La teva informació personal es molt sensible, a SickGames les cookies només 
            seran utilitzades implicitament per millorar la pàgina y mai serà venguda
            a tercers ni utilitzada per fins publicitaris.
        </p>
        <a class="btn btn-primary" id="acceptarCookie">Acceptar</a>
        <a href="#">Més informació</a>
    </div>
</div>
<!--Secció top: Buscador, conta, logo....--> 
<div id="page-container">
<section class="section-top">
    <a href="<c:url value='/'/>"><img src="<c:url value='/resources/img/logo_icon.png'/>" alt="SickGames,  ofertes jocs, codis jocs online, tenda de codis" class="logoMvl"></a>
    <nav class="container" id="container-top">
        <div class="row">
            <div class="col-5">
                <div class="row">
                    <div class="col-12" id="colbuscador" style="display:inline-flex">
                        <div class="col-6" id="showHideLogo">
                            <a href="<c:url value='/'/>"><img src="<c:url value='/resources/img/logo_sick.png'/>" alt="SickGames,  ofertes jocs, codis jocs online, tenda de codis" class="logo"></a>
                        </div>
                        <form action="/product" form="GET">
                            <input autocomplete="off"  class="buscador" type="text" placeholder=" Cerca" name="search">
                            <button class="botonBuscador" type="submit"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-7" id="colbuscador">
                <div class="d-flex flex-row" id="cuenta">
                    <div class="col-3" id="suportCol">
                        <a href="<c:url value='/suport'/>" class="soporte" >Suport 24/7</a>
                        <a href="<c:url value='/suport'/>" class="soporteMvl" ><i class="fa fa-comment fa-lg" aria-hidden="true"></i></a>
                    </div>
                    <c:choose>
                        <c:when test="${not empty cookie.userMail.name}">
                            <div class="col-3">
                                <div id="menuUser">
                                    <a href="#" class="soporte" id="compte">Hola ${cookie.userNick.value}</a>
                                    <a href="#" class="soporteMvl" id="compteMvl"><i class="fa fa-user fa-lg" aria-hidden="true"></i></a>
                                    <ul id="menuCompte" class="menuCompte">
                                        <a href="<c:url value='/user'/>">
                                            <li>Perfil</li>
                                        </a>
                                        <a href="<c:url value='/user'/>">
                                            <li>Comandes</li>
                                        </a>
                                        <a href="<c:url value='/user'/>">
                                            <li>Llista desitjos</li>
                                        </a>
                                        <a href="<c:url value='/user/logoff'/>">
                                            <li>Tancar sessió</li>
                                        </a>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-3" id="menuCarrito">            
                                <a href="#"><i class="fas fa-shopping-cart"></i></a><!--Redirect a una pagina para comprar y pagar?-->
                                <ul id="productesComprats" class="productesComprats">
                                    <li class="cesta">
                                        <div style="display:inline-block">
                                            <img src="<c:url value="/resources/img/portades/World of Warcraft Shadowlands.jpg"/>"> 
                                            <span> <!--Aqui poner una cruz al lado del producto para quitarlo del carro?-->
                                                 World of Warcraft:Shadowlands - 60€
                                            </span>
                                        </div>
                                    </li>
                                    <li class="cesta">
                                        <div style="display:inline-block">
                                            <img src="<c:url value="/resources/img/portades/World of Warcraft Shadowlands.jpg"/>"> 
                                            <span> <!--Aqui poner una cruz al lado del producto para quitarlo del carro?-->
                                                 World of Warcraft:Shadowlands - 60€
                                            </span>
                                        </div>
                                    </li>
                                    <!--También iria a la pagina para comprar y pagar-->
                                    <hr>
                                    <a href="#">
                                        <li>Realitzar la compra = 999€</li>
                                    </a>
                                </ul>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="col-3">
                                <div id="menuUser">
                                    <a href="#" class="soporte" id="conectarse">Login</a>
                                    <a href="#" class="soporteMvl" id="conectarseMvl">Login</a>
                                </div>
                            </div> 
                            <div class="col-3">
                                <div id="menuLogin">
                                    <a href="<c:url value='/user/signIn'/>" class="soporte" id="nouCompte">Nou Usuari</a>
                                    <a href="<c:url value='/user/signIn'/>" class="soporteMvl" id="compteMvl"><i class="fa fa-user fa-lg" aria-hidden="true"></i></a>
                                </div>
                            </div>  
                        </c:otherwise>
                    </c:choose>
                    <div class="col-3">
                        <a href="#" class="darkMode"><i class="fa fa-moon fa-lg" aria-hidden="true"></i></a>
                        <a href="#" class="lightMode"><i class="fa fa-sun fa-lg" aria-hidden="true"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </nav>
    <div id="id01" class="modal">
        <form class="modal-content animate" action="user/login" method="post">
            <div class="imgcontainer">
                <span class="close" title="Tancar finestra">&times;</span>
                <img title="Logo Web" src="<c:url value='/resources/img/logo_sick.png'/>" alt="Avatar" class="avatar">
            </div>

            <div class="container">
                    <label for="nickname"><b>Nick</b></label>
                    <input title="Introdueix el teu nick" type="text" placeholder="Nom de l'usuari" name="nickname" class="inputLogin" required>

                    <label for="psw"><b>Contrasenya</b></label>
                    <input title="Introdueix la contrasenya" type="password" placeholder="Introdueix contrasenya" name="password" class="inputLogin" required>
                    
                    <input title="Fer login" type="submit" class="buttonLogin" value="Login">
            </div>

            <div class="container">
                <button title="Sortir del menu login" type="button" class="cancelbtn">Sortir</button>
                <span class="psw">Restaurar <a title="Restaurar Contrasenya"href="#">Contrasenya</a></span>
            </div>
        </form>
    </div>

</section>
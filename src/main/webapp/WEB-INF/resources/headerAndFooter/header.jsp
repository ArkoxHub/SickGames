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
            <div class="col-5" id="colbuscador">
                <form action="/product" form="GET">
                    <input autocomplete="off"  class="buscador" type="text" placeholder=" Cerca" name="search">
                    <button class="botonBuscador" type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
            <div class="col-5" id="colbuscador">
                <div class="d-flex flex-row" id="cuenta">
                    <div class="col-4" id="suportCol">
                        <a href="#" class="soporte" >Suport 24/7</a>
                        <a href="#" class="soporteMvl" ><i class="fa fa-comment fa-lg" aria-hidden="true"></i></a>
                    </div>
                    <c:choose>
                        <c:when test="${not empty user}">
                            <div class="col-5">
                                <div id="menuUser">
                                    <a href="#" class="soporte" id="compte">Hola ${user.nom}</a>
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
                                        <a href="<c:url value='/user'/>">
                                            <li>Tancar sessió</li>
                                        </a>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-1" id="menuCarrito">            
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
                                        <li>Comprar = 999€</li>
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
                            <div class="col-4">
                                <div id="menuLogin">
                                    <a href="<c:url value='/user/signIn'/>" class="soporte" id="nouCompte">Nou Usuari</a>
                                    <a href="<c:url value='/user/signIn'/>" class="soporteMvl" id="compteMvl"><i class="fa fa-user fa-lg" aria-hidden="true"></i></a>
                                </div>
                            </div>  
                        </c:otherwise>
                    </c:choose>
                    <div class="col-1">
                        <a href="#" class="darkMode"><i class="fa fa-moon fa-lg" aria-hidden="true"></i></a>
                        <a href="#" class="lightMode"><i class="fa fa-sun fa-lg" aria-hidden="true"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </nav>
    <div id="id01" class="modal">
        <form class="modal-content animate" action="#" method="post">
            <div class="imgcontainer">
                <span class="close" title="Tancar finestra">&times;</span>
                <img title="Logo Web" src="<c:url value='/resources/img/logo_sick.png'/>" alt="Avatar" class="avatar">
            </div>

            <div class="container">
                <label for="uname"><b>Username</b></label>
                <input title="Introdueix l'usuari" type="text" placeholder="Nom de l'usuari" name="uname" class="inputLogin" required>

                <label for="psw"><b>Password</b></label>
                <input title="Introdueix la contrasenya" type="password" placeholder="Contrasenya" name="psw" class="inputLogin" required>

                <button title="Fer login" type="submit" class="buttonLogin">Login</button>
            </div>

            <div class="container">
                <button title="Sortir del menu login" type="button" class="cancelbtn">Sortir</button>
                <span class="psw">Restaurar <a title="Restaurar Contrasenya"href="#">Contrasenya</a></span>
            </div>
        </form>
    </div>

</section>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="cat">
    <head>
        <title>SickGames</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--Bootstrap CSS-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="true">
        <!--My css-->
        <link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet" type="text/css"/>
        <!--WebIcon-->
        <link rel="icon" href="<c:url value="/resources/img/logo_icon.png"/>" alt="Favicon">
        <!--FontsGoogle-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="true">
        <link href="https://fonts.googleapis.com/css?family=Archivo&display=swap" rel="stylesheet">
        <!--FontAwesome js-->
        <script src="https://use.fontawesome.com/384f95a176.js"></script>
        <!--Jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <!--My javascript-->
        <script src="<c:url value="/resources/js/index.js"/>" type="text/javascript" ></script>
    </head>

    <body>
        <!--Secció top: Buscador, conta, logo....--> 
        <section class="section-top">
            <a href="<c:url value="/admin/addGame"/>">Afegir nou videojoc</a>
            <a href="<c:url value="/"/>"><img src="<c:url value="/resources/img/logo_sick.png"/>" alt="SickGames,  ofertes jocs, codis jocs online, tenda de codis" class="logoMvl"></a>
            <nav class="container" id="container-top">
                <div class="d-flex flex-row">
                    <div class="col-2">
                        <a href="<c:url value="/"/>"><img src="<c:url value="/resources/img/logo_sick.png"/>" alt="SickGames,  ofertes jocs, codis jocs online, tenda de codis" class="logo"></a>
                    </div>
                    <div class="col-6" id="colbuscador">
                        <form action="/action_page.php">
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
                                        <a href="<c:url value="/user"/>">
                                            <li>Perfil</li>
                                        </a>
                                        <a href="<c:url value="/user"/>">
                                            <li>Comandes</li>
                                        </a>
                                        <a href="<c:url value="/user"/>">
                                            <li>Llista desitjos</li>
                                        </a>
                                        <a href="<c:url value="/user"/>">
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
        <!--Fi Secció top-->

        <!--Secció body; Jocs més venuts, valorats, millors ofertes, streams...-->
        <section class="section-body">
            <div class="container">

                <!--MOST SELLED GAMES-->
                <p class="tituloFilas">Jocs més venuts</p>
                <div class="row" id="filaCatalogo">
                    <c:forEach var="joc" items="${videojocs}" begin="0" end="3">
                        <div class="column">
                            <a href="<c:url value="/product?id=${joc.codi_Joc}"/>" class="imgProducteAComprar" id="${joc.nom}"><img src="<c:url value="/resources/portades/${joc.nom}.jpg"/>" title="${joc.nom}" alt="SickGames,  ofertes jocs, codis jocs online, tenda de codis, ${joc.nom}">
                                <div class="infoJoc">
                                    <span class="preu">${joc.preu}€</span>
                                    <!--Aqui faltan los generes para que se creen solos-->
                                    <div class="genere1"><span>RPG</span></div><!--Genere(numero bd)-->
                                </div>
                            </a>
                            <a href="<c:url value="/product"/>" class="producteAComprar" id="overwatch"><i class="fa fa-arrow-down"></i> ${joc.oferta}% - Comprar</a>
                        </div>
                    </c:forEach>
                </div>

                <!--MOST VALORATED GAMES     NEED IMPLEMENTATION-->
                <p class="tituloFilas">Jocs més valorats</p>
                <div class="row" id="filaCatalogo">
                    <div class="column">
                        <a href="<c:url value="/product"/>" class="imgProducteAComprar" id="overwatch"><img src="<c:url value="/resources/img/cover_test_juego.jpg"/>" alt="SickGames, codis jocs online, tenda de codis, ofertes jocs"><!--poner alt nombrejuego, oferta, nombreweb, juegobarato, etc-->
                            <div class="infoJoc">
                                <span class="preu">28€</span>
                                <div class="genere2"><span>Aventura</span></div><!--Genere(numero bd)-->
                                <div class="genere3"><span>Cundicció</span></div>
                                <div class="genere4"><span>Estrategia</span></div>
                                <div class="genere5"><span>Simulador</span></div>
                            </div>
                        </a>
                        <a href="<c:url value="/product"/>" class="producteAComprar" id="overwatch"><i class="fa fa-arrow-down"></i> 10% - Comprar</a>
                    </div>
                </div>

                <!--TOP OFFERTS DESC-->
                <p class="tituloFilas">Millors ofertes</p>
                <div class="row" id="filaCatalogo">
                    <c:forEach items="${ofertes}" var="joc_Oferta">
                        <div class="column">
                            <!-- SE TIENE QUE PASAR UNA EL NOMBRE O ID DEL PRODUCTO COMO ID EN LOS LINKS PARA PODER CREAR UNA WEB CON UN CONTENIDO U OTRO-->
                            <a href="<c:url value="/product?id=${joc_Oferta.codi_Joc}"/>" class="imgProducteAComprar" id="${joc_Oferta.nom}"><img src="<c:url value="/resources/portades/${joc_Oferta.nom}.jpg"/>" title="${joc_Oferta.codi_Joc}" alt="SickGames,  ofertes jocs, codis jocs online, tenda de codis, ${joc_Oferta.codi_Joc} , ${joc_Oferta.nom}"><!--poner alt nombrejuego, oferta, nombreweb, juegobarato, etc-->
                                <div class="infoJoc">
                                    <span class="preu">${joc_Oferta.preu}</span>
                                    <div class="genere2"><span>Aventura</span></div><!--Genere(numero bd)-->
                                    <div class="genere3"><span>Cundicció</span></div>
                                </div>
                            </a>
                            <a href="<c:url value="/product"/>" class="producteAComprar" id="overwatch"><i class="fa fa-arrow-down"></i> ${joc_Oferta.oferta}% - Comprar</a>
                        </div>
                    </c:forEach>
                </div>

                <!--Streams-->
                <p class="tituloFilas">Top Streamers [ESP]</p>
                <div class="row" id="filaStreams"></div><!--S'omplira automaticament amb els top streamers-->
                <div class="row" id="streamView"></div><!--Quan fem click a un stream, podrem veure el video dintre d'aquest div-->
            </div>
        </section>
        <!--Fi secció body-->

        <!--Secció footer-->
        <section class="section-footer">
            <!-- Footer -->
            <div class="container">
                <footer class="page-footer font-small blue pt-4">
                    <!-- Footer Links -->
                    <div class="container-fluid text-center text-md-left">

                        <!-- Grid row -->
                        <div class="row" >

                            <!-- Grid column -->
                            <div class="col-md-6 mt-md-0 mt-3">

                                <!-- Content -->
                                <h5 class="text-uppercase">Gràcies per confiar en SickGames</h5>
                                <ul class="list-unstyled">
                                    <li>
                                        Adrià
                                    </li>
                                    <li>
                                        Oscar
                                    </li>
                                    <li>
                                        Kevin
                                    </li>
                                </ul>
                            </div>
                            <!-- Grid column -->

                            <hr class="clearfix w-100 d-md-none pb-3">

                            <!-- Grid column -->
                            <div class="col-md-3 mb-md-0 mb-3">

                                <!-- Links -->
                                <h5 class="text-uppercase">Links</h5>

                                <ul class="list-unstyled">
                                    <li>
                                        <a href="#!">Link 1</a>
                                    </li>
                                    <li>
                                        <a href="#!">Link 2</a>
                                    </li>
                                    <li>
                                        <a href="#!">Link 3</a>
                                    </li>
                                    <li>
                                        <a href="#!">Link 4</a>
                                    </li>
                                </ul>

                            </div>
                            <!-- Grid column -->

                            <!-- Grid column -->
                            <div class="col-md-3 mb-md-0 mb-3">

                                <!-- Links -->
                                <h5 class="text-uppercase">Links</h5>

                                <ul class="list-unstyled">
                                    <li>
                                        <a href="#!">Link 1</a>
                                    </li>
                                    <li>
                                        <a href="#!">Link 2</a>
                                    </li>
                                    <li>
                                        <a href="#!">Link 3</a>
                                    </li>
                                    <li>
                                        <a href="#!">Link 4</a>
                                    </li>
                                </ul>

                            </div>
                            <!-- Grid column -->

                        </div>
                        <!-- Grid row -->

                    </div>
                    <!-- Footer Links -->

                    <!-- Copyright -->
                    <div class="footer-copyright text-center py-3">© 2019 Copyright:
                        <a href="<c:url value="/"/>">SickGames</a>
                    </div>
                    <!-- Copyright -->

                </footer>
            </div>
            <!-- Footer -->   
        </section>
        <!-- Load the Twitch embed script -->
        <script src="https://embed.twitch.tv/embed/v1.js"></script>

    </body>
</html>
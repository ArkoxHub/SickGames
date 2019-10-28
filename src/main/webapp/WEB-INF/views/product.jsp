<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="cat">
    <head>
        <title>SickGames</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--Bootstrap CSS-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="true">
        <!--My css-->
        <link href="<c:url value="/resources/css/product.css"/>" rel="stylesheet" type="text/css"/>
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
        <script src="<c:url value="/resources/js/product.js"/>" type="text/javascript" ></script>
    </head>

    <body>
        <!--Secció top; Buscador, conta, logo....--> 
        <section class="section-top">
            <a href="<c:url value="/"/>"><img src="<c:url value="/resources/img/logo_sick.png"/>" alt="" class="logoMvl"></a>
            <nav class="container" id="container-top">
                <div class="d-flex flex-row">
                    <div class="col-2">
                        <a href="<c:url value="/"/>"><img src="<c:url value="/resources/img/logo_sick.png"/>" alt="" class="logo"></a>
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
        <!--FI Secció top-->
        <div class="text-center center" style="margin-bottom:-38px">
            <a  class="btn btn-primary" href="<c:url value="/admin/updateGame?id=${joc.codi_Joc}"/>">Modifica aquest videojoc</a>
        </div>
        <!--Secció body; Jocs més venuts, valorats, millors ofertes, streams...-->
        <section class="section-body">
            <div class="container" >
                <div class="row" id="cartaJoc">
                    <div class="column-3">
                        <img id="stream${joc.nom}" class="portadaJoc" src="<c:url value="/resources/img/portades/${joc.nom}.jpg"/>">
                        <img class="afegirWhishList" src="<c:url value="/resources/img/like.png"/>" alt=""> <!--Alt deberia ser el nombre del juego de la bd-->
                    </div>
                    <div class="portada">
                        <img class="portadaJocMvl" src="<c:url value="/resources/img/portades/${joc.nom}.jpg"/>">
                    </div>
                    <div class="column-9">
                        <div class="row" id="titol">
                            <!--Importar nombre juego de la bd-->
                            <div class="column-12 text-center">${joc.nom}</div>
                        </div>
                        <div class="row justify-content-md-center">           
                            <img src="<c:url value="/resources/img/plataformes/battlenet.png"/>" alt="">
                            <img src="<c:url value="/resources/img/plataformes/steam.png"/>" alt="">
                            <img src="<c:url value="/resources/img/plataformes/uplay.png"/>" alt="">
                        </div>
                        <div class="row justify-content-md-center" id="genere">
                            RPG - Acció - Local <!--Imporatr genere de la bd/En js tendremos que meter los guiones de algun modo-->
                        </div>
                        <div class="row" id="stock">
                            <div class="column-6 text-left">
                                <span class="stockSi">Stock disponible: ${joc.qty_Available}<!--si no hay stock , la class se llamara stockNo y no se mostrara el total-->
                                    <i class="fa fa-times" id="cruz"></i>
                                </span>
                            </div>
                            <div class="column-6 text-right">
                                <c:forEach var="split" items="${joc.idioma.split(', ')}">
                                    <c:choose>
                                        <c:when test="${split == 'Multillengua'}">
                                            Multillengua
                                        </c:when>
                                        <c:otherwise>
                                            <img src="<c:url value="/resources/img/banderas/${split}.png"/>" alt="SickGames,  ofertes jocs, codis jocs online, tenda de codis, ${joc.nom},  ${joc.idioma}">
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                               
                            </div>
                        </div>
                        <div class="row" id="infoCompres">
                            <div class="column-6 text-left">
                                <span>70 Adquisicions</span>
                            </div>
                            <div class="column-6 text-right">
                                <span>
                                    <i class="fa fa-arrow-down"></i> ${joc.oferta}%<!--Importar descompte joc-->
                                </span>
                            </div>
                        </div>
                        <div class="row" id="preu">
                            <div class="column-12 text-center">
                                <span>${joc.preu}€</span>
                            </div>
                        </div>
                        <div class="row" id="comprarJoc">
                            <div class="column-12 text-center">
                                <a href="#" class="producteAComprar" id="overwatch">
                                    Comprar
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container" id="infoJoc">
                <div class="row">
                    <div class="col-md-6">
                        <h4 class="titolsTaules">Configuració mínima</h4>
                        <table>
                            <tbody>
                                <tr>
                                    <td class="requisit">OS</td>
                                    <td class="descripcioRequisit">64-bit Windows 10</td>
                                </tr>
                                <tr>
                                    <td class="requisit">CPU</td>
                                    <td class="descripcioRequisit">I3-3220 or Equivalent</td>
                                </tr>
                                <tr>
                                    <td class="requisit">RAM</td>
                                    <td class="descripcioRequisit">4 GB</td>
                                </tr>
                                <tr>
                                    <td class="requisit">GPU</td>
                                    <td class="descripcioRequisit">GeForce GT 640 or Equivalent</td>
                                </tr>
                                <tr>
                                    <td class="requisit">HDD</td>
                                    <td class="descripcioRequisit">15 GB</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-6">
                        <h4 class="titolsTaules">Descripció</h4>
                        <table>
                            <tbody>
                                <tr>
                                    <td class="requisit">${joc.descripcio}
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="container">
                <h4 class="titolsTaules">Streams</h4>
                <div class="row" id="filaStreams"></div><!--S'omplira automaticament amb els top streamers-->
                <div class="row" id="streamView"></div><!--Quan fem click a un stream, podrem veure el video dintre d'aquest div-->
            </div>
        </section>
        <!--Fi secciÃ³ body-->

        <!--SecciÃ³ footer-->
        <section class="section-footer">
            <!-- Footer -->
            <div class="container" >
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
        <script type="text/javascript">
            var dataFromParent;
            function init() {
                document.write(dataFromParent);
            }
        </script>
    </body>
</html>
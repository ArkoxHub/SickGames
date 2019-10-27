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
        <link href="<c:url value="/resources/css/user.css"/>" rel="stylesheet" type="text/css"/>
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
        <script src="<c:url value="/resources/js/user.js"/>" type="text/javascript" ></script>
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
        <section class="section-body">
            <div class="container">
                <div class="row"  id="jocsPerfil">
                    <div class="col-md-2 text-center center">
                        <img id="fotoPerfil"  src="<c:url value="/resources/img/fotosPerfil/user.jpg"/>">
                        <i class="fas fa-camera upload-button"></i>
                        <input class="file-upload" type="file" accept="image/*"/>
                    </div>
                    <div class="col-md-8">
                        <h2>Pepito</h2>
                        <p>Carrito de la compra: <a class="btn btn-primary" id="carritoShow">Mostrar productes</a> <a class="btn btn-primary" id="carritoHide">Ocultar productes</a></p>
                        <ul id="llistaProductes">
                            <li>Overwatch - 24€</li>
                            <li>Overwatch - 25€</li>
                            <li>Overwatch - 25€</li>
                        </ul>
                        <p>Preu total a pagar: 108€</p><a class="btn btn-primary" id="realitzarPagament">Pagar</a>
                    </div>
                </div>
            </div>
            <div class="container">
                <h4  id="jocsH4">Llista de jocs desitjats</h4>
                <div class="row" id="jocsPerfil">
                    <div class="column">
                        <!---->
                        <a href="<c:url value="/product?id=1"/>"><img id="portadaJoc" src="<c:url value="/resources/img/portades/Overwatch.jpg"/>"></a> 
                        <img class="retirarWhishList" src="<c:url value="/resources/img/like.png"/>" alt="">
                        <a href="<c:url value="/product"/>" class="producteAComprar" id="overwatch"><i class="fa fa-arrow-down"></i> 20% - Comprar</a>
                    </div>
                    <div class="column">
                        <!---->
                        <a href="<c:url value="/product?id=1"/>"><img id="portadaJoc" src="<c:url value="/resources/img/portades/Overwatch.jpg"/>"></a> 
                        <img class="retirarWhishList" src="<c:url value="/resources/img/like.png"/>" alt="">
                        <a href="<c:url value="/product"/>" class="producteAComprar" id="overwatch"><i class="fa fa-arrow-down"></i> 20% - Comprar</a>
                    </div>
                    <div class="column">
                        <!---->
                        <a href="<c:url value="/product?id=1"/>"><img id="portadaJoc" src="<c:url value="/resources/img/portades/Overwatch.jpg"/>"></a> 
                        <img class="retirarWhishList" src="<c:url value="/resources/img/like.png"/>" alt="">
                        <a href="<c:url value="/product"/>" class="producteAComprar" id="overwatch"><i class="fa fa-arrow-down"></i> 20% - Comprar</a>
                    </div>
                    <div class="column">
                        <!---->
                        <a href="<c:url value="/product?id=1"/>"><img id="portadaJoc" src="<c:url value="/resources/img/portades/Overwatch.jpg"/>"></a> 
                        <img class="retirarWhishList" src="<c:url value="/resources/img/like.png"/>" alt="">
                        <a href="<c:url value="/product"/>" class="producteAComprar" id="overwatch"><i class="fa fa-arrow-down"></i> 20% - Comprar</a>
                    </div>
                </div>
            </div>
            <div class="container">
                <h4  id="jocsH4">Jocs comprats</h4>
                <div class="row"  id="jocsPerfil">
                    <div class="column">
                        <!---->
                        <a href="<c:url value="/product?id=1"/>"><img id="portadaJoc" src="<c:url value="/resources/img/portades/Overwatch.jpg"/>"></a> 
                    </div>
                </div>
            </div>            
        </section>
        <!--SecciÃ³ footer-->
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
                        <a href="<c:url value="/"/>"> SickGames</a>
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
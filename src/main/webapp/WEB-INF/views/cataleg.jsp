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
        <link href="<c:url value="/resources/css/cataleg.css"/>" rel="stylesheet" type="text/css"/>
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
        <script src="<c:url value="/resources/js/cataleg.js"/>" type="text/javascript" ></script>
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
        
        <!--Secció body; Jocs més venuts, valorats, millors ofertes, streams...-->
        
        <div class="text-center center" style="margin-top:10px;">
            <a class="btn btn-primary" href="<c:url value="/admin/addGame"/>">Afegir videojoc</a>
        </div>
        <section class="section-body">
            <div class="container-cataleg">
                <div class="row" id="filaCatalogo">
                    <div class="col-md-2 menuPlataforma">
                        <div class="row">
                            <div class="col-md-12" id="marginMenuCalaleg">
                                <button class="btn btn-primary" id="escollirPlataforma" href="">Plataforma</button>
                                <form class="mostrarPlataforma">
                                    <!--Plataformes per mostrar , foreach que recorri tote les plataformes, de mentres ho he creat per probar-ho-->
                                    <div class="checkboxDiv">
                                        <label for="Battlenet">Battle.net</label>
                                        <input type="checkbox" class="checkbox" id="Battlenet" name="Battlenet"><br>
                                    </div>
                                    <div class="checkboxDiv">
                                        <label for="Battlenet">Epic Games</label>
                                        <input type="checkbox" class="checkbox" id="Battlenet" name="Battlenet"><br>
                                    </div>
                                    <div class="checkboxDiv">
                                        <label for="Battlenet">Battle.net</label>
                                        <input type="checkbox" class="checkbox" id="Battlenet" name="Battlenet"><br>
                                    </div>
                                    <div class="checkboxDiv">
                                        <label for="Battlenet">Battle.net</label>
                                        <input type="checkbox" class="checkbox" id="Battlenet" name="Battlenet"><br>
                                    </div>
                                    <div class="checkboxDiv">
                                        <label for="Battlenet">Battle.net</label>
                                        <input type="checkbox" class="checkbox" id="Battlenet" name="Battlenet"><br>
                                    </div>
                                    <div class="checkboxDiv">
                                        <label for="Battlenet">Battle.net</label>
                                        <input type="checkbox" class="checkbox" id="Battlenet" name="Battlenet"><br>
                                    </div>
                                    <div class="checkboxDiv">
                                        <label for="Battlenet">Battle.net</label>
                                        <input type="checkbox" class="checkbox" id="Battlenet" name="Battlenet"><br>
                                    </div>
                                    <div class="checkboxDiv">
                                        <label for="Battlenet">Battle.net</label>
                                        <input type="checkbox" class="checkbox" id="Battlenet" name="Battlenet"><br>
                                    </div>
                                    
                                </form>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12" id="marginMenuCalaleg">
                                <button class="btn btn-primary" id="escollirGenere" >Genere</button>
                                <form class="mostrarGenere">
                                    <!--Generes per mostrar, foreach generes... -->
                                    <div class="checkboxDiv">
                                        <label for="RPG">RPG</label>
                                        <input type="checkbox" class="checkbox" id="RPG" name="RPG"><br>
                                    </div>
                                    <div class="checkboxDiv">
                                        <label for="RPG">Joc en solitari</label>
                                        <input type="checkbox" class="checkbox" id="RPG" name="RPG"><br>
                                    </div>
                                    <div class="checkboxDiv">
                                        <label for="RPG">RPG</label>
                                        <input type="checkbox" class="checkbox" id="RPG" name="RPG"><br>
                                    </div>
                                    <div class="checkboxDiv">
                                        <label for="RPG">RPG</label>
                                        <input type="checkbox" class="checkbox" id="RPG" name="RPG"><br>
                                    </div>
                                    <div class="checkboxDiv">
                                        <label for="RPG">RPG</label>
                                        <input type="checkbox" class="checkbox" id="RPG" name="RPG"><br>
                                    </div>
                                    <div class="checkboxDiv">
                                        <label for="RPG">RPG</label>
                                        <input type="checkbox" class="checkbox" id="RPG" name="RPG"><br>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-10">
                        <div class="container-fluid">
                            <div class="row">
                                <c:forEach var="joc" items="${videojocs}" begin="0" end="19">
                                    <div class="column">
                                        <a href="<c:url value="/product?id=${joc.codi_Joc}"/>" id="${joc.nom}"><img src="<c:url value="/resources/img/portades/${joc.nom}.jpg"/>" title="${joc.nom}" alt="SickGames,  ofertes jocs, codis jocs online, tenda de codis, ${joc.nom}">
                                            <div class="infoJoc">
                                                <span class="preu">${joc.preu}€</span>
                                                <!--Aqui faltan los generes para que se creen solos-->
                                                <div class="genere1"><span>RPG</span></div><!--Genere(numero bd)-->
                                            </div>
                                        </a>
                                        <a href="<c:url value="product?id=${joc.codi_Joc}"/>" class="producteAComprar" id="overwatch"><i class="fa fa-arrow-down"></i> ${joc.oferta}% - Comprar</a>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>  
                    </div>
                </div>
            </div>
            <nav>
                <ul class="pagination justify-content-center">
                    <li class="page-item disabled"> <!--Cambiar el disabled si se encuentra en pagina 2 backend-->
                        <a class="page-link" href="#" tabindex="-1"><i class="fas fa-arrow-left"></i></a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#"><i class="fas fa-arrow-right"></i></a>
                    </li>
                </ul>
            </nav>
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
    </body>
</html>
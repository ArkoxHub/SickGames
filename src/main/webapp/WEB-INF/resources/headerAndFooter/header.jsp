<%@page import="com.sick.games.domain.Videojoc"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<title>SickGames</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--Jquery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<!--Bootstrap CSS-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="true">
<!--Global javascript-->
<script src="<c:url value='/resources/js/funcions.js'/>" type="text/javascript" ></script>
<!--Global css-->
<link href="<c:url value='/resources/css/global.css'/>" rel="stylesheet" type="text/css"/>
<!--WebIcon-->
<link rel="icon" href="<c:url value='/resources/img/logo_icon.png'/>" alt="Favicon">
<!--FontsGoogle-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="true">
<link href="https://fonts.googleapis.com/css?family=Archivo&display=swap" rel="stylesheet">
<!--FontAwesome js-->
<script src="https://use.fontawesome.com/384f95a176.js"></script>
</head>

<body>
    <!--Cookies div fixed-->
    <div class="cookiesAccept">
        <div class="container-cataleg">
            <h3 id="titleCookie">La teva privacitat és important</h3>
            <p id="textCookie">La teva informació personal es molt sensible, a SickGames les cookies només 
                seran utilitzades implicitament per millorar la pàgina y mai serà venguda
                a tercers ni utilitzada per fins publicitaris.
            </p>
            <a href="#" class="btn btn-primary" id="acceptarCookie" tabindex="1">Acceptar</a>
            <a href="<c:url value='/cookies'/>" tabindex="2">Més informació</a>
        </div>
    </div>
    <!--Secció top: Buscador, conta, logo....--> 
    <div id="fondo"></div>
    <div id="page-container">
        <section class="section-top">
            <a href="<c:url value='/'/>"><img src="<c:url value='/resources/img/logo_icon.png'/>" role="banner" alt="SickGames Logo" class="logoMvl"></a>
            <nav class="container-cataleg" id="container-top" role="navigation">
                <div class="row">
                    <div class="col-5">
                        <div class="row">
                            <div class="col-12" id="colbuscador" style="display:inline-flex">
                                <div class="col-6" id="showHideLogo">
                                    <a href="<c:url value='/'/>"><img src="<c:url value='/resources/img/logo_sick.png'/>" role="banner" alt="SickGames Logo" class="logo"></a>
                                </div>
                                <form action="/sickgames/cataleg" form="GET"  id="formBuscador">
                                    <input autocomplete="off" title="Buscar Videojoc" class="buscador" type="text" placeholder=" Cerca" name="search">
                                    <button class="botonBuscador" type="submit" title="Realitzar Busqueda"><i class="fa fa-search"></i></button>
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
                                <c:when test="${not empty user.nom}">
                                    <div class="col-3">
                                        <div id="menuUser">
                                            <a href="<c:url value='/user'/>" class="soporte" id="compte"><img id="userImg" />${user.nickname}</a>
                                            <a href="#" class="soporteMvl" id="compteMvl"><img id="userImgMvl" /></a>
                                            <ul id="menuCompte" class="menuCompte">
                                                <a href="<c:url value='/user'/>">
                                                    <li>Perfil</li>
                                                </a>
                                                <a href="<c:url value='/user/comandes'/>">
                                                    <li>Comandes</li>
                                                </a>
                                                <a href="<c:url value='/user/'/>">
                                                    <li>Llista desitjos</li>
                                                </a>
                                                <a href="<c:url value='/user/logoff'/>">
                                                    <li>Tancar sessió</li>
                                                </a>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-3" id="menuCarrito">   
                                        <%
                                            List<Videojoc> carro = (List<Videojoc>) request.getSession().getAttribute("carro");
                                            String total = "";
                                            if (carro.size() != 0) {
                                                total = Integer.toString(carro.size());
                                            }
                                        %>
                                        <%=total%>
                                        <a href="<c:url value='/user'/>"><i class="fas fa-shopping-cart"></i></a><!--Redirect a una pagina para comprar y pagar?-->
                                        <ul id="productesComprats" class="productesComprats">
                                            <c:forEach var="joc" items="${carro}" varStatus="status">
                                                <li class="cesta">
                                                    <div style="display:inline-block">
                                                        <img src="<c:url value="/resources/img/portades/${joc.nom}.jpg"/>" alt="${joc.nom}" title="${joc.nom}"> 
                                                        <span style="margin-right: 5px;"> <!--Aqui poner una cruz al lado del producto para quitarlo del carro?-->
                                                            ${joc.nom} - ${codis[status.index].preu} €
                                                        </span>
                                                        <a href="<c:url value="/user/remove?item=${joc.codi_Joc}&nickname=${user.nickname}"></c:url>" class="eliminarProducte" title="Eliminar producte">&times;</a>
                                                        </div>
                                                    </li>
                                            </c:forEach>
                                            <hr>
                                            <c:forEach var="codi" items="${codis}">
                                                <c:set var="total" value="${ total + codi.preu}"/>
                                            </c:forEach>
                                            <c:if test="${total > 0}">
                                                <a href="<c:url value="/user/buyout"/>">
                                                    <li>Realitzar pagament - <fmt:formatNumber value="${total}"currencySymbol="€" type="currency" pattern="###,###.00 ¤"/></li>
                                                </a>
                                            </c:if>
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
                                <a href="#" class="darkMode" title="Dark Mode"><i class="fa fa-moon fa-lg" aria-hidden="true"></i></a>
                                <a href="#" class="lightMode" title="Light Mode"><i class="fa fa-sun fa-lg" aria-hidden="true"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>

            <c:choose>
                <c:when test="${not empty loginError}">
                    <div id="id01" class="modal" style="display: block">
                </c:when>
                <c:otherwise>
                    <div id="id01" class="modal">
                </c:otherwise>
            </c:choose>
            <form class="modal-content animate" action="user/login" method="POST">
                <div class="imgcontainer">
                    <span class="close" title="Tancar finestra">&times;</span>
                    <img title="Logo Web" src="<c:url value='/resources/img/logo_sick.png'/>" alt="Avatar" class="avatar">
                </div>

                <div class="container">
                    <label for="nickname"><b>Nickname</b></label>
                    <c:if test="${loginError == 'user'}">
                        <div class="alert alert-danger">
                            Usuari invàlid
                        </div>
                    </c:if>
                    <input title="Introdueix l'usuari" type="text" placeholder="Nom de l'usuari" name="nickname" class="inputLogin" required>

                    <label for="psw"><b>Contrasenya</b></label>
                    <c:if test="${loginError == 'password'}">
                        <div class="alert alert-danger">
                            Contrasenya invàlida
                        </div>
                    </c:if>
                    <input title="Introdueix la contrasenya" type="password" placeholder="Introdueix contrasenya" name="password" class="inputLogin" required>

                    <input title="Fer login" type="submit" class="buttonLogin" value="Login">
                </div>

                <div class="container">
                    <button title="Sortir del menu login" type="button" class="cancelbtn">Sortir</button>
                    <span class="psw">Restaurar <a title="Restaurar Contrasenya" href="#">Contrasenya</a></span>
                </div>
            </form>
                </div>
        </section>
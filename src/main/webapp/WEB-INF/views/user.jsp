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
        <link href="<c:url value='/resources/css/user.css'/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value='/resources/css/global.css'/>" rel="stylesheet" type="text/css"/>
        <!--WebIcon-->
        <link rel="icon" href="<c:url value='resources/img/logo_icon.png'/>" alt="Favicon">
        <!--FontsGoogle-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="true">
        <link href="https://fonts.googleapis.com/css?family=Archivo&display=swap" rel="stylesheet">
        <!--FontAwesome js-->
        <script src="https://use.fontawesome.com/384f95a176.js"></script>
        <!--Jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <!--My javascript-->
        <script src="<c:url value='/resources/js/user.js'/>" type="text/javascript" ></script>
        <script src="<c:url value='/resources/js/funcions.js'/>" type="text/javascript" ></script>
    </head>

    <body>
        <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
            <section class="section-body">
                <div class="container">
                    <div class="row"  id="jocsPerfil">
                        <div class="col-md-2 text-center center">
                            <img id="fotoPerfil"  src="<c:url value="/resources/img/fotosPerfil/user.jpg"/>">
                        <i class="fas fa-camera upload-button"></i>
                        <input class="file-upload" type="file" accept="image/*"/>
                    </div>
                    <c:out value="&emsp;" escapeXml="false"/>
                    <div class="col-md-8">
                        <h2>${user.nom}</h2>
                        <h5>Rebràs els codis al següent correu electrònc: ${user.email}</h5>
                        <p>Carro de la compra: <a class="btn btn-primary" id="carritoShow">Mostrar productes</a> <a class="btn btn-primary" id="carritoHide">Ocultar productes</a></p>
                        <ul id="llistaProductes">
                            <c:forEach var="joc" items="${carro}" varStatus="status">
                                <li><pre style="color: white">Producte: ${joc.nom}    -   ${codis[status.index].preu} €</pre></li>
                                </c:forEach>
                            <p>===============================</p>
                        </ul>
                        <c:forEach var="codi" items="${codis}">
                            <c:set var="total" value="${ total + codi.preu}"/>
                        </c:forEach>
                        <c:if test="${total > 0}">
                            <p>Preu total a pagar - <fmt:formatNumber value="${total}"currencySymbol="€" type="currency" pattern="###,###.00 ¤"/></p>
                            <a class="btn btn-primary" id="realitzarPagament">Pagar</a>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="container">
                <h4  id="jocsH4">Llista de jocs desitjats</h4>
                <div class="row" id="jocsPerfil">
                    <c:forEach var="joc" items="${wishlistgames}" varStatus="status">
                        <div class="column">
                            <a href="<c:url value="/product?id=${joc.codi_Joc}"/>"><img id="portadaJoc" src="<c:url value="/resources/img/portades/${joc.nom}.jpg"/>"></a> 
                            <a href="<c:url value="/user/removeWishlist?item=${joc.codi_Joc}&nickname=${user.nickname}"></c:url>">
                                <img class="retirarWhishList" src="<c:url value="/resources/img/like.png"/>" title="${joc.nom}" alt="${joc.nom}">
                            </a>
                            <a href="<c:url value="/product"/>" class="producteAComprar" id="overwatch"><i class="fa fa-arrow-down"></i> ${wishlistcodes[status.index].oferta}% - Comprar</a>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <!--Falta importar taules Detall i Comanda per tal de poder mostrar aquest apartat (no és fàcil)... 
     <div class="container">
         <h4  id="jocsH4">Jocs comprats</h4>
         <div class="row"  id="jocsPerfil">
             <div class="column">
                 <a href="<c:url value="/product?id=1"/>"><img id="portadaJoc" src="<c:url value="/resources/img/portades/Overwatch.jpg"/>"></a> 
             </div>
         </div>
     </div>  
            -->
        </section>
        <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>
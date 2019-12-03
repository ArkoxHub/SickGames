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
        <!--Jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <!--This css-->
        <link href="<c:url value='/resources/css/user.css'/>" rel="stylesheet" type="text/css"/>
        <!--This javascript-->
        <script src="<c:url value='/resources/js/user.js'/>" type="text/javascript" ></script>

        <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
            <section class="section-body">
                <div class="container-cataleg">
                    <div class="row"  id="jocsPerfil">
                        <div class="col-md-2 text-center center">
                            <img id="fotoPerfil"  src="<c:url value="/resources/img/fotosPerfil/user.jpg"/>">
                        <i class="fas fa-camera upload-button"></i>
                        <input class="file-upload" type="file" accept="image/*"/>
                        <h4>${user.nom}</h4>
                        <a class="btn btn-primary" href="<c:url value="/user/productesComprats"/>">Jocs Comprats</a>
                    </div>
                    <c:out value="&emsp;" escapeXml="false"/>
                    <c:if test="${not empty carro}">
                        <div class="col-md-9">
                            <table class="table table-striped table-dark">
                                <thead>
                                    <tr>
                                        <th scope="col">Joc</th>
                                        <th scope="col">Preu</th>
                                        <th scope="col">Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="joc" items="${carro}" varStatus="status">
                                        <tr>
                                            <td><img id="jocCarroPerfil" src="<c:url value="/resources/img/portades/${joc.nom}.jpg"/>"> ${joc.nom}</td>
                                            <td>${codis[status.index].preu} € </td>
                                            <td><a href="<c:url value="/user/remove?item=${joc.codi_Joc}&nickname=${user.nickname}"></c:url>" class="eliminarProducte" title="Eliminar producte">&times;</a></td>
                                            </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <c:forEach var="codi" items="${codis}">
                                <c:set var="total" value="${ total + codi.preu}"/>
                            </c:forEach>
                            <c:if test="${total > 0}">
                                <a href="<c:url value="/user/realitzarPagament"/>" class="btn btn-primary" id="realitzarPagament">Pagar - <fmt:formatNumber value="${total}"currencySymbol="€" type="currency" pattern="###,###.00 ¤"/></a>
                            </c:if>
                        </div>
                    </c:if>
                </div>
                <h4  id="jocsH4">Llista de jocs desitjats</h4>
                <div class="row" id="jocsPerfil">
                    <c:forEach var="joc" items="${wishlistgames}" varStatus="status">
                        <div class="column">
                            <div id="black">
                                <div id="imgOverflow">
                                    <a href="<c:url value="/product?id=${joc.codi_Joc}"/>">
                                        <img id="portadaJoc" src="<c:url value="/resources/img/portades/${joc.nom}.jpg"/>">
                                    </a> 
                                </div>
                                <a href="<c:url value="/user/removeWishlist?item=${joc.codi_Joc}&nickname=${user.nickname}"></c:url>">
                                    <img class="retirarWhishList" src="<c:url value="/resources/img/dislike.png"/>" title="${joc.nom}" alt="${joc.nom}">
                                </a>
                                <a href="<c:url value="/product"/>" class="producteAComprar" id="overwatch"><i class="fa fa-arrow-down"></i> ${wishlistcodes[status.index].oferta}% - Comprar</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
    <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>

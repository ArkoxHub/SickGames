<%@page import="com.sick.games.domain.Videojoc"%>
<%@page import="java.util.List"%>
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
        <!--Jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <!--This css-->
        <link href="<c:url value='/resources/css/product.css'/>" rel="stylesheet" type="text/css"/>
        <!--This javascript-->
        <script src="<c:url value='/resources/js/product.js'/>" type="text/javascript" ></script>
    <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
        <!--FI Secció top-->
    <!--Secció body; Jocs més venuts, valorats, millors ofertes, streams...-->
    <section class="section-body">
        <div class="container-cataleg">
            <div class="text-center center" style="padding-top:10px;">
                <a  class="btn btn-primary" href="<c:url value="/admin/updateGame?id=${joc.codi_Joc}"/>">Modifica aquest videojoc</a>
            </div>
            <div class="row" id="cartaJoc">
                <div class="column-3">
                    <img id="stream${joc.nom}" class="portadaJoc" src="<c:url value="/resources/img/portades/${joc.nom}.jpg"/>">
                    <c:choose>
                        <c:when test="${not empty user}">
                            <a href="<c:url value="/user/addWishlist?item=${joc.codi_Joc}&nickname=${user.nickname}"></c:url>">
                                <img class="afegirWhishList" src="<c:url value="/resources/img/like.png"/>" title="${joc.nom}" alt="${joc.nom}">
                            </a>
                        </c:when>
                    </c:choose>
                </div>
                <div class="portada">
                    <img class="portadaJocMvl" src="<c:url value="/resources/img/portades/${joc.nom}.jpg"/>">
                </div>
                <div class="column-9">
                    <div class="row" id="titol">
                        <div class="column-12 text-center">${joc.nom}</div>
                    </div>
                    <div class="row justify-content-md-center">     
                        <img src="<c:url value="/resources/img/plataformes/${codi.plataforma}.png"/>" alt=""> <!-- TEA3:  Falta importat taula Plataforma -->                
                    </div>
                    <div class="row justify-content-md-center" id="genere">
                        <c:forEach var="genere" items="${joc.generes.split(', ')}" varStatus="status">
                            <c:choose>
                                <c:when test="${status.last}">
                                    <c:out value="${genere}" escapeXml="false"></c:out>
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${genere} -" escapeXml="false"></c:out>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </div>
                    <div class="row" id="stock">
                        <div class="column-6 text-left">
                            <span class="stockSi">Stock disponible: <c:out value="${stock}" escapeXml="false"></c:out>
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
                                        <img src="<c:url value="/resources/img/banderas/${split}.png"/>" alt="SickGames,  ofertes jocs, codis jocs online, tenda de codis, ${joc.nom}, ${joc.idioma}">
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="row" id="infoCompres">
                        <div class="column-6 text-left">
                            <!--  <span>70 Adquisicions</span> TEA 3: Falta importat taules Detall i Comanda -->
                        </div>
                        <div class="column-6 text-right">
                            <span>
                                <i class="fa fa-arrow-down"></i> ${codi.oferta}%
                            </span>
                        </div>
                    </div>
                    <div class="row" id="preu">
                        <div class="column-12 text-center">
                            <span><fmt:formatNumber value="${codi.preu}" currencySymbol="€" type="currency" pattern="###,###.00 ¤"/></span>
                        </div>
                    </div>
                    <div class="row" id="comprarJoc">
                        <div class="column-12 text-center">
                            <c:choose>
                                <c:when test="${not empty user}">
                                    <a href="user/add?jocId=${joc.codi_Joc}&nickname=${user.nickname}" class="productToBuy" id="${joc.nom}">
                                        Comprar
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="#" class="productToBuy" id="NoLogin"><!--S'ha de posar que si es fa click aquí, surti un avís de que ha de fer login o donar-se d'alta-->
                                        Comprar
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="column-12 text-left" id="PVP">
                            Preu d'origen: <fmt:formatNumber value="${joc.pvp}" currencySymbol="€" type="currency" pattern="###,###.00 ¤"/>
                        </div>
                    </div>
                </div>
            </div>
            <div id="infoJoc">
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
            <div id="cartaJoc">
                <h4 class="titolsTaules">Streams</h4>
                <div class="row" id="filaStreams"></div><!--S'omplira automaticament amb els top streamers-->
                <div class="row" id="streamView"></div><!--Quan fem click a un stream, podrem veure el video dintre d'aquest div-->
            </div>
    </section>
    <!--Fi secció body-->
    <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>
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
                <div class="text-center center" style="padding-top:30px;">
                </div>
                <div class="row" id="cartaJoc">
                    <div class="column-3">
                        <img id="stream${joc.nom}" class="portadaJoc" src="<c:url value="/resources/img/portades/${joc.nom}.jpg"/>" alt="${joc.nom}">
                    <c:choose>
                        <c:when test="${not empty user}">
                            <a href="<c:url value="/user/addWishlist?item=${joc.codi_Joc}&nickname=${user.nickname}"></c:url>">
                                <img class="afegirWhishList" src="<c:url value="/resources/img/like.png"/>" title="Afegir a la whishlist" alt="Afegir a la wishlish ${joc.nom}">
                            </a>
                        </c:when>
                    </c:choose>
                </div>
                <div class="portada">
                    <img class="portadaJocMvl" src="<c:url value="/resources/img/portades/${joc.nom}.jpg"/>" alt="${joc.nom}">
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
                        <c:if test="${stock gt 0}">
                            <div class="column-12 text-center">
                                <span><fmt:formatNumber value="${codi.preu}" currencySymbol="€" type="currency" pattern="###,###.00 ¤"/></span>
                            </div> 
                        </c:if>
                    </div>
                    <div class="row" id="comprarJoc">
                        <div class="column-12 text-center">
                            <c:choose>
                                <c:when test="${not empty user}">
                                    <c:if test="${stock gt 0}">
                                        <a href="user/add?jocId=${joc.codi_Joc}&nickname=${user.nickname}" class="productToBuy" id="${joc.nom}">
                                            Comprar
                                        </a>
                                    </c:if>
                                    <c:if test="${stock le 0}">
                                        <a href="#" class="productToBuy" id="${joc.nom}">
                                            No Stock
                                        </a>
                                    </c:if>
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${stock gt 0}">
                                        <a href="#" class="productToBuy" id="NoLogin">
                                            Comprar
                                        </a>
                                    </c:if>
                                    <c:if test="${stock le 0}">
                                        <a href="#" class="productToBuy">
                                            No Stock
                                        </a>
                                    </c:if>
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

            <!--Permet afegir comentaris si ha comprat el joc-->
            <div id="cartaJoc">
                <div class="llistaComentaris">
                    <c:if test="${not empty comment}">
                        <h4 class="titolsTaules">Has comprat ${joc.nom}.</h4>
                        <button id="valorar">Valorar</button>
                        <form style="display: none" id="valoration" action="product/comment" method="POST">
                            <p></p>
                            <div class="form-group">
                                <label for="estrelles">Puntuació</label>
                                <input id="puntuacio" list="tickmarks" class="form-control" name="estrelles" type="range" min="1" max="5" step="1" required="true">
                                <datalist id="tickmarks">
                                    <option value="1" label="1"></option>
                                    <option value="2" label="2"></option>
                                    <option value="3" label="3"></option>
                                    <option value="4" label="4"></option>
                                    <option value="5" label="5"></option>
                                </datalist>
                                <p id="rangeValue"></p>
                                <label for="comentari">Escriu el teu comentari</label>
                                <textarea type="text" name="comentari" minlength="100" maxlength="2000" placeholder="Mínim 100 caràcters" required="true"></textarea>
                                <p id="textLeft"></p>
                                <input type="hidden" name="id_Usuari" class="form-control" value="${user.id_Usuari}">
                                <input type="hidden" name="email" class="form-control" value="${user.email}">
                                <input type="hidden" name="nickname" class="form-control" value="${user.nickname}">
                                <input type="hidden" name="codi_Joc" class="form-control" value="${joc.codi_Joc}">
                                <input type="submit" value="Enviar">
                            </div>
                            <p style="color: #4496F2; font-style: italic">Guanyes 2 punts per cada ressenya</p>
                            <p style="color: #4496F2">El comentari es publicarà amb el nom de: 
                                <span style="color: #4596F0">${user.nickname}</span></p>
                        </form>   
                    </c:if>
                </div>
            </div>

            <!--Llista de comentaris publicats per a tots els usuaris-->
            <div id="cartaJoc">
                <h4 class="titolsTaules">Comentaris</h4>
                <div class="llistaComentaris">
                    <div class="row">
                        <div class="col-md-6">
                            <c:if test="${empty comentaris}">
                                <p>No hi ha comentaris</p>
                            </c:if>
                            <c:forEach items="${comentaris}" var="comentari">
                                <p><strong>Usuari:</strong> ${comentari.nickname}</p>
                                <p><strong>Data de publicació:</strong> ${comentari.data_Publicacio}</p>
                                <p><strong>Puntuació:</strong> ${comentari.estrelles}</p>
                                <p><strong>Comentari</strong></p>
                                <p><strong>${comentari.comentari}</p>
                                <p class="line"></p>
                            </c:forEach>
                        </div>
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
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
        <link href="<c:url value='/resources/css/index.css'/>" rel="stylesheet" type="text/css"/>
        <!--This javascript-->
        <script src="<c:url value='/resources/js/index.js'/>" type="text/javascript" ></script>
    <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
        <!--Fi Secció top-->
    <section class="section-body">
        <div class="container-cataleg">

            <div class="text-center center" style="padding-top:10px">
                <a class="btn btn-primary" href="<c:url value="/admin/addGame"/>">Afegir videojoc</a>
                <a class="btn btn-primary" href="<c:url value="/cataleg"/>">Visitar Cataleg</a>
            </div>   
            <!--PRECOMPRA-->
            <p class="tituloFilas">Próximes novetats</p>
            <div class="row" id="filaCatalogo">
                <c:forEach var="joc" items="${upcoming}" begin="0" end="3">
                    <div class="column">
                        <div class="outClick">
                            <div class="mvlGeneres">
                                <span>Veure Generes</span>
                            </div>
                            <a href="<c:url value="/product?id=${joc[0]}"/>" id="${joc[1]}">
                                <div id="imgOverflow">
                                    <img src="<c:url value="/resources/img/portades/${joc[1]}.jpg"/>" 
                                         title="${joc[1]}" alt="SickGames ${joc[1]}">
                                </div>
                                <div class="infoJoc">
                                    <span class="preu"><i class="fa fa-arrow-down"></i> ${joc[3]}%</span>
                                    <c:forEach var="genere" items="${joc[2].split(', ')}">                                       
                                        <div class="genere${genere} liMvl"><span>${genere}</span></div>
                                    </c:forEach>
                                </div>
                            </a>
                        </div>         
                        <a href="<c:url value="/product?id=${joc[0]}"/>" class="producteAComprar" id="overwatch">
                            <fmt:formatNumber value="${joc[5]}" currencySymbol="€" type="currency" pattern="###,###.00 ¤"/> - Comprar
                        </a>
                    </div>
                </c:forEach>
            </div> 

            <!--TOP OFFERTS DESC-->
            <p class="tituloFilas">Millors ofertes</p>
            <div class="row" id="filaCatalogo">
                <c:forEach var="joc" items="${ofertes}" begin="0" end="3">
                    <div class="column">
                        <div class="outClick">
                            <div class="mvlGeneres">
                                <span>Veure Generes</span>
                            </div>
                            <a href="<c:url value="/product?id=${joc[0]}"/>" id="${joc[1]}">
                                <div id="imgOverflow">
                                    <img src="<c:url value="/resources/img/portades/${joc[1]}.jpg"/>" 
                                         title="${joc[1]}" alt="SickGames ${joc[1]}">
                                </div>
                                <div class="infoJoc">
                                    <span class="preu"><i class="fa fa-arrow-down"></i> ${joc[3]}%</span>
                                    <c:forEach var="genere" items="${joc[2].split(', ')}">                                       
                                        <div class="genere${genere} liMvl"><span>${genere}</span></div>
                                    </c:forEach>
                                </div>
                            </a>
                        </div>
                        <a href="<c:url value="/product?id=${joc[0]}"/>" class="producteAComprar" id="overwatch">
                            <fmt:formatNumber value="${joc[5]}" currencySymbol="€" type="currency" pattern="###,###.00 ¤"/> - Comprar
                        </a>
                    </div>
                </c:forEach>
            </div>

            <!--MOST VALORATED GAMES-->
            <p class="tituloFilas">Més econòmics</p>
            <div class="row" id="filaCatalogo">
                <c:forEach var="joc" items="${preus}" begin="0" end="3">
                    <div class="column">
                        <div class="outClick">
                            <div class="mvlGeneres">
                                <span>Veure Generes</span>
                            </div>
                            <a href="<c:url value="/product?id=${joc[0]}"/>" id="${joc[1]}">
                                <div id="imgOverflow">
                                    <img src="<c:url value="/resources/img/portades/${joc[1]}.jpg"/>" 
                                         title="${joc[1]}" alt="SickGames ${joc[1]}">                                        
                                </div>
                                <div class="infoJoc">
                                    <span class="preu"><i class="fa fa-arrow-down"></i> ${joc[3]}%</span>
                                    <c:forEach var="genere" items="${joc[2].split(', ')}">                                       
                                        <div class="genere${genere} liMvl"><span>${genere}</span></div>
                                    </c:forEach>
                                </div>
                            </a>
                        </div>
                        <a href="<c:url value="/product?id=${joc[0]}"/>" class="producteAComprar" id="overwatch"> 
                            <fmt:formatNumber value="${joc[5]}" currencySymbol="€" type="currency" pattern="###,###.00 ¤"/> - Comprar
                        </a>
                    </div>
                </c:forEach>
            </div>

            <!--Streams-->
            <p class="tituloFilas">Top Streamers [ESP]</p>
            <div class="row" id="filaStreams"></div>
            <div class="row" id="streamView"></div>
        </div>
    </section>
    <!--Fi secció body-->
    <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>
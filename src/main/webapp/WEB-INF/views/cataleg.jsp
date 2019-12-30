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
        <link href="<c:url value='/resources/css/cataleg.css'/>" rel="stylesheet" type="text/css"/>
        <!--This javascript-->
        <script src="<c:url value='/resources/js/cataleg.js'/>" type="text/javascript" ></script>
        <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>

    <!--Secció body; Jocs més venuts, valorats, millors ofertes, streams...-->
    <section class="section-body">
        <div class="container-cataleg">
            <div class="text-center center" style="padding-top:10px;">
            </div>
            <div class="row" id="filaCatalogo">
                <div class="col-md-3 menuPlataforma">
                    <div class="row">
                        <div class="col-md-12" id="marginMenuCalaleg"  style="display:none;">
                            <button class="btn btn-primary" id="escollirPlataforma" href="">Plataforma</button>
                            <form class="mostrarPlataforma">
                                <!--Plataformes per mostrar , foreach que recorri tote les plataformes, de mentres ho he creat per probar-ho-->
                                <div class="checkboxDiv">
                                    <label for="Battlenet">
                                        <img src="<c:url value="/resources/img/plataformes/1.png"/>" alt="Battlenet">
                                    </label>
                                    <input type="checkbox" class="checkboxPlataforma" id="Battlenet" name="Battlenet"><br>
                                </div>
                                <div class="checkboxDiv">
                                    <label for="Steam">
                                        <img src="<c:url value="/resources/img/plataformes/2.png"/>" alt="Steam">
                                    </label>
                                    <input type="checkbox" class="checkboxPlataforma" id="Steam" name="Steam"><br>
                                </div>
                                <div class="checkboxDiv">
                                    <label for="Uplay">
                                        <img src="<c:url value="/resources/img/plataformes/3.png"/>" alt="Uplay">
                                    </label>
                                    <input type="checkbox" class="checkboxPlataforma" id="Uplay" name="Uplay"><br>
                                </div>
                                <div class="checkboxDiv">
                                    <label for="Origin">
                                        <img src="<c:url value="/resources/img/plataformes/4.png"/>" alt="Origin">
                                    </label>
                                    <input type="checkbox" class="checkboxPlataforma" id="Origin" name="Origin"><br>
                                </div>
                                <div class="checkboxDiv">
                                    <label for="Nintendo">
                                        <img src="<c:url value="/resources/img/plataformes/5.png"/>" alt="Nintendo">
                                    </label>
                                    <input type="checkbox" class="checkboxPlataforma" id="Nintendo" name="Nintendo"><br>
                                </div>
                                <div class="checkboxDiv">
                                    <label for="Xbox">
                                        <img src="<c:url value="/resources/img/plataformes/6.png"/>" alt="Xbox">
                                    </label>
                                    <input type="checkbox" class="checkboxPlataforma" id="Xbox" name="Xbox"><br>
                                </div>
                                <div class="checkboxDiv">
                                    <label for="PlayStation">
                                        <img src="<c:url value="/resources/img/plataformes/7.png"/>" alt="PlayStation">
                                    </label>
                                    <input type="checkbox" class="checkboxPlataforma" id="PlayStation" name="PlayStation"><br>
                                </div>
                                <div class="checkboxDiv">
                                    <label for="Rockstar">
                                        <img src="<c:url value="/resources/img/plataformes/8.png"/>" alt="Rockstar">
                                    </label>
                                    <input type="checkbox" class="checkboxPlataforma" id="Rockstar" name="Rockstar" ><br>
                                </div>
                                <div class="checkboxDiv">
                                    <label for="Gog">
                                        <img src="<c:url value="/resources/img/plataformes/9.png"/>"
                                    </label>
                                    <input type="checkbox" class="checkboxPlataforma" id="Gog" name="Gog"><br>
                                </div>
                                <div class="checkboxDiv">
                                    <label for="Windows Games">
                                        <img src="<c:url value="/resources/img/plataformes/10.png"/>"
                                    </label>
                                    <input type="checkbox" class="checkboxPlataforma" id="Windows Games" name="Windows Games"><br>
                                </div>
                                <div class="checkboxDiv">
                                    <label for="Apple">
                                        <img src="<c:url value="/resources/img/plataformes/11.png"/>"
                                    </label>
                                    <input type="checkbox" class="checkboxPlataforma" id="Apple" name="Apple"><br>
                                </div>
                                <div class="checkboxDiv">
                                    <label for="Epic Games">
                                        <img src="<c:url value="/resources/img/plataformes/12.png"/>"
                                    </label>
                                    <input type="checkbox" class="checkboxPlataforma" id="Epic Games" name="Epic Games"><br>
                                </div>

                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12" id="marginMenuCalaleg">
                            <button class="btn btn-primary" id="escollirGenere" >Genere</button>
                            <form class="mostrarGenere">
                                <!--Generes per mostrar, foreach generes... -->
                                <div class="row" style="max-width: fit-content;">
                                    <%
                                        String[] llistaGeneres = {
                                            "FPS", "RPG", "Cooperació", "Deportiu", "Multijugador",
                                            "Construcció", "Aventura", "Survival", "Gestió", "Estratègia",
                                            "SinglePlayer", "Acció", "Simulador", "MMO", "Indies",
                                            "Conducció", "Plataforma", "Lluita"
                                        };
                                        pageContext.setAttribute("llistaGeneres", llistaGeneres);
                                    %>
                                    <div class="col-md-12 checkboxDiv">
                                        <div id="formLeft">
                                            <label for="generesTots">Tots</label>
                                        </div>
                                        <div id="formRight">
                                            <input type="checkbox" class="generesTots" id="generesTots" name="generesTots" value="on" checked><br>
                                        </div>
                                    </div>
                                    <hr>
                                    <c:forEach var="generes" items="${llistaGeneres}">
                                        <div class="col-md-12 checkboxDiv">
                                            <div id="formLeft">
                                                <label for="${generes}">${generes}</label>
                                            </div>
                                            <div id="formRight">
                                                <input type="checkbox" class="checkboxGenere" data-target="${generes}" id="${generes}" name="gen"><br>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12" id="marginMenuCalaleg">
                            <button class="btn btn-primary" id="escollirPreu" >Preu</button>
                            <form class="mostrarPreu">
                                <!--Generes per mostrar, foreach generes... -->
                                <div class="row">
                                    <div class="col-md-12 checkboxDiv">
                                        <input type="range" class="custom-range" id="customRange" min="5" max="70" step="5" value="70">
                                        <div class="value">Preu inferior a: 70 €</div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>               
                </div>
                <div class="col-md-9">
                    <div class="container-fluid" id="catalegJocs">
                        <div class="row">
                            <c:forEach var="joc" items="${videojocs}">
                                <c:set var="search" value="'" />
                                <c:set var = "string1" value = "${fn:replace(joc[1],' ', '')}" />
                                <c:set var = "string2" value = "${fn:replace(string1,search, '')}" />
                                <div class="column <c:forTokens var="token" items="${joc[2]}" delims=","> ${token} </c:forTokens> ${string2}">
                                    <div class="outClick">
                                        <div class="mvlGeneres">
                                            <span>Veure Generes</span>
                                        </div>
                                        <a href="<c:url value="/product?id=${joc[0]}"/>" id="${joc[1]}">
                                            <div id="imgOverflow">
                                                <img src="<c:url value="/resources/img/portades/${joc[1]}.jpg"/>" title="${joc[1]}" alt="SickGames,  ofertes jocs, codis jocs online, tenda de codis, ${joc[1]}">
                                            </div>
                                            <div class="infoJoc">
                                                <span class="preu"><i class="fa fa-arrow-down"></i> ${joc[3]}%</span>
                                                <c:forTokens var="g" items="${joc[2]}" delims=", "> 
                                                    <div class="genere${g} liMvl"><span>${g}</span></div>
                                                </c:forTokens>
                                            </div>
                                        </a>
                                        <a href="<c:url value="product?id=${joc[0]}"/>" class="producteAComprar" id="${joc[5]}" title="${joc[1]}">
                                            <fmt:formatNumber value="${joc[5]}" currencySymbol="€" type="currency" pattern="###,###.00 ¤"/> - Comprar
                                        </a>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>  
                </div>
            </div>
        </div>
    </section>
    <!--Fi secció body-->
    <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>
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
        <link href="<c:url value='/resources/css/realitzarPagament.css'/>" rel="stylesheet" type="text/css"/>
        <!--This javascript-->
        <script src="<c:url value='/resources/js/realitzarPagament.js'/>" type="text/javascript" ></script>
        <style>
            table, th, tr {
                background-color: #333; 
                border-collapse: collapse; 
                border: 1px solid black;

            }
            table {
                min-width: 300px;
            }
        </style>
    </head>
    <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
        <section class="section-body">
            <div class="container-cataleg">
                <div class="row" id="pagamentRow">
                    <div class="col-md-6">
                        <form action="buyout" method="POST" id="formPagament" name="formPagament">
                            <label for="nomTitular">Titular de la tarjeta:</label>
                            <input class="form-control" type="text" name="nomTitular" id="nomTitular" required><br/>

                            <label for="numTarjeta">Número de la tarjeta:</label>
                            <input class="form-control" type="number" name="numTarjeta" id="numTarjeta" required><br/>

                            <label for="mesCad">Mes de caducitat</label>
                            <input class="form-control" type="number" name="mesCad" id="mesCad" required><br/>

                            <label for="anyCad">Any de caducitat</label>
                            <input class="form-control" type="number" name="anyCad" id="anyCad" required><br/>

                            <label for="cvc">Codi CVC2</label>
                            <input class="form-control" type="number" name="cvc" id="cvc" required><br/>

                            <input type="hidden" name="punts" value="${punts}">
                            <input type="hidden" name="jocs" value="${carro}">
                            <input type="hidden" name="codis" value="${codis}">
                            <input type="hidden" name="factura" value="${total}">
                            <input type="hidden" name="user" value="${user}">

                        <input class="btn btn-primary" type="submit" value="Comprar">
                    </form>                        
                </div>
                <div class="col-md-6">
                    <h2>Productes:</h2>
                        <table class="table table-striped table-dark">
                            <thead>
                                <td scope="col">Joc a comprar</td>
                                <td scope="col">Preu</td>
                            </thead>
                            <tbody>
                                <c:forEach items="${carro}" var="joc" varStatus="status">  
                                    <tr>  
                                        <td>
                                            <img class="imgProducteComprat" style="width: 60px" src="<c:url value="/resources/img/portades/${joc.nom}.jpg"/>">
                                            <span style="color: green;">${joc.nom}</span>
                                        </td><!--Tambien joc nom-->
                                        <td id="serial">                                        
                                            ${codis[status.index].preu}€
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                         </table>
                    <div class="row" id="rowCurrency">
                        <div class="col-md-6">
                            <h5>Import total: <fmt:formatNumber value="${total}"currencySymbol="€" type="currency" pattern="###,###.00 ¤"/></h5>
                        </div>
                        <div class="col-md-6">
                            <h5>Punts adquirits: <span style="color: green">${punts}</span></h5>
                        </div>
                    </div>
                    <div>
                        <h2>Sistema de punts</h2>
                        <table class="table table-striped table-dark">
                            <thead>
                                <tr>
                                    <th scope="col">Preu videojoc</th>
                                    <th scope="col">Punts</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr id="seixanta">
                                    <td>+ 60€</td>
                                    <td>30</td>
                                </tr>
                                <tr id="quaranta">
                                    <td>+ 40€</td>
                                    <td>10</td>
                                </tr>
                                <tr id="vint">
                                    <td>+ 20€</td>
                                    <td>5</td>
                                </tr>
                                <tr id="cinc">
                                    <td>+ 5€</td>
                                    <td>2</td>
                                </tr>
                            </tbody>
                        </table>
                        <em>*Al comprar a SickGames, guanyes punts bescanviables per grans descomptes en les futures compres!</em>
                    </div>
                </div>
            </div>
    </section>
    <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>
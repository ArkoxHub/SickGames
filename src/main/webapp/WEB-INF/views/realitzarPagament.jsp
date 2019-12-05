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
                        <form action="buyout" method="POST">
                            <label for="nomTitular">Titular de la tarjeta:</label>
                            <input class="form-control" type="text" name="nomTitular" required><br/>

                            <label for="numTarjeta">Número de la tarjeta:</label>
                            <input class="form-control" type="number" name="numTarjeta" required><br/>

                            <label for="mesCad">Mes de caducitat</label>
                            <input class="form-control" type="number" name="mesCad" required><br/>

                            <label for="anyCad">Any de caducitat</label>
                            <input class="form-control" type="number" name="anyCad" required><br/>

                            <label for="cvc">Codi CVC2</label>
                            <input class="form-control" type="number" name="cvc" required><br/>

                            <input type="hidden" name="punts" value="${punts}">
                            <input type="hidden" name="jocs" value="${carro}">
                            <input type="hidden" name="codis" value="${codis}">
                            <input type="hidden" name="factura" value="${total}">
                            <input type="hidden" name="user" value="${user}">

                        <input class="btn btn-primary" type="submit" value="Comprar">
                    </form>                        
                </div>
                <div class="col-md-6">
                    <div class="tarjeta"></div>
                </div>
                <div class="col-md-6 col-lg-6 col-sm-4" style="border: 1px dotted yellowgreen;">
                    <p>Productes:</p>
                    <c:forEach items="${carro}" var="joc" varStatus="status">              
                        <p><span style="color: green;">${joc.nom}</span> - <span style="color: orangered;">${codis[status.index].preu}€</span></p>
                    </c:forEach>
                    <h5>Import total: <fmt:formatNumber value="${total}"currencySymbol="€" type="currency" pattern="###,###.00 ¤"/></h5>
                    <h5>Total punts al realitzar la compra: <span style="color: green">${punts}</span></h5>
                </div>
            </div>

            <hr>
            <div>
                <p>
                    Al comprar a SickGames, guanyes punts bescanviables per grans descomptes en les futures compres!<br>
                <table>
                    <thead>Taula de punts SickGames</thead>
                    <tr>
                        <th>Preu videojoc</th>
                        <th>Punts</th>
                    </tr>
                    <tr>
                        <td>+ 60€</td>
                        <td>30</td>
                    </tr>
                    <tr>
                        <td>+ 40</td>
                        <td>10</td>
                    </tr>
                    <tr>
                        <td>+ 20€</td>
                        <td>5</td>
                    </tr>
                    <tr>
                        <td>+ 5</td>
                        <td>2</td>
                    </tr>
                </table>
                </p>
            </div>
        </div>
    </section>
    <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>
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

    <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
        <section class="section-body">
            <div class="container-cataleg">
                <div class="row" id="pagamentRow">
                    <div class="col-md-6">
                        <form style="max-width: 300px" class="bla" action="" method="post" >
                            <label for="nomTitular">Titular de la tarjeta:</label>
                            <input class="form-control" type="text" name="nomTitular" required><br/>

                            <label for="numTarjeta">Número de la tarjeta:</label>
                            <input class="form-control" type="text" name="numTarjeta" required><br/>

                            <label for="mesCad">Mes de caducitat</label>
                            <input class="form-control" type="text" name="mesCad" required><br/>

                            <label for="anyCad">Any de caducitat</label>
                            <input class="form-control" type="text" name="anyCad" required><br/>
                            
                            <label for="cvc">Codi CVC2</label>
                            <input class="form-control" type="text" name="cvc" required><br/>
                            
                            <input class="btn btn-primary" type="submit" value="Enviar">
                        </form>                        
                    </div>
                    <div class="col-md-6">
                        <div class="tarjeta"></div>
                    </div>
                </div>
            </div>
        </section>
    <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>
<%-- 
    Document   : updateCodeForm
    Created on : 01-dic-2019, 23:16:01
    Author     : Adri
--%>

<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Formulari add Codi</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--Bootstrap CSS-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="true">
        <!--My css-->
        <link href="<c:url value='/resources/css/global.css'/>" rel="stylesheet" type="text/css"/>
        <!--WebIcon-->
        <link rel="icon" href="<c:url value='/resources/img/logo_icon.png'/>" alt="Favicon">
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
        <div class="container">
            <form:form modelAttribute="codi" method="POST">
                <div class="col-12 col-sm-12 col-md-8 col-lg-6">
                    <div class="panel-heading text-center">
                        <h3 class="panel-title">Formulari per afegir codi a un joc</h3>
                    </div>
                    <c:if test="${status == 'OK'}">
                        <div class="alert">
                            <p style="color: green;">Codi guardat satisfactòriament</p>
                        </div>
                    </c:if>
                    <c:if test="${status == 'ERROR'}">
                        <div class="alert alert-danger">
                            Error al pujar el codi a la base de dades
                        </div>
                    </c:if>
                    <c:if test="${status == 'DUPLICATE'}">
                        <div class="alert alert-danger">
                            Serial existent a la base de dades
                        </div>
                    </c:if>
                    <div class="form-group">
                        <label for="serial">Serial</label>
                        <form:input class="form-control" path="serial" type="text" id="serial" min="19" max="19" required="true" 
                                    pattern="[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}"></form:input>
                    </div>
                    <div class="form-group">
                        <label for="oferta">Oferta</label>
                        <form:input class="form-control" path="oferta" type="number" id="oferta" required="true"></form:input>
                    </div>
                    <div class="form-group">
                        <label for="codi_Joc">Codi referència Videojoc</label>
                        <form:input class="form-control" path="codi_Joc" type="number" id="codi_Joc" required="true"></form:input>
                    </div>
                    <div class="form-group">
                        <label for="plataforma">Codi Plataforma</label>
                        <form:input class="form-control" path="plataforma" type="number" id="plataforma" required="true"></form:input>
                    </div>
                    <input class="btn btn-lg btn-success btn-block" type="submit" value="Afegir">
                </div>
            </form:form>
            <hr>
            <p>
                *El preu del codi es calcularà automàticament tenint en compte el
                Preu de Venta al Públic (PVP) del videojoc i l'oferta aplicada en aquest codi.
            </p>
        </div>
    </body>
</html>

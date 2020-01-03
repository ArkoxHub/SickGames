<%-- 
    Document   : addCodeForm
    Created on : 01-dic-2019, 18:25:48
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

        <!--Jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <!--My css-->
        <link href="<c:url value='/resources/css/admin.css'/>" rel="stylesheet" type="text/css"/>

        <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
        <section class="section-body">
            <div class="container-cataleg">
                <div class="row" id="adminRow">
                    <div class="logout text-center">
                        <a href="<c:url value="/admin" />" 
                       class="btn btn-primary" style="color: white">Panell Admin</a>
                    <a href="<c:url value="/j_spring_security_logout" />" 
                       class="btn btn-danger btn-mini pull-right" style="color: white">Desconectar ${admin}</a>
                </div>
            </div>
            <div>
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
        </div>
    </section>
</body>
</html>


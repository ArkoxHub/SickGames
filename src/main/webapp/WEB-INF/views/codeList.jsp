<%-- 
    Document   : codeList
    Created on : 01-dic-2019, 20:55:00
    Author     : Adri
--%>

<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Admin Page</title>
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
            <h2>${option} Codis</h2>
            <div class="row">        
                <div class="col-md-12">
                    <form action="/sickgames/admin/codeList/${option}" method="POST">
                        <div class="form-group">
                            <label for="codi">Codi del Videojoc</label>
                            <input class="for-control" type="number" id="codi" name="codi">
                            <input class="btn btn-success btn-block" type="submit" value="Consultar" required>
                        </div>
                    </form>
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger">
                            ${error}
                        </div>
                    </c:if>
                    <c:if test="${not empty status}">
                        <div class="alert" style="background-color: green;">
                            ${status}
                        </div>
                    </c:if>
                    <c:if test="${not empty videojoc}">
                        <h2>Videojoc: ${videojoc.nom}</h2>
                    </c:if>
                    <c:forEach items="${codis}" var="codi">
                        <c:if test="${option == 'Modify'}">
                            <li class="gameList">
                                <a href="<c:url value="/admin/updateCode?id=${codi.codi}"></c:url>">${codi.serial}</a>
                                </li>
                        </c:if>
                        <c:if test="${option == 'Delete'}">
                            <li class="gameList">
                                <a class="confirm" href="<c:url value="/admin/Delete/deleteCode?id=${codi.codi}&codi_Joc=${codi.codi_Joc}"></c:url>">${codi.serial}</a>
                                </li>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
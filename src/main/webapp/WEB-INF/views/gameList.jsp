<%-- 
    Document   : gameList
    Created on : 01-dic-2019, 0:30:50
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
        <!--My JS-->
        <script src="<c:url value='/resources/js/admin.js'/>" type="text/javascript"></script>
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
            <h2>${option} Videojocs</h2>
            <div class="row">           
                <div class="col-md-12">
                    <c:forEach items="${videojocs}" var="joc">
                        <c:if test="${option == 'Modify'}">
                            <li class="gameList">
                                <a style="color:white !important" href="<c:url value="/admin/updateGame?id=${joc.codi_Joc}"></c:url>">${joc.nom}</a>
                                </li>
                        </c:if>
                        <c:if test="${option == 'Delete'}">
                            <li class="gameList">
                                <a style="color:white !important" class="confirm" href="<c:url value="/admin/deleteGame?id=${joc.codi_Joc}"></c:url>">${joc.nom}</a>
                                </li>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
</body>
</html>

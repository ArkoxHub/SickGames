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

        <!--Bootstrap CSS-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="true">
        <!--My css-->
        <link href="<c:url value='/resources/css/admin.css'/>" rel="stylesheet" type="text/css"/>
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

                <div class="row">
                    <div class="logout text-center">
                        <a href="<c:url value="/j_spring_security_logout" />" 
                       class="btn btndanger btn-mini pull-right" style="color: white">Desconectar Admin</a><br>
                </div>

            </div>
            <h2>${option} Codis</h2>
            <div class="row">        
                <div>
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
    </body>
</html>
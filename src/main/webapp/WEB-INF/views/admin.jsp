<%-- 
    Document   : admin
    Created on : 29-nov-2019, 0:05:00
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
                        <a href="<c:url value="/j_spring_security_logout" />" 
                       class="btn btn-danger btn-mini pull-right" style="color: white">Desconectar ${admin}</a><br>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-4 col-md-12 col-sm-12 col-12 option">
                    <div class="accio">
                        <h2>Videojocs</h2>
                        <a href="<c:url value="/admin/addGame"></c:url>"><li>Afegir videojoc</li></a>
                        <a href="<c:url value="/admin/gameList/Modify"></c:url>"><li>Modificar videojoc</li></a>
                        <a href="<c:url value="/admin/gameList/Delete"></c:url>"><li>Eliminar videojoc</li></a>
                        </div>
                    </div>
                    <div class="col-xl-4 col-md-12 col-sm-12 col-12 option">
                        <div class="accio">
                            <h2>Codis</h2>
                            <a href="<c:url value="/admin/addCode"></c:url>"><li>Afegir codi</li></a>
                        <a href="<c:url value="/admin/codeList/Modify"></c:url>"><li>Modificar codi</li></a>
                        <a href="<c:url value="/admin/codeList/Delete"></c:url>"><li>Eliminar codi</li></a>
                        </div>
                    </div>
                    <div class="col-xl-4 col-md-12 col-sm-12 col-12 option">
                        <div class="accio">
                            <h2>Usuaris</h2>
                            <a href="<c:url value="#"></c:url>"><li>Afegir partner</li></a>
                        <a href="<c:url value="#"></c:url>"><li>Modificar dades usuari</li></a>
                        <a href="<c:url value="#"></c:url>"><li>Eliminar usuari</li></a>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>

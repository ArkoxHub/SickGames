<%-- 
    Document   : adminLogin
    Created on : 29-nov-2019, 0:05:17
    Author     : Adri
--%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Admin Login</title>
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
                    <div class="col-sm-12, col-md-12 col-lg-8 col-xl-6 text-center">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Introdueixi les dades d'accés</h3>
                            </div>
                            <div class="panel-body">
                                <c:if test="${not empty error}">
                                    <div class="alert alert-danger">
                                        Dades incorrectes
                                    </div>
                                </c:if>
                                <form action="<c:url value="/j_spring_security_check"> </c:url>" method="post">
                                    <fieldset>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Usuari" name='j_username' type="text">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Contrasenya" name='j_password' type="password">
                                        </div>
                                        <input class="btn btn-lg btn-success btn-block" type="submit" value="Connectar">
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>

<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="cat">
    <head>
        <title>SickGames</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--Bootstrap CSS-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="true">
        <!--My css-->
        <link href="<c:url value='../resources/css/signIn.css'/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value='../resources/css/global.css'/>" rel="stylesheet" type="text/css"/>
        <!--WebIcon-->
        <link rel="icon" href="<c:url value='../resources/img/logo_icon.png'/>" alt="Favicon">
        <!--FontsGoogle-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="true">
        <link href="https://fonts.googleapis.com/css?family=Archivo&display=swap" rel="stylesheet">
        <!--FontAwesome js-->
        <script src="https://use.fontawesome.com/384f95a176.js"></script>
        <!--Jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <!--My javascript-->
        <script src="<c:url value='../resources/js/signIn.js'/>" type="text/javascript" ></script>
        <script src="<c:url value='../resources/js/funcions.js'/>" type="text/javascript" ></script>
    </head>

    <body>
        <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
            <!--Fi Secció top-->
            <section class="section-body">
                <div class="container-cataleg register">
                <form:form modelAttribute="user" method="POST">
                    <div class="row">
                        <div class="col-md-3 register-left">
                            <h3>Benvingut/da a</h3>
                            <img src="<c:url value='/resources/img/logo_sick.png'/>" alt=""/><br/>
                            <a id="login" class="btn btn-primary btnRegister">Login</a>
                        </div>
                        <div class="col-md-9 register-right">
                            <div class="tab-content" id="myTabContent">
                                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                    <h3 class="register-heading">Registre d'usuari</h3>
                                    <div class="row register-form">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="nom">Nom</label>
                                                <div class="input-container">
                                                    <i class="fa fa-user icon"></i>
                                                    <form:input path="nom" type="text" id="nom" class="input-field" required="true" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="cognoms">Cognoms</label>
                                                <div class="input-container">
                                                    <i class="fa fa-user icon"></i>
                                                    <form:input path="cognoms" type="text" id="cognoms" class="input-field" required="true"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="nickname">Nickname</label>
                                                <div class="input-container">
                                                    <i class="fa fa-user icon"></i>
                                                    <form:input path="nickname" type="text" id="nickname" class="input-field" required="true"/>
                                                </div>
                                            </div>
                                            <div class="form-group" id="pass">
                                                <label for="contrasenya">Contrasenya</label>
                                                <div class="input-container">
                                                    <i class="fa fa-key icon"></i>
                                                    <form:input path="contrasenya" type="password" id="contrasenya" maxlength="20" class="input-field" required="true"/>
                                                    <i class="fa fa-eye icon"></i>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="email">Correu electrònic</label>
                                                <div class="input-container">
                                                    <i class="fa fa-envelope icon"></i>
                                                    <form:input path="email" type="email" id="email" class="input-field" required="true"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="telefon">Número de Telèfon</label>
                                                <div class="input-container">
                                                    <i class="fa fa-phone icon"></i>
                                                    <form:input path="telefon" type="number" id="telefon" minlength="9" maxlength="9" name="txtEmpPhone" class="input-field" required="true"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="direccio">Direcció</label>
                                                <div class="input-container">
                                                    <i class="fa fa-home icon"></i>
                                                    <form:input path="direccio" type="text" id="direccio" class="input-field" required="true"/>
                                                </div>
                                            </div>
                                            <div class="form-group" id="confirmarContrasenya">
                                                <label for="contrasenyaConfirm">Confirma la contrasenya</label>
                                                <div class="input-container" id="checkThis">
                                                    <i class="fa fa-key icon"></i>
                                                    <input type="password" id="contrasenyaConfirm" maxlength="20" class="input-field" required="true"/>
                                                </div>
                                            </div>
                                        </div>
                                    <div class="form-group" id="submitButton">
                                        <input type="submit" class="btn btn-primary btnRegister"  value="Registrarse"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </section>
    <!--Fi secció body-->
    <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>
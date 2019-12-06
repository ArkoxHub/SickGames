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
        <!--Jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <!--This css-->
        <link href="<c:url value='../resources/css/signIn.css'/>" rel="stylesheet" type="text/css"/>
        <!--This javascript-->
        <script src="<c:url value='../resources/js/signIn.js'/>" type="text/javascript" ></script>
        
        
    <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
        <!--Fi Secció top-->
        <section class="section-body">
            <div class="container-cataleg register">
                <form:form modelAttribute="user" method="POST" name="registre">
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
                                            <spring:message text="Juan" var="nombre"/>
                                            <label for="nom">Nom</label>
                                            <div class="input-container">
                                                <i class="fa fa-user icon"></i>
                                                <form:input path="nom" type="text" id="nom" class="input-field" required="true" placeholder="${nombre}" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <spring:message text="Sánchez de las Montañas" var="cognoms"/>
                                            <label for="cognoms">Cognoms</label>
                                            <div class="input-container">
                                                <i class="fa fa-user icon"></i>
                                                <form:input path="cognoms" type="text" id="cognoms" class="input-field" required="true" placeholder="${cognoms}" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <spring:message text="Senyor X" var="nickname"/>
                                            <label for="nickname">Nickname</label>
                                            <div class="input-container">
                                                <i class="fa fa-user icon"></i>
                                                <form:input path="nickname" type="text" id="nickname" class="input-field" required="true" placeholder="${nickname}" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <spring:message text="tucorreo@hotmail.com" var="correu"/>
                                            <label for="email">Correu electrònic</label>
                                            <div class="input-container">
                                                <i class="fa fa-envelope icon"></i>
                                                <form:input path="email" type="email" id="email" class="input-field" required="true" placeholder="${correu}" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <spring:message text="679148114" var="telefon"/>
                                            <label for="telefon">Número de Telèfon</label>
                                            <div class="input-container">
                                                <i class="fa fa-phone icon"></i>
                                                <form:input path="telefon" type="number" id="telefon" minlength="9" maxlength="9" name="txtEmpPhone" class="input-field" value="0" required="true" placeholder="${telefon}" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <spring:message text="C/Catalunya 27, 5 - 2a" var="direccio"/>
                                            <label for="direccio">Direcció</label>
                                            <div class="input-container">
                                                <i class="fa fa-home icon"></i>
                                                <form:input path="direccio" type="text" id="direccio" class="input-field" required="true" placeholder="${direccio}" />
                                            </div>
                                        </div>
                                        <div class="form-group" id="pass">
                                            <label for="contrasenya">Contrasenya</label>
                                            <div class="input-container">
                                                <i class="fa fa-key icon"></i>
                                                <form:input path="contrasenya" type="password" id="contrasenya" name="contrasenya" maxlength="20" class="input-field" required="true"/>
                                                <i class="fa fa-eye icon"></i>
                                            </div>
                                        </div>    
                                        <div class="form-group" id="confirmarContrasenya">
                                            <label for="contrasenyaConfirm">Confirma la contrasenya</label>
                                            <div class="input-container" id="checkThis">
                                                <i class="fa fa-key icon"></i>
                                                <input type="password" id="contrasenyaConfirm" name="contrasenyaConfirm" maxlength="20" class="input-field" required="true"/>
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
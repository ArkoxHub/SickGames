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

        <!--Bootstrap CSS-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="true">
        <!--My css-->
        <link href="<c:url value='/resources/css/signIn.css'/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value='/resources/css/global.css'/>" rel="stylesheet" type="text/css"/>
        <!--WebIcon-->
        <link rel="icon" href="<c:url value='resources/img/logo_icon.png'/>" alt="Favicon">
        <!--FontsGoogle-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="true">
        <link href="https://fonts.googleapis.com/css?family=Archivo&display=swap" rel="stylesheet">
        <!--FontAwesome js-->
        <script src="https://use.fontawesome.com/384f95a176.js"></script>
        <!--Jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <!--My javascript-->
        <script src="<c:url value='/resources/js/signIn.js'/>" type="text/javascript" ></script>
        <script src="<c:url value='/resources/js/funcions.js'/>" type="text/javascript" ></script>
    </head>

    <body>
        <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
        <!--Fi Secció top-->
        <section class="section-body">
            <div class="container register">
                <form action="#">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <h3>Benvingut/da a</h3>
                        <img src="<c:url value='/resources/img/logo_sick.png'/>" alt=""/><br/>
                        <a href="<c:url value='/login'/>" class="btn btn-primary btnRegister">Login</a>
                    </div>
                    <div class="col-md-9 register-right">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Registre d'Usuari</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="nom">Nom</label>
                                            <div class="input-container">
                                                <i class="fa fa-user icon"></i>
                                                <input type="text" id="nom" class="input-field" placeholder="Joan" required/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="cognom1">Primer Cognom</label>
                                            <div class="input-container">
                                                <i class="fa fa-user icon"></i>
                                                <input type="text" id="cognom1" class="input-field" placeholder="García" required/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="cognom2">Segon Cognom</label>
                                            <div class="input-container">
                                                <i class="fa fa-user icon"></i>
                                                <input type="text" id="cognom2" class="input-field" placeholder="Fernandez" required/>
                                            </div>
                                        </div>
                                        <div class="form-group" id="pass">
                                            <label for="contrasenya">Contrasenya</label>
                                            <div class="input-container">
                                                <i class="fa fa-key icon"></i>
                                                <input type="password" id="contrasenya" maxlength="20" class="input-field" placeholder="*******" required/>
                                                <i class="fa fa-eye icon"></i>
                                            </div>
                                        </div>
                                        <div class="form-group" id="confirmarContrasenya">
                                            <label for="contrasenyaConfirm">Confirma la contrasenya</label>
                                            <div class="input-container" id="checkThis">
                                                <i class="fa fa-key icon"></i>
                                                <input type="password" id="contrasenyaConfirm" maxlength="20" class="input-field"  placeholder="*******" required/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="correu">Correu electronic</label>
                                            <div class="input-container">
                                                <i class="fa fa-envelope icon"></i>
                                                <input type="email" id="correu" class="input-field" placeholder="joangf@gmail.com" required/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="telefon">Número de Telèfon</label>
                                            <div class="input-container">
                                                <i class="fa fa-phone icon"></i>
                                                <input type="text" id="telefon" minlength="9" maxlength="9" name="txtEmpPhone" class="input-field" placeholder="935402318" required/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="direccio">Direcció</label>
                                            <div class="input-container">
                                                <i class="fa fa-home icon"></i>
                                                <input type="text" id="direccio" class="input-field" placeholder="C/ De les monjes 2" required/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="data">Dia d'enregistrament</label>
                                            <div class="input-container">
                                                <i class="fa fa-calendar icon"></i>
                                                <c:set var = "now" value ="<%= new java.util.Date()%>"/>
                                                <input type="text" id="data" class="input-field" value="<fmt:formatDate pattern = 'yyyy-MM-dd' value = '${now}' />" disabled/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="maxl text-center center">
                                                <label class="checkbox-right"> 
                                                    <input type="checkbox" name="radio" value="Partner">
                                                    <span> Vols ser Partner? </span> 
                                                </label>
                                            </div>
                                        </div>
                                        <div id="partner">    
                                            <div class="form-group">
                                                <label for="twitch">Nom canal de Twitch</label>
                                                <div class="input-container">
                                                    <i class="fab fa-twitch icon"></i>
                                                    <input type="text" id="twitch" class="input-field" placeholder="soyunbot"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="text-center center">
                                            <input type="submit" class="btnRegister"  value="Registrarse"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                </form>
            </div>
        </section>
        <!--Fi secció body-->
        <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>
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
        <link href="<c:url value='/resources/css/suport.css'/>" rel="stylesheet" type="text/css"/>
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
        <script src="<c:url value='/resources/js/suport.js'/>" type="text/javascript" ></script>
        <script src="<c:url value='/resources/js/funcions.js'/>" type="text/javascript" ></script>
    </head>

    <body>
        <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
            <!--Fi Secció top-->
        <div class="text-center center" style="margin-bottom:-20px; margin-top:10px">
        </div>

        <section class="section-body">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center divTitol">
                        <span class="textTitol">Com activar el codi adquirit</span>
                        <div class="text-left descripcioSuport">
                            <p class="bla">
                                "En espera de la verificación" es un bloqueo temporal de una transacción por nuestro sistema de seguridad. Las instrucciones para verificar una compra están disponibles en "Mis pedidos", aunque también se envian por correo.
                                    
                                Esto no es un paso obligatorio, por lo tanto, si no deseas verificar tu transacción, podemos cancelar tu compra y reembolsarte.
                            </p>
                        </div>
                    </div>
                    <div class="col-md-12 text-center divTitol">
                        <span class="textTitol">Reembolsar un videojoc</span>
                        <div class="text-left descripcioSuport">
                            <p class="bla">
                                Un cop adquirit un codi de videojoc no es pot retornar, ja que no formem part de les empreses on s'activen aquest codis
                            </p>
                        </div>
                    </div>
                    <div class="col-md-12 text-center divTitol">
                        <span class="textTitol">El meu codi no funciona</span>
                        <div class="text-left descripcioSuport">
                            <p class="bla">
                                En cas de que el codi no funcioni omple aquest formulari amb el codi pero comprobar 
                                amb l'empresa responsable quan va ser activat, en cas de que hagi sigut activat abans 
                                de la seva adquisició es reembolsara el 100% del preu. En cas de que hagi sigut activat
                                desprès de la seva adquisició, SickGames no es fa responsable del seu mal ús.
                            </p>
                        </div>
                    </div>
                    <div class="col-md-12 text-center divTitol">
                        <span class="textTitol">Problemes de rendiment amb un joc</span>
                        <div class="text-left descripcioSuport">
                            <p class="bla">
                                SickGames no es fa carrec del funcionament dels jocs ja que no som els desenvolupadors.
                                Si us plau posat amb contacte amb el desenvolupador del joc en questió.
                            </p>
                        </div>
                    </div>
                    <div class="col-md-12 text-center divTitol">
                        <span class="textTitol">No puc recuperar la contrasenya</span>
                        <div class="text-left descripcioSuport">
                            <p class="bla">
                                En cas de que el codi no funcioni omple aquest formulari amb el codi pero comprobar 
                                amb l'empresa responsable quan va ser activat, en cas de que hagi sigut activat abans 
                                de la seva adquisició es reembolsara el 100% del preu. En cas de que hagi sigut activat
                                desprès de la seva adquisició, SickGames no es fa responsable del seu mal ús.
                            </p>
                        </div>
                    </div>
                    <div class="col-md-12 text-center divTitol">
                        <span class="textTitol">No trobo la solució al meu problema</span>
                        <div class="text-left descripcioSuport">
                            <p class="bla">
                                Si no hem pogut resoldre els teus dubtes, omple el següent formulari amb la descripció del
                                problema.
                            </p>
                        </div>
                    </div>
                </div>                
            </div>
        </section>
        <!--Fi secció body-->
        <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>

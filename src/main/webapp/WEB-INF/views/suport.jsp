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
        <!--Jquery-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <!--This css-->
        <link href="<c:url value='/resources/css/suport.css'/>" rel="stylesheet" type="text/css"/>
        <!--This javascript-->
        <script src="<c:url value='/resources/js/suport.js'/>" type="text/javascript" ></script>
    <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
        <!--Fi Secció top-->
    <section class="section-body">
        <div class="container-cataleg">
            <div class="row" id="suportRow">
                <div class="col-md-12 text-center divTitol">
                    <span class="textTitol">Com activar el codi adquirit</span>
                </div>
                <div class="text-left descripcioSuport">
                    <p class="bla">
                        "En espera de la verificación" es un bloqueo temporal de una transacción por nuestro sistema de seguridad. Las instrucciones para verificar una compra están disponibles en "Mis pedidos", aunque también se envian por correo.

                        Esto no es un paso obligatorio, por lo tanto, si no deseas verificar tu transacción, podemos cancelar tu compra y reembolsarte.
                    </p>
                </div>
                
                <div class="col-md-12 text-center divTitol">
                    <span class="textTitol">Reembolsar un videojoc</span>
                </div>
                <div class="text-left descripcioSuport">
                    <p class="bla">
                        Un cop adquirit un codi de videojoc no es pot retornar, ja que no formem part de les empreses on s'activen aquest codis
                    </p>
                </div>
                
                <div class="col-md-12 text-center divTitol">
                    <span class="textTitol">El meu codi no funciona</span>
                </div>
                <div class="text-left descripcioSuport">
                    <p class="bla">
                        En cas de que el codi no funcioni omple aquest formulari amb el codi per comprobar 
                        amb l'empresa responsable quan va ser activat, en cas de que hagi sigut activat abans 
                        de la seva adquisició es reembolsara el 100% del preu. En cas de que hagi sigut activat
                        desprès de la seva adquisició, SickGames no es fa responsable del seu mal ús.
                    </p>
                    <form style="max-width: 300px" class="bla" action="mailto:sickgames@hotmail.com" method="post" enctype="text/plain">
                        <label for="nomUser">Nom usuari</label>
                        <input class="form-control" type="text" name="nomUser" required><br/>

                        <label for="codi">Codi que no funciona</label>
                        <input class="form-control" type="text" name="codi" required><br/>

                        <label for="nomJoc">Nom del Joc</label>
                        <input class="form-control" type="text" name="nomJoc" required><br/>

                        <label for="Plataforma">Plataforma</label>
                        <input class="form-control" type="text" name="Plataforma" required><br/>

                        <input class="form-control" type="submit" value="Enviar">
                    </form>
                </div>
                
                <div class="col-md-12 text-center divTitol">
                    <span class="textTitol">Problemes de rendiment amb un joc</span>
                </div>
                <div class="text-left descripcioSuport">
                    <p class="bla">
                        SickGames no es fa carrec del funcionament dels jocs ja que no som els desenvolupadors.
                        Si us plau posat amb contacte amb el desenvolupador del joc en questió.
                    </p>
                </div>
                
                <div class="col-md-12 text-center divTitol">
                    <span class="textTitol">No puc recuperar la contrasenya</span>
                </div>
                <div class="text-left descripcioSuport">
                    <p class="bla">
                        En cas de que el codi no funcioni omple aquest formulari amb el codi pero comprobar 
                        amb l'empresa responsable quan va ser activat, en cas de que hagi sigut activat abans 
                        de la seva adquisició es reembolsara el 100% del preu. En cas de que hagi sigut activat
                        desprès de la seva adquisició, SickGames no es fa responsable del seu mal ús.
                    </p>
                </div>
                
                <div class="col-md-12 text-center divTitol">
                    <span class="textTitol">No trobo la solució al meu problema</span>
                </div>
                <div class="text-left descripcioSuport">
                    <p class="bla">
                        Si no hem pogut resoldre els teus dubtes, omple el següent formulari amb la descripció del
                        problema.
                    </p>
                </div>
            </div>                
        </div>
    </section>
    <!--Fi secció body-->
    <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>

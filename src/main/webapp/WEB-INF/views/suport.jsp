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
                <div class="col-md-12 text-center" id='contacte'>
                <p>
                    Telèfon de contacte 977 451 214 - Email: ajudasickgames@hotmail.com
                    <br/>
                    Horari d'atenció al client: Dilluns a Divendres de 9:00-14:00.
                </p>
                </div>
                <div class="col-md-12 text-center divTitol">
                    <span class="textTitol">Com activar el codi adquirit</span>
                </div>
                <div class="text-left descripcioSuport">
                    <div class="bla">
                        <p>Verifica a quina plataforma pertany el joc i segueix una de les següents guies:</p>
                        <p>
                            <a target="_blank" href="https://eu.battle.net/support/es/article/11263">
                                <img src="<c:url value="./resources/img/plataformes/1.png"/>"> Battle.Net
                            </a>
                        </p>
                        <p>
                            <a target="_blank" href="https://store.steampowered.com/account/redeemwalletcode?l=spanish">
                                <img src="<c:url value="./resources/img/plataformes/2.png"/>"> Steam
                            </a>
                        </p>
                        <p>
                            <a target="_blank" href="https://support.ubi.com/es-es/Faqs/000024797/C%C3%B3mo-canjeo-el-c%C3%B3digo-de-contenido-exclusivo">
                                <img src="<c:url value="./resources/img/plataformes/3.png"/>"> Uplay
                            </a>
                        </p>
                        <p>
                            <a target="_blank" href="https://help.ea.com/es-es/help/origin/origin/origin-code-redemption-faq/">
                                <img src="<c:url value="./resources/img/plataformes/4.png"/>"> Origin
                            </a>
                        </p>
                        <p>
                            <a target="_blank" href="https://www.nintendo.es/Atencion-al-cliente/Nintendo-Switch/Utilizacion/Programas-de-Nintendo-Switch/Como-adquirir-programas-descargables/Como-canjear-un-codigo-de-descarga-en-Nintendo-eShop-de-Nintendo-Switch-1226548.html"><img src="<c:url value="./resources/img/plataformes/5.png"/>"> Nintendo</a>
                        </p>
                        <p>
                            <a target="_blank" href="https://beta.support.xbox.com/help/Subscriptions-Billing/redeem-codes-gifting/redeem-prepaid-codes">
                                <img src="<c:url value="./resources/img/plataformes/6.png"/>"> XBOX
                            </a>
                        </p>
                        <p>
                            <a target="_blank" href="https://www.playstation.com/es-co/explore/playstationnetwork/redemption/">
                                <img src="<c:url value="./resources/img/plataformes/7.png"/>"> PlayStation
                            </a>
                        </p>
                        <p>
                            <a target="_blank" href="https://support.fanatical.com/hc/en-us/articles/214143285-How-do-I-use-my-new-Rockstar-keys-">
                                <img src="<c:url value="./resources/img/plataformes/8.png"/>"> Rockstar
                            </a>
                        </p>
                        <p>
                            <a target="_blank" href="https://gameflip.zendesk.com/hc/en-us/articles/212478108-How-do-I-activate-a-GOG-code-">
                                <img src="<c:url value="./resources/img/plataformes/9.png"/>"> GOG
                            </a>
                        </p>
                        <p>
                            <a target="_blank" href="https://support.microsoft.com/es-do/help/10604/microsoft-account-redeem-gift-card-or-code">
                                <img src="<c:url value="./resources/img/plataformes/10.png"/>"> Windows Games
                            </a>
                        </p>
                        <p>
                            <a target="_blank" href="https://support.apple.com/es-lamr/HT201209">
                                <img src="<c:url value="./resources/img/plataformes/11.png"/>"> Mac
                            </a>
                        </p>
                        <p>
                            <a target="_blank" href="https://www.epicgames.com/store/es-MX/redeem">
                                <img src="<c:url value="./resources/img/plataformes/12.png"/>"> Epic Games
                            </a>
                        </p>
                    </div>
                </div>
                
                <div class="col-md-12 text-center divTitol">
                    <span class="textTitol">Reembolsar un videojoc</span>
                </div>
                <div class="text-left descripcioSuport">
                    <p class="bla">
                        Un cop adquirit un codi de videojoc no es pot retornar, ja que no formem part de les empreses on s'activen aquest codis.
                    </p>
                </div>
                
                <div class="col-md-12 text-center divTitol">
                    <span class="textTitol">El meu codi no funciona</span>
                </div>
                <div class="text-left descripcioSuport">
                    <p class="bla">
                        En cas de que el codi no funcioni posa't en conctacte amb nosaltres (ajudasickgames@hotmail.com) per comprobar 
                        amb l'empresa responsable quan va ser activat el codi, en cas de que hagi sigut activat abans 
                        de la seva adquisició es reembolsara el 100% del preu. En cas de que hagi sigut activat
                        desprès de la seva adquisició, SickGames no es fa responsable del seu mal ús.
                    </p>
                </div>
                
                <div class="col-md-12 text-center divTitol">
                    <span class="textTitol">Problemes de rendiment amb un joc</span>
                </div>
                <div class="text-left descripcioSuport">
                    <p class="bla">
                        SickGames no es fa carrec del funcionament dels jocs ja que no som els desenvolupadors.
                        Si us plau posat amb contacte amb l'empresa del joc en questió.
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
                        Si no hem pogut resoldre els teus dubtes, posat en contacte amb nosaltres per correu: ajudasickgames@hotmail.com
                        o truca'ns al 977 451 214.<br/> Horari: Dilluns a Divendres de 9:00-14:00.
                    </p>
                </div>
            </div>                
        </div>
    </section>
    <!--Fi secció body-->
    <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>

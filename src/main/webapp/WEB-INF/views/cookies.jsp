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
        <link href="<c:url value='../resources/css/cookies.css'/>" rel="stylesheet" type="text/css"/>
        <!--This javascript-->
        <script src="<c:url value='../resources/js/cookies.js'/>" type="text/javascript" ></script>
        
        
    <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
    <!--Fi Secció top-->
        <section class="section-body">
            <div class="container-cataleg">
                <div class="texto">
                    <i class="ultimaModificacio">Última modificació: 25/12/2019</i>
                    <div class="text-center">
                        <u><h2>Política de Cookies</h2></u>
                    </div>
                    <h3>Resum:</h3>
                    <ul class="textoUl">
                        <li>Cookies utilitzades: Propies i Twitch.</li>
                        <li>No s'utilitzen per mostrar publicitat</li>
                        <li>No s’utilitzen per a realitzar estadístiques.</li>
                    </ul>
                    
                    <h3>Com configurar y deshabilitar les cookies</h3>
                    
                    <p>Desde les opcions del navegador pots permetre, bloquejar o eliminar les cookies instal·lades al teu dispositiu. En cas de no permetre la instal·lació de cookies al teu dispositiu, pot ser que la teva experiencia de navegació no sigui la més òptima.</p>
                    <p>Com configurar les cookies a cada navegador:</p>
                    <ul class="textoUl">
                        <li><a href="https://support.microsoft.com/es-es/help/4468242/microsoft-edge-browsing-data-and-privacy-microsoft-privacy">Edge</a></li>
                        <li><a href="https://support.google.com/chrome/answer/95647?hl=es">Google Chrome</a></li>
                        <li><a href="https://support.google.com/chrome/answer/114662?hl=es&visit_id=637121700067084911-147810398&rd=1">Google Android</a></li>
                        <li><a href="https://support.microsoft.com/es-es/help/17442/windows-internet-explorer-delete-manage-cookies#ie=ie-10">Internet Explorer 10 o anterior</a></li>
                        <li><a href="https://support.microsoft.com/es-es/help/17442/windows-internet-explorer-delete-manage-cookies#ie=ie-10">Internet Explorer 11</a></li>
                        <li><a href="https://support.mozilla.org/es/kb/habilitar-y-deshabilitar-cookies-sitios-web-rastrear-preferencias?redirectlocale=es&redirectslug=habilitar-y-deshabilitar-cookies-que-los-sitios-we">Mozilla Firefox</a></li>
                        <li><a href="https://help.opera.com/en/latest/web-preferences/#cookies">Opera</a></li>
                        <li><a href="https://support.apple.com/es-es/guide/safari/sfri11471/mac">Safari</a></li>
                        <li><a href="https://support.apple.com/es-es/HT201265">Safari Mobile</a></li>
                    </ul>
                    
                    <h3>1. Utilització de les cookies</h3>
                    <p>SickGames utilitza cookies propies per millorar la navegació i proporcionar un millor servei web.</p>
                    
                    <h3>2. Què es una cookie i per a que serveixen?</h3>
                    <p>Una cookie es un fitxer de text que s’envia al navegador web del teu ordinador, móvil o tablet y que serveix per guardar i recuperar informació sobre la navegació realitzada. Per exemple, recordar el teu nom d’usuari i contrasenya.</p>
                    
                    <h3>3. Quins tipus de cookies existeixen?</h3>
                    <p class="textoIndentTitle">a) Segons qui les gestiona:</p>
                    <ul class="textoUl">
                        <li>Cookies pròpies: Desde el nostre servidor o domini web s’envien al teu navegador.</li>
                        <li>Cookies de tercers: Son enviades al teu navegador des d’un equip o domini web que no està gestionat per nosaltres directament, sino una tercera entitat, com ara Google.</li>
                    </ul>
                    <p class="textoIndentTitle">b) En funció del temps que están actives:</p>
                    <ul class="textoUl">
                        <li>Cookies de sessió: Son cookies que només es guarden durant la teva estancia a una pàgina web, un tancas la finestra o el navegador aquestes deixen d’existir i es crearan unes noves quan tornis a accedir a la pàgina.</li>
                        <li>Cookies persistents: Aquestes cookies tenen una data de caducitat, ajustada per la pròpia pàgina web, que serveixen per a que cada cop que entres a las pàgina es guardin les preferències assignades durant l’anterior sessió. Per exemple, es poden guardar canvis a la interfície de la pàgina, com ara el mode “dark&light”.</li>
                    </ul>
                    <p class="textoIndentTitle">c) Segons la seva finalitat:</p>
                    <ul class="textoUl">
                        <li>Cookies tècniques: Milloren la navegació i el bon funcionament de la web.</li>
                        <li>Cookies de personalització: Permet accedir al servei web amb unes característiques predefinides en funció d’una serie de criteris.</li>
                        <li>Cookies d'anàlisi: Serveixen per realitzar anàlisis estadístiques de l’ús que es fa del servei.</li>
                    </ul>
                    
                    <h3>Cookies utilitzades per SickGames</h3>
                    <table class="table table-striped table-dark">
                        <thead>
                            <tr>
                                <th scope="col">Nom</th>
                                <th scope="col">Origen</th>
                                <th scope="col">Finalitat</th>
                                <th scope="col">Tipus</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>UserNick</td>  
                                <td>SickGames</td>
                                <td>Tècnica</td>
                                <td>Propia</td>
                            </tr>
                            <tr>
                                <td>UserPwd</td>  
                                <td>SickGames</td>
                                <td>Tècnica</td>
                                <td>Propia</td>
                            </tr>
                            <tr>
                                <td>UserMail</td>  
                                <td>SickGames</td>
                                <td>Tècnica</td>
                                <td>Propia</td>
                            </tr>
                            <tr>
                                <td>Background</td>  
                                <td>SickGames</td>
                                <td>Tècnica</td>
                                <td>Propia</td>
                            </tr>
                            <tr>
                                <td>CookiesLlei</td>  
                                <td>SickGames</td>
                                <td>Tècnica</td>
                                <td>Propia</td>
                            </tr>
                            <tr>
                                <td>JSESSIONID</td>  
                                <td>SickGames</td>
                                <td>Tècnica</td>
                                <td>Propia</td>
                            </tr>
                        </tbody>
                    </table>
                    
                    <h3>Cookies utilitzades per Twitch</h3>
                    <p>A algunes de les pàgines de la nostra pàgina web tenim incrustats elements de <a href="www.twitch.tv" target="_blank">www.twitch.tv</a>. El seu ús implica les següents cookies:</p>
                    <table class="table table-striped table-dark">
                        <thead>
                            <tr>
                                <th scope="col">Nom</th>
                                <th scope="col">Origen</th>
                                <th scope="col">Tipus</th>
                                <th scope="col">Caducitat</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>session_unique_id</td>  
                                <td>.twitch.tv</td>
                                <td>Tercers</td>
                                <td>De sessió</td>
                            </tr>
                            <tr>
                                <td>device_id</td>  
                                <td>embed.twitch.tv</td>
                                <td>Tercers</td>
                                <td>10 anys</td>
                            </tr>
                            <tr>
                                <td>unique_id</td>  
                                <td>.twitch.tv</td>
                                <td>Tercers</td>
                                <td>10 anys</td>
                            </tr>
                            <tr>
                                <td>UID</td>  
                                <td>.scorecardresearch.com</td>
                                <td>Tercers</td>
                                <td>2 anys</td>
                            </tr>
                            <tr>
                                <td>UIDR</td>  
                                <td>.scorecardresearch.com</td>
                                <td>Tercers</td>
                                <td>2 anys</td>
                            </tr>
                            <tr>
                                <td>ad-id</td>  
                                <td>.amazon-adsystem.com</td>
                                <td>Tercers</td>
                                <td>1 any</td>
                            </tr>
                            <tr>
                                <td>ad-privacy</td>  
                                <td>.amazon-adsystem.com</td>
                                <td>Tercers</td>
                                <td>6 anys</td>
                            </tr>
                        </tbody>
                    </table>
                    <p>*Aquestes llistes s’actualitzaran cada cop que es realitzin canvis als serveis de la pàgina i s’informarà a l’usuari.</p>
                </div>
            </div>
        </section>
    <!--Fi secció body-->
    <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>
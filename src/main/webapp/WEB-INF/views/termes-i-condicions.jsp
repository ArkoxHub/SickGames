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
        <link href="<c:url value='../resources/css/termes-i-condicions.css'/>" rel="stylesheet" type="text/css"/>
        <!--This javascript-->
        <script src="<c:url value='../resources/js/termes-i-condicions.js'/>" type="text/javascript" ></script>
        
        
    <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
    <!--Fi Secció top-->
        <section class="section-body">
            <div class="container-cataleg">
                <div class="texto">
                    <i class="ultimaModificacio">Última modificació: 25/12/2019</i>
                    <div class="text-center">
                        <u><h2>Termes i Condicions</h2></u>
                    </div>
                    <p>Si desitges posar-te en contacte amb nosaltres utilitza el següent correu: ajudasickgames@hotmail.com</p>
                    
                    <h3>1. Acceptació</h3>
                    <ul class="textoUl">
                        <li>Posem a disposició aquesta pàgina per a qualsevol usuari, amb les condicions legals que trobaràs en aquesta, la <a href="<c:url value='/politica-de-privacitat'/>">privacitat</a> i les <a href="<c:url value='/cookies'/>">cookies</a>. Es recomanable que llegeixi amb atenció tots els termes i condicions, ja que els tindras que aceptar si desitjes utilitzar aquesta pàgina web.</li>
                        <li>L’utilització de la pàgina web, per part de l’usuari, implica un compromís de no utilitzar-la amb finalitats il·legals, il·lícites, o que no respectin les normes d’aquesta.</li>
                    </ul>
                        
                    <h3>2. Descripció registre y accés d’usuari</h3>
                    <p>Quan accedeixes a <a href="<c:url value='/'/>">www.sickgames.com</a> trobaràs els videojocs amb les millors ofertes, les novetats, els més econòmics i petita mostra dels streamers espanyols més populars. A la barra de navegació trobaràs un cercador de videojocs que, un cop realitzada la cerca, et redirigirà a la pàgina catàleg per mostrar-te els resultats, ja que poden ser múltiples.</p>
                    <h4 class="textoIndentTitle">2.1 En cas de no estar registrat</h4>
                    <ul class="textoUl">
                        <li>A la detra del cercador trobaràs tres botons, de esquerra a dreta:</li>
                        <ul class="textoUl">
                            <li>Suport de la pàgina: Et redirecciona a una pàgina amb la informació de contacte i les preguntes més freqüents.</li>
                            <li>Login: Aquest botó obre una finestra per fer login, com que no tens conta tindràs que prémer el botó de Crear nova conta.</li>
                            <li>Registre: Redirecciona a l’usuari a la pàgina de registre. Serà necessari omplir tot el formulari.</li>
                            <li>Ligh&Dark mode: Es un botó per cambiar la tonalitat del cos de la pàgina.</li>
                            <ul class="textoUl">
                                <li>Sol: Mostrarà el cos de la pàgina de color blanc i els textos de color negre.</li>
                                <li>Lluna: Mostrarà el cos de la pàgina de color gris oscur i els textos de color blanc.</li>
                            </ul>
                        </ul>
                    </ul>
                    
                    <h4 class="textoIndentTitle">2.2 Usuari sense sessió iniciada</h4>
                    <ul class="textoUl">
                        <li>A la dreta del cercador trobaràs tres botons, de esquerra a dreta:</li>
                        <ul class="textoUl">
                            <li>Suport de la pàgina: Explicat al punt 2.1</li>
                            <li>Login: S’obrirà una finestra on es demanarà el nick i la contrasenya per fer login</li>
                            <li>Registre: Explicat al punt 2.1</li>
                            <li>Light&Dark mode: Explicat al punt 2.1</li>
                        </ul>
                    </ul>
                    
                    <h4 class="textoIndentTitle">2.3 Usuari amb sessió iniciada</h4>
                    <ul class="textoUl">
                        <li>A la dreta del cercador trobaràs tres botons, de esquerra a dreta:</li>
                        <ul class="textoUl">
                            <li>Suport de la pàgina: Explicat al punt 2.1</li>
                            <li>Icono user / perfil: En pasar el ratolí per sobra es mostrarà un menú desplegable amb opcions com:</li>
                            <ul class="textoUl">
                                <li>Perfil: Redirecciona al perfil de l’usuari.</li>
                                <li>Wishlist: Redirecciona al perfil de l’usuari, on es troba la wishlist.</li>
                                <li>Comandes: Redirecciona a la pàgina de compres realitzades anteriorment, on pots consultar els codis dels jocs adquirits.</li>
                                <li>Tancar Sessió: Tanca la sessió.</li>
                            </ul>
                            <li>Light&Dark mode: Explicat al punt 2.1</li>
                        </ul>
                    </ul>
                    
                    <h3>3. Enllaços</h3>
                    <ul class="textoUl">
                        <li>Reiterem aquí també que SickGames no es fa responsable de les polítiques de pàgines alienes a aquesta. Més informació <a href="<c:url value='/politica-de-privacitat'/>">privacitat</a>.</li>
                        <li>Es posible que persones alienes a la pàgina web posin un link a <a href="<c:url value='/'/>">www.sickgames.com</a>. No hi ha cap problema, ja que tenim una llicencia <a href="https://creativecommons.org/licenses/by-sa/4.0/legalcode.es" target="_blank">CC BY-SA</a> sobre el nostre contingut (pots veure més informació al punt 9), però et compromets amb nosaltres a:</li>
                        <ul class="textoUl">
                            <li>el link només donarà accès a la web principal o a un producte en concret.</li>
                            <li>no es permet mostrar imatges de la pàgina web, ja que pot estar desactualizada.</li>
                            <li>no es pot donar informació falsa o incorrecta sobre <a href="<c:url value='/'/>">www.sickgames.com</a>.</li>
                            <li>no s’utilitzarà per realitzar publicitat ni comparacions amb altres pàgines.</li>
                            <li>aquest enllaç no suposa cap relació entre SickGames i el propietari o operador de la web on surt el nostre enllaç. SickGames tampoc té coneixement, acceptació o serveis que aquests tercer ofereix.</li>
                            <li>SickGames en cap cas es farà responsable dels continguts, informació o serveis oferts per el lloc web aliè.</li>                        
                        </ul>
                    </ul>
                    <h3>4. Edat</h3>
                    <ul class="textoUl">
                        <li>Si ets menor de 18 anys només podràs realitzar compres de jocs amb el consentiment del teu pare o tutor legal, ja que és requisit tenir una conta bancaria.</li>
                    </ul>
                    
                    <h3>5. Desactivació de la conta</h3>
                    <ul class="textoUl">
                        <li>Pots eliminar la teva conta enviant un correu a ajudasickgames@hotmail.com. Si es tracta d’una conta conta de la qual no ets titular, has d’explicar els motius i justificar un interès legítim per fer-ho.</li>
                        <li>Si decideixes eliminar la teva compta, totes les teves dades seran borrades i irrecuperables.</li>
                    </ul>
                    
                    <h3>6. Utilització del servei</h3>
                    <ul class="textoUl">
                        <li>Utilitzaràs SickGames de forma adecuada i legal, sempre complint la legislació vigent i respectant aquests termes. Que no has de fer:</li>
                        <ul class="textoUl">
                            <li>utilitzar la web amb finalitats o efectes ilícits, prohibits per aquest document, lesius dels drets i interessos de tercers, o de qualsevol forma puguin danyar, inutilitzar, sobrecarregar, deteriorar o impedir la normal utilització dels serveis, el equips informàtics o els documents, arxius i tota classe de continguts emmagatzemats en qualsevol equip informàtic.</li>
                            <li>accedir a àrees o recursos restringits, sense complir les condicions exigides.</li>
                            <li>provocar danys físics o lògics a SickGames o tercers, a través de la web. Com ara virus o malwares.</li>
                            <li>intentar i/o manipular les dades de SickGames, tercers , proveïdors o d’altres usuaris.</li>
                            <li>reproduir o copiar, distribuir, modificar o transformar els continguts d’altres autors sense autorització o llicència.</li>
                            <li>et compromets a no transmetre, difondre o posar a disposició de tercers informacions, dades, continguts, missatges, gràfics, dibuixos, arxius de so i/o imatge, fotografies, enregistraments, programari i, en general, qualsevol classe de material que:</li>
                            <ul class="textoUl">
                                <li>Atempti contra els drets fonamentals i les llibertats públiques reconegudes.</li>
                                <li>Indueixi, inciti o promogui actuacions delictives, denigrants, difamatòries, infamants, violentes o, en general, contràries a la llei, a la moral i bons costums generalment acceptats o a l’ordre públic.</li>
                                <li>Induexi, inciti o promogui actuacions, actituds o pensaments discriminatoris per raó de sexe, raça, religió, creences, edat o condició.</li>
                                <li>Incorpori, posi a disposició o permitir accedir a productes, elements, missatges i/o serveis delictius, violents, ofensius, nocius, degradants o, en general, contraris a la llei , a la moral i als bons costums generalment acceptats o a l’ordre públic.</li>
                                <li>Indueixi o pugui induir a un estat inacceptable d’ansietat o temor.</li>
                                <li>Indueixi o inciti a involucrar-se en pràctiques perilloses, de risc o nocives per a la salut i equilibri psíquic.</li>
                            </ul>
                            <li>En tot cas pots consultar a la pròpia web les recomanacions que us fem per a un bon ús de SickGames.</li>
                        </ul>
                    </ul>
                    
                    <h3>7. Propietat intel·lectual</h3>
                    <ul class="textoUl">
                        <li>Els continguts textuals de la web estàn subjectes a una <a href="https://creativecommons.org/licenses/by-sa/4.0/legalcode.es" target="_blank">Llicència Reconeixement - compartir igual 4.0</a>, és a dir, pots compartir els nostres continguts sempre que ens citis com a font, o comparteixis de la mateixa manera que nosaltres els continguts. És a dir, si nombres sickgames, alguna oferta o producte de sickgames, o qualsevol pàgina o element de sickgames, has de posar un enllaç a la nostra pàgina.</li>
                    </ul>
                    
                    <h3>8. Contes Inactives</h3>
                    <ul class="textoUl">
                        <li>Per asegurar un correcte funcionament de la pàgina, ens reservem el dret d’eliminar aquelles contes que no hagin sigut utilitzades en un període de 36 mesos (3 anys), això no vol dir que totes les contes que passin aquest període siguin eliminades cada 3 anys automàticament. Si no has iniciat sessió en aquest període, mínim un cop, és possible que eliminem la conta.</li>
                    </ul> 
                    
                    <h3>9. Denuncies</h3>
                    <ul class="textoUl">
                        <li>Encara que a SickGames la seguretat i la privacitat es lo primordial, si alguna persona t’ha robat la teva conta, posat en contacte amb nosaltres immediatament utilitzant: ajudasickgames@hotmail.com.</li>
                        <li>Si algú està utilitzant la teva conta bancària sense el teu consentiment, posat en contacte amb el teu banc. SickGames no es fa responsable del teu mal ús de la conta, ja que en cap moment guardem la informació de la teva conta.</li>
                        <li>Si vols informació desde ón s’ha utilitzat la teva conta bancària posat en contacte amb nosaltres utilitzant: ajudasickgames@hotmail.com.</li>
                    </ul>
                    
                    <h3>10. Modificacions</h3>
                    <ul class="textoUl">
                        <li>Hi ha la possibilitat que continuem actualitzant aquest termes i condicions en el futur. T’informem sobre aquests canvis mitjançant el correu electrònic.</li>
                        <li>Si qualsevol clàusula inclosa en aquestes condicions fos declarada, totalment o parcialment, nul·la o ineficaç, només afectarà a aquesta disposició o part de la mateixa que resulti nul·la o ineficaç. És a dir, si un paràgraf o punt d’aquests termes està malament, no vol dir que la resta ho estigui.</li>
                    </ul>
                    
                    <h3>11. Titularitat de la web</h3>
                    <ul class="textoUl">
                        <li>Aquesta pàgina web és propietat i esta operada per el Grup2 de l’IOC (SickGames). Som un grup de 2 alumnes: Adrià Gual (Backend) i Kevin Merat (Frontend).</li>
                    </ul>
                </div>
            </div>
        </section>
    <!--Fi secció body-->
    <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>
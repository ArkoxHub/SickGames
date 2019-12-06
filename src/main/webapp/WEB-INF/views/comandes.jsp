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
        <link href="<c:url value='/resources/css/productesComprats.css'/>" rel="stylesheet" type="text/css"/>
        <!--This javascript-->
        <script src="<c:url value='/resources/js/productesComprats.js'/>" type="text/javascript" ></script>

        <jsp:include page="/WEB-INF/resources/headerAndFooter/header.jsp"></jsp:include>
        <section class="section-body">
            <div class="container-cataleg">
                <div class="row" id="productesCompratsRow">
                    <!-- for each jocs comprats -->
                <c:forEach var="detall" items="${detalls}" varStatus="status">
                    <div class="col-md-6">
                        <div class="row">
                            <div class="col-md-12">
                                <table class="table table-striped table-dark">
                                    <thead>
                                    <td>${videojocs[status.index].nom}</td>
                                    <td><img alt="Logo Plataforma" src="<c:url value="/resources/img/plataformes/${detall.plataforma}.png"/>" alt=""></td>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><img class="imgProducteComprat" src="<c:url value="/resources/img/portades/${videojocs[status.index].nom}.jpg"/>"></td>
                                            <td id="serial"><span>${detall.serial} </span><i title="Copiar Codi" class="far fa-copy"></i></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <!-- fi foreach -->
            </div>
        </div>
    </section>
    <jsp:include page="/WEB-INF/resources/headerAndFooter/footer.jsp"></jsp:include>
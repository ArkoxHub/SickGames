<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!--Secció footer-->
        <section class="section-footer">
            <!-- Footer -->
            <div class="container" id="footer">
                <footer class="page-footer font-small blue pt-4">
                    <!-- Footer Links -->
                    <div class="container-fluid text-center text-md-left">

                        <!-- Grid row -->
                        <div class="row" >

                            <!-- Grid column -->
                            <div class="col-md-6 mt-md-0 mt-3">

                                <!-- Content -->
                                <h5 class="text-uppercase">Gràcies per confiar en SickGames</h5>
                                <ul class="list-unstyled">
                                    <li>
                                        Adrià Gual
                                    </li>
                                    <li>
                                        Kevin Merat
                                    </li>
                                </ul>
                            </div>
                            <!-- Grid column -->

                            <hr class="clearfix w-100 d-md-none pb-3">

                            <!-- Grid column -->
                            <div class="col-md-3 mb-md-0 mb-3">

                                <!-- Links -->
                                <h5 class="text-uppercase">Xarxes</h5>

                                <ul class="list-unstyled">
                                    <li>
                                        <i title="Twitter" class="fab fa-twitter"></i>
                                    </li>
                                    <li>
                                        <i title="Facebook" class="fab fa-facebook-f"></i>
                                    </li>
                                    <li>
                                        <i title="Instagram" class="fab fa-instagram"></i>
                                    </li>
                                    <li>
                                        <i title="Twitch" class="fab fa-twitch"></i>
                                    </li>
                                </ul>

                            </div>
                            <!-- Grid column -->

                            <!-- Grid column -->
                            <div class="col-md-3 mb-md-0 mb-3">

                                <!-- Links -->
                                <h5 class="text-uppercase">Privacitat </h5>

                                <ul class="list-unstyled">
                                    <li>
                                        <a href="<c:url value='/cookies'/>">Cookies</a>
                                    </li>
                                    <li>
                                        <a href="<c:url value='/termes-i-condicions'/>">Termes i Condicions</a>
                                    </li>
                                    <li>
                                        <a href="<c:url value='/suport'/>">Ajuda</a>
                                    </li>
                                    <li>
                                        <a href="<c:url value='/politica-de-privacitat'/>">Política de privacitat</a>
                                    </li>
                                </ul>

                            </div>
                            <!-- Grid column -->

                        </div>
                        <!-- Grid row -->

                    </div>
                    <!-- Footer Links -->

                    <!-- Copyright -->
                    <div class="footer-copyright text-center py-3">© 2019 Copyright:
                        <a href="<c:url value="/copyright"/>">SickGames</a>
                    </div>
                    <!-- Copyright -->

                </footer>
            </div>
                    
        </section>
        </div>
            <!-- Footer -->   
        <!-- Load the Twitch embed script -->
        <script src="https://embed.twitch.tv/embed/v1.js"></script>

    </body>
</html>
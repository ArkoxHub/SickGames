$(document).ready(function () {
    var userImg = document.getElementById('userImg');
    var userImgMvl = document.getElementById('userImgMvl');
    var foto = localStorage.getItem('fotoDePerfil');

    if (userImg != null || userImgMvl != null) {
        if (window.localStorage.getItem('fotoDePerfil')) {

            userImg.src = foto;
            userImgMvl.src = foto;
        } else {
            userImg.src = "../sickgames/resources/img/fotosPerfil/user.jpg";
            userImgMvl.src = "../sickgames/resources/img/fotosPerfil/user.jpg";
        }
    }
});
/*Funció acceptar cookies*/
$(document).ready(function () {
    $("#acceptarCookie").click(function () {
        setCookie('CookiesLlei', 'Acceptades', 999);
        $(".cookiesAccept").css("display", "none");
    });
    if (comprobarCookie('CookiesLlei') == 'Acceptades') {
        $(".cookiesAccept").css("display", "none");
    } else {
        $(".cookiesAccept").css("display", "block");
    }
});
/*Realitzar busqueda*/
$(document).ready(function () {
    var searchParams = new URLSearchParams(window.location.search);
    //Itera los parámetros de búsqueda.
    for (let busqueda of searchParams) {
        actualitzarBusqueda("ajudaBusqueda", busqueda[1]);
        //La posición 0 es el name del form y la 1 la busqueda
        $('.column:not([class*=' + busqueda[1] + '])').hide();
    }
});
/*Funcio cambiar fons random*/
$(document).ready(function () {

    /*
     * Recogemos la distancia a la que se encuentra
     * el fondo de top en el momento de cargar la página.
     * Le quitamos el texto px para hacer el calculo
     */
    var topFondo = $("#fondo").css("top").valueOf();
    topFondo = topFondo.slice(0, -2);

    var scrollToponLoad = $(window).scrollTop();
    /*
     * Si no nos encontramos arriba de la página se ajustará el fondo
     */
    if (scrollToponLoad >= 0 && scrollToponLoad <= topFondo) {
        var toponLoad = topFondo - scrollToponLoad;
        $("#fondo").css("top", toponLoad + "px");
    } else {
        $("#fondo").css("top", "0px");
    }
    /*
     * Cada vez que se haga scroll se calculara la distancia con el top
     */
    document.addEventListener('scroll', function (event) {
        var scrollTop = $(window).scrollTop();
        for (var i = 0; i <= topFondo; i++) {
            //Si es mayor a 0 calcularemos la distancia 
            if (scrollTop >= i) {
                var top = topFondo - i;
                $("#fondo").css("top", top);
            }
        }
    });



    //guardar cookie imagen fondo durante 30min

    var colorImg;
    if (comprobarCookie('Background') >= 1 || comprobarCookie('Background') <= 8) {
        let img = parseInt(comprobarCookie('Background'));
        colorFons(img);
        $("#fondo").css("background", "url('/../sickgames/resources/img/backgrounds/" + img + ".png') center 0px no-repeat " + colorImg);
    } else {
        let img = 1 + Math.floor(Math.random() * 8);
        colorFons(img);
        setCookie('Background', img, 1);
        $("#fondo").css("background", "url('../../sickgames/resources/img/backgrounds/" + img + ".png') center 0px no-repeat " + colorImg);
    }

    //Assginar color fons
    /*
     * 
     * @param {type} img
     * @returns {undefined}
     */
    function colorFons(img) {
        if (img == 1) {
            colorImg = "#2a0203"
        }
        ;/*color*/
        if (img == 2) {
            colorImg = "#bdeaddb5"
        }
        ;/*color*/
        if (img == 3) {
            colorImg = "#444957"
        }
        ;/*color*/
        if (img == 4) {
            colorImg = "#070e25"
        }
        ;/*color*/
        if (img == 5) {
            colorImg = "#024b9069"
        }
        ;/*color*/
        if (img == 6) {
            colorImg = "#432a25"
        }
        ;/*color*/
        if (img == 7) {
            colorImg = "#27817e"
        }
        ;/*color*/
        if (img == 8) {
            colorImg = "#101007"
        }
        ;/*color*/
    }
});
//Funció per omplir streams
/*
 * 
 * @param {type} datosStream
 * @returns {undefined}
 */
function rellenarStreams(datosStream) {

    //Si no troba cap stream mostrarem que no n'hi han
    if (datosStream.data.length == 0) {
        $("#filaStreams").append($('<p>No hi ha streamers en aquest moment</p>'));
    }
    //En cas de que si que hi trobem streams mostrarem els de parla espanyola
    else {
        for (var i = 0; i < datosStream.data.length; i++) {
            //Agafem el thumbnail (imatge previsualitzacio)
            var thumbnail = datosStream.data[i].thumbnail_url;
            //Modifiquem el thumbnail per aplicarli les mesures que desitjem
            var aplicarTamaño = thumbnail.replace("{width}x{height}", "500x500");
            $("#filaStreams").append($(
                    '<div class="column">' +
                    '<span class="viewers"><i class="fa fa-user"></i> ' + datosStream.data[i].viewer_count + '</span>' +
                    '<a href="#streamView" class=' + datosStream.data[i].user_name + ' id="stream">' +
                    '<div id="imgOverflow"><img  title=' + datosStream.data[i].user_name + ' src="' + aplicarTamaño + '"></div>' +
                    '</a>' +
                    '<a href="#streamView" class=' + datosStream.data[i].user_name + ' id="streamName">' +
                    datosStream.data[i].user_name +
                    '</a>' +
                    '</div>'));

            $("." + datosStream.data[i].user_name).click(function () {
                var existeStream = $("#streamView");
                if (existeStream.length >= 1) {
                    $("#streamView").empty();
                }
                $("#streamView").hide();
                $("#streamView").append($(
                        '<div class="col-12">' +
                        '<div>' +
                        '<a id="cerrar" href="#filaStreams">' +
                        '<div class="text-center center" id="cerrarStream"><i class="fas fa-chevron-down"></i></div>' +
                        '</a>' +
                        '</div>' +
                        '</div>' +
                        '<div class="col-12">' +
                        '<div id="twitch-embed"></div>' +
                        '</div>'));

                $("#streamView").slideDown("slow");

                $('html, body').animate({
                    scrollTop: $($(this).attr('href')).offset().top
                }, 700);

                $("#cerrar").click(function () {
                    $("#streamView").slideUp("slow");
                    setTimeout(function () {
                        $("#streamView").children().detach().remove();
                    }, 800);
                })

                if (window.matchMedia('(max-width: 600px)').matches) {
                    new Twitch.Embed("twitch-embed", {
                        width: "100%",
                        height: 250,
                        layout: "video",
                        channel: this.className //devuelve el nombre del streamer, ya que la class es el nombre
                    });
                } else {
                    new Twitch.Embed("twitch-embed", {
                        width: "100%",
                        height: 625,
                        layout: "video",
                        channel: this.className //devuelve el nombre del streamer, ya que la class es el nombre
                    });
                }
            });
        }
        ;
    }
}
//Dark y light Mode 
$(document).ready(function () {
    
    if (window.localStorage.getItem('colorMode') == "darkMode") {
        colorsDark();
    }
    if (window.localStorage.getItem('colorMode') == "lightMode") {
        colorsLight();
    }
    $(".darkMode").click(function () {
        colorsDark();
        setLocalStorage("colorMode", "darkMode");
    });
    $(".lightMode").click(function () {
        colorsLight();
        setLocalStorage("colorMode", "lightMode");

    });
    function colorsLight() {
        $(".lightMode").css("display", "none");
        $(".darkMode").css("display", "block");
        $("body").css("color", "black");
        $(".container-cataleg").css("background-color", "white");
        $(".section-top").css("background", "rgba(0, 0, 0)");
        $(".column-9").css("background-color", "white");
        $("hr").css("background", "black");
    }
    function colorsDark() {
        $(".darkMode").css("display", "none");
        $(".lightMode").css("display", "block");
        $("body").css("color", "white");
        $(".container-cataleg").css("background-color", "rgb(42, 41, 41)");
        $(".soporte").css("color", "white");
        $(".column-9").css("background-color", "black");
        $("hr").css("background", "white");
    }

});


/* Menu login*/
$(document).ready(function () {
    var hoverTimeOut;
    $('#menuUser').hover(function (event) {
        clearTimeout(hoverTimeOut);
        $('#menuCompte').stop().slideDown('fast');
    }, function (event) {
        hoverTimeOut = setTimeout(function () {
            $("#menuCompte").stop().slideUp("fast");
        }, 200);
    });

    $('#menuCarrito').hover(function (event) {
        $('#menuCompte').stop().hide();
    });
});

/* Carrito de la compra nav*/
$(document).ready(function () {
    $('#menuCarrito').hover(function (event) {
        var hoverTimeOut;
        clearTimeout(hoverTimeOut);
        if ($('ul#productesComprats li').length > 1) {
            $("#productesComprats").stop().slideDown("fast");
        }
    }, function (event) {
        hoverTimeOut = setTimeout(function () {
            $("#productesComprats").stop().slideUp("fast");
        }, 200);
    });
    $('#menuUser').hover(function (event) {
        $('#productesComprats').stop().hide();
    });
});

/*Obrir menu login*/
$(document).ready(function () {
    $('#conectarse, #conectarseMvl, #login, #NoLogin').on('click', function () {
        $('#id01').css("display", "block");
    });
    $('.close, .cancelbtn').on('click', function () {
        $('#id01').hide();
    });
});

/*Mostrar generes al fer click en versió movil*/
$(document).ready(function () {
    $('.mvlGeneres').on('click', function () {
        $(this).parent('.outClick').find('.liMvl').css("display", "flex");
        $(this).parent('.outClick').find('.mvlGeneres').css("display", "none");
    });
});

/*Mostrar ajudes de busqueda*/
$(document).ready(function(){
    var busquedasString = localStorage.getItem("ajudaBusqueda");
    var busquedasArray = "";
    
    busquedasString!=null ? busquedasArray = busquedasString.split(",") :busquedasArray = "";
    if(busquedasString!=null){
        $('#formBuscador').append(`
            <ul id="ajudaBuscador" class="ajudaBuscador" ></ul>
        `);
    }else{
        $("#ajudaBuscador").remove();
    }
    for (var i = 0; i < busquedasArray.length; i++){
        if(busquedasArray[i].length < 30){
            $("#ajudaBuscador").append(`
                <div id="ajuda`+busquedasArray[i]+`">
                    <a href="cataleg?search=`+busquedasArray[i]+`">
                        <li>`+busquedasArray[i]+`
                    </a><span class="borrarBusqueda" id="`+busquedasArray[i]+`">&times;</span></li>
                </div>
            `);
        }
    }
    $(".borrarBusqueda").on("click",function(){
        $('.buscador').focus();
        console.log(this.id)
        $('#ajuda'+this.id).remove();
        console.log($('#ajuda'+this.id));
        removeValorBusqueda("ajudaBusqueda" , this.id);
        if (localStorage.getItem("ajudaBusqueda") == "") {
           localStorage.removeItem("ajudaBusqueda");
        }
        let check = localStorage.getItem("ajudaBusqueda");
        if(check == null){
            $("#ajudaBuscador").remove();
        }
    });
    $(".buscador").on("focus",function(){
        $('#ajudaBuscador').slideDown('fast');
    });
    $(".section-body").on("click",function(){
        $('#ajudaBuscador').slideUp('fast');
    });
    
    
});


//Cookies Functions
/*
 * 
 * @param {type} nomCookie
 * @param {type} text
 * @param {type} caducitat
 * @returns {undefined}
 */
function setCookie(nomCookie, text, caducitat) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + caducitat);
    var c_value = escape(text) + ((caducitat == null) ? "" : "; expires=" + exdate.toUTCString());
    document.cookie = nomCookie + "=" + c_value;
}
;
/*
 * 
 * @param {type} nomCookie
 * @returns {String} name
 */
function comprobarCookie(nomCookie) {
    //Codi de w3 schools, com agafar una cookie
    var name = nomCookie + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return name;
}

/*
     * 
     * @param {type} c_name
     * @param {type} value
     * @returns {undefined}
     */
function setLocalStorage(c_name, value) {
    var exdays = 30;

    if (('localStorage' in window) && window.localStorage !== null) {
        localStorage[c_name] = value;
    } else {
        var exdate = new Date();
        exdate.setDate(exdate.getDate() + exdays);
        var c_value = escape(value) + ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
        document.cookie = c_name + "=" + c_value;
    }
}


function actualitzarBusqueda(name,  value) {
    
	var existing = localStorage.getItem(name);

	// Si no existeix , crea l'array
	// Sino converteix el localStorage en un array.
	existing = existing ? existing.split(',') : [];

	// Afegim les noves dades a l'array
	existing.push(value);
        //Netejem l'array de resultats identics
        var result = [];
        $.each(existing, function(i, e) {
          if ($.inArray(e, result) == -1) result.push(e);
        });
        existing = result;
	// El guardem al localStorage
	localStorage.setItem(name, existing.toString());

};


function removeValorBusqueda(name,  value) {
    
	var existing = localStorage.getItem(name);
        
	// Si no existeix , crea l'array
	// Sino converteix el localStorage en un array.
	existing = existing ? existing.split(',') : [];
        var index = existing.indexOf(value);
	// Afegim les noves dades a l'array
        if (index > -1) {
            existing.splice(index,1);
        }
	// El guardem al localStorage
	localStorage.setItem(name, existing.toString());

};

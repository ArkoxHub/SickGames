
/*Funció acceptar cookies*/
$(document).ready(function () {
    $("#acceptarCookie").click(function(){
        setCookie('CookiesLlei','Acceptades',999);
        console.log("hola");
        $(".cookiesAccept").css("display","none");
    });
    if (comprobarCookie('CookiesLlei') == 'Acceptades'){
        $(".cookiesAccept").css("display","none");
    }else{
        $(".cookiesAccept").css("display","block");
    }
    /*
     * 
     * @param {type} nomCookie
     * @param {type} text
     * @param {type} caducitat
     * @returns {undefined}
     */
    function setCookie(nomCookie,text,caducitat){
        var exdate = new Date();
        exdate.setDate(exdate.getDate() + caducitat);
        var c_value = escape(text) + ((caducitat == null) ? "" : "; expires=" + exdate.toUTCString());
        document.cookie = nomCookie + "=" + c_value;
    };
    /*
     * 
     * @param {type} nomCookie
     * @returns {String}
     */
    function comprobarCookie(nomCookie){
        //Codi de w3 schools, com agafar una cookie
        var name = nomCookie + "=";
        var decodedCookie = decodeURIComponent(document.cookie);
        var ca = decodedCookie.split(';');
        for(var i = 0; i <ca.length; i++) {
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
});

/*Funcio cambiar fons random*/
window.onload = function () {
    var img = 1 + Math.floor(Math.random() * 8);
    $("body").css("background-image", "url('../../sickgames/resources/img/backgrounds/"+img+".png')");
};
//Funció per omplir streams
/*
 * 
 * @param {type} datosStream
 * @returns {undefined}
 */
function rellenarStreams(datosStream){

    //Si no troba cap stream mostrarem que no n'hi han
    if (datosStream.data.length == 0){
        $("#filaStreams").append($('<p>No hi ha streamers en aquest moment</p>'));
    }
    //En cas de que si que hi trobem streams mostrarem els de parla espanyola
    else{
        for (var i = 0; i < datosStream.data.length; i++) {
            //Agafem el thumbnail (imatge previsualitzacio)
            var thumbnail = datosStream.data[i].thumbnail_url;
            //Modifiquem el thumbnail per aplicarli les mesures que desitjem
            var aplicarTamaño = thumbnail.replace("{width}x{height}", "500x500");
            $("#filaStreams").append($(
                    '<div class="column">' +
                    '<span class="viewers"><i class="fa fa-user"></i> '+datosStream.data[i].viewer_count+'</span>'+
                    '<a href="#streamView" class=' + datosStream.data[i].user_name + ' id="stream">' +
                    '<div id="imgOverflow"><img src="' + aplicarTamaño + '"></div>' +
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
        };
    }
}
//Dark y light Mode 
$(document).ready(function () {
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
    function colorsLight(){
        $(".lightMode").css("display", "none");
        $(".darkMode").css("display", "block");
        $("body").css("color", "black")
                .css("background-color", "white");
        $(".section-top").css("background", "rgba(0, 0, 0)");
        $(".column-9").css("background-color", "white");
    }
    function colorsDark(){
        $(".darkMode").css("display", "none");
        $(".lightMode").css("display", "block");
        $("body").css("color", "white")
                .css("background-color", "rgb(42, 41, 41)");
        $(".soporte").css("color", "white");
        $(".column-9").css("background-color", "black");
    }

});


/* Menu login*/
$(document).ready(function () {
    var hoverTimeOut;
    $('#menuUser').hover(function (event) {
        clearTimeout(hoverTimeOut);
        $('#menuCompte').stop().slideDown('fast');
    }, function (event) {        
        hoverTimeOut = setTimeout(function() {
            $("#menuCompte").stop().slideUp("fast");
        },200);
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
        if($('ul#productesComprats li').length > 1){
            $("#productesComprats").stop().slideDown("fast");
        }
    }, function (event) {        
        hoverTimeOut = setTimeout(function() {
            $("#productesComprats").stop().slideUp("fast");
        },200);
    });
    $('#menuUser').hover(function (event) {
        $('#productesComprats').stop().hide();
    });
});

/*Obrir menu login*/
$(document).ready(function () {
    $('#conectarse, #conectarseMvl, #login, #NoLogin').on('click', function(){
        $('#id01').css("display","block");
    });
    $('.close, .cancelbtn').on('click', function(){
        $('#id01').hide();
    });
});

/*Mostrar generes al fer click en versió movil*/
$(document).ready(function () {
    $('.mvlGeneres').on('click', function(){
        $(this).parent('.outClick').find('.liMvl').css("display","flex");
        $(this).parent('.outClick').find('.mvlGeneres').css("display", "none");
    });
});

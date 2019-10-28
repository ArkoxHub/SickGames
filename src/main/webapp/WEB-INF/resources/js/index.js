/**
 
 * @fileoverview Archivo Js de la página index.html
 
 *
 
 * @author                  Kevin Merat <kevinmerat@hotmail.com>
 
 * @copyright               www.sickgames.com/copyright
 
 * 
 
 **/
$(document).ready(function () {
    var jocApi = "https://api.twitch.tv/helix/streams?first=4&language=es";
    $.ajax({
        type: "GET",
        url: jocApi,
        success: mostrarTop5,
        headers: {
            'Client-ID': 'w202jotbdcd2zue6prnpvmyk7sbitc'
        },
        error: function () {
            alert("error carrega resposta");
        }
    });

    function mostrarTop5(datosStream) {
        for (var i = 0; i < datosStream.data.length; i++) {
            //Agafem el thumbnail (imatge previsualitzacio)
            var thumbnail = datosStream.data[i].thumbnail_url;
            //Modifiquem el thumbnail per aplicarli les mesures que desitjem
            var aplicarTamaño = thumbnail.replace("{width}x{height}", "500x500");
            $("#filaStreams").append($(
                    '<div class="column">' +
                    '<a href="#streamView" class=' + datosStream.data[i].user_name + ' id="stream">' +
                    '<img src="' + aplicarTamaño + '">' +
                    '</a>' +
                    '<a href="#streamView" class=' + datosStream.data[i].user_name + ' id="streamName">' +
                    datosStream.data[i].user_name +
                    '</a>' +
                    '</div>'));

            $("." + datosStream.data[i].user_name).click(function () {
                $("#streamView").show("slow");
                var existeStream = $("#streamView");
                if (existeStream.length >= 1) {
                    $("#streamView").empty();
                }
                $("#streamView").append($(
                        '<div class="col-12">' +
                        '<div>' +
                        '<a id="cerrar" href="#filaStreams">' +
                        '<img src="/SickGames/resources/img/cruz.png" style="width:30px; float:right">' +
                        '</a>' +
                        '</div>' +
                        '</div>' +
                        '<div class="col-12">' +
                        '<div id="twitch-embed"></div>' +
                        '</div>').show("slow"));


                $("#cerrar").click(function () {
                    $("#streamView").hide("slow");
                    $("#streamView").empty();
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

});

//Esto seria el href="" de cada juego, seguramente se creara con views...
$(document).ready(function () {
    $('[class*="roducteAComprar"]').click(function comprar() {
        var myWindow = window.open("/pages/product.html", "_parent");   // Opens a new window
        $(myWindow).onload = function () {
            $(".container".append($('<div class="column"><p>hola</p></div>')));
        };
    });
});

/* Menu login*/
$(document).ready(function () {
    $('#test').hover(function (event) {
        clearTimeout($(this).data('timeout'));
        $(this).data('timeout', setTimeout(function () {
            $('.menuCompte').slideDown('fast');
        }, 100));
    }, function (event) {
        clearTimeout($(this).data('timeout'));
        $('.menuCompte').slideUp(200, function () {
            $(this).hide();
        });
    });

});
//Dark y light Mode y storage local para que se mantenga dark o light mode
$(document).ready(function () {
    function setLocalStorage(c_name, value) {
        var exdays = 30;
        if (('localStorage' in window) && window.localStorage !== null) {
            localStorage[c_name] = value;
        } else {
            var exdate = new Date();
            exdate.setDate(exdate.getDate() + exdays);
            var c_value = escape(value) + ((exdays === null) ? "" : "; expires=" + exdate.toUTCString());
            document.cookie = c_name + "=" + c_value;
        }
    }


    if (window.localStorage.getItem('colorMode') === "darkMode") {
        $(".darkMode").css("display", "none");
        $("body").css("color", "white")
                .css("background", "rgb(42, 41, 41)");
        /*$(".soporte").css("color", "white");
         * $(".lightMode").css("color","white");
         * $(".darkMode").css("color","black");
         **/
    }
    if (window.localStorage.getItem('colorMode') === "lightMode") {
        $(".darkMode").toggle();
        $(".lightMode").css("display", "none");
        $("body").css("color", "black")
                .css("background", "#717070");
        /*
         * $(".section-top").css("background", "background: rgba(0, 0, 0, 0.22)");
         * $(".soporte").css("color", "black");
         * $(".darkMode").css("color","black");
         * $(".lightMode").css("color","white");
         **/
    }


    $(".darkMode").click(function () {
        $(".darkMode").toggle();
        $(".lightMode").toggle();
        $("body").css("color", "white")
                .css("background", "rgb(42, 41, 41)");
        /*
         * $(".soporte").css("color", "white");
         * $(".column-9").css("background-color", "black");
         * $(".darkMode").css("color","black");
         */
        setLocalStorage("colorMode", "darkMode");
    });
    $(".lightMode").click(function () {
        $(".darkMode").toggle();
        $(".lightMode").toggle();
        $("body").css("color", "black")
                .css("background", "white");
        $(".section-top").css("background", "background: rgba(0, 0, 0, 0.22)");
        /*
         * $(".column-9").css("background-color", "white");
         * $(".soporte").css("color","black");
         * (".lightMode").css("color","white");
         **/
        setLocalStorage("colorMode", "lightMode");

    });

});
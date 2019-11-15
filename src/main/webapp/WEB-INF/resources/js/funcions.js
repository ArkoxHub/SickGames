/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Funció per omplir streams
function rellenarStreams(datosStream){
    for (var i = 0; i < datosStream.data.length; i++) {
        //Agafem el thumbnail (imatge previsualitzacio)
        var thumbnail = datosStream.data[i].thumbnail_url;
        //Modifiquem el thumbnail per aplicarli les mesures que desitjem
        var aplicarTamaño = thumbnail.replace("{width}x{height}", "500x500");
        $("#filaStreams").append($(
                '<div class="column">' +
                '<span class="viewers"><i class="fa fa-user"></i> '+datosStream.data[i].viewer_count+'</span>'+
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
                    '<img src="/sickgames/resources/img/cruz.png" style="width:30px; float:right">' +
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
    };
}
//Dark y light Mode 
$(document).ready(function () {
    function setLocalStorage(c_name, value) {
        var exdays = 30;
        // if localStorage is present, use that
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
        $(".darkMode").css("display", "none");
        $("body").css("color", "white")
                .css("background-color", "rgb(42, 41, 41)");
        $(".soporte").css("color", "white");
        $(".column-9").css("background-color", "black");
        $("#genere").css("color", "#4596F0");
    }
    if (window.localStorage.getItem('colorMode') == "lightMode") {
        $(".darkMode").toggle();
        $(".lightMode").css("display", "none");
        $("body").css("color", "black")
                .css("background-color", "rgb(250, 250, 250)");
        $(".section-top").css("background", "rgba(0, 0, 0)");
        $(".column-9").css("background-color", "white");
        $("#genere").css("color", "#004085");
    }


    $(".darkMode").click(function () {
        $(".darkMode").toggle();
        $(".lightMode").toggle();
        $("body").css("color", "white")
                .css("background-color", "rgb(42, 41, 41)");
        $(".soporte").css("color", "white");
        $(".column-9").css("background-color", "black");
        $("#genere").css("color", "#4596F0");
        setLocalStorage("colorMode", "darkMode");
    });
    $(".lightMode").click(function () {
        $(".darkMode").toggle();
        $(".lightMode").toggle();
        $("body").css("color", "black")
                .css("background-color", "white");
        $(".section-top").css("background", "rgba(0, 0, 0)");
        $(".column-9").css("background-color", "white");
        $("#genere").css("color", "#132e4d");
        setLocalStorage("colorMode", "lightMode");

    });

});


/* Menu login*/
$(document).ready(function () {
    $('#menuUser').hover(function (event) {
        $('.menuCompte').stop().slideDown('fast');
    }, function (event) {
        $('.menuCompte').stop().slideUp('fast');
    });
});
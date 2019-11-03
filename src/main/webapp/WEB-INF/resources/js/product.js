$(document).ready(function () {
    var jocStream = $("img[id^='stream']").val("");
    //console.log(jocStream[0].id);
    var obtenirNomJoc = jocStream[0].id.replace('stream','');
    if (obtenirNomJoc == "Diablo III Reaper of Souls") {
        obtenirNomJoc = "Diablo III: Reaper of Souls";
    }
    if (obtenirNomJoc == "Star Wars Jedi Fallen Order") {
        obtenirNomJoc = "Star Wars Jedi: Fallen Order";
    }
    if (obtenirNomJoc == "Tom Clancy's Rainbow Six Siege") {
        obtenirNomJoc = "Tom Clancy's Rainbow Six: Siege";
    }
    if (obtenirNomJoc == "The Legend of Zelda Link's Awakening") {
        obtenirNomJoc = "The Legend of Zelda: Link's Awakening";
    }
    if (obtenirNomJoc == "Call of Duty Black Ops 4") {
        obtenirNomJoc = "Call of Duty: Black Ops 4";
    }
    if (obtenirNomJoc == "Pokemon Escudo") {
        obtenirNomJoc = "Pokemon Shield";
    }
    if (obtenirNomJoc == "Pokemon Espada") {
        obtenirNomJoc = "Pokemon Sword";
    }
    var jocApi = "https://api.twitch.tv/helix/games?name="+obtenirNomJoc;
    $.ajax({
        type: "GET",
        url: jocApi,
        success: gameID,
        headers: {
            'Client-ID': 'w202jotbdcd2zue6prnpvmyk7sbitc'
        },
        error: function () {
            alert("error carrega resposta");
        }
    });
    function gameID(datosJuego) {
        var idJoc = datosJuego.data[0].id;
        $.ajax({
            type: "GET",
            url: "https://api.twitch.tv/helix/streams?first=4&game_id=" + idJoc + "&language=es",
            success: mostrarStreamsJoc,
            headers: {
                'Client-ID': 'w202jotbdcd2zue6prnpvmyk7sbitc'
            },
            error: function () {
                alert("error carrega resposta streams");
            }
        });
    
    function mostrarStreamsJoc(datosStream) {
        if (datosStream.data.length == 0) {
            $.ajax({
                type: "GET",
                url: "https://api.twitch.tv/helix/streams?first=4&game_id=" + idJoc,
                success: mostrarStreamsGlobales,
                headers: {
                    'Client-ID': 'w202jotbdcd2zue6prnpvmyk7sbitc'
                },
                error: function () {
                    alert("error carrega resposta streams");
                }
            });
            
            function mostrarStreamsGlobales(datosStream) {
                if (datosStream.data.length == 0) {
                    $("#filaStreams").append($('<span>No hi ha streamers en aquest moment</span>'));
                }
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
        }
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
        };
    }
}
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
    })
    $(".lightMode").click(function () {
        $(".darkMode").toggle();
        $(".lightMode").toggle();
        $("body").css("color", "black")
                .css("background-color", "white");
        $(".section-top").css("background", "rgba(0, 0, 0)");
        $(".column-9").css("background-color", "white");
        $("#genere").css("color", "#132e4d");
        setLocalStorage("colorMode", "lightMode");

    })

});
  
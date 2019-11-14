$(document).ready(function () {
    var jocStream = $("img[id^='stream']").val("");
    var obtenirNomJoc = jocStream[0].id.replace('stream','');
    //Alguns jocs a twitch tenen els dos punts, però les imatges no admeten dos punts (així que en cas de coincidir es tenene que afegir)
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
    //Comprobem que hi han streams sobre el joc en concret
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
        //Si no troba cap stream mostrarem que no n'hi han
        if (datosJuego.data.length == 0){
            $("#filaStreams").append($('<span>No hi ha streamers en aquest moment</span>'));
        }
        //En cas de que si que hi trobem streams mostrarem els de parla espanyola
        else{
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
        }
        //Si no trobem cap stream de parla espanyola ens mostraran els globals
        function mostrarStreamsJoc(datosStream) {
            if (datosStream.data.length == 0) {
                $.ajax({
                    type: "GET",
                    url: "https://api.twitch.tv/helix/streams?first=4&game_id=" + idJoc,
                    success: rellenarStreams,
                    headers: {
                        'Client-ID': 'w202jotbdcd2zue6prnpvmyk7sbitc'
                    },
                    error: function () {
                        alert("error carrega resposta streams");
                    }
                });
            }else{
                rellenarStreams(datosStream);
            }
        }
    }
});
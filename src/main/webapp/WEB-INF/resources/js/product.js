$(document).ready(function () {
    var jocStream = $("img[id^='stream']").val("");
    var obtenirNomJoc = jocStream[0].id.replace('stream', '');
    //Alguns jocs a twitch tenen els dos punts, però les imatges no admeten dos punts (així que en cas de coincidir es tenene que afegir)
    if (obtenirNomJoc == "Diablo III Reaper of Souls")
        obtenirNomJoc = "Diablo III: Reaper of Souls";

    if (obtenirNomJoc == "Star Wars Jedi Fallen Order")
        obtenirNomJoc = "Star Wars Jedi: Fallen Order";

    if (obtenirNomJoc == "Tom Clancy's Rainbow Six Siege")
        obtenirNomJoc = "Tom Clancy's Rainbow Six: Siege";

    if (obtenirNomJoc == "The Legend of Zelda Link's Awakening")
        obtenirNomJoc = "The Legend of Zelda: Link's Awakening";

    if (obtenirNomJoc == "Call of Duty Black Ops 4")
        obtenirNomJoc = "Call of Duty: Black Ops 4";

    if (obtenirNomJoc == "Pokemon Escudo")
        obtenirNomJoc = "Pokemon Shield";

    if (obtenirNomJoc == "Pokemon Espada")
        obtenirNomJoc = "Pokemon Sword";

    if (obtenirNomJoc == "World of Warcraft Shadowlands")
        obtenirNomJoc = "World of Warcraft";

    //Comprobem que hi han streams sobre el joc en concret
    var jocApi = "https://api.twitch.tv/helix/games?name=" + obtenirNomJoc;
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
    /*
     * 
     * @param {type} datosJuego
     * @returns {undefined}
     */
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

        //Si no trobem cap stream de parla espanyola ens mostraran els globals
        /*
         * 
         * @param {type} datosStream
         * @returns {undefined}
         */
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
            } else {
                rellenarStreams(datosStream);
            }
        }
    }

    var rangeInput = document.getElementById('puntuacio');
    var rangeText = document.getElementById('rangeValue');
    if (rangeInput) {
        rangeInput.addEventListener('mousemove', updateText);
    }


    var valorar = document.getElementById('valorar');
    if (valorar) {
        valorar.addEventListener('click', showForm);
    }


    var textarea = document.getElementsByTagName('textarea');
    var textLeft = document.getElementById('textLeft');
    if (textarea[0]) {
        textarea[0].addEventListener('keyup', countLeft);
        textarea[0].addEventListener('keypress', countLeft);
    }

    function updateText() {
        rangeText.innerHTML = rangeInput.value + " estrelles";
    }

    function showForm() {
        $('#valoration').toggle(1000);
    }

    function countLeft() {
        var textEscrit = textarea[0].value;
        textEscrit = textEscrit.length;
        console.log('Caràcters mínim restants', 100 - textEscrit);
        var total = 100 - textEscrit;
        if (total >= 0) {
            textLeft.textContent = "Has descriure " + total + " caràcters més";
        } else {
            textLeft.innerHTML = "<p style='color: green;'>Caràcters mínims completat!</p>";
        }
        if (textEscrit >= 2000) {
            textLeft.innerHTML = "<p style='color: red;'>Màxim de caràcters permesos</p>";
        }
    }
});
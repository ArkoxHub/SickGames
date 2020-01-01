$(document).ready(function () {
    var jocStream = $("img[id^='stream']").val("");
    var obtenirNomJoc = jocStream[0].id.replace('stream','');
    //Alguns jocs a twitch tenen els dos punts, però les imatges no admeten dos punts (així que en cas de coincidir es tenene que afegir)
    if (obtenirNomJoc == "Diablo III Reaper of Souls") obtenirNomJoc = "Diablo III: Reaper of Souls";
    
    if (obtenirNomJoc == "Star Wars Jedi Fallen Order") obtenirNomJoc = "Star Wars Jedi: Fallen Order";
    
    if (obtenirNomJoc == "Tom Clancy's Rainbow Six Siege") obtenirNomJoc = "Tom Clancy's Rainbow Six: Siege";
    
    if (obtenirNomJoc == "The Legend of Zelda Link's Awakening") obtenirNomJoc = "The Legend of Zelda: Link's Awakening";
    
    if (obtenirNomJoc == "Call of Duty Black Ops 4") obtenirNomJoc = "Call of Duty: Black Ops 4";
    
    if (obtenirNomJoc == "Pokemon Escudo") obtenirNomJoc = "Pokemon Shield";
    
    if (obtenirNomJoc == "Pokemon Espada") obtenirNomJoc = "Pokemon Sword";
    
    if (obtenirNomJoc == "World of Warcraft Shadowlands") obtenirNomJoc = "World of Warcraft";
    
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
            }else{
                rellenarStreams(datosStream);
            }
        }
    }
});
/* Es podria implementar més endevant
$(document).ready(function () {
    $('.productToBuy').on('click', function () {
        if($('.portadaJoc').css("filter") == "blur(12px)" || $('.portadaJoc').css("-webkit-filter") == "blur(12px)" ){
            var cart = $('.fa-shopping-cart');
            var imgtodrag = $(this).parent('.column-12').parent('#comprarJoc').parent('.column-9').siblings('.portada').find("img").eq(0);
            if (imgtodrag) {
                var imgclone = imgtodrag.clone()
                        .offset({
                            top: imgtodrag.offset().top,
                    left: imgtodrag.offset().left
                })
                        .css({
                            'opacity': '0.5',
                    'position': 'absolute',
                    'height': '150px',
                    'width': '150px',
                    'z-index': '100'
                })
                        .appendTo($('body'))
                        .animate({
                            'top': cart.offset().top + 10,
                    'left': cart.offset().left + 10,
                    'width': 75,
                    'height': 75
                }, 1000,);
                
                imgclone.animate({
                    'width': 0,
                    'height': 0
                }, function () {
                    $(this).detach();
                });
            }
            }else{
            var cart = $('.fa-shopping-cart');
            var imgtodrag = $(this).parent('.column-12').parent('#comprarJoc').parent('.column-9').siblings('.column-3').find("img").eq(0);
            if (imgtodrag) {
                var imgclone = imgtodrag.clone()
                    .offset({
                    top: imgtodrag.offset().top,
                    left: imgtodrag.offset().left
                })
                    .css({
                    'opacity': '0.5',
                        'position': 'absolute',
                        'height': '150px',
                        'width': '150px',
                        'z-index': '100'
                })
                    .appendTo($('body'))
                    .animate({
                    'top': cart.offset().top + 10,
                        'left': cart.offset().left + 10,
                        'width': 75,
                        'height': 75
                }, 1000,);

                imgclone.animate({
                    'width': 0,
                        'height': 0
                }, function () {
                    $(this).detach();
                });
            }
        }
    });
});
*/
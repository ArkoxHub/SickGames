$(document).ready(function () {
    var jocApi = "https://api.twitch.tv/helix/streams?first=4&language=es";
    $.ajax({
        type: "GET",
        url: jocApi,
        success: rellenarStreams,
        headers: {
            'Client-ID': 'w202jotbdcd2zue6prnpvmyk7sbitc'
        },
        error: function () {
            alert("error carrega resposta");
        }
    });

});

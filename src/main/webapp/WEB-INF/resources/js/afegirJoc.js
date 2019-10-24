
var loadFile = function(event) {
    var reader = new FileReader();
    reader.onload = function(){
      var output = document.getElementById('preview');
      output.src = reader.result;
    };
    reader.readAsDataURL(event.target.files[0]);
};

function validacio(){
    $(".alert").remove();
    
    var nom = $("#nom").val();
    var data_Llançament = $("#data_Llançament").val();
    var preu = $("#preu").val();
    var idioma = $("#idioma").val();
    var oferta = $("#oferta").val();
    var qty_Available = $("#qty_Available").val();
    var plataforma = $("#plataforma").val();
    var descripcio = $("#descripcio").val();
    var fullPath = document.getElementById('logo').value;
    var comprobarJoc = "";
    if (fullPath) {
        var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
        var filename = fullPath.substring(startIndex);
        if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
            filename = filename.substring(1);
        }
        comprobarJoc = filename;
        comprobarJoc = comprobarJoc.substring(0, comprobarJoc.indexOf('.'));
        
    }
    
    if (!nom){
        $("#nom").after("<div class='alert error'>Introdueix el nom</div>");
        $("#nom").focus();
        return false;
    }
    if (!data_Llançament){
        $("#data_Llançament").after("<div class='alert error'>Introdueix la data de llançament</div>"); 
        $("#data_Llançament").focus();
        return false;
    }
    if (!preu){
        $("#preu").after("<div class='alert error'>Introdueix el preu</div>"); 
        $("#preu").focus();
        return false;
    }
    if (!idioma){
        $("#idioma").after("<div class='alert error'>Introdueix l'idioma</div>"); 
        $("#idioma").focus();
        return false;
    }
    if (!oferta){
        $("#oferta").after("<div class='alert error'>Introdueix l'oferta</div>"); 
        $("#oferta").focus();
        return false;
    }
    if (!qty_Available){
        $("#qty_Available").after("<div class='alert error'>Introdueix la cuantitat</div>"); 
        $("#qty_Available").focus();
        return false;
    }
    if (!plataforma){
        $("#plataforma").after("<div class='alert error'>Introdueix la plataforma</div>"); 
        $("#plataforma").focus();
        return false;
    }
    if (!descripcio){
        $("#descripcio").after("<div class='alert error'>Introdueix la descripcio</div>"); 
        $("#descripcio").focus();
        return false;
    }
    if (nom != comprobarJoc){
        $("#nom").after("<div class='alert error'>El nom té que coincidir amb el nom de l'arxiu</div>"); 
        $("#nom").focus();
        return false;
    }
    return true;
}
var loadFile = function (event) {
    var reader = new FileReader();
    reader.onload = function () {
        var output = document.getElementById('preview');
        output.src = reader.result;
    };
    reader.readAsDataURL(event.target.files[0]);
};

function validacio() {
    $(".alert").remove();


    var nom = $("#nom").val();
    var data_Llançament = $("#data_Llançament").val();
    var preu = $("#pvp").val();
    var idioma = $("#idioma").val();
    //var oferta = $("#oferta").val();
    var generes = $("#generes").val();
    //var qty_Available = $("#qty_Available").val();
    var descripcio = $("#descripcio").val();
    var fullPath = document.getElementById('logo').value;
    var comprobarJoc = "";
    if (fullPath) {
        var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
        console.log(fullPath);
        var filename = fullPath.substring(startIndex);
        if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
            filename = filename.substring(1);
        }
        comprobarJoc = filename;
        comprobarJoc = comprobarJoc.substring(0, comprobarJoc.indexOf('.'));

    }

    if (!nom) {
        $("#nom").after("<div class='alert error'>Introdueix el nom</div>");
        $("#nom").focus();
        return false;
    }
    if (!data_Llançament) {
        $("#data_Llançament").after("<div class='alert error'>Introdueix la data de llançament</div>");
        $("#data_Llançament").focus();
        return false;
    }
    if (!preu) {
        $("#pvp").after("<div class='alert error'>Introdueix el preu</div>");
        $("#pvp").focus();
        return false;
    }
    if (!idioma) {
        $("#idioma").after("<div class='alert error'>Introdueix l'idioma</div>");
        $("#idioma").focus();
        return false;
    }
    if (!descripcio) {
        $("#descripcio").after("<div class='alert error'>Introdueix la descripcio</div>");
        $("#descripcio").focus();
        return false;
    }
    if (!generes) {
        $("#generes").after("<div class='alert error'>Introdueix el/s generes</div>");
        $("#generes").focus();
        return false;
    }
    if (nom !== comprobarJoc) {
        $("#nom").after("<div class='alert error'>El nom té que coincidir amb el nom de l'arxiu</div>");
        $("#nom").focus();
        return false;
    }
    return true;
}

$(document).ready(function () {
    var language = document.getElementById("idioma");
    var plataforma = document.getElementById("plataforma");
    language.addEventListener("blur", deleteDiv);
    language.addEventListener("focus", addDiv);
    plataforma.addEventListener("blur", deleteDiv);
    plataforma.addEventListener("focus", addDiv);

    function addDiv() {
        if (this.getAttribute("id") === "idioma") {
            var div = document.querySelector(".helpForm1");
            div.classList.remove("helpForm1");
            div.classList.add("helpForm1Show");
        } else {
            var div = document.querySelector(".helpForm2");
            div.classList.remove("helpForm2");
            div.classList.add("helpForm2Show");
        }
    };

    function deleteDiv() {
        if (this.getAttribute("id") === "idioma") {
            var div = document.querySelector(".helpForm1Show");
            div.classList.remove("helpForm1Show");
            div.classList.add("helpForm1");
        } else {
            var div = document.querySelector(".helpForm2Show");
            div.classList.remove("helpForm2Show");
            div.classList.add("helpForm2");
        }
    };
});


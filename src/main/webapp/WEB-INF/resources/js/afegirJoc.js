var loadFile = function (event) {
    var reader = new FileReader();
    reader.onload = function () {
        var output = document.getElementById('preview');
        output.src = reader.result;
    };
    reader.readAsDataURL(event.target.files[0]);
};
/**
 * 
 * @returns {Boolean}
 */
function validacio() {
    $(".alert").remove();

    var nom = $("#nom").val();
    var data_Llançament = $("#data_Llançament").val();
    var preu = $("#pvp").val();

    // Validació idiomes
    var idioma = $("#idioma").val().toUpperCase();

    idioma = idioma.split(" ");
    for (var i = 0; i < idioma.length; i++) {
        if (idioma[i] === 'ESP' || idioma[i] === 'ENG' || idioma[i] === 'ALM'
                || idioma[i] === 'FR' || idioma[i] === 'ITL' || idioma[i] === 'JPN'
                || idioma[i] === 'Multillengua') {
            console.log(idioma[i] + " vàlid");
        } else {
            alert(idioma[i] + " no és un idioma vàlid");
            event.preventDefault();
            $("#idioma").focus();
        }
    }

    // Validació generes
    var generes = $("#generes").val();
    generes = generes.split(" ");
    for (var i = 0; i < generes.length; i++) {
        // Upper Case si té 3 o menys lletres (FPS, RPG MMO...)
        if (generes[i].length <= 3) {
            generes[i] = generes[i].toUpperCase();
            // Capitalize resta de categories (Plataforma, Estratègia...)
        } else {
            generes[i] = generes[i].charAt(0).toUpperCase() + generes[i].slice(1);
        }

        if (generes[i] === 'FPS' || generes[i] === 'RPG' || generes[i] === 'MMO'
                || generes[i] === 'Acció' || generes[i] === 'Deportiu' || generes[i] === 'Aventura'
                || generes[i] === 'Construcció' || generes[i] === 'Conducció' || generes[i] === 'Cooperació'
                || generes[i] === 'Plataforma' || generes[i] === 'Simulador' || generes[i] === 'Survival'
                || generes[i] === 'Gestió' || generes[i] === 'Estratègia' || generes[i] === 'Indies'
                || generes[i] === 'Lluita' || generes[i] === 'SinglePlayer' || generes[i] === 'Multijugador') {
            console.log(generes[i], "ok");
        } else {
            alert(generes[i] + " no és una categoria vàlida");
            event.preventDefault();
            $("#generes").focus();
        }
    }


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

    // Validacions TEA4 Adrià
    if (idioma !== '')
        return true;
}

$(document).ready(function () {
    var language = document.getElementById("idioma");
    var plataforma = document.getElementById("generes");
    language.addEventListener("blur", deleteDiv);
    language.addEventListener("focus", addDiv);
    plataforma.addEventListener("blur", deleteDiv);
    plataforma.addEventListener("focus", addDiv);
    /**
     * 
     * @returns {undefined}
     * 
     */
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
    }
    ;

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
    }
    ;
});


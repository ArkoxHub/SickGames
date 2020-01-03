
$(document).ready(function () {
    /*******Variables del formulari*******/
    let nom = $("#nom");
    let cognoms = $("#cognoms");
    let nickname = $("#nickname");
    let contrasenya = $("#contrasenya");
    let confirmarContrasenya = $("#contrasenyaConfirm");
    let email = $("#email");
    let telefon = $("#telefon");
    let direccio = $("#direccio");
    
    if (telefon.attr("value") == 0){
        telefon.attr("value", "");
    }
    
    /*************Contraseña********************/
    //Mostrar contraseña cuando hacemos hover al fa-eye
    $('.fa-eye').hover(function(){
        contrasenya.attr('type', 'text'); 
    }, function (event) {
        contrasenya.attr('type', 'password'); 
    });
    
    //Evitar copy paste en los input de tipo contraseña
    $('input[type=password]').bind("cut copy paste",function(e) {
        e.preventDefault();
    });
    
    
    //Formato que tiene que cumplir la contraseña
    var regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,20}$";
    
    //Escondemos el input repetir contraseña hasta que se rellene la contraseña correctamente.
    $("#confirmarContrasenya").hide();
    
    //Click en input contraseña hacemos comprobaciones y ofrecemos ayuda
    contrasenya.focusin(function(){
        $("#infoPass").remove();
        $("#badPass").remove();
        var pass = contrasenya.val();
        
        probes(pass);
    });
    
    //Si salimos del input contraseña comprobamos que los datos introducidos sean correctos y desactivamos las ayudas en caso de no tener contraseña
    contrasenya.focusout(function(){
        var pass = contrasenya.val();
        if (!pass.match(regexp)){
            $("#badPass").remove();
            $("#badSpace").remove();
            $("#infoPass").remove();
            if(pass.length > 0){
                $("#pass").append("<div id='badPass'>Indrodueix una contraseña correcta</div>");
            }
            $("#confirmarContrasenya").stop().slideUp();
        }else{
            probes(pass);
        }
    });
    
    //Cada vez que pulsamos una tecla recogemos el valor de la contraseña y ejecutamos las comprobaciones de ayuda.
    contrasenya.keyup(function(event){
        var pass = contrasenya.val();
        var passConfirm = confirmarContrasenya.val();
        
        if (event.keyCode == 32) {
            $("#badSpace").remove();
            $("#pass").append("<div id='badSpace'>No s'accepten espais</div>");
            $("#infoPass").remove();
            this.value = this.value.replace(/\s/g, "");
        }else{
            $("#badSpace").remove();
            checkPassword(pass, passConfirm);
            probes(pass);
        }
    });
    //Comprobamos con cada tecleo que las contraseñas coinciden
    confirmarContrasenya.keyup(function(event){
        var pass = contrasenya.val();
        var passConfirm = confirmarContrasenya.val();
        
        checkPassword(pass, passConfirm);
    });
    
    function checkPassword(pass, passConfirm){
        if (pass === passConfirm) {
            $(".iconCheck").remove();
            $(".iconUnCheck").remove();
            $("#checkThis").append('<i class="fa fa-check iconCheck"></i>');
        }else{
            $(".iconUnCheck").remove();
            $(".iconCheck").remove();
            $("#checkThis").append('<i class="fa fa-times iconUnCheck"></i>');
        }
    }
    
    function probes(pass){
        if(!pass.match(regexp)){
            $("#infoPass").remove();
            $("#pass").append('<div id="infoPass" style="font-size=20px">'
            +'<ul>'
            +'<li id="mayus"> 1 Lletra en majúscules </li>'
            +'<li id="minus"> 1 Lletra en minúscules </li>'
            +'<li id="numero"> 1 Número</li>'
            +'<li id="longitud"> Entre 8 i 20 caràcters</li>'
            +'</div>');
        }
        if(pass.length >= 8 && pass.length <= 20){
            $("#longitud").remove();
        }else{
            $("#longitud").show();
        }
        if(pass.match("[A-Z]")){
            $("#mayus").remove();
        }else{
            $("#mayus").show();
        }
        
        if(pass.match("[a-z]")){
            $("#minus").hide();
        }else{
            $("#minus").show();
        }
        
        if(pass.match("[0-9]")){
            $("#numero").hide();
        }else{
            $("#numero").show();
        }
        if (pass.match(regexp)){
            $("#badPass").remove();
            $("#infoPass").remove();
            $("#badSpace").remove();
            $("#confirmarContrasenya").stop().slideDown();
        }else{
            $("#confirmarContrasenya").stop().hide();
        }
    }
    
    $.validator.addMethod("regex", function(value) {
        return /^[A-Za-z0-9\d=!\-@._*]*$/.test(value) // Mínimo una mayúscula y símbolos
            && /[a-z]/.test(value) // Mínimo una minuscula
            && /\d/.test(value); // Mínimo 1 número
    });
    /* Validacio formulario quan fem submit */
    $("form[name='registre']").validate({
        rules: {
            nom: {
                required: true,
                minlength: 2,
                maxlength: 20
            },
            cognoms: {
                required: true,
                minlength: 2,
                maxlength: 50
            },
            nickname: {
                required: true,
                minlength: 3,
                maxlength: 20
            },
            email: {
                required: true,
                maxlength: 50,
                email: true
            },
            telefon: {
                required: true,
                minlength: 9,
                maxlength: 9
            },
            direccio: {
                required: true,
                minlength: 8,
                maxlength: 50
            },
            contrasenya: {
                required: true,
                minlength: 8,
                maxlength: 20,
                regex: true
            },
            contrasenyaConfirm: {
                required: true,
                equalTo : "#contrasenya"
            }
        },
        // Especificamos los errores 
        messages: {
            nom: {
                required: "Introdueix un nom",
                minlength: "Mínim 3 caràcters",
                maxlength: "Màxim 20 caràcters"
            },
            cognoms: {
                required: "Introdueix un cognom",
                minlength: "Mínim 2 caràcters",
                maxlength: "Màxim 50 caràcters"
            },
            nickname: {
                required: "Introdueix un nick",
                minlength: "Mínim 3 caràcters",
                maxlength: "Màxim 10 caràcters"
            },
            email: {
                required: "Introdueix un correu",
                maxlength: "Màxim 50 caràcters",
                email: "Introdueix un correu vàlid"
            },
            telefon: {
                required: "Introdueix un telèfon",
                minlength: "Mínim 9 caràcters",
                maxlength: "Màxim 9 caràcters"
            },
            direccio: {
                required: "Introdueix una direcció",
                minlength: "Mínim 8 caràcters",
                maxlength: "Màxim 50 caràcters"
            },
            contrasenya: {
                required: "Introdueix una contrasenya",
                minlength: "",
                maxlength: "",
                pattern: ""
            },
            contrasenyaConfirm: {
                required: "Les contrasenyes no coincideixen",
                equalTo : "Les contrasenyes no coincideixen"
            }
        },
        //Una vez se cumplen las validaciones, nos dejará hacer submit
        submitHandler: function (form) {
            form.submit();
        }
    });
    
});


$(document).ready(function () {
    /*****************Partner********************/
    //Dejamos el input partner oculto
    $("#partner").hide(); 
    
    //Si esta checked se muestra el input
    $("input[type='checkbox']").change(function(){
        if($(this).is(':checked')){
            $("#partner").stop().slideDown();
            $("#twitch").attr('required','required');
        
        }if(!$(this).is(':checked')){
            $("#twitch").removeAttr('required');
            $("#partner").stop().slideUp();
        }

    });
    
    /*****************Contraseña********************/
    //Mostrar contraseña cuando hacemos hover al fa-eye
    $('.fa-eye').hover(function(){
        $('#contrasenya').attr('type', 'text'); 
    }, function (event) {
        $('#contrasenya').attr('type', 'password'); 
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
    $("#contrasenya").focusin(function(){
        $("#infoPass").remove();
        $("#badPass").remove();
        var pass = $("#contrasenya").val();
        
        probes(pass);
    });
    
    //Si salimos del input contraseña comprobamos que los datos introducidos sean correctos y desactivamos las ayudas en caso de no tener contraseña
    $("#contrasenya").focusout(function(){
        var pass = $("#contrasenya").val();
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
    $("#contrasenya").keyup(function(event){
        var pass = $("#contrasenya").val();
        var passConfirm = $("#contrasenyaConfirm").val();
        
        if (event.keyCode == 32) {
            $("#badSpace").remove();
            $("#pass").append("<div id='badSpace'>No s'accepten espais</div>");
            this.value = this.value.replace(/\s/g, "");
        }else{
            $("#badSpace").remove();
            checkPassword(pass, passConfirm);
            probes(pass);
        }
    });
    //Comprobamos con cada tecleo que las contraseñas coinciden
    $("#contrasenyaConfirm").keyup(function(event){
        var pass = $("#contrasenya").val();
        var passConfirm = $("#contrasenyaConfirm").val();
        
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
            $("#confirmarContrasenya").stop().slideUp();
        }
    }
    
});

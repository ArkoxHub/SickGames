/* Menu login*/
$(document).ready(function(){
    $('#test').hover(function(event) {
        clearTimeout($(this).data('timeout'));
        $(this).data('timeout', setTimeout(function() {
          $('.menuCompte').slideDown('fast');
        },100));
      }, function(event) {
        clearTimeout($(this).data('timeout'));
        $('.menuCompte').slideUp(200, function() {
          $(this).hide();
        });
      });

});


//Dark y light Mode 
$(document).ready(function(){
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
            
    
    if (window.localStorage.getItem('colorMode') == "darkMode"){
        $(".darkMode").css("display","none");
        $("body").css("color","white")
                .css("background-color","rgb(42, 41, 41)");
        $(".soporte").css("color","white");
        $(".column-9").css("background-color","black");
        $("#genere").css("color","#4596F0");
    }
    if (window.localStorage.getItem('colorMode') == "lightMode"){
        $(".darkMode").toggle();
        $(".lightMode").css("display","none");
        $("body").css("color","black")
                .css("background-color","rgb(250, 250, 250)");
        $(".section-top").css("background","rgba(0, 0, 0)");
        $(".column-9").css("background-color","white");
        $("#genere").css("color","#004085");
    }

    
    $(".darkMode").click(function(){
        $(".darkMode").toggle();
        $(".lightMode").toggle();
        $("body").css("color","white")
                .css("background-color","rgb(42, 41, 41)");
        $(".soporte").css("color","white");
        $(".column-9").css("background-color","black");
        $("#genere").css("color","#4596F0");
        setLocalStorage("colorMode", "darkMode");
    })
    $(".lightMode").click(function(){
        $(".darkMode").toggle();
        $(".lightMode").toggle();
        $("body").css("color","black")
                .css("background-color","rgb(250, 250, 250)");
        $(".section-top").css("background","rgba(0, 0, 0)");
        $(".column-9").css("background-color","white");
        $("#genere").css("color","#132e4d");
        setLocalStorage("colorMode", "lightMode");
        
    })
    
});

//File reader
$(document).ready(function () {
    var readURL = function (input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#fotoPerfil').attr('src', e.target.result);
                var imatge =  $('#fotoPerfil').val('');
                var tokenImg = imatge[0].attributes[1].nodeValue;
                setLocalStorage("fotoDePerfil", tokenImg);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }


    $(".file-upload").on('change', function () {
        readURL(this);
    });

    $(".upload-button").on('click', function () {
        $(".file-upload").click();
    });
    
    
    
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
    if (window.localStorage.getItem('fotoDePerfil')){
        var foto = localStorage.getItem('fotoDePerfil');

        cambiarFotoDefault = document.getElementById('fotoPerfil');

        cambiarFotoDefault.src = foto;
        
    }
        
});

//Mostrar carrito
$(document).ready(function () {
    /*$("#carritoShow").click(function(){
       $("#llistaProductes").css("display","block");
       $("#carritoShow").css("display", "none");
       $("#carritoHide").css("display", "inline-flex");
    });
    
    $("#carritoHide").click(function(){
       $("#llistaProductes").css("display","none");
       $("#carritoShow").css("display", "inline-flex");
       $("#carritoHide").css("display", "none");
    });*/
    $('#carritoShow').click(function() {
        $('#llistaProductes').slideDown('slow');
        $("#llistaProductes").css("display","block");
        $("#carritoShow").css("display", "none");
        $("#carritoHide").css("display", "inline-flex");
        
    });
    $('#carritoHide').click(function() {
        $('#llistaProductes').slideUp('slow');
        $("#carritoShow").css("display", "inline-flex");
        $("#carritoHide").css("display", "none");
    });

});
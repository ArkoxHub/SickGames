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
//lateral cataleg
$(document).ready(function(){
    $("#escollirPlataforma").click(function(){
        $(".mostrarPlataforma").slideToggle("fast"); 
        
    });
    $("#escollirGenere").click(function(){
        $(".mostrarGenere").slideToggle("fast");    
    });
    

});
//CHECKBOX MOSTRAR o OCULTAR
$( window ).ready(function(){ 
    
    checkboxGenere("FPS");
    checkboxGenere("RPG");
    checkboxGenere("Cooperació");
    checkboxGenere("Deportiu");
    checkboxGenere("Multijugador");
    checkboxGenere("Construcció");
    checkboxGenere("Aventura");
    checkboxGenere("Survival");
    checkboxGenere("Gestió");
    checkboxGenere("Estratègia");
    checkboxGenere("SinglePlayer");
    checkboxGenere("Acció");
    checkboxGenere("Simulador");
    checkboxGenere("MMO");
    checkboxGenere("Indies");
    checkboxGenere("Conducció");
    checkboxGenere("Plataforma");
    checkboxGenere("Lluita");
    
    function checkboxGenere(genere){
        $('#'+genere).change(function(){
            if(this.checked){
               $(".column").not("div[id*="+genere+"]").fadeOut("slow");
            }else{
               $(".column").not("div[id*="+genere+"]").slideDown("slow");
            }
        });
    }
    function checkboxPlataforma(plataforma){
        $('#'+plataforma).change(function(){
            if(this.checked){
                console.log("Esta es:"+ test[0]);
               $(".column").not("div[id*="+plataforma+"]").fadeOut("slow");
            }else{
               $(".column").not("div[id*="+plataforma+"]").slideDown("slow");
            }
        });
    }
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
    });
    $(".lightMode").click(function(){
        $(".darkMode").toggle();
        $(".lightMode").toggle();
        $("body").css("color","black")
                .css("background-color","rgb(250, 250, 250)");
        $(".section-top").css("background","rgba(0, 0, 0)");
        $(".column-9").css("background-color","white");
        $("#genere").css("color","#132e4d");      
        setLocalStorage("colorMode", "lightMode");
        
    });
    
});

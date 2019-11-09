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

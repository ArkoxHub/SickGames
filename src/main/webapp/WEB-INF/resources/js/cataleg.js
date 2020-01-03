//lateral cataleg
$(document).ready(function(){
    $("#escollirPlataforma").click(function(){
        $(".mostrarPlataforma").slideToggle("fast"); 
    });
    $("#escollirGenere").click(function(){
        $(".mostrarGenere").slideToggle("fast");    
    });
    $("#escollirPreu").click(function(){
        $(".mostrarPreu").slideToggle("fast");    
    });

});
//Quan fem refresh a la pàgina cataleg borrarem el query
$(document).ready(function(){
    if (performance.navigation.type == 1) {
        window.location = window.location.href.split("?")[0];
    }
});
//CHECKBOX MOSTRAR o OCULTAR
$(document).ready(function(){
    //Desactivamos el checkbox de mostrar todos los generos (ya que viene por defecto activa)
    $('.generesTots').prop( "disabled", true);
    
    //Si el checkbox de los generos cambia....
    $('.generesTots').on('change', function(){
        // Mostramos todas las columnas
        // Deshabilitamos el boton de todos
        // Limpiamos los checkbox de los generos
        if ($('.generesTots').is(':checked')) {
            $('.column').show();
            $('.checkboxGenere').prop("checked", false);
            $('.generesTots').prop( "disabled", true);
        }
        //Sino... Activamos la opción de mostrar todos
        else{
            $('.generesTots').prop( "disabled", false);
        }
    });
    $('.checkboxGenere').on('change', function(){
        // Coge los marcados
        let marcados = $('.checkboxGenere:checked');
        
        //Cambiamos el checkbox generesTots
        if (marcados.length === 0){
            $('.generesTots').prop("checked", true).change();
        }else{
            $('.generesTots').prop("checked", false).change();
        }

        // Coge los targets
        let targets = '';
        $.each(marcados, function(i, checkbox){
            let target = $(this).data('target');
            targets += '.'+target;
        });

        // Si hay marcados, muestralos
        if(targets.length !== 0){
            $('.column'+targets).show();
            $('.column').not('.column'+targets).hide();
            // Si no hay juegos que cumplan los requisitos, mostramos el siguiente mensaje
            if($('.column'+targets).show().length === 0){
                var salu2 = '<div class="text-center center salu2" ><h2>No hi ha jocs amb aquesta combinació de generes</h2></div>';
                if($(".salu2").length == 0){
                    $('#catalegJocs').append(salu2);
                }
            }else{
                $('.salu2').remove();
            }
        }else{
            
        }
    });
});
/*INPUT RANGE MOSTRAR PER PREU*/
$(document).on('input', '#customRange', function() {
    $('.value').html("Preu inferior a: " +$(this).val()+ " €" );
    
    var preu = parseInt($(this).val());
    $('.producteAComprar').each(function() {
        var preuId = parseInt(this.id);
        if (preu <= preuId){
            $(this).parent().parent().hide();
        }else{
            $(this).parent().parent().show();
        }
    });
});
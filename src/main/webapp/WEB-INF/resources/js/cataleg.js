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
            if($('.column'+targets).show().length === 0){
                var salu2 = '<div class="text-center center salu2" ><h2>No hi ha jocs amb aquest generes</h2></div>';
                $('.container-fluid').append(salu2);
            }else{
                $('.salu2').remove();
            }
        }else{
            
        }
    });
});

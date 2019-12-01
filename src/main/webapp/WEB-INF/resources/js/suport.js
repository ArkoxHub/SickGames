/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $(".divTitol").on('click', function(){
        var mostrarText = $(this).closest('div').nextAll(':has(.bla):first').find('.bla');
        mostrarText.slideToggle("slow");
        if(mostrarText.hasClass("vanishIn")){
            mostrarText.removeClass("vanishIn");
            mostrarText.addClass("vanishOut");
        }else{
            mostrarText.addClass("vanishIn");
            mostrarText.removeClass("vanishOut");
        }
    });
});
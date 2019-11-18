/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $(".divTitol").on('click', function(){
        $('.bla', this).slideToggle("slow");
        
        if($('.bla', this).hasClass("vanishIn")){
            $('.bla', this).removeClass("vanishIn");
            $('.bla', this).addClass("vanishOut");
        }else{
            $('.bla', this).addClass("vanishIn");
            $('.bla', this).removeClass("vanishOut");
        }
    });
});
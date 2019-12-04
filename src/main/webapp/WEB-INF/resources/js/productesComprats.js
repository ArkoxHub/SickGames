/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $(".fa-copy").click(function(){
        
        var codi = $(this).siblings("span").text();
        
        var guardarTexto = document.createElement("textarea");
        document.body.appendChild(guardarTexto);
        guardarTexto.value = codi;
        guardarTexto.select();
        //Movil
        guardarTexto.setSelectionRange(0, 99999);
        document.execCommand("copy");
        document.body.removeChild(guardarTexto);
    });
});
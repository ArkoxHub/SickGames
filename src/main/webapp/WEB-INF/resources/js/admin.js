/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $deleteItems = $('.confirm');

    $deleteItems.each(function (index) {
        $(this).on("click", function () {
            console.log($(this).text());
            var $value = confirm("Segur que vols eliminar el videojoc: " + $(this).text());
            if (!$value) {
                event.preventDefault();
            }
        });
    });
});
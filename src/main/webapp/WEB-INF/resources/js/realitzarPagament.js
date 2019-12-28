$(document).ready(function () {
    $("form[name='formPagament']").validate({
        rules: {
            nomTitular: {
                required: true,
                minlength: 3,
                maxlength: 70
            },
            numTarjeta: {
                required: true,
                minlength: 16,
                maxlength: 16
            },
            mesCad: {
                required: true,
                minlength: 2,
                maxlength: 2
            },
            anyCad: {
                required: true,
                minlength: 2,
                maxlength: 2
            },
            cvc: {
                required: true,
                minlength: 3,
                maxlength: 3
            }
        },
        // Especificamos los errores 
        messages: {
            nomTitular: {
                required: "Introdueix el nom",
                minlength: "Mínim 3 caràcters",
                maxlength: "Màxim 70 caràcters"
            },
            numTarjeta: {
                required: "Introdueix una tarjeta vàlida",
                minlength: "Introdueix una tarjeta vàlida",
                maxlength: "Introdueix una tarjeta vàlida"
            },
            mesCad: {
                required: "Introdueix el mes",
                minlength: "Ha de tindre com a mínim 2 numeros",
                maxlength: "Ha de tindre com a màxim 2 numeros"
            },
            anyCad: {
                required: "Introdueix l'any",
                minlength: "Ha de tindre com a mínim 2 numeros",
                maxlength: "Ha de tindre com a màxim 2 numeros"
            },
            cvc: {
                required: "Introdueix el codi cvc",
                minlength: "Ha de tindre com a mínim 3 numeros",
                maxlength: "Ha de tindre com a màxim 3 numeros"
            }
        },
        //Una vez se cumplen las validaciones, nos dejará hacer submit
        submitHandler: function (form) {
            form.submit();
        }
    });
});
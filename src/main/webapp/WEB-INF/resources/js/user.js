//File reader
$(document).ready(function () {
    /*
     * 
     * @param {type} input
     * @returns {undefined}
     */
    var readURL = function (input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            /*
             * 
             * @param {type} e
             * @returns {undefined}
             */
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
    
    
    /*
     * 
     * @param {type} c_name
     * @param {type} value
     * @returns {undefined}
     */
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
        var cambiarFotoDefault = document.getElementById('fotoPerfil');

        cambiarFotoDefault.src = foto;
    }
    $('#cambiarUserImg').change(function() {
        location.reload();
    });
        
});


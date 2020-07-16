$(document).ready(function(){
        HideEditImage();
    });

    function editImage(id, oldFile){
        $("#popup2").show();
        document.getElementById("IdForImage").value = id;
        document.getElementById("oldFile").value = oldFile;
    }

    function HideEditImage(){
        $("#popup2").hide();
    }
    function() {

          'use strict';

          $('.input-file').each(function() {
            var $input = $(this),
                $label = $input.next('.js-labelFile'),
                labelVal = $label.html();

           $input.on('change', function(element) {
              var fileName = '';
              if (element.target.value) fileName = element.target.value.split('\\').pop();
              fileName ? $label.addClass('has-file').find('.js-fileName').html(fileName) : $label.removeClass('has-file').html(labelVal);
           });
          });

    };
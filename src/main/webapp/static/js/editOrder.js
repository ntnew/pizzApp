
$(document).ready(function(){
    PopUpHide();
});

function PopUpShow(status, notice, id){

    $("#popup1").show();
    document.getElementById("notice").value = notice;
    document.getElementById("id").value = id;
    document.getElementById("selector").value = status;

}
function PopUpHide(){
    $("#popup1").hide();
}
    $(document).ready(function(){
        //Скрыть PopUp при загрузке страницы
        PopUpHide();
    });
    //Функция отображения PopUp
    function PopUpShow(food_id){
        $("#popup1").show();
        alert(food_id);
    }
    //Функция скрытия PopUp
    function PopUpHide(){
        $("#popup1").hide();
    }

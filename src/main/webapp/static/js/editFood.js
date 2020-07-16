    $(document).ready(function(){
        PopUpHide();
    });

    function PopUpShow(name, description, price, weight, type, id){
        $("#popup1").show();
        document.getElementById("FoodName").value = name;
        document.getElementById("FoodDescription").value = description;
        document.getElementById("FoodPrice").value = price;
        document.getElementById("FoodWeight").value = weight;
        document.getElementById("FoodType").value = type;
         document.getElementById("FoodId").value = id;
    }

    function PopUpHide(){
        $("#popup1").hide();
    }
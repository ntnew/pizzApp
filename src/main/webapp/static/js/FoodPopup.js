    $(document).ready(function(){
        PopUpHide();
    });

    function PopUpShow(name, description, price, image){
        $("#popup1").show();
        document.getElementById("preOrderName").innerHTML = name;
        document.getElementById("preOrderDescription").innerHTML = description;
        document.getElementById("preOrderPrice").innerHTML = price;
        document.getElementById("orderName").value = name;
        document.getElementById("orderPrice").value = price;
        document.getElementById("image").src="../../static/images/"+image;
    }

    function PopUpHide(){
        $("#popup1").hide();
    }

    function addToBucket(){
        alert('Товар добавлен в корзину');
    }
    function orderAdded(){
        alert('Заказ оформлен');
    }

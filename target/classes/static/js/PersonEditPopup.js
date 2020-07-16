    $(document).ready(function(){

        PopUpHide();
    });

    function PopUpShow(){
        $("#popup1").show();
    }
    function editPassword(){
            $("#popup2").show();
    }
    function validate_form()
    {
        let form = document.getElementById('passwordForm');
        form.action = '/user/editPassword';
        form.method = 'POST';
        let valid = true;



        if(document.getElementById("oldPassword").value !=document.getElementById("oldPassword1").value ){
            $("#wrongOldPassword").show();
            valid = false;
        }
        if(document.getElementById("newPassword").value !=document.getElementById("repeatPassword").value){
            $("#PasswordDidntMatch").show();
            valid = false;
        }
        if(document.getElementById("newPassword").value < 4 || document.getElementById("newPassword").value < 16){
            $("#ValidatePassword").show();
            valid = false;
        }
        if(valid){
            alert("Пароль изменён")
            form.submit();
        }
    }

    function successEdit(){
    alert('Данные изменены');
    }

    function PopUpHide(){
        $("#popup1").hide();
        $("#popup2").hide();
        $("#PasswordDidntMatch").hide();
        $("#wrongOldPassword").hide();
        $("#ValidatePassword").hide();
    }
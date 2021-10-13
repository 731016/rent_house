window.addEventListener('load',function () {
    $(function(){
        $('#txt').blur(function(){
            if($(this).val().length!=0){
                if($(this).val().length<=4 || $(this).val().length>=10){
                    $('#sptxt').text('账号长度必须大于4小于10').css('color','red');
                    // $(this).css('color','red');
                    $(this).css('border-color','red');
                }else{
                    $('#sptxt').text('账号格式正确').css('color','green');
                    // $(this).css('color','green');
                    $(this).css('border-color','green');
                }
            }else{
                $('#sptxt').text('账号不能为空').css('color','red');
            }
        });
        $('#psw').blur(function(){
            if($(this).val().length!=0){
                if($(this).val().length<=4 || $(this).val().length>=10){
                    $('#sppass').text('密码长度必须大于4小于10').css('color','red');
                    $(this).css('border-color','red');
                }else{
                    $('#sppass').text('密码格式正确').css('color','green');
                    $(this).css('border-color','green');
                }
            }else{
                $('#sppass').text('密码不能为空').css('color','red');
            }
        });

        $("#btn").click(function () {
            let $txt = $("#txt").val();
            let $psw = $("#psw").val();
            let aj = {"account":$txt,"password":$psw}
            $.ajax({
                type:"post",
                data:aj,
                dataType:"json",
                url:"/login",
                success:function (data) {
                    if (data.flag){
                        history.back();
                    }else if (data.msg.error("disable")){
                        $("#validation").html("<span>用户已被禁用</span>").css("color","red");
                    }else {
                        $("#validation").html("<span>账号或密码错误</span>").css("color","red");
                    }
                },
                error:function (e) {
                    $("body").html(e.responseText)
                }
            })
        })
    });
});
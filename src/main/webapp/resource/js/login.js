window.addEventListener('load',function () {
    $(function(){



        $("#btn").click(function () {
            let $txt = $("#txt").val();
            let $psw = $("#psw").val();
            let aj = {"account":$txt,"password":$psw}
            $.ajax({
                type:"post",
                data:aj,
                dataType:"json",
                cache:false,
                url:"/login",
                success:function (data) {
                    if (data.flag){
                        history.back();
                    }else if (data.msg==="disable"){
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
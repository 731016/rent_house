window.addEventListener('load', function () {
    $(function () {
        cocoMessage.config({
            duration: 1000,
        });
        $("#btn").click(function () {
            let $txt = $("#txt").val();
            let $psw = $("#psw").val();
            let aj = {"account": $txt, "password": $psw}
            $.ajax({
                type: "post",
                data: aj,
                dataType: "json",
                cache: false,
                url: "/login",
                success: function (data) {
                    if (data.flag) {
                        var rsuccessDiv = document.createElement("div");
                        rsuccessDiv.innerText = "登录成功！";
                        cocoMessage.success(rsuccessDiv);
                        setTimeout(() => {
                            location.href = "index.jsp"
                        },2000);
                    } else if (data.msg === "disable") {
                        // $("#validation").html("<span>用户已被禁用</span>").css("color","red");
                        var disableDiv = document.createElement("div");
                        disableDiv.innerText = "用户已被禁用！";
                        cocoMessage.warning(disableDiv);
                    } else {
                        // $("#validation").html("<span>账号或密码错误</span>").css("color","red");
                        var errorDiv = document.createElement("div");
                        errorDiv.innerText = "账号或密码错误！";
                        cocoMessage.error(errorDiv);
                    }
                    // if(data.state == 201){
                    //     var regDiv = document.createElement("div");
                    //     regDiv.innerText = "注册成功！";
                    //     cocoMessage.success(regDiv);
                    // }
                },
                error: function (e) {
                    $("body").html(e.responseText)
                }
            })
        })
    });
});
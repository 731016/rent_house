$(function () {
    $.ajax({
        type: 'post',
        dataType: 'json',
        url: '/login',
        cache: false,
        success: function (data) {
            let object = data.object;
            if (object !== undefined) {
                $('#show_login').html("<a href='/userinfo.jsp' class='nav_header'>" + object.account + "</a>");
                $('#show_register').html("<a href='/exit' class='nav_header'>退出</a>");
                $('.vertical_line').css('visibility', 'hidden').css('margin-right', '5%');
                if (data.state == 200){
                    var successDiv = document.createElement("div");
                    successDiv.innerText = "登录成功！";
                    cocoMessage.success(successDiv);
                }else if(data.state == 404){
                    var failDiv = document.createElement("div");
                    failDiv.innerText = "登录失败！";
                    cocoMessage.error(failDiv);
                }
            } else {
                $('#show_login').html("<a href='login.jsp' class='nav_header'>登录</a>")
                $('#show_register').html("<a href='register.jsp' class='nav_header'>注册</a>")
            }
        },
        error: function (res) {
            $('body').innerText(res.responseText);
        }
    });
});
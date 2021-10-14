$(function () {
    $.ajax({
        type: 'post',
        dataType: 'json',
        cache:false,
        url: '/login',
        cache: false,
        success: function (data) {
            let object = data.object;
            if (object !== undefined) {
                $('#show_login').html("<a href='javascript:;' class='nav_header'>" + object.account + "</a>");
                $('#show_register').html("<a href='javascript:;' class='nav_header'>退出</a>");
                $('.vertical_line').css('visibility', 'hidden').css('margin-right', '5%');
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
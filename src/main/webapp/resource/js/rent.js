window.addEventListener('load', function () {
    cocoMessage.config({
        duration: 2000,
    });
    $(function () {
        $.ajax({
            type: 'post',
            dataType: 'json',
            cache: false,
            url: '/login',
            cache: false,
            success: function (data) {
                let object = data.object;
                if (object !== undefined) {
                    // TODO :点击账户名进入账户信息页面
                    $('#topright #login').text(object.account).prop('href', '"javascript;"');
                    $('#topright #register').text('退出').prop('href', '"javascript;"');
                    if (data.state == 200) {
                        var successDiv = document.createElement("div");
                        successDiv.innerText = "登录成功！";
                        cocoMessage.success(successDiv);
                    } else if (data.state == 404) {
                        var failDiv = document.createElement("div");
                        failDiv.innerText = "登录失败！";
                        cocoMessage.error(failDiv);
                    }
                } else {
                    $('#topright #login').text('登录').prop('href', '"login.jsp"');
                    $('#topright #register').text('注册').prop('href', '"register.jsp"');
                }
            },
            error: function (res) {
                $('body').innerText(res.responseText);
            }
        });
    });
});


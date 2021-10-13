window.addEventListener('load', function () {
    var test;
    $(function () {
        $.ajax({
            type: 'post',
            dataType: 'json',
            url: '/login',
            success: function (data) {
                test=data;
                let object = data.object;
                if (object != undefined) {
                    $('#show_login').html("<a href='javascript:;' class='nav_header'>" + object.account + "</a>");
                    $('#show_register').html("<a href='javascript:;' class='nav_header'>退出</a>");
                } else {
                    $('#show_login').html("<a href='login.jsp' class='nav_header'>登录</a>")
                    $('#show_register').html("<a href='register.jsp' class='nav_header'>注册</a>")
                }
            },
            error: function (res) {
                $('body').innerText(res.responseText);
            }
        });
        $('.search_nav ul').on('click', 'li', function () {
            $(this).siblings().css('color', '').removeClass('current');
            $(this).css('color', '#FF961E');
            // 点击 【全部/整租/全选】，下面输入框的placeholder替换为data-placeholder的值。
            let search_data = $(this).attr('data-placeholder');
            let search_data_val = $(this).attr('data-val');

            // 点击开始找房，获取data-val的值
            $('#search_input').prop('placeholder', search_data);
            $('#search_input').attr('data-val', search_data_val);
        });
        $('#search_btn').on({
            click: function () {
                let val = $('#search_input').attr('data-val');
                let rgx = new RegExp('^[\u4e00-\u9fa5],{0,}$');
                if (!rgx.test(val)) {
                    return false;
                }
            }
        });
        $(window).on('scroll', function () {
            scroll();
        });

        // 租房
        $('.con_father_yz').on('click',function () {
            location.href='renting.jsp';
        });
        // TODO 出租
        $('.con_father_zf').on('click',function () {
            location.href='';
        })
    });

    function scroll() {
        let scrollTop=$(window).scrollTop();
        if (scrollTop>0){
            $('.nav_header').css('color','#000');
            $('header').css('background-color','rgba(255, 255, 255, 1.0)');
        }else {
            $('.nav_header').css('color','#fff');
            $('header').css('background-color','rgba(0, 0, 0, 0.2)');
        }
    }

});
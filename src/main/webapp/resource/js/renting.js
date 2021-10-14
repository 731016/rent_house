$(function () {
    $.ajax({
        type: 'post',
        dataType: 'json',
        cache:false,
        url: '/login',
        cache: false,
        success: function (data) {
            let object = data.object;
            if (object != undefined) {
                console.log(1)
                $('#show_login').html("<a href='javascript:;' class='nav_header'>" + object.account + "</a>");
                $('#show_register').html("<a href='javascript:;' class='nav_header'>退出</a>");
                $('.vertical_line').css('visibility', 'hidden').css('margin-right', '5%');
            } else {
                console.log(2)
                $('#show_login').html("<a href='login.jsp' class='nav_header'>登录</a>")
                $('#show_register').html("<a href='register.jsp' class='nav_header'>注册</a>")
            }
        },
        error: function (res) {
            $('body').innerText(res.responseText);
        }
    });

    $("#area").click(function () {
        $('#area svg:first').hide();
        $('#area svg:last').show();
        $('#subway svg:first').show();
        $('#subway svg:last').hide();
        $('#div_subway').stop();
        $('#div_subway').slideUp(500, function () {
            $('#div_area').stop();
            $('#div_area').slideDown(500);
        });
    })

    $("#subway").click(function () {
        $('#subway svg:first').hide();
        $('#subway svg:last').show();
        $('#area svg:first').show();
        $('#area svg:last').hide();
        $('#div_area').stop();
        $('#div_area').slideUp(500, function () {
            $('#div_subway').stop();
            $('#div_subway').slideDown(500);
        });

    })

    $('#unfold').click(function () {
        $('#div_unfold').slideDown(500, function () {
            $('#button_packUp').show();
            $('#button_unfold').hide();
        });
    })

    $('#packUp').click(function () {
        $('#div_unfold').slideUp(500, function () {
            $('#button_packUp').hide();
            $('#button_unfold').show();
        });
    })

    $('#sort_default').click(function () {
        $('#div_sort div button').removeClass('sort_current');
        $('#sort_default').addClass('sort_current');
        $('#sort_price svg').hide();
        $('#sort_area svg').hide();
    })

    $('#sort_price').click(function () {
        $('#div_sort div button').removeClass('sort_current');
        $('#sort_price').addClass('sort_current');
        $('#sort_area svg').hide();
        if ($('#sort_price svg:first').css('display') == 'none' && $('#sort_price svg:last').css('display') == 'none') {
            $('#sort_price svg:first').show();
        } else {
            $('#sort_price svg').toggle();
        }
    })

    $('#sort_area').click(function () {
        $('#div_sort div button').removeClass('sort_current');
        $('#sort_area').addClass('sort_current');
        $('#sort_price svg').hide();
        if ($('#sort_area svg:first').css('display') == 'none' && $('#sort_area svg:last').css('display') == 'none') {
            $('#sort_area svg:first').show();
        } else {
            $('#sort_area svg').toggle();
        }
    });
    $('#div_img').click(function () {
        location.href = "/housedetails";
    });
})
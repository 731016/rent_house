$(function () {
    $.ajax({
        type: 'post',
        dataType: 'json',
        cache:false,
        url: '/login',
        success: function (data) {
            let object = data.object;
            if (object != undefined) {
                console.log(1)
                $('#show_login').html("<a href='javascript:;' class='nav_header'>" + object.account + "</a>");
                $('#show_register').html("<a href='/exit' class='nav_header'>退出</a>");
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

    $.ajax({
        type:"post",
        dataType:"json",
        async:false,
        cache:false,
        url:"/type",
        success:function (data) {
            $.each(data,function () {
                $("#housingType").append($("<button type=\"button\" class=\"btn btn-secondary\" name=\"type\">"+this.typeName+"</button>"))
            })
        },
        error:function (e) {
            $("body").html(e.responseText)
        }
    })

    $.ajax({
        type:"post",
        dataType:"json",
        async:false,
        cache:false,
        url:"/toward",
        success:function (data) {
            $.each(data,function () {
                $("#toward").append($("<button type=\"button\" class=\"btn btn-secondary\" name=\"toward\">"+this.towardName+"</button>"))
            })
        },
        error:function (e) {
            $("body").html(e.responseText)
        }
    })

    $.ajax({
        type:"post",
        dataType:"json",
        async:false,
        cache:false,
        url:"/area",
        success:function (data) {
            $.each(data,function () {
                $("#area").append($("<button type=\"button\" class=\"btn btn-secondary\" name=\"area\">"+this.aName+"</button>"))
            })
        },
        error:function (e) {
            $("body").html(e.responseText)
        }
    })

    // addList();
})

//租房列表添加方法
function addList() {
    //需要获取数据传入后台作为筛选条件
    $("[]")
    //
    $("#div_house").children().remove();
    $.ajax({
        type:"post",
        data:"",
        dataType:"json",
        cache:false,
        url:"/rentingList",
        success:function (data) {
            $.each(data,function () {
                let $div = $("<div id=\"house_id\" class=\"div_inBlock house_id\"></div>");
                $div.append("<div id=\"div_img\" class=\"div_img\"><a href=\"housedetails.jsp?id="+this.hId+"\"><img src=\"/upload/"+this.ImgList.split(",")[0]+"\" id=\"house_img\"></a></div>")
                $div.append("<div id=\"house_info\" class=\"house_info\">\n" +
                   "          <span class=\"badge badge-pill badge-success incon\">即住</span>\n" +
                   "          <h5><a href=\"#\">"+this.title+"</a></h5>\n" +
                   "          <div>面积："+this.area+"平米</div>\n" +
                   "          <div class=\"location\">地址："+this.address+"</div>\n" +
                   "          <div>￥"+this.rent+"/月</div>\n" +
                   "        </div>")
                $("#div_house").append($div)
            })
        },
        error:function (e) {
            $("body").html(e.responseText)
        }
    })
}
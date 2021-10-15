window.addEventListener('load', function () {
    cocoMessage.config({
        duration: 2000,
    });
    $(function () {
        // 登录ajax
        $.ajax({
            type: 'post',
            dataType: 'json',
            url: '/login',
            cache: false,
            success: function (data) {
                let object = data.object;
                if (object !== undefined) {
                    // TODO :点击账户名进入账户信息页面
                    $('#topright #login').text(object.account).prop('href', 'javascript;');
                    $('#topright #register').text('退出').prop('href', '/exit');
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
                    $('#topright #login').text('登录').prop('href', 'login.jsp');
                    $('#topright #register').text('注册').prop('href', 'register.jsp');
                }
            },
            error: function (res) {
                $('body').innerText(res.responseText);
            }
        });
        $.ajax({
            type: 'post',
            dataType: 'json',
            url: '/housedetails',
            cache: false,
            success: function (data) {
                // 房源轮播图
                $('#imgsmall').children().remove();
                $.each(data.imgList.split(','), function () {
                    $('#imgsmall').append($('<img src="/upload/' + this + '" class="small">'))
                });
                // 房源简介 数据库无此字段
                // $('#jianjie').text();

                //房屋设施列表
                $('#tubiao').children().remove();
                $.each(data.facilities.split(','), function () {
                    let facility = [油烟机, 热水器, 浴霸, 书架, 床, 微波炉, 洗衣机, 衣柜, 沙发, 桌子, 床垫, 智能锁, 椅子, 中央空调];
                    for (let i = 1; i <= 14; i++) {
                        if (this == i) {
                            $('#tubiao').append($('<img src="/resource/images/"' + i + ' class="tubiaoimg">' + '<br>'
                                + facility[i]));
                        }
                    }
                });
                // 租约信息 可入住日期，签约时长 数据库无此字段

                // 标题
                $('#bodyright h2').text(data.title);

                //价格
                $('#price').text('￥' + data.rent);

                //使用面积
                $('.td1').html('使用面积<h3>' + data.area + '</h3>');
                // 朝向
                let toward = ['东', '南', '西', '北', '东南', '东北', '西南', '西北'];
                for (let i = 1; i <= 8; i++) {
                    if (data.towardId == i) {
                        $('.td2').html('朝向<h3>' + toward[i] + '</h3>');
                    }
                }

                // 户型
                $('#houseType').html('户型<h3>' + data.houseType + '</h3>');

                // 位置
                $('.sp1').siblings().text(data.address);


                // 房东信息
                

            },
            error: function (res) {
                $('body').html(res.responseText)
                console.log("error")
            }
        });
    });

    let big = document.getElementById("big");
    let small = document.getElementsByClassName("small");
    for (let i = 0; i < small.length; i++) {
        small[i].onclick = function () {
            big.src = this.src;
        }
    }

});
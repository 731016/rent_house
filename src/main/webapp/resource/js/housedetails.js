window.addEventListener('load', function () {
    cocoMessage.config({
        duration: 2000,
    });

    function getFd(lid) {
        let json = {'lid': lid};
        $.ajax({
            type: 'post',
            data: json,
            dataType: 'json',
            cache: false,
            url: '/getLandlordInfo',
            success: function (data) {
                $('#name').text(data.object.lName);
                $('#phone').text(data.object.phone);
                if (data.msg == "default.png"){
                    $('#touxiangimg').attr('src', '/resource/images/default.png');
                }else{
                    $('#touxiangimg').attr('src', '/upload/' + data.msg);
                }

            },
            error: function (resp) {
                $('body').text(resp.responseText)
            }
        });
    };

    function loadjscssfile(filename, filetype) {
        if (filetype == "js") { //判定文件类型
            var fileref = document.createElement('script')//创建标签
            fileref.setAttribute("type", "text/javascript")//定义属性type的值为text/javascript
            fileref.setAttribute("src", filename)//文件的地址
        } else if (filetype == "css") { //判定文件类型
            var fileref = document.createElement("link")
            fileref.setAttribute("rel", "stylesheet")
            fileref.setAttribute("type", "text/css")
            fileref.setAttribute("href", filename)
        }
        if (typeof fileref != "undefined")
            document.getElementsByTagName("head")[0].appendChild(fileref)
    };

    $(function () {
        var flag = false;
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
                    $('#topright #login').text(object.account).prop('href', 'userinfo.jsp');
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
            async: false,
            url: '/housedetails',
            cache: false,
            success: function (data) {
                // 房源轮播图
                var picBox = document.getElementById('picBox');
                var listBox = document.getElementById('listBox');

                picBox.innerHTML = "";
                listBox.innerHTML = "";

                var picul = document.createElement("ul");
                picul.className = 'cf';
                var listul = document.createElement("ul");
                listul.className = 'cf';


                for (let index = 0; index < data.imgList.split(',').length; index++) {
                    picul.insertAdjacentHTML('beforeend', '<li> <a href="javascript:;"><img style="width: 100%" src="/upload/' + data.imgList.split(',')[index] + '" alt=""></a>  </li>');

                    if (index == 0) {
                        listul.insertAdjacentHTML('beforeend', '<li class="on"><i class="arr2"></i><a href="javascript:;"><img style="width: 100%" src="/upload/' + data.imgList.split(',')[index] + '" alt=""></a></li>');
                    } else {
                        listul.insertAdjacentHTML('beforeend', '<li><i class="arr2"></i><a href="javascript:;"><img style="width: 100%" src="/upload/' + data.imgList.split(',')[index] + '" alt=""></a></li>');
                    }
                }
                picBox.appendChild(picul);
                listBox.appendChild(listul);


                // 房源简介
                $('#Introduction').text(data.describe);

                //房屋设施列表
                $('#tubiao2').empty();
                let facility = ['油烟机', '热水器', '浴霸', '书架', '床', '微波炉', '洗衣机', '衣柜', '沙发', '桌子', '床垫', '智能锁', '椅子', '中央空调'];
                for (let i = 0; i < facility.length; i++) {
                    let flag = false;
                    $.each(data.facilities.split(','), function () {
                        if ((i + 1) == this) {
                            flag = true;
                        }
                    });
                    let $div = $('<div><img class="tubiaoimg"><br>' + facility[i] + '</div>');
                    if (flag) {
                        $div.children(':eq(0)').attr('src', '/resource/images/' + (i + 1) + '.png');
                        // $('#tubiao2').append('<div><img class="tubiaoimg" src="/resource/images/' + (i+1) + '.png"><br>' + facility[i] + '</div>');
                    } else {
                        $div.children(':eq(0)').attr('src', '/resource/images/empty.png');
                        // $('#tubiao2').append('<div><img src="/resource/images/empty.png"><br>' + facility[i] + '</div>');

                    }
                    $('#tubiao2').append($div);
                }
                // 租约信息 可入住日期，签约时长 数据库无此字段

                // 标题
                $('#title').text(data.title);

                //价格
                $('#price').text('￥' + data.rent + '元/月');

                //使用面积
                $('.td1').html('使用面积<h3>' + data.area + ' ㎡</h3>');
                // 朝向
                let toward = ['东', '南', '西', '北', '东南', '东北', '西南', '西北'];
                for (let i = 0; i < 8; i++) {
                    if (data.towardId == i + 1) {
                        $('.td2').html('朝向<h3>' + toward[i] + '</h3>');
                    }
                }

                // 户型
                $('#houseType').html('户型<h3>' + data.houseType + '</h3>');

                // 位置
                $('#address').siblings().text(data.address);


                // 房东信息
                getFd(data.lId);

                flag = true;
            },
            error: function (res) {
                $('body').html(res.responseText);
            }
        });

        var loadFile;

        loadFile = setTimeout(function () {
            if (flag) {
                loadjscssfile("/resource/css/public.css", "css");
                loadjscssfile("/resource/css/housedetails.css", "css");
                loadjscssfile("/resource/css/imgstyle.css", "css");
                loadjscssfile("/resource/js/jquery-3.6.0.min.js", "js");
                loadjscssfile("/resource/js/coco-message.js", "js");
                loadjscssfile("/resource/js/jqueryPhoto.js", "js");
                loadjscssfile("/resource/js/housedetails.js", "js");
                clearTimeout(loadFile);
            }
        }, 50);


    });

});
let pwdReg = new RegExp(/^[a-zA-Z][a-zA-Z0-9]{5,15}$/);
let pwd = false;    //密码
let pwd2 = false;   //二次密码
$(function () {
    cocoMessage.config({
        duration: 2000,
    });
    $('#userinfo').click(function () {
        $('#userhouse').removeClass('user_menu_a');
        $(this).addClass('user_menu_a');
        $('#userinfo_body').show();
        $('#userhouse_body').hide();
        $('#userinfo_content').show();
        $('#house_record_content').hide();
        showUser();
    })
    $('#userhouse').click(function () {
        $('#userinfo').removeClass('user_menu_a');
        $(this).addClass('user_menu_a');
        $('#userinfo_body').hide();
        $('#userhouse_body').show();
        $('#userhouse_content').show();
        $('#house_list_div').hide();
        $('#house_content').hide();
        showLandlord();
    })

    $('#change_password').click(function () {
        $('#password_tr').toggle();
    })

    $('#house_record').click(function () {
        $('#userinfo_content').hide();
        $('#house_record_content').show();
        showHouseRecord();
    })

    $('#user_info').click(function () {
        $('#userinfo_content').show();
        $('#house_record_content').hide();
    })

    $('#landlord_info').click(function () {
        $('#userhouse_content').show();
        $('#house_list_div').hide();
        $('#house_content').hide();
    })

    $('#house_info').click(function () {
        $('#userhouse_content').hide();
        $('#house_list_div').show();
        $('#house_content').hide();
        showHouseInfoList();
    })

    $('#landlord_update').click(function () {
        updateLandlord();
    })

    initialArea();
    initialHouseType();
    initialToward();
    showUser();
    isLandlord();

    //密码
    $('#new_pwd').blur(function () {
        let psw = $(this).val().trim();
        if (psw.length !== 0) {
            if (!pwdReg.test(psw)) {
                $('#sppass').text('密码长度必须大于等于6小于等于16，且必须以英文开头').css('color', 'red');
                $(this).css('border-color', 'red');
                pwd = false;
            } else {
                $('#sppass').text('密码格式正确').css('color', 'green');
                $(this).css('border-color', 'green');
                pwd = true;
            }
        } else {
            $('#sppass').text('密码不能为空').css('color', 'red');
            $(this).css('border-color', 'red');
            pwd = false;
        }
    });
    //第二次密码
    $('#second_pwd').blur(function () {
        var psw2 = $(this).val().trim();
        var psw = $('#new_pwd').val().trim();
        if (psw2.length !== 0) {
            if (psw2 === psw) {
                $('#sppass2').text('密码格式正确').css('color', 'green');
                $(this).css('border-color', 'green');
                pwd2 = true;
            } else {
                $('#sppass2').text('两次密码不一致').css('color', 'red');
                $(this).css('border-color', 'red');
                pwd2 = false;
            }
        } else {
            $('#sppass2').text('密码不能为空').css('color', 'red');
            $(this).css('border-color', 'red');
            pwd2 = false;
        }
    });

    $('#img_file').change(function () {
        let file = this.files[0];
        let dataImgUrl = getObjectURL(file);
        $("#user_img").attr("src", dataImgUrl);
    })

    //显示上传的户型图片
    if ($('#file2').val().trim() !== "") {
        $('#hximg').attr('src', getObjectURL($('#file2').attr('files')[0]))
    }
    $('#file2').change(function () {
        let file = this.files[0];

        let dataImgUrl = getObjectURL(file);
        $("#hximg").attr("src", dataImgUrl);
    })
})

//显示用户信息
function showUser() {
    $.ajax({
        type: 'post',
        dataType: 'json',
        url: '/userinfo',
        cache: false,
        success: function (userinfo) {
            $('#userName').text(userinfo.userName);
            if (userinfo.img == "") {
                $("img[name='user_img']").attr('src', '/resource/images/default.png');
            } else {
                $("img[name='user_img']").attr('src', '/upload/' + userinfo.img);
            }
            $('#nickname').val(userinfo.nickName);
            $('#phone').val(userinfo.phone);
            $('#email').val(userinfo.email);
        },
        error: function (e) {
            $("body").html(e.responseText);
        }
    })
}

//判断房东信息是否为空
function isLandlord() {
    $.ajax({
        type: 'post',
        dataType: 'json',
        url: '/landlordInfo',
        cache: false,
        success: function (landlordInfo) {
            if (landlordInfo == null) {
                $('#userhouse').hide();
            }
        },
        error: function (e) {
            $("body").html(e.responseText);
        }
    })
}

//显示房东信息
function showLandlord() {
    $.ajax({
        type: 'post',
        dataType: 'json',
        url: '/landlordInfo',
        cache: false,
        success: function (landlordInfo) {
            $('#landlordName').text(landlordInfo.lName);
            $('#lName').val(landlordInfo.lName);
            $('#lId').text(landlordInfo.lId);
            $('#idCard').val(landlordInfo.idCard);
            $('#address').val(landlordInfo.address);
        },
        error: function (e) {
            $("body").html(e.responseText);
        }
    })
}

//显示看房记录
function showHouseRecord() {
    $.ajax({
        type: 'post',
        dataType: 'json',
        url: '/checkHouseRecord',
        cache: false,
        success: function (recordList) {
            $('#record').children(":gt(0)").remove();
            $.each(recordList, function (i, record) {
                let $tr = $("<tr></tr>");
                let $td1 = $('<td>' + record.checkHouseRecord.cId + '</td>');
                let $td2 = $('<td>' + timeToString(record.checkHouseRecord.checkDate) + '</td>');
                let $td3 = $('<td><a href="/housedetails?id='+record.checkHouseRecord.cId+'">' + record.title + '</a></td>');
                let $td4 = $('<td><button type="button"  class="userinfo_button" onclick="return delHouseRecord(this)">删除</button></td>');

                $tr.append($td1);
                $tr.append($td2);
                $tr.append($td3);
                $tr.append($td4);

                $('#record').append($tr);
            })
        },
        error: function (e) {
            $("body").html(e.responseText);
        }
    })
}

//修改时间显示格式
function timeToString(time) {
    let date = new Date(time);
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let day = date.getDate();
    let hour = date.getHours();
    let minute = date.getMinutes();
    return year + "年" + month + "月" + day + "日 " + hour + "时" + minute + "分";
}

//删除看房记录
function delHouseRecord(button) {
    let $button = $(button);
    if (!confirm('确定删除吗？')) {
        return false;
    }
    let cid = $button.parent().parent().children(":eq(0)").text();
    $.ajax({
        type: 'post',
        data: {'cid': cid},
        dataType: 'json',
        cache: false,
        url: '/delHouseRecord',
        success: function (data) {
            if (data.state == 203) {
                var delSuccessDiv = document.createElement("div");
                delSuccessDiv.innerText = "删除成功！";
                cocoMessage.warning(delSuccessDiv);
                $button.parent().parent().remove();
            } else {
                var delErrorDiv = document.createElement("div");
                delErrorDiv.innerText = "删除失败！";
                cocoMessage.error(delErrorDiv);
            }
        },
        error: function (e) {
            $("body").html(e.responseText);
        }
    });
}

//修改房东信息
function updateLandlord() {
    let lId = $("#lId").text();
    let lName = $('#lName').val();
    let phone = $('#phone').val();
    let idCard = $('#idCard').val();
    let address = $('#address').val();
    let js = "{'lId':" + lId + ",'lName':'" + lName + "','phone':'" + phone + "','address':'" + address + "'," +
        "'idCard':'" + idCard + "'}";
    $.ajax({
        type: 'post',
        data: {'json': js},
        dataType: 'json',
        cache: false,
        url: '/LandlordInfoUpdate',
        success: function (data) {
            if (data.state == 204) {
                var delSuccessDiv = document.createElement("div");
                delSuccessDiv.innerText = "修改成功！";
                cocoMessage.success(delSuccessDiv);
                $('#landlordName').text(lName);
            }
        },
        error: function (e) {
            $("body").html(e.responseText);
        }
    });
}

//查询房屋信息列表
function showHouseInfoList() {
    let lId = $('#lId').text();
    $.ajax({
        type: 'post',
        data: {'lId': lId},
        dataType: 'json',
        url: '/HouseInfoList',
        cache: false,
        success: function (houseInfoList) {
            $('#house_list').children(":gt(0)").remove();
            let index = 1;
            $.each(houseInfoList, function (i, houseInfo) {
                let $tr = $("<tr></tr>");
                let $td1 = $('<td>' + index++ + '</td>');
                let $td2 = $('<td>' + houseInfo.hId + '</td>');
                let $td3 = $('<td>' + houseInfo.title + '</td>');
                let $td4 = $('<td>' +
                    '<button type="button"  class="userinfo_button" onclick="return delHouseInfo(this)">删除</button>' +
                    '<button type="button"  class="userinfo_button" name="update_houseInfo">修改</button></td>');

                $tr.append($td1);
                $tr.append($td2);
                $tr.append($td3);
                $tr.append($td4);

                $('#house_list').append($tr);
            })
            initialEditBtn();
        },
        error: function (e) {
            $("body").html(e.responseText);
        }
    })
}

//删除房屋信息
function delHouseInfo(button) {
    let $button = $(button);
    if (!confirm('确定删除吗？')) {
        return false;
    }
    let hid = $button.parent().parent().children(":eq(1)").text();
    $.ajax({
        type: 'post',
        data: {'hid': hid},
        dataType: 'json',
        cache: false,
        url: '/delHouseInfo',
        success: function (data) {
            if (data.state == 203) {
                var delSuccessDiv = document.createElement("div");
                delSuccessDiv.innerText = "删除成功！";
                cocoMessage.warning(delSuccessDiv);
                $button.parent().parent().remove();
            } else {
                var delErrorDiv = document.createElement("div");
                delErrorDiv.innerText = "删除失败！";
                cocoMessage.error(delErrorDiv);
            }
        },
        error: function (e) {
            $("body").html(e.responseText);
        }
    });
}

//修改房屋信息
function initialEditBtn() {
    $('button[name="update_houseInfo"]').on('click', function () {
        $('#house_list_div').hide();
        $('#house_content').show();
        let hid = $(this).parent().parent().children(":eq(1)").text();
        $.ajax({
            type: 'post',
            data: {'hid': hid},
            dataType: 'json',
            url: '/houseInfo',
            cache: false,
            success: function (houseInfo) {
                $('#house_title').val(houseInfo.title);

                $('#housetype').parent().append('<input style="display: none" name="hid" value="' + houseInfo.hId + '">');

                $('#housetype').children().attr("selected", false);
                $("#housetype option[value='" + houseInfo.typeId + "']").prop("selected", true);

                $('#house_type').children().attr("selected", false);
                $("#house_type option[value='" + houseInfo.houseType + "']").prop("selected", true);

                $('#toward').children().attr("selected", false);
                $("#toward option[value='" + houseInfo.towardId + "']").prop("selected", true);

                $('#quyu').children().attr("selected", false);
                $("#quyu option[value='" + houseInfo.aid + "']").prop("selected", true);

                $('#house_area').val(houseInfo.area);

                $('#house_rent').val(houseInfo.rent);

                $('#check input').prop('checked', false);
                let obj = houseInfo.facilities.split(',');
                $.each(obj, function () {
                    $('#check input[value="' + this + '"]').prop('checked', true);
                })

                $('#house_address').val(houseInfo.address);

                $('#house_describe').val(houseInfo.describe);

                let imgList = houseInfo.imgList.split(',');
                $('#hximg').attr('src', '/upload/' + imgList[imgList.length - 1]);
            },
            error: function (e) {
                $("body").html(e.responseText);
            }
        })
    })
}

function getObjectURL(file) {
    let url = null;
    if (window.createObjectURL != undefined) {
        url = window.createObjectURL(file);
    } else if (window.URL != undefined) {
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) {
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}

function initialHouseType() {
    $.ajax({
        type: 'post',
        url: '/type',
        dataType: 'json',
        cache: false,
        success: function (data) {
            let $housetype = $('#housetype');
            for (let i = 0; i < data.length; i++) {
                let $option = $('<option value="' + data[i].typeId + '">' + data[i].typeName + '</option>');
                $housetype.append($option);
            }
        }
    })
}

function initialToward() {
    $.ajax({
        type: 'post',
        url: '/toward',
        dataType: 'json',
        cache: false,
        success: function (data) {
            let $toward = $('#toward');
            for (let i = 0; i < data.length; i++) {
                let $option = $('<option value="' + data[i].towardId + '">' + data[i].towardName + '</option>');
                $toward.append($option);
            }
        }
    })
}

function initialArea() {
    $.ajax({
        type: 'post',
        url: '/area',
        dataType: 'json',
        cache: false,
        success: function (data) {
            let $area = $('#quyu');
            for (let i = 0; i < data.length; i++) {
                let $option = $('<option value="' + data[i].aid + '">' + data[i].aName + '</option>');
                $area.append($option);
            }
        }
    })
}
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
    })

    $('#house_info').click(function () {
        $('#userhouse_content').hide();
        $('#house_list_div').show();
        showHouseInfo();
    })

    $('#landlord_update').click(function () {
        updateLandlord();
    })

    $('')

    showUser();
    isLandlord();
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
            $('img').attr('src', '/upload/' + userinfo.img);
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
                let $td2 = $('<td>' + record.checkHouseRecord.checkDate + '</td>');
                let $td3 = $('<td><a href="javascript:;">' + record.title + '</a></td>');
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
function showHouseInfo() {
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
                    '<button type="button"  class="userinfo_button" id="update_houseInfo">修改</button></td>');

                $tr.append($td1);
                $tr.append($td2);
                $tr.append($td3);
                $tr.append($td4);

                $('#house_list').append($tr);
            })
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
function updateHouseInfo() {

}

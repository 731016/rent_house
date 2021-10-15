$(function () {
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
        $('#house_content').hide();
    })

    $('#house_info').click(function () {
        $('#userhouse_content').hide();
        $('#house_content').show();
    })
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
            if(landlordInfo==null){
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
            $.each(recordList,function (i,record) {
                let $tr = $("<tr></tr>");
                let $td1=$('<td>'+record.checkHouseRecord.cId+'</td>');
                let $td2=$('<td>'+record.checkHouseRecord.checkDate+'</td>');
                let $td3=$('<td><a href="">'+record.title+'</a></td>');

                $tr.append($td1);
                $tr.append($td2);
                $tr.append($td3);

                $('#record').append($tr);
            })
        },
        error: function (e) {
            $("body").html(e.responseText);
        }
    })
}
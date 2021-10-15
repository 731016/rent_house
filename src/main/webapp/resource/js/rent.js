$(function () {
    //显示上传的户型图片
    $('#file2').change(function () {
        let file = this.files[0];

        let dataImgUrl = getObjectURL(file);
        $("#hximg").attr("src", dataImgUrl);
    })
    initialArea();
    initialHouseType();
    initialToward();

    //     let housetitle=$('#td3').val();//房屋标题
    //     let housetype=$('#housetype').selected();//类型
    //     let huxing=$('#huxing').selected();//户型
    //     let chaoxiang=$('#chaoxiang').selected();//朝向
    //     let quyu=$('#quyu').selected();//区域
    //     let mianji=$('#mianji').val();//面积
    //     let price=$('#price').val();//租金
    //     let sheshi=$('.sheshi').checked();//设施
    //     let address=$('#address').val();//详细地址
    //     let xinxi=$('#td5').val();//房屋信息
    //
    //     let a={'housetitle':housetitle,'housetype':housetype,'huxing':huxing,'chaoxiang':chaoxiang,'quyu':quyu,'mianji':mianji,'price':price,'sheshi':sheshi,'address':address,'xinxi':xinxi};
    //     $.ajax({
    //         type: 'post',
    //         dataType: 'json',
    //         data:a,
    //         url: '/rent',
    //         cache: false,
    //         success: function (data) {
    //             // let object = data.object;
    //             // if (object !== undefined) {
    //             //     // TODO :点击账户名进入账户信息页面
    //             //     $('#topright #login').text(object.account).prop('href','"javascript;"');
    //             //     // TODO: exit账户，删除session
    //             //     $('#topright #register').text('退出').prop('href','"javascript;"');
    //             // } else {
    //             //     $('#topright #login').text('登录').prop('href','"login.jsp"');
    //             //     $('#topright #register').text('注册').prop('href','"register.jsp"');
    //             // }
    //         },
    //         error: function (res) {
    //             // $('body').innerText(res.responseText);
    //         }
    //     });
});
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
        type:'post',
        url:'/type',
        dataType:'json',
        cache:false,
        success:function (data) {
            let $housetype = $('#housetype');
            for (let i = 0; i < data.length; i++) {
                let $option = $('<option value="'+data[i].typeId+'">'+data[i].typeName+'</option>');
                $housetype.append($option);
            }
        }
    })
}
function initialToward() {
    $.ajax({
        type:'post',
        url:'/toward',
        dataType: 'json',
        cache: false,
        success:function (data) {
            let $toward = $('#toward');
            for (let i = 0; i < data.length; i++) {
                let $option = $('<option value="'+data[i].towardId+'">'+data[i].towardName+'</option>');
                $toward.append($option);
            }
        }
    })
}
function initialArea() {
    $.ajax({
        type:'post',
        url:'/area',
        dataType:'json',
        cache:false,
        success:function (data) {
            let $area = $('#quyu');
            for (let i = 0; i < data.length; i++) {
                let $option = $('<option value="'+data[i].aid+'">'+data[i].aName+'</option>');
                $area.append($option);
            }
        }
    })
}

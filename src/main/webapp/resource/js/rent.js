window.addEventListener('load',function(){
    $(function () {
        //显示上传的户型图片
        $('#file2').change(function () {
            let file=this.files[0];

            let $imgfile=$(this);
            let imgobj=$imgfile[0];
            let windowURL=window.url || window.webkitURL;
            let dataimgurl=windowURL.createObjectURL(imgobj.files[0]);
            $("#hximg").attr("src",dataimgurl);
        })

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
});

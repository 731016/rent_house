window.addEventListener('load', function () {
    cocoMessage.config({
        duration: 2000,
    });
    initialUsers();
    initialHouseManager();
    initialUserManager();
});

function initialUserManager() {
    $('#userManager').on('click', function () {
        $('#dv2').addClass("hidden");
        $('#dv1').removeClass('hidden');
        initialUsers();
    })
}

function initialHouseManager() {
    $('#houseManager').on('click', function () {
        $('#dv1').addClass("hidden");
        $('#dv2').removeClass('hidden');
        initialHouses();
    })

}

function initialUserChange() {
    $('button[name="users"]').on('click', function () {
        let $sta = $(this).parent().prev();
        let na = $(this).parent().parent().children(':eq(1)').html();
        let noo = $(this).html();
        if (confirm('确定要' + noo + ' ' + na + ' 吗')) {
            $.ajax({
                type:'post',
                data:{"account":na},
                cache:false,
                url:'/updateuser',
                dataType:'json',
                success:function (data) {
                    if(data.flag){
                        if(data.state === 0) {
                            initialUsers();
                        }else{
                            alert('修改失败')
                        }
                    }else{
                        switch (data.state) {
                            case 1:
                                alert("会话过期");
                                location.href="/admin.jsp";
                                break;
                            case 2:
                                alert('缺少参数');
                                break;
                            case 3:
                                alert('没有用户名为' + na + '的用户');
                                initialHouses();
                                break;
                        }
                    }
                }
            })
        }
    })
}

function initialUsers() {
    $('#tbody_user').children().remove();
    $.ajax({
        type: 'post',
        async: false,
        cache: false,
        url: '/userlist',
        dataType: 'json',
        success: function (data) {
            if (!data.flag) {
                alert('会话过期');
                location.href = "/admin.jsp";
                return;
            }
            let json = data.object;
            $.each(json, function () {
                let $tr = $('<tr>\n' +
                    '<td>' + this.userName + '</td>\n' +
                    '<td>' + this.account + '</td>\n' +
                    '<td>' + this.phone + '</td>\n' +
                    '<td>' + this.email + '</td>\n' +
                    '<td class="state">' + this.state + '</td>\n' +
                    '<td><button class="btn btn-primary" name="users">' + (this.state === 1 ? "禁用" : "启用") + '</button></td>\n' +
                    '</tr>');
                $('#tbody_user').append($tr);
            })
        }
    })
    initialUserChange();
}

function initialHousesDelete() {
    $('button[name="houses"]').on('click', function () {
        let hid = $(this).parent().parent().children(':eq(0)').text();
        let value = $(this).val();
        if (!confirm('确定 '+ value + hid + '的记录？')) {
            return;
        }
        $.ajax({
            type: 'post',
            dataType: 'json',
            data: {"hid": hid},
            cache: false,
            url: "/housedel",
            success: function (data) {
                if (data.flag) {
                    if (data.state !== 0) {
                        alert(data.msg);
                    } else {
                        initialHouses();
                    }
                } else {
                    if (data.state === 1) {
                        alert(data.msg);
                        location.href = "/admin.jsp";
                    } else {
                        alert(data.msg);
                    }
                }
            },
            error:function (response) {
                $('body').html(response.responseText);
            }
        })
    })

}

function initialHouses() {
    $('#tbody_house').children().remove();
    $.ajax({
        type: 'post',
        dataType: 'json',
        url: '/houselist',
        async: false,
        cache: false,
        success: function (data) {
            if (!data.flag) {
                alert('会话过期');
                location.href = "/admin.jsp";
                return;
            }
            let json = data.object;
            $.each(json, function () {
                let $tr = $('<tr>\n' +
                    '<td>' + this.hId + '</td>' +
                    '<td>' + this.title + '</td>\n' +
                    '<td>' + this.rent + '</td>\n' +
                    '<td>' + this.houseType + '</td>\n' +
                    '<td>' + this.area + '</td>\n' +
                    '<td>' + this.address + '</td>\n' +
                    '<td><button type="button" class="btn btn-danger" name="houses">删除</button></td>\n' +
                    '</tr>');
                $('#tbody_house').append($tr);
            })
        }
    })
    initialHousesDelete();
}
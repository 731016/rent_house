let accReg = new RegExp(/^[a-zA-Z0-9]{4,16}$/);
let pwdReg = new RegExp(/^[a-zA-Z][a-zA-Z0-9]{5,15}$/);
let acc = false;    //账号
let pwd = false;    //密码
let pwd2 = false;   //二次密码
let na = false;     //姓名
let nick = false;   //昵称
let email = false;  //邮箱
let phone = false;  //手机号
window.addEventListener('load', function () {
    cocoMessage.config({
        duration: 2000,
    });
    $(function () {
        // 用户已登录返回首页
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/login",
            success: function (data) {
                if (data.state == 202) {
                    location.href = "/index.jsp";
                }
            },
            error: function (resp) {
                $('body').html(resp.responseText);
            }
        });


        //用户名
        $('#txt').blur(function () {
            let txt = $(this).val().trim();
            if (txt.length !== 0) {
                if (!accReg.test(txt)) {
                    $('#sptxt').text('账号长度必须大于4小于16').css('color', 'red');
                    // $(this).css('color','red');
                    $(this).css('border-color', 'red');
                    acc = false;
                } else {
                    let aj = {"account": txt}
                    $.ajax({
                        type: "post",
                        data: aj,
                        dataType: "json",
                        url: "/registerJudge",
                        success: function (data) {
                            if (data.flag) {
                                $('#sptxt').text('账号格式正确').css('color', 'green');
                                // $(this).css('color','green');
                                $(this).css('border-color', 'green');
                                acc = true;
                            } else {
                                $('#sptxt').text('用户已被注册').css('color', 'red');
                                // $(this).css('color','green');
                                $(this).css('border-color', 'red');
                                acc = false;
                            }
                        },
                        error: function (e) {
                            $("body").html(e.responseText);
                        }
                    })

                }
            } else {
                $('#sptxt').text('账号不能为空').css('color', 'red');
                $(this).css('border-color', 'red');
                acc = false;
            }
        });
        //密码
        $('#psw').blur(function () {
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
        $('#psw2').blur(function () {
            var psw2 = $(this).val().trim();
            var psw = $('#psw').val().trim();
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

        //姓名
        $('#name').blur(function () {
            if ($(this).val().trim().length == 0) {
                $('#spname').text('姓名不能为空').css('color', 'red');
                na = false;
            } else {
                $('#spname').text(null);
                na = true;
            }
        });
        //昵称
        $('#account').blur(function () {
            if ($(this).val().trim().length == 0) {
                $('#spaccount').text('昵称不能为空').css('color', 'red');
                nick = false;
            } else {
                $('#spaccount').text(null);
                nick = true;
            }
        });
        //邮箱
        $('#qq').blur(function () {
            if ($(this).val().trim().length == 0) {
                $('#spQQ').text('邮箱不能为空').css('color', 'red');
                email = false;
            } else {
                $('#spQQ').text(null)
                email = true;
            }
        });
        //手机号
        $('#phone').blur(function () {
            if ($(this).val().trim().length == 0) {
                $('#spphone').text('手机号不能为空').css('color', 'red');
                phone = false;
            } else {
                $('#spphone').text(null);
                phone = true;
            }
        });
        $("form").submit(function () {

        })

        $("#btn_reg").click(function () {
            let stateList = [acc, pwd, pwd2, na, nick, email, phone];
            let flag = true;
            for (let i = 0; i < stateList.length; i++) {
                if (!stateList[i]) {
                    flag = false;
                }
            }
            if (flag) {
                add()
            }
        })

    });
});

function add() {
    let acc = $("[name='account']").val();
    let pwd = $("[name='password']").val();
    let name = $("[name='name']").val();
    let nickName = $("[name='nickname']").val();
    let email = $("[name='email']").val();
    let phone = $("[name='phone']").val();
    let ajax = {"account": acc, "password": pwd, "name": name, "nickname": nickName, "email": email, "phone": phone}
    $.ajax({
        type: "post",
        data: ajax,
        dataType: "json",
        url: "/register",
        success: function (data) {
            if (data.flag) {
                //注册成功弹出
                let registerDiv = document.createElement("div");
                registerDiv.innerText = "注册成功！";
                cocoMessage.success(registerDiv);
                //
                setTimeout(() => {
                    location.href = "/login.jsp"
                }, 2000)
            } else {
                //失败弹出
                let registerDiv = document.createElement("div");
                registerDiv.innerText = "注册失败！";
                cocoMessage.error(registerDiv);
            }
        },
        error: function (e) {
            $("body").html(e.responseText)
        }
    })
}
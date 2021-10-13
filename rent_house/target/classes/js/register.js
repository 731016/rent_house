window.addEventListener('load',function () {
    $(function(){
        //用户名
        $('#txt').blur(function(){
            var txt=$(this).val().trim();
            if(txt.length!=0){
                if(txt.length<=4 || txt.length>=10){
                    $('#sptxt').text('账号长度必须大于4小于10').css('color','red');
                    // $(this).css('color','red');
                    $(this).css('border-color','red');
                }else{
                    $('#sptxt').text('账号格式正确').css('color','green');
                    // $(this).css('color','green');
                    $(this).css('border-color','green');
                }
            }else{
                $('#sptxt').text('账号不能为空').css('color','red');
            }
        });
        //密码
        $('#psw').blur(function(){
            var psw=$(this).val().trim();
            if(psw.length!=0){
                if(psw.length<=4 || psw.length>=10){
                    $('#sppass').text('密码长度必须大于4小于10').css('color','red');
                    $(this).css('border-color','red');
                }else{
                    $('#sppass').text('密码格式正确').css('color','green');
                    $(this).css('border-color','green');
                }
            }else{
                $('#sppass').text('密码不能为空').css('color','red');
            }
        });
        //第二次密码
        $('#psw2').blur(function(){
            var psw2=$(this).val().trim();
            var psw=$('#psw').val().trim();
            if(psw2.length!=0){
                if(psw2.length<=4 || psw2.length>=10){
                    $('#sppass2').text('密码长度必须大于4小于10').css('color','red');
                    $(this).css('border-color','red');
                }else{
                    if(psw2==psw){
                        $('#sppass2').text('密码格式正确').css('color','green');
                        $(this).css('border-color','green');
                    }else{
                        $('#sppass2').text('两次密码不一致').css('color','red');
                    }
                }
            }else{
                $('#sppass2').text('密码不能为空').css('color','red');
            }
        });

        //姓名
        $('#name').blur(function(){
            if($(this).val().trim().length==0){
                $('#spname').text('姓名不能为空').css('color','red');
            }
        });
        //昵称
        $('#account').blur(function(){
            if($(this).val().trim().length==0){
                $('#spaccount').text('昵称不能为空').css('color','red');
            }
        });
        //邮箱
        $('#qq').blur(function(){
            if($(this).val().trim().length==0){
                $('#spQQ').text('邮箱不能为空').css('color','red');
            }
        });
        //手机号
        $('#phone').blur(function(){
            if($(this).val().trim().length==0){
                $('#spphone').text('手机号不能为空').css('color','red');
            }
        });
    });
});
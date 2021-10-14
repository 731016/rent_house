let accReg = new RegExp(/^[a-zA-Z0-9]{4,16}$/);
let pwdReg = new RegExp(/^[a-zA-Z][a-zA-Z0-9]{5,15}$/);

let na = false;     //姓名
let nick = false;   //昵称
let email = false;  //邮箱
let phone = false;  //手机号
window.addEventListener('load',function () {
    $(function(){
        
        //姓名
        $('#name').blur(function(){
            if($(this).val().trim().length==0){
                $('#spname').text('姓名不能为空').css('color','red');
                na = false;
            }else {
                $('#spname').text(null);
                na = true;
            }
        });
        //手机号
        $('#phone').blur(function(){
            if($(this).val().trim().length==0){
                $('#spphone').text('手机号不能为空').css('color','red');
                phone = false;
            }else {
                $('#spphone').text(null);
                phone = true;
            }
        });
        //身份证
        $('#cid').blur(function(){
            if($(this).val().trim().length==0){
                $('#spcid').text('身份证不能为空').css('color','red');
                nick = false;
            }else {
                $('#spcid').text(null);
                nick = true;
            }
        });
        //住址
        $('#zhuzhi').blur(function(){
            if($(this).val().trim().length==0){
                $('#spzhuzhi').text('住址不能为空').css('color','red');
                email = false;
            }else {
                $('#spzhuzhi').text(null)
                email = true;
            }
        });
        $("form").submit(function () {
            let stateList = [na,nick,email,phone];
            let flag = true;
           for (let i=0;i<stateList.length;i++){
                if (!stateList[i]){
                    flag=false;
                }
            }
            return flag;
        })


    });
});
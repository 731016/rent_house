$(function () {
   $("#btn").click(function () {
      let acc = $("#acc").val();
      let pwd = $("#pwd").val();
      let ajax = {"account":acc,"password":pwd}
      $.ajax({
         type:"post",
         data:ajax,
         dataType:"json",
         url:"/adminlogin",
         success:function (data) {
            if (data.flag){
               location.href = "bgmanage.jsp"
            }else {
               $("#judge").html("用户名或密码错误").css("color","red")
            }
         },
         error:function (e) {
            $("body").html(e.responseText)
         }
      })
   })
})
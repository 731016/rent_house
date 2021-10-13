<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录页面</title>
  <%--网页logo START --%>
  <link rel="icon" href="/resource/favicon.ico" type="image/x-icon" />
  <link rel="shortcut icon" href="/resource/favicon.ico" type="image/x-icon"/>
  <%--网页logo END --%>
  <link rel="stylesheet" href="/resource/css/login.css">
  <script src="/resource/js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
  <script src="/resource/js/login.js"></script>
  <script>
    $(function () {
      $("#btn").click(function () {
        let $txt = $("#txt").val();
        let $psw = $("#psw").val();
        let aj = {"account":$txt,"password":$psw}
        $.ajax({
          type:"post",
          data:aj,
          dataType:"json",
          url:"/login",
          success:function (data) {
            if (data.flag){
              history.back();
            }else {
              $("#validation").html("<span>账号或密码错误</span>").css("color","red")
              return false;
            }
          },
          error:function (e) {
            $("body").html(e.responseText)
          }
        })
      })
    })
  </script>
</head>
<body>
<form>
  <span id="our">Lie flat租房</span>
  <div id="big">
    <div id="login">
      <a href="index.jsp" id="backhome">< 返回首页</a>
      <div id="title" style="text-align: center;">
        <h1>登录</h1>
      </div>
      <div id="validation"></div>
      <div class="input">
        账号：
        <input id="txt" name="account" /><br />
        <span id="sptxt" class="sp"></span>
      </div>
      <div class="input">
        密码：
        <input type="password" id="psw" name="password" /><br>
        <span id="sppass" class="sp"></span>
      </div>
      <div id="aa">
        <input type="checkbox"/>记住密码
      </div>
      <div id="sub">
        <input type="button" value="登录" id="btn" />
      </div>
      <a href="register.jsp">注册</a>
    </div>
  </div>
</form>
</body>
</html>

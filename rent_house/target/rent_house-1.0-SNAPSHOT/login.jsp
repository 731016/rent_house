<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录页面</title>
  <link rel="stylesheet" href="./resource/css/login.css">
  <script src="resource/js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
  <script src="resource/js/login.js"></script>
</head>
<body>
<form method="post" action="">
  <span id="our">Lie flat租房</span>
  <div id="big">
    <div id="login">
      <div id="title" style="text-align: center;">
        <h1>登录</h1>
      </div>
      <div class="input">
        账号：
        <input id="txt" /><br />
        <span id="sptxt" class="sp"></span>
      </div>
      <div class="input">
        密码：
        <input type="password" id="psw" /><br>
        <span id="sppass" class="sp"></span>
      </div>
      <div id="aa">
        <input type="checkbox"/>记住密码
        <span id="first">首次登陆自动注册</span>
      </div>
      <div id="sub">
        <input type="submit" value="登录" id="btn" />
      </div>
      <!-- <a href="#">注册</a> -->
    </div>
  </div>
</form>
</body>
</html>

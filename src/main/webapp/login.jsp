<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录页面</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <%--网页logo START --%>
  <link rel="icon" href="/resource/favicon.ico" type="image/x-icon" />
  <link rel="shortcut icon" href="/resource/favicon.ico" type="image/x-icon"/>
  <link href="/resource/bootstrap-4.6.0-dist/css/bootstrap.min.css" rel="stylesheet">

<%--网页logo END --%>
  <link href="/resource/css/public.css" rel="stylesheet">
  <link rel="stylesheet" href="/resource/css/login.css">
  <script src="/resource/js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
  <script src="/resource/bootstrap-4.6.0-dist/js/bootstrap.bundle.min.js"></script>
  <script src="/resource/js/coco-message.js"></script>
  <script src="/resource/js/login.js"></script>

</head>
<body>
<form>
  <header id="header">
    <span id="our">Lie flat租房</span>
  </header>
  <div id="big">
    <div id="login">
      <a href="index.jsp" id="backhome">< 返回首页</a>
      <div id="title" style="text-align: center;">
        <h1 id="lab">登录</h1>
      </div>
      <div id="validation" style="text-align: center"></div>
      <div class="input">
        账号：
        <input type="text" id="txt" name="account" /><br />
        <span id="sptxt" class="sp"></span>
      </div>
      <div class="input">
        密码：
        <input type="password" id="psw" name="password" /><br>
        <span id="sppass" class="sp"></span>
      </div>
      <div id="sub">
        <input type="button" value="登录" id="btn" class="btn btn-primary btn_log" />
      </div>
      <a href="register.jsp" >注册</a>
    </div>
  </div>
</form>
</body>
</html>

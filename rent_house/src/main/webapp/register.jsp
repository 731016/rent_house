<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>注册页面</title>
  <%--网页logo START --%>
  <link rel="icon" href="resource/favicon.ico" type="image/x-icon" />
  <link rel="shortcut icon" href="resource/favicon.ico" type="image/x-icon"/>
  <%--网页logo END --%>
  <link rel="stylesheet" href="./resource/css/regist.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="/resource/js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="/resource/js/register.js"></script>
</head>
<body>
<form method="post" action="#">
<span id="our">Lie flat租房</span>
<div id="big">
  <div id="login">
    <div id="title" style="text-align: center;">

      <a href="index.jsp" id="index_a">< 返回首页</a>
      <h1>注册</h1>
    </div>
    <table>
      <tr>
        <td class="td1">
          账号：
        </td>
        <td class="input">
          <input id="txt" class="inp" /><br />
          <span id="sptxt" class="sp"></span>
        </td>
      </tr>
      <tr>
        <td class="td1">
          密码：
        </td>
        <td class="input">
          <input type="password" id="psw" class="inp" /><br>
          <span id="sppass" class="sp"></span>
        </td>
      </tr>
      <tr>
        <td class="td1">
          再次密码：
        </td>
        <td class="input">
          <input type="password" id="psw2" class="inp" /><br>
          <span id="sppass2" class="sp"></span>
        </td>
      </tr>
      <tr>
        <td class="td1">
          姓名：
        </td>
        <td class="input">
          <input id="name"  class="inp"/><br />
          <span id="spname" class="sp"></span>
        </td>
      </tr>
      <tr>
        <td class="td1">
          昵称：
        </td>
        <td class="input">
          <input id="account" class="inp" /><br />
          <span id="spaccount" class="sp"></span>
        </td>
      </tr>
      <tr>
        <td class="td1">
          邮箱：
        </td>
        <td class="input">
          <input id="qq" class="inp" /><br />
          <span id="spQQ" class="sp"></span>
        </td>
      </tr>
      <tr>
        <td class="td1">
          手机号：
        </td>
        <td class="input">
          <input id="phone" class="inp" /><br />
          <span id="spphone" class="sp"></span>
        </td>
      </tr>
      <tr>
        <td colspan="2" style="text-align: right;">
          <a href="login.jsp" id="log_a">已有账号立即登录</a>
        </td>
      </tr>
      <tr id="reg_tr">
        <td colspan="2" style="text-align: center;">
          <input type="submit" value="注册" id="btn_reg" class="btn btn-primary" />
        </td>
      </tr>
    </table>
  </div>
</div>
</form>
</body>
</html>

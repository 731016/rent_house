<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/12
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>注册页面</title>
  <link rel="stylesheet" href="./resource/css/regist.css">
  <script src="jquery/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
  <script src="./resource/js/register.js"></script>
</head>
<body>
<form>
<span id="our">Lie flat租房</span>
<div id="big">
  <div id="login">
    <div id="title" style="text-align: center;">

      <a href="#">< 返回登录</a>
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
        <td colspan="2" style="text-align: center;">
          <input type="submit" value="注册" id="btn" />
        </td>
      </tr>
    </table>
  </div>
</div>
</form>
</body>
</html>

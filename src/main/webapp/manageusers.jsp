<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/14
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>管理用户</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <link rel="stylesheet" type="text/css" href="/resource/css/manageusers.css"/>
  <link rel="stylesheet" href="/resource/bootstrap-4.6.0-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resource/css/public.css">
  <script src="/resource/js/jquery-3.6.0.min.js"></script>
  <script src="/resource/js/manageusers.js" type="text/javascript" charset="utf-8"></script>
  <script src="/resource/js/public_login.js"></script>
</head>
<body>

<header id="header">
  <ul>
    <li><a href="index.jsp" class="nav_header">首页</a></li>
    <li><a href="#" class="nav_header current">租房</a></li>
    <li><a href="javascript:;" class="nav_header">出租</a></li>
    <li class="reg_log" id="show_register"><a href="register.jsp" class="nav_header">注册</a></li>
    <li class="reg_log" style="color: #fff;">|</li>
    <li class="reg_log" id="show_login"><a href="login.jsp" class="nav_header">登录</a></li>
  </ul>
</header>
<div id="dv">
  <table class="table table-hover">
    <tr>
      <td id="td" id="td1" class="td1">姓名</td>
      <td class="td1">用户名</td>
      <td class="td1">手机号</td>
      <td class="td1">邮箱</td>
      <td class="td1">状态</td>
      <td class="td1">操作</td>
    </tr>
    <tr>
      <td class="td">姓名</td>
      <td>用户名</td>
      <td>手机号</td>
      <td>邮箱</td>
      <td class="state">-1</td>
      <td><a href="#" class="no"></a></td>
    </tr>
    <tr>
      <td class="td">adas</td>
      <td>用户名</td>
      <td>手机号</td>
      <td>邮箱</td>
      <td class="state">1</td>
      <td><a href="#" class="no"></a></td>
    </tr>
  </table>
</div>

</body>
</html>

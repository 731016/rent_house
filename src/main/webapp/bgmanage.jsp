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
  <script src="/resource/js/public_login.js"></script>
  <script src="/resource/js/manageusers.js" type="text/javascript" charset="utf-8"></script>
  <script src="/resource/js/coco-message.js"></script>
</head>
<body>

<header id="header">
  <ul>
    <li><a class="nav_header a" id="userManager">用户管理</a></li>
    <li><a class="nav_header a" id="houseManager">房屋管理</a></li>
    <li class="reg_log"><a href="/adminlogout" class="nav_header a">退出</a></li>
  </ul>
</header>
<div id="dv1" class="dv show">
  <table class="table table-dark table-hover">
    <thead>
    <tr>
      <th>姓名</th>
      <th>用户名</th>
      <th>手机号</th>
      <th>邮箱</th>
      <th>状态</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody id="tbody_user"></tbody>
  </table>
</div>
<div id="dv2" class="dv hidden">
  <table class="table table-dark table-hover">
    <thead>
    <tr>
      <th>编号</th>
      <th>标题</th>
      <th>租金</th>
      <th>户型</th>
      <th>面积</th>
      <th>地址</th>
      <th>操作</th>
    </tr>
    </thead>
      <tbody id="tbody_house"></tbody>
  </table>
</div>
</body>
</html>

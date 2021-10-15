<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/15
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>超级管理员</title>
   <meta http-equiv="pragma" content="no-cache">
   <meta http-equiv="cache-control" content="no-cache">
   <meta http-equiv="expires" content="0">
   <!-- <%--网页logo START --%> -->
   <link rel="icon" href="/resource/favicon.ico" type="image/x-icon"/>
   <link rel="shortcut icon" href="/resource/favicon.ico" type="image/x-icon"/>
   <!-- <%--网页logo END --%> -->
   <link rel="stylesheet" href="/resource/css/admin.css">
   <link href="/resource/bootstrap-4.6.0-dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="/resource/js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
   <script src="/resource/bootstrap-4.6.0-dist/js/bootstrap.bundle.min.js"></script>
   <script src="/resource/js/admin.js"></script>
</head>
<body>
<div class="divtop">
   <h1 class="title">管理员登录</h1>
   <div id="judge"></div>
   <table>
      <tr>
         <td>账号：</td>
         <td><input type="text" id="acc" class="form-control"></td>
      </tr>
      <tr>
         <td>密码：</td>
         <td><input type="password" name="" id="pwd" class="form-control"></td>
      </tr>
      <tr>
         <td colspan="2"><input type="button" class="btn btn-primary btnbottom" id="btn" value="登录"></td>
      </tr>
   </table>
</div>
</body>
</html>

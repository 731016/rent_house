<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>房东注册</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <link rel="icon" href="/resource/favicon.ico" type="image/x-icon" />
  <link rel="shortcut icon" href="/resource/favicon.ico" type="image/x-icon"/>

  <link rel="stylesheet" href="/resource/css/fdregister.css">
  <link href="/resource/bootstrap-4.6.0-dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="/resource/js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
  <script src="/resource/bootstrap-4.6.0-dist/js/bootstrap.bundle.min.js"></script>
  <script src="resource/js/coco-message.js"></script>
  <script src="/resource/js/fdregister.js"></script>
</head>
<body>
<form method="post" action="/fdregister">
  <span id="our">Lie flat租房</span>
  <div id="big">
    <div id="login">
      <div id="title" style="text-align: center;">
        <a href="index.jsp" id="index_a">< 返回首页</a>
        <h1>房东注册</h1>
      </div>
      <table>
        <tr>
          <td class="td1">
            姓名：
          </td>
          <td class="input">
            <input id="name"  class="inp" name="name"/><br />
            <span id="spname" class="sp"></span>
          </td>
        </tr>
        <tr>
          <td class="td1">
            手机号：
          </td>
          <td class="input">
            <input id="phone" class="inp" name="phone" /><br />
            <span id="spphone" class="sp"></span>
          </td>
        </tr>
        <tr>
          <td class="td1">
            身份证：
          </td>
          <td class="input">
            <input id="cid" class="inp" name="cid" /><br />
            <span id="spcid" class="sp"></span>
          </td>
        </tr>
        <tr>
          <td class="td1">
            住址：
          </td>
          <td class="input">
            <input type="text" id="zhuzhi" class="inp" name="zhuzhi" /><br />
            <span id="spzhuzhi" class="sp"></span>
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

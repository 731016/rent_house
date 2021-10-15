<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/15
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>我的信息</title>
  <link rel="stylesheet" href="/resource/bootstrap-4.6.0-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="resource/css/userinfo.css">
  <script src="/resource/js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
  <script src="/resource/bootstrap-4.6.0-dist/js/bootstrap.bundle.min.js"></script>
  <script src="resource/js/userinfo.js"></script>
</head>
<body>
<div class="div_header" id="user_menu">
  <div class="div_body user_menu_div center">
    <div id="logo" class="div_inBlock"></div>
    <div id="menu_list">
      <a href="javascript:;" class="user_menu_a" id="userinfo">我的信息</a>
      <a href="javascript:;" id="userhouse">我的房屋</a>
    </div>
    <a class="backindex" id="backindex" href="/index.jsp">返回首页</a>
  </div>
</div>
<!-- 用户信息界面 -->
<div class="div_body user_body" id="userinfo_body">
  <!-- 用户信息菜单 -->
  <div id="userinfo_menu" class="userinfo_left border">
    <div id="userinfo_menu_img" class="userinfo_menu_img">
      <img src="" alt="">
      <p>用户姓名</p>
    </div>
    <ul id="userinfo_ul" class="userinfo_ul">
      <li>
        <b></b>
        <a href="#" id="user_info">个人信息</a>
      </li>
      <li>
        <b></b>
        <a href="#" id="house_record">看房记录</a>
      </li>
    </ul>
  </div>
  <!-- 用户信息详情 -->
  <div id="userinfo_content" class="userinfo_right border">
    <div id="userinfo_title" class="userinfo_title border_bottom">
      个人信息
    </div>
    <div id="user_tableForm">
      <form action="">
        <table id="userinfo_table" class="userinfo_table">
          <tr>
            <td style="width: 100px;">头像</td>
            <td style="width: 160px;">
              <img src="" alt="">
            </td>
            <td>
              <div style="position: relative;">
                <input type="button" value="本地照片" class="userinfo_button" id="img_button">
                <input type="file" name="" id="img_file" class="img_file">
                <p style="margin-top: 10px;">仅支持JPG、PNG格式。</p>
              </div>
            </td>
          </tr>
          <tr>
            <td colspan="3" style="border-top: 1px solid rgb(117, 117, 117); height: 0px; padding: 0;">
            </td>
          </tr>
          <tr>
            <td>昵称</td>
            <td colspan="2"><input type="text" class="userinfo_input" id="nickname"></td>
          </tr>
          <tr>
            <td>手机号</td>
            <td colspan="2"><input type="text" class="userinfo_input" id="phone"></td>
          </tr>
          <tr>
            <td>邮箱</td>
            <td colspan="2"><input type="text" class="userinfo_input" id="email"></td>
          </tr>
          <tr>
            <td>密码</td>
            <td colspan="2"><input type="button" class="userinfo_button" value="修改密码" id="change_password"></td>
          </tr>
          <tr style="display: none;" id="password_tr">
            <td colspan="3">
              <div class="password_div">
                <span class="password_span div_inBlock">初始密码</span>
                <input type="text" class="userinfo_input">
              </div>
              <div class="password_div">
                <span class="password_span div_inBlock">新密码</span>
                <input type="text" class="userinfo_input">
              </div>
              <div class="password_div">
                <span class="password_span div_inBlock">确认密码</span>
                <input type="text" class="userinfo_input">
              </div>
            </td>
          </tr>
          <tr>
            <td></td>
            <td colspan="2"><input type="submit" class="userinfo_button"  value="保存"></td>
          </tr>
        </table>
      </form>
    </div>
  </div>
  <!-- 看房记录 -->
  <div class="userinfo_right border" id="house_record_content" style="display: none;">
    <div id="house_record_title" class="userinfo_title border_bottom">
      看房记录
    </div>
    <div>
      <table class="table table-striped">
        <thead>
        <tr>
          <th scope="col">编号</th>
          <th scope="col">日期</th>
          <th scope="col">房屋</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>1</td>
          <td>2021.10.15</td>
          <td><a href="">xxxxxx</a></td>
        </tr>
        </tbody>
      </table>
      </table>
    </div>
  </div>

</div>
<!-- 房东信息界面 -->
<div class="div_body user_body" id="userhouse_body" style="display: none;">
  <!-- 房东信息菜单 -->
  <div id=" userhouse_menu " class="userinfo_left border ">
    <div id="userhouse_menu_img " class="userinfo_menu_img ">
      <img src=" " alt=" " style="min-width: 100px;">
      <p>房东姓名</p>
    </div>
    <ul id="userhouse_ul " class="userinfo_ul ">
      <li>
        <b></b>
        <a href="# " id="landlord_info">房东信息</a>
      </li>
      <li>
        <b></b>
        <a href="# " id="house_info">房屋信息</a>
      </li>
    </ul>
  </div>
  <!-- 房东信息详情 -->
  <div id="userhouse_content" class="userinfo_right border ">
    <div id="userhouse_title" class="userinfo_title border_bottom ">
      房东信息
    </div>
    <div id="huose_tableForm ">
      <form action=" ">
        <table id="userhouse_table " class="houseinfo_table ">
          <tr>
            <td class="table_td table_td_first">姓名</td>
            <td class="table_td table_td_first"><input type="text " class="userinfo_input " id="nickname "></td>
          </tr>
          <tr>
            <td class="table_td">身份证</td>
            <td class="table_td"><input type="text " class="userinfo_input " id="phone "></td>
          </tr>
          <tr>
            <td class="table_td">住址</td>
            <td class="table_td"><input type="text " class="userinfo_input " id="email "></td>
          </tr>
          <tr>
            <td class="table_td"></td>
            <td class="table_td"><input type="submit" class="userinfo_button" id="" value="保存"></td>
          </tr>
        </table>
      </form>
    </div>
  </div>
  <div id="house_content" class="userinfo_right border" style="display: none;">
    <div id="houseinfo_title " class="userinfo_title border_bottom ">
      房屋信息
    </div>
    <table class="houseinfo_table ">
      <tr>
        <td class="table_td table_td_first">房屋标题 :</td>
        <td class="table_td table_td_first"><input type="text" id="td3" class="userinfo_input "></td>
      </tr>

      <tr>
        <td class="table_td">户型 :</td>
        <td class="table_td">
          <select>
            <option value="一室" disabled selected hidden>一室</option>
            <option value="一室">一室</option>
            <option value="两室">两室</option>
            <option value="三室">三室</option>
            <option value="四室">四室</option>
            <option value="五室">五室</option>
          </select>
        </td>
      </tr>

      <tr>
        <td class="table_td">面积 :</td>
        <td class="table_td"><input type="text" oninput="value=value.replace(/[^\d]/g,'')" class="userinfo_input ">平米
        </td>
      </tr>

      <tr>
        <td class="table_td">租金 :</td>
        <td class="table_td"><input type="text" oninput="value=value.replace(/[^\d]/g,'')" class="userinfo_input ">元/月
        </td>
      </tr>

      <tr>
        <td class="table_td" style="height: 80px">设施:</td>
        <td id="check">
          <input type="checkbox" value="3">浴霸
          <input type="checkbox" value="4">书架
          <input type="checkbox" value="1">油烟机
          <input type="checkbox" value="2">热水器
          <input type="checkbox" value="10">桌子
          <br>
          <input type="checkbox" value="8">衣柜
          <input type="checkbox" value="9">沙发
          <input type="checkbox" value="6">微波炉
          <input type="checkbox" value="14">中央空调
          <input type="checkbox" value="5">床
          <br>
          <input type="checkbox" value="11">床垫
          <input type="checkbox" value="13">椅子
          <input type="checkbox" value="12">智能锁
          <input type="checkbox" value="7">洗衣机
        </td>
      </tr>

      <tr>
        <td class="table_td" style="height: 80px">房屋信息 :</td>
        <td class="table_td"><textarea cols="20" id="td5" class="userinfo_input "></textarea></td>
      </tr>

      <tr>
        <td class="table_td">房屋图片上传:</td>
        <td class="table_td" style="position: relative;">
          <input type="button" value="本地照片" class="userinfo_button" id="house_img_button">
          <input type="file" name="" id="house_img_file" class="img_file">
        </td>
      </tr>

      <tr>
        <td></td>
        <td class="table_td">
          <input class="userinfo_button" id="btn" type="submit" value="保存">
        </td>
      </tr>
    </table>
  </div>
</div>
</body>
</html>

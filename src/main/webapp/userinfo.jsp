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
  <script src="/resource/js/coco-message.js"></script>
  <script src="resource/js/rent.js"></script>
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
      <img src="" alt="" name="user_img">
      <p id="userName"></p>
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
      <form action="/UpdateUserInfo" method="post" enctype="multipart/form-data">
        <table id="userinfo_table" class="userinfo_table">
          <tr>
            <td style="width: 100px;">头像</td>
            <td style="width: 160px;">
              <img src="" alt="" name="user_img" id="user_img">
            </td>
            <td>
              <div style="position: relative;">
                <input type="button" value="本地照片" class="userinfo_button" id="img_button">
                <input type="file" name="img_file" id="img_file" class="img_file">
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
            <td colspan="2"><input type="text" class="userinfo_input" id="nickname" name="nickname"></td>
          </tr>
          <tr>
            <td>手机号</td>
            <td colspan="2"><input type="text" class="userinfo_input" id="phone" name="phone"></td>
          </tr>
          <tr>
            <td>邮箱</td>
            <td colspan="2"><input type="text" class="userinfo_input" id="email" name="email"></td>
          </tr>
          <tr>
            <td>密码</td>
            <td colspan="2"><input type="button" class="userinfo_button" value="修改密码" id="change_password">
            </td>
          </tr>
          <tr style="display: none;" id="password_tr">
            <td colspan="3">
              <div class="password_div">
                <span class="password_span div_inBlock">初始密码</span>
                <input type="text" class="userinfo_input" id="initial_pwd" name="initial_pwd">
              </div>
              <div class="password_div">
                <span class="password_span div_inBlock">新密码</span>
                <input type="text" class="userinfo_input" id="new_pwd" name="new_pwd">
                <span id="sppass" class="sp"></span>
              </div>
              <div class="password_div">
                <span class="password_span div_inBlock">确认密码</span>
                <input type="text" class="userinfo_input" id="second_pwd" name="second_pwd">
                <span id="sppass2" class="sp"></span>
              </div>
            </td>
          </tr>
          <tr>
            <td></td>
            <td colspan="2"><input type="submit" class="userinfo_button" value="保存" id="userinfo_update"></td>
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
      <table class="table table-striped" id="record">
        <thead>
        <tr>
          <th scope="col">编号</th>
          <th scope="col">日期</th>
          <th scope="col">房屋</th>
          <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
      </table>
    </div>
  </div>
</div>
<!-- 房东信息界面 -->
<div class="div_body user_body" id="userhouse_body" style="display: none;">
  <!-- 房东信息菜单 -->
  <div id=" userhouse_menu " class="userinfo_left border ">
    <div id="userhouse_menu_img " class="userinfo_menu_img ">
      <img src=" " alt=" " name="user_img">
      <p id="landlordName"></p>
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
      <table id="userhouse_table " class="houseinfo_table ">
        <tr>
          <td class="table_td table_td_first">姓名</td>
          <td class="table_td table_td_first"><input type="text " class="userinfo_input " id="lName"></td>
          <td id="lId" style="display: none"></td>
        </tr>
        <tr>
          <td class="table_td">身份证</td>
          <td class="table_td"><input type="text " class="userinfo_input " id="idCard"></td>
        </tr>
        <tr>
          <td class="table_td">住址</td>
          <td class="table_td"><input type="text " class="userinfo_input " id="address"></td>
        </tr>
        <tr>
          <td class="table_td"></td>
          <td class="table_td"><input type="button" class="userinfo_button" id="landlord_update" value="保存">
          </td>
        </tr>
      </table>
    </div>
  </div>
  <div id="house_list_div" class="userinfo_right border" style="display: none">
    <div id="houselist_title " class="userinfo_title border_bottom ">
      我的房屋
    </div>
    <div>
      <table class="table table-striped" id="house_list">
        <thead>
        <tr>
          <th scope="col">编号</th>
          <th scope="col">房屋编号</th>
          <th scope="col">房屋标题</th>
          <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
      </table>
    </div>
  </div>
  <%-- 房屋信息修改界面 --%>
  <div id="house_content" class="userinfo_right border" style="display: none;">
    <div id="houseinfo_title " class="userinfo_title border_bottom ">
      房屋信息
    </div>
    <form action="/UpdateRent" method="post" enctype="multipart/form-data">
      <table class="houseinfo_table ">
        <tr>
          <td class="table_td table_td_first">房屋标题 :</td>
          <td class="table_td table_td_first">
            <input type="text" name="house_title" id="house_title" class="userinfo_input ">
          </td>
        </tr>
        <tr>
          <td class="table_td">类型 :</td>
          <td class="table_td">
            <select name="housetype" id="housetype">
            </select>
          </td>
        </tr>
        <tr>
          <td class="table_td">户型 :</td>
          <td class="table_td">
            <select id="house_type" name="house_type">
              <option value="一室">一室</option>
              <option value="两室">两室</option>
              <option value="三室">三室</option>
              <option value="四室">四室</option>
              <option value="五室">五室</option>
            </select>
          </td>
        </tr>
        <tr>
          <td class="table_td">朝向 :</td>
          <td class="table_td">
            <select name="toward" id="toward">
            </select>
          </td>
        </tr>

        <tr>
          <td class="table_td">区域 :</td>
          <td class="table_td">
            <select name="quyu" id="quyu">
            </select>
          </td>
        </tr>
        <tr>
          <td class="table_td">面积 :</td>
          <td class="table_td"><input type="number" class="userinfo_input " id="house_area" name="house_area">平米
          </td>
        </tr>

        <tr>
          <td class="table_td">租金 :</td>
          <td class="table_td"><input type="text" oninput="value=value.replace(/[^\d]/g,'')"
                                      class="userinfo_input " id="house_rent" name="rent_price">元/月
          </td>
        </tr>

        <tr>
          <td class="table_td" style="height: 80px">设施:</td>
          <td id="check">
            <label class="btn btn-primary">
              <input type="checkbox" name="facility" value="3">浴霸
            </label>
            <label class="btn btn-primary">
              <input type="checkbox" name="facility" value="4">书架
            </label>
            <label class="btn btn-primary">
              <input type="checkbox" name="facility" value="1">油烟机
            </label>
            <label class="btn btn-primary">
              <input type="checkbox" name="facility" value="2">热水器
            </label>
            <label class="btn btn-primary">
              <input type="checkbox" name="facility" value="10">桌子
            </label>
            <label class="btn btn-primary">
              <input type="checkbox" name="facility" value="8">衣柜
            </label>
            </label>
            <label class="btn btn-primary">
              <input type="checkbox" name="facility" value="9">沙发
            </label>
            </label>
            <label class="btn btn-primary">
              <input type="checkbox" name="facility" value="6">微波炉
            </label>
            <label class="btn btn-primary">
              <input type="checkbox" name="facility" value="14">中央空调
            </label>
            <label class="btn btn-primary">
              <input type="checkbox" name="facility" value="5">床
            </label>
            <label class="btn btn-primary">
              <input type="checkbox" name="facility" value="11">床垫
            </label>
            <label class="btn btn-primary">
              <input type="checkbox" name="facility" value="13">椅子
            </label>
            <label class="btn btn-primary">
              <input type="checkbox" name="facility" value="12">智能锁
            </label>
            <label class="btn btn-primary">
              <input type="checkbox" name="facility" value="7">洗衣机
            </label>
          </td>
        </tr>
        <tr>
          <td class="table_td">
            详细地址:
          </td>
          <td class="table_td">
            <input class="userinfo_input " name="house_address" id="house_address">
          </td>
        </tr>

        <tr>
          <td class="table_td" style="height: 80px">房屋信息 :</td>
          <td class="table_td"><textarea cols="20" id="house_describe" name="house_describe"
                                         class="userinfo_input "></textarea></td>
        </tr>

        <tr>
          <td class="table_td">房屋图片上传:</td>
          <td class="table_td" style="position: relative;">
            <input type="button" value="本地照片" class="userinfo_button" id="house_img_button">
            <input type="file" name="" id="house_img_file" class="img_file">
          </td>
        </tr>
        <tr>
          <td class="table_td">户型图片上传:</td>
          <td class="table_td">
            <label for="file2">
              <div id="dvimg">
                <img id="hximg">
                +
              </div>
            </label>
            <input type="file" name="huxingimg" id="file2" hidden="hidden">
          </td>
        </tr>
        <tr>
          <td></td>
          <td class="table_td">
            <input class="userinfo_button" id="btn" type="submit" value="保存">
          </td>
        </tr>
      </table>
    </form>
  </div>
</div>
</div>
</body>
</html>

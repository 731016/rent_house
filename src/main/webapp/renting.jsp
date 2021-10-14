<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>租房页面</title>
  <%--网页logo START --%>
  <link rel="icon" href="/resource/favicon.ico" type="image/x-icon"/>
  <link rel="shortcut icon" href="/resource/favicon.ico" type="image/x-icon"/>
  <%--网页logo END --%>
  <link rel="stylesheet" href="/resource/bootstrap-4.6.0-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resource/css/public.css">
  <link rel="stylesheet" href="/resource/css/renting.css">
  <script src="/resource/js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
  <script src="/resource/bootstrap-4.6.0-dist/js/bootstrap.bundle.min.js"></script>
  <script src="/resource/js/renting.js"></script>
</head>
<body>
<%--头部 START--%>
<header id="header">
  <ul>
    <li><a href="index.jsp" class="nav_header">首页</a></li>
    <li><a href="renting.jsp" class="nav_header current">租房</a></li>
    <li><a href="rent.jsp" class="nav_header">出租</a></li>
    <li class="reg_log" id="show_register"><a href="register.jsp" class="nav_header">注册</a></li>
    <li class="reg_log" style="color: #fff;">|</li>
    <li class="reg_log" id="show_login"><a href="login.jsp" class="nav_header">登录</a></li>
  </ul>
</header>
<%--头部 END--%>

<div id="page_body">
  <div class="div_bodyHeight">
    <div class="input-group mb-3" id="div_select">
      <input type="text" class="form-control" placeholder="请输入小区..." id="input_select">
      <div class="input-group-append">
        <button class="btn btn-warning" type="button" id="button-addon2">开始找房</button>
      </div>
    </div>
  </div>
  <div id="div_renting">
    <ul>
      <%--               <li>--%>
      <%--                 <strong class="strong_title">找房方式</strong>--%>
      <%--                 <div id="opt" class="div_inBlock div_border">--%>
      <%--                   <button type="button" class="btn btn-outline-secondary" id="area">区域--%>
      <%--                     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-down" viewBox="0 0 16 16">--%>
      <%--                       <path d="M3.204 5h9.592L8 10.481 3.204 5zm-.753.659 4.796 5.48a1 1 0 0 0 1.506 0l4.796-5.48c.566-.647.106-1.659-.753-1.659H3.204a1 1 0 0 0-.753 1.659z"/>--%>
      <%--                     </svg>--%>
      <%--                     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-down-fill div_none" viewBox="0 0 16 16" >--%>
      <%--                       <path d="M7.247 11.14 2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z"/>--%>
      <%--                     </svg>--%>
      <%--                   </button>--%>
      <%--                   <button type="button" class="btn btn-outline-secondary" id="subway">地铁--%>
      <%--                     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-down" viewBox="0 0 16 16">--%>
      <%--                       <path d="M3.204 5h9.592L8 10.481 3.204 5zm-.753.659 4.796 5.48a1 1 0 0 0 1.506 0l4.796-5.48c.566-.647.106-1.659-.753-1.659H3.204a1 1 0 0 0-.753 1.659z"/>--%>
      <%--                     </svg>--%>
      <%--                     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-down-fill div_none" viewBox="0 0 16 16" >--%>
      <%--                       <path d="M7.247 11.14 2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z"/>--%>
      <%--                     </svg>--%>
      <%--                   </button>--%>
      <%--                 </div>--%>

      <%--                 <div class="div_none " id="div_area">--%>
      <%--                   <strong class="strong_title">区域</strong>--%>
      <%--                   <div class="div_border div_inBlock">--%>
      <%--                     <div class="btn-group mr-2">--%>
      <%--                       <button type="button" class="btn btn-secondary">不限</button>--%>
      <%--                       <button type="button" class="btn btn-secondary">2</button>--%>
      <%--                       <button type="button" class="btn btn-secondary">3</button>--%>
      <%--                       <button type="button" class="btn btn-secondary">4</button>--%>
      <%--                     </div>--%>
      <%--                   </div>--%>
      <%--                 </div>--%>

      <%--                 <div class="div_none" id="div_subway">--%>
      <%--                   <strong class="strong_title ">地铁</strong>--%>
      <%--                   <div class="div_border div_inBlock">--%>
      <%--                     <div class="btn-group mr-2">--%>
      <%--                       <button type="button" class="btn btn-secondary">不限</button>--%>
      <%--                       <button type="button" class="btn btn-secondary">2</button>--%>
      <%--                       <button type="button" class="btn btn-secondary">3</button>--%>
      <%--                       <button type="button" class="btn btn-secondary">4</button>--%>
      <%--                     </div>--%>
      <%--                   </div>--%>
      <%--                 </div>--%>
      <%--               </li>--%>
      <li>
        <strong class="strong_title" style="vertical-align: top;">区域</strong>
        <div class="div_border div_inBlock">
          <div class="btn-group mr-2" id="area">
            <button type="button" class="btn btn-secondary" name="area">不限</button>
          </div>
        </div>
      </li>
      <li>
        <strong class="strong_title" style="vertical-align: top;">类型</strong>
        <div class="div_border div_inBlock">
          <div class="btn-group mr-2" id="housingType">
            <button type="button" class="btn btn-secondary" name="type">不限</button>

          </div>
        </div>
      </li>
      <li>
        <strong class="strong_title" style="vertical-align: top;">租金</strong>
        <div class="div_inBlock div_border">
          <div class="btn-group mr-2 div_price">
            <button type="button" class="btn btn-secondary" name="rent">不限</button>
            <button type="button" class="btn btn-secondary" name="rent">1000以下</button>
            <button type="button" class="btn btn-secondary" name="rent">1000-2000</button>
            <button type="button" class="btn btn-secondary" name="rent">2000-3000</button>
            <button type="button" class="btn btn-secondary" name="rent">3000-4000</button>
            <button type="button" class="btn btn-secondary" name="rent">4000-5000</button>
            <button type="button" class="btn btn-secondary" name="rent">5000以上</button>
          </div>
          <div>
            <div class="btn-group mr-2">
              <input type="number" class="btn btn-light input_price">
              <button type="button" class="btn btn-secondary" disabled>-</button>
              <input type="number" class="btn btn-light input_price">
              <button type="button" class="btn btn-secondary" disabled>元</button>
            </div>
            <button type="button" class="btn btn-outline-secondary" name="rent">确定</button>
          </div>
        </div>
      </li>
      <div class="div_none" id="div_unfold">
        <li>
          <strong class="strong_title" style="vertical-align: top;">户型</strong>
          <div class="div_border div_inBlock">
            <div class="btn-group mr-2">
              <button type="button" class="btn btn-secondary" name="housingType">不限</button>
              <button type="button" class="btn btn-secondary" name="housingType">一室</button>
              <button type="button" class="btn btn-secondary" name="housingType">两室</button>
              <button type="button" class="btn btn-secondary" name="housingType">三室</button>
              <button type="button" class="btn btn-secondary" name="housingType">三室</button>
              <button type="button" class="btn btn-secondary" name="housingType">四室</button>
              <button type="button" class="btn btn-secondary" name="housingType">五室及以上</button>
            </div>
          </div>
        </li>
        <li>
          <strong class="strong_title" style="vertical-align: top;">朝向</strong>
          <div class="div_border div_inBlock">
            <div class="btn-group mr-2" id="toward">
              <button type="button" class="btn btn-secondary" name="toward">不限</button>

            </div>
          </div>
        </li>
        <%--        <li>--%>
        <%--          <strong class="strong_title">签约时长</strong>--%>
        <%--          <div class="div_border div_inBlock">--%>
        <%--            <div class="btn-group mr-2" >--%>
        <%--              <button type="button" class="btn btn-secondary">不限</button>--%>
        <%--              <button type="button" class="btn btn-secondary">2</button>--%>
        <%--              <button type="button" class="btn btn-secondary">3</button>--%>
        <%--              <button type="button" class="btn btn-secondary">4</button>--%>
        <%--            </div>--%>
        <%--          </div>--%>
        <%--        </li>--%>
        <%--        <li>--%>
        <%--          <strong class="strong_title">房源状态</strong>--%>
        <%--          <div class="div_border div_inBlock">--%>
        <%--            <div class="btn-group mr-2 ">--%>
        <%--              <button type="button" class="btn btn-secondary">不限</button>--%>
        <%--              <button type="button" class="btn btn-secondary">2</button>--%>
        <%--              <button type="button" class="btn btn-secondary">3</button>--%>
        <%--              <button type="button" class="btn btn-secondary">4</button>--%>
        <%--            </div>--%>
        <%--          </div>--%>
        <%--        </li>--%>
      </div>
      <div id="button_unfold">
        <button type="button" class="btn btn-outline-secondary" id="unfold">展开选项
          <svg id="" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
               class="bi bi-arrow-bar-down" viewBox="0 0 16 16">
            <path fill-rule="evenodd"
                  d="M1 3.5a.5.5 0 0 1 .5-.5h13a.5.5 0 0 1 0 1h-13a.5.5 0 0 1-.5-.5zM8 6a.5.5 0 0 1 .5.5v5.793l2.146-2.147a.5.5 0 0 1 .708.708l-3 3a.5.5 0 0 1-.708 0l-3-3a.5.5 0 0 1 .708-.708L7.5 12.293V6.5A.5.5 0 0 1 8 6z"/>
          </svg>
        </button>
      </div>
      <div id="button_packUp" class="div_none">
        <button type="button" class="btn btn-outline-secondary" id="packUp">收起选项
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
               class="bi bi-arrow-bar-up" viewBox="0 0 16 16">
            <path fill-rule="evenodd"
                  d="M8 10a.5.5 0 0 0 .5-.5V3.707l2.146 2.147a.5.5 0 0 0 .708-.708l-3-3a.5.5 0 0 0-.708 0l-3 3a.5.5 0 1 0 .708.708L7.5 3.707V9.5a.5.5 0 0 0 .5.5zm-7 2.5a.5.5 0 0 1 .5-.5h13a.5.5 0 0 1 0 1h-13a.5.5 0 0 1-.5-.5z"/>
          </svg>
        </button>
      </div>

    </ul>
  </div>
  <div>
    <div id="div_sort">
      <div class="btn-group mr-2 ">
        <button type="button" class="btn btn-light sort_current" id="sort_default">默认</button>
        <button type="button" class="btn btn-light" id="sort_price">价格
          <svg id="a" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-up-square div_none" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M15 2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2zM0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm8.5 9.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V11.5z"/>
          </svg>
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-square div_none" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M15 2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2zM0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm8.5 2.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V4.5z"/>
          </svg>
        </button>
        <button type="button" class="btn btn-light" id="sort_area">面积
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-up-square div_none" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M15 2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2zM0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm8.5 9.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V11.5z"/>
          </svg>
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-down-square div_none" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M15 2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2zM0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm8.5 2.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V4.5z"/>
          </svg>
        </button>
      </div>
    </div>
    <div id="div_house" class="div_inBlock div_house">
      <div id="house_id" class="div_inBlock house_id">
        <div id="div_img" class="div_img">
          <a href="#"><img src="" alt="" id="house_img"></a>
        </div>
        <div id="house_info" class="house_info">
          <span class="badge badge-pill badge-success incon">即住</span>
          <h5><a href="#">标题</a></h5>
          <div>面积丨楼层</div>
          <div class="location">地址</div>
          <div class="trait">
            <span class="badge badge-pill badge-info">特点标签</span>
            <span class="badge badge-pill badge-info">特点标签</span>
            <span class="badge badge-pill badge-info">特点标签</span>
          </div>
          <div>￥0000/月</div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
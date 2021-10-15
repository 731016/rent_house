<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>房屋详情</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <link rel="stylesheet" type="text/css" href="/resource/css/housedetails.css"/>
  <script src="/resource/js/jquery-3.6.0.min.js"></script>
  <script src="/resource/js/coco-message.js"></script>
  <script src="/resource/js/housedetails.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div id="top">
  <div id="top2">
    <span id="titlename">Lie flat租房</span>
    <div id="topright">
      <a href="index.jsp" id="home">首页</a>
      <a href="renting.jsp">租房</a>
      <a href="login.jsp" id="login">登录</a>&nbsp;|&nbsp;
      <a href="register.jsp" id="register">注册</a>
    </div>
  </div>
</div>
<div id="body">
  <!-- 身体部分左侧 -->
  <div id="bodyleft">
    <!-- 图片 -->
    <div id="img">
      <div id="imgbig">
        <img src="img/mm01.jpeg" id="big">
      </div>
      <div id="imgsmall">
        <img src="img/mm01.jpeg" class="small">
        <img src="img/loginbg.jpg" class="small">
      </div>
    </div>
    <div id="jianjie">
      <h2>房源简介</h2>
      <span style="color: grey;">
						房源位置 这套位于纽宾凯公园里的房源属于抢手房源。小区一共有7个楼栋。小区有24小时安保。小区有车位可出租。小区有1个门。有多项设施供住户使用，如健身广场，饮水站，快递柜。楼栋概况 小区是2020年建的，楼栋外立面较新。出入单元需通过门禁。楼栋总高46层。小区注重卫生管理，会定期安排人员维护楼栋的卫生。房源概况 这间4居室的05卧面积较大，两人住也不会太拥挤。房源在第17层，卧室朝向为南。有1个独立阳台，方便晾晒衣物和储物。厨房有1个阳台，瓶瓶罐罐可存放于此。装修亮点 卧室装修为原木色系，让人在木色与白色的交织中，感受自然纯粹。房间优选环保无醛板材，为您居住安全保驾护航。
					</span>
      <div id="tubiao">
        <div>
          <img src="img/loginbg.jpg" class="tubiaoimg">
          <br>
          椅子
        </div>
        <div>
          <img src="img/loginbg.jpg" class="tubiaoimg">
          <br>
          椅子
        </div>
      </div>
      <h2>租约信息</h2>
      <div class="dv3">
        <span class="sp2">可入住日期</span>
        <span style="margin-left: 30px;">随时入住</span>
      </div>
      <div class="dv3">
        <span class="sp2">签约时长</span>
        <span style="margin-left: 47px;">可长租1年</span>
      </div>
      <!-- <div id="dv3">
        <span class="sp2">注意事项</span>&ensp;&ensp;
        <span>随时入住</span>
      </div> -->
    </div>
  </div>
  <!-- 身体部分右侧 -->
  <div id="bodyright">
    <h2>标题</h2>
    <span id="price">￥价格</span>
    <table style="border-top: 1px solid gainsboro;" cellspacing="0px">
      <tr style="text-align: center;">
        <td class="td1">
          使用面积
        </td>
        <td class="td2">
          朝向
        </td>
        <td id="houseType">
          户型
        </td>
      </tr>
    </table>
    <div class="dv1">
      <span class="sp1">位置</span>&ensp;
      <span>小区距4号线十里铺站步行约86米</span>
    </div>
    <div class="dv1">
      <span class="sp1">楼层</span>&ensp;
      <span>

					</span>
    </div>
    <div colspan="3" class="dv1">
      <span class="sp1">电梯</span>&ensp;
      <span>
						<!--  -->
					</span>
    </div>
    <div class="dv1">
      <span class="sp1">年代</span>&ensp;
      <span>
						<!--  -->
					</span>
    </div>
    <div class="dv1">
      <span class="sp1">门锁</span>&ensp;
      <span>
						<!--  -->
					</span>
    </div>
    <div class="dv1">
      <span class="sp1">绿化</span>&ensp;
      <span>
						<!--  -->
					</span>
    </div>
    <div class="dv1"></div>
    <div id="fangdong">
      <div id="fangdong2">
        <h2 id="xinxi">
        房东信息
        </h2>
        <div id="fangdongtitle">
          <div id="touxiang">
            <img src="img/mm01.jpeg" id="touxiangimg">
          </div>
          <div id="fangdongname">
            <span id="name">房东姓名</span><br>
            <span id="phone">房东手机号</span>
          </div>
          <div>
            <input type="submit" id="zixun" value="咨询房源" />
          </div>
          <div>
            <input type="submit" id="yuyue" value="预约看房" />
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>

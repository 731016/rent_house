<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <title>Lie flat</title>
    <%--网页logo START --%>
    <link rel="icon" href="/resource/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="/resource/favicon.ico" type="image/x-icon"/>
    <%--网页logo END --%>
    <%--关键字 Keywords是页面关键词，是搜索引擎关注点之一。Keywords应该限制在6～8个关键词左右 START--%>
    <meta name ="Keywords"content="Lie flat,租房,出租,出租房交易平台,房屋出租信息"/>
    <%--关键字  END--%>
    <%--网站说明 字符数含空格在内不要超过 120 个汉字 START --%>
    <meta name ="description" content="Lie flat租房信息网提供房屋合租信息及月租价格,房屋整租信息及价格"/>
    <%--网站说明 END --%>
    <link rel="stylesheet" href="/resource/css/index.css">
    <link rel="stylesheet" href="/resource/css/public.css">
    <script src="/resource/js/jquery-3.6.0.min.js"></script>
    <%--消息提示插件--%>
    <script src="/resource/js/coco-message.js"></script>
    <script src="/resource/js/index.js"></script>
</head>

<body>
<%--头部 START--%>
    <header>
        <ul>
            <li><a href="#" class="nav_header current">首页</a></li>
            <li><a href="renting.jsp" class="nav_header">租房</a></li>
            <li><a href="rent.jsp" class="nav_header">出租</a></li>
            <li class="reg_log">
                <a href="fdregister.jsp" class="nav_header landlord">成为房东</a>
            </li>
            <li class="reg_log" id="show_register">
                <a href="register.jsp" class="nav_header">注册</a>
            </li>
            <li class="reg_log nav_header vertical_line" style="color: #fff;">|</li>
            <li class="reg_log" id="show_login">
                <a href="login.jsp" class="nav_header">登录</a>
            </li>
        </ul>
    </header>
<%--头部 END--%>

<%--主体 START--%>
<section>
    <img src="/resource/images/index_bg.jpg" class="main_img" alt="">
    <div class="search">
        <div class="search_title">
            <h1>品质租房选 Lie flat</h1>
            <p>10年，10城，近50万业主、400万 Lie flat Guest 的选择</p>
        </div>
        <div class="search_nav">
            <ul>
                <li class="current" id="search_all" data-placeholder="请输入小区..." data-val="0">全部</li>
                <li id="search_entireRent" data-placeholder="请输入区域开始找合租房" data-val="1">合租</li>
                <li id="search_share" data-placeholder="请输入区域开始找整租房" data-val="2">整租</li>
            </ul>
        </div>
        <br>
        <span class="triangle"></span>
        <div class="search_main">
            <input type="text" class="search_input" id="search_input" placeholder="请输入小区..." data-val=""/>
            <a href="javascript:;" class="search_btn" id="search_btn" alt="开始找房">开始找房</a>
        </div>
    </div>
    <div class="container">
        <dl>
            <%--js 跳转 START--%>
            <dd class="con_father_yz">
                <img src="/resource/images/index_yz.jpg" alt="">
                <div class="con_yz">
                    <h2>租房</h2>
                    <span>合租/整租</span>
                </div>
            </dd>
            <dd class="con_father_zf">
                <img src="/resource/images/index_zf.jpg" alt="">
                <div class="con_zf">
                    <h2>业主</h2>
                    <span>房屋出租</span>
                </div>
            </dd>
                <%--js 跳转 END--%>
        </dl>
    </div>
</section>
<%--主体 END--%>
</body>

</html>
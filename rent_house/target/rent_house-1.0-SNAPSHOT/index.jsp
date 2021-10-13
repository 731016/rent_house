<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Lie flat</title>
    <%--网页logo START --%>
    <link rel="icon" href="resource/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="resource/favicon.ico" type="image/x-icon"/>
    <%--网页logo END --%>
    <link rel="stylesheet" href="/resource/css/index.css">
    <link rel="stylesheet" href="/resource/css/public.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/resource/js/index.js"></script>
</head>

<body>
<header>
    <ul>
        <li><a href="#" class="nav current">首页</a></li>
        <li><a href="javascript:;" class="nav">租房</a></li>
        <li><a href="javascript:;" class="nav">出租</a></li>
        <li class="reg_log"><a href="register.jsp" class="nav">注册</a></li>
        <li class="reg_log" style="display: none"><a href="javascript:;" class="nav">admin</a></li>
        <li class="reg_log" style="color: #fff;">|</li>
        <li class="reg_log"><a href="login.jsp" class="nav">登录</a></li>
        <li class="reg_log" style="display: none"><a href="javascript:;" class="nav">退出</a></li>
    </ul>
</header>
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
        <div class="search_main">
            <input type="text" class="search_input" id="search_input" placeholder="请输入小区..." data-val=""/>
            <a href="javascript:;" class="search_btn" id="search_btn" alt="开始找房">开始找房</a>
        </div>
    </div>
    <div class="container">
        <dl>
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
        </dl>
    </div>
</section>
</body>

</html>
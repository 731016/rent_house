<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>房东提交房源页面</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link rel="stylesheet" href="/resource/css/public.css">
    <link rel="stylesheet" href="/resource/bootstrap-4.6.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resource/css/rent.css"/>

    <script src="/resource/js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="/resource/js/coco-message.js"></script>
    <script src="/resource/js/public_login.js"></script>
</head>
<body id="b1">
<header id="header">
    <ul>
        <li><a href="index.jsp" class="nav_header">首页</a></li>
        <li><a href="renting.jsp" class="nav_header current">租房</a></li>
        <li><a href="rent.jsp" class="nav_header">出租</a></li>
        <li class="reg_log" id="show_register">
            <a href="register.jsp" class="nav_header">注册</a>
        </li>
        <li class="reg_log nav_header vertical_line" style="color: #fff;">|</li>
        <li class="reg_log" id="show_login">
            <a href="login.jsp" class="nav_header">登录</a>
        </li>
    </ul>
</header>
<div id="big">
    <div id="d1">
        <table id="t2">
            <tr>
                <td colspan="2" id="td1"><h1>房东房屋出租</h1></td>
            </tr>

                <tr>
                    <td class="m">房屋标题 :</td>
                    <td><input type="text" id="td3" ></td>
                </tr>

                <tr>
                    <td class="m">户型 :</td>
                    <td colspan="3" >
                        <select >
                            <option value="一室"disabled selected hidden>一室</option>
                            <option value="一室" >一室</option>
                            <option value="二室" >二室</option>
                            <option value="三室" >三室</option>
                            <option value="四室" >四室</option>
                            <option value="五室" >五室</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td class="m">类型 :</td>
                    <td></td>
                </tr>

                <tr>
                    <td class="m">朝向 :</td>
                    <td></td>
                </tr>

                <tr>
                    <td class="m">区域 :</td>
                    <td></td>
                </tr>

                <tr>
                    <td class="m">面积 :</td>
                    <td><input type="text" class="td4" oninput = "value=value.replace(/[^\d]/g,'')">平米</td>
                </tr>

                <tr>
                    <td class="m">租金 :</td>
                    <td><input type="text" class="td4" oninput = "value=value.replace(/[^\d]/g,'')">元/月</td>
                </tr>

                <tr>
                    <td class="m" style="height: 89px">设施:</td>
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
                    <td class="m" style="height: 89px">房屋介绍 :</td>
                    <td><textarea  cols="20" id="td5"></textarea></td>
                </tr>

                <tr>
                    <td class="m">房屋图片上传:</td>
                    <td>
                        <input multiple="multiple" type="file" id="file">
                    </td>
                </tr>
                <tr>
                    <td class="m">户型图片上传:</td>
                    <td>
                        <input multiple="multiple" type="file" id="file2">
                    </td>
                </tr>

                <tr>
                    <td colspan="2" class="tr1">
                        <input class="btn btn-primary" id="btn" type="submit" value="提交" >
                    </td>
                </tr>
            </table>
        </div>
    </div>
    </body>
</html>

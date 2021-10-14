<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/13
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="/resource/css/cssfangdong.css"/>
</head>
<body id="b1">
<header id="header">
    <ul>
        <li><a href="index.jsp" class="nav_header">首页</a></li>
        <li><a href="#" class="nav_header current">租房</a></li>
        <li><a href="javascript:;" class="nav_header">出租</a></li>
        <li class="reg_log"><a href="register.jsp" class="nav_header">注册</a></li>
        <%--         TODO: 默认display 检查session，cookie是否存储用户信息 --%>
        <li class="reg_log" style="display: none"><a href="javascript:;" class="nav_header">admin</a></li>
        <li class="reg_log" style="color: #fff;">|</li>
        <li class="reg_log"><a href="login.jsp" class="nav_header">登录</a></li>
        <%--         TODO: 默认display 检查session，cookie是否存储用户信息 --%>
        <li class="reg_log" style="display: none"><a href="javascript:;" class="nav_header">退出</a></li>
    </ul>
</header>

<div id="top">
    <div id="top2">
        <span id="titlename">Lie flat租房</span>
        <div id="topright">
            <a href="index.jsp" id="home">首页</a>
            <a href="#">租房</a>
            <a href="login.jsp" id="login">登录</a>&nbsp;|&nbsp;
            <a href="#">注册</a>
        </div>
    </div>
</div>

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
                            <option value="0"disabled selected hidden>1</option>
                            <option value="1" >1</option>
                            <option value="2" >2</option>
                            <option value="3" >3</option>
                            <option value="4" >4</option>
                            <option value="5" >5</option>
                        </select>室
                        <select >
                            <option value="0"disabled selected hidden>1</option>
                            <option value="1" >1</option>
                            <option value="2" >2</option>
                            <option value="3" >3</option>
                            <option value="4" >4</option>
                            <option value="5" >5</option>
                        </select>厅
                        <select >
                            <option value="0"disabled selected hidden>1</option>
                            <option value="1" >1</option>
                            <option value="2" >2</option>
                            <option value="3" >3</option>
                            <option value="4" >4</option>
                            <option value="5" >5</option>
                        </select>卫
                    </td>
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
                    <td class="m" style="height: 80px">设施:</td>
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
                    <td class="m" style="height: 80px">房屋信息 :</td>
                    <td><textarea  cols="20" id="td5"></textarea></td>
                </tr>

                <tr>
                    <td class="m">房屋图片上传:</td>
                    <td><input type="file" id="file"></td>
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

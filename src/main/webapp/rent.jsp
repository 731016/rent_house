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
<body background="/resource/images/R-C.jpg" style="color: white;">

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
        <td class="m">小区名称 :</td>
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
        <td class="m" >设施</td>
        <td>
            <input type="checkbox" value="1">油烟机
            <input type="checkbox" value="2">微波炉
            <input type="checkbox" value="3">热水器
            <input type="checkbox" value="4">洗衣机
            <input type="checkbox" value="5">浴霸
            <input type="checkbox" value="6">床
            <input type="checkbox" value="7">书架
            <br>
            <input type="checkbox" value="8">衣柜
            <input type="checkbox" value="9">沙发
            <input type="checkbox" value="10">智能锁
            <input type="checkbox" value="11">床垫
            <input type="checkbox" value="12">桌子
            <input type="checkbox" value="13">椅子
            <input type="checkbox" value="14">中央空调
        </td>
    </tr>

    <tr>
        <td class="m">房屋介绍 :</td>
        <td><textarea rows="5" cols="60" id="td5"></textarea></td>
    </tr>

    <tr>
        <td class="m">房屋图片</td>
        <td><input type="file"></td>
    </tr>

    <tr style="text-align: center;">
        <td colspan="2"><input id="td6" type="button" value="提交" ></td>
    </tr>


</table>

</body>
</html>

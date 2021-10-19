package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.Landlord;
import com.zr.pojo.UserInfo;
import com.zr.service.LandlordService;
import com.zr.service.UserInfoService;
import com.zr.service.impl.LandlordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//获取最新的该用户信息
@WebServlet(name = "UserInfoSvl", urlPatterns = "/userinfo")
public class UserInfoSvl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取用户信息，传递到前台
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        UserInfoService user = UserInfoService.getInstance();
        UserInfo userInfoByAccount = user.getUserInfoByAccount(userInfo.getAccount());
        String s = JSON.toJSONString(userInfoByAccount);
        response.getWriter().print(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index.jsp");
    }
}

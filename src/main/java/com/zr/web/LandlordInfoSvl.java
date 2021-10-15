package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.Landlord;
import com.zr.pojo.UserInfo;
import com.zr.service.LandlordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LandlordInfoSvl", urlPatterns = "/landlordInfo")
public class LandlordInfoSvl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //根据账号获取房东信息，传递到前台
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        String account = userInfo.getAccount();
        LandlordService instance = LandlordService.getInstance();
        Landlord landlord = instance.getLandlordByAccount(account);
        String s1 = JSON.toJSONString(landlord);
        response.getWriter().print(s1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index.jsp");
    }
}

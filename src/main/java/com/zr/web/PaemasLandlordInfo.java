package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.Landlord;
import com.zr.pojo.ReturnResult;
import com.zr.pojo.UserInfo;
import com.zr.service.LandlordService;
import com.zr.service.UserInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PaemasLandlordInfo", urlPatterns = "/getLandlordInfo")
public class PaemasLandlordInfo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String lid = request.getParameter("lid");
        // 房东的姓名和手机号
        LandlordService landlordService = LandlordService.getInstance();
        Landlord landlord = landlordService.getLandlordById(Integer.valueOf(lid));

        // 房东对应的账号头像
        UserInfoService userInfoService = UserInfoService.getInstance();
        UserInfo userInfo = userInfoService.getUserInfoByAccount(landlord.getAccount());
        String img = userInfo.getImg();

        ReturnResult returnResult = new ReturnResult();
        returnResult.setObject(landlord);
        returnResult.setMsg(img);
        response.getWriter().print(JSON.toJSONString(returnResult));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

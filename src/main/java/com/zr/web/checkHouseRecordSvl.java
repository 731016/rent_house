package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.CheckHouseRecord;
import com.zr.pojo.Landlord;
import com.zr.pojo.ShowRecord;
import com.zr.pojo.UserInfo;
import com.zr.service.CheckHouseRecordService;
import com.zr.service.LandlordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "checkHouseRecordSvl" ,urlPatterns = "/checkHouseRecord")
public class checkHouseRecordSvl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //根据账号获取看房记录，传递到前台
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        String account = userInfo.getAccount();
        CheckHouseRecordService instance = CheckHouseRecordService.getInstance();
        List<ShowRecord> recordByAccount = instance.getRecordByAccount(account);
        String s = JSON.toJSONString(recordByAccount);
        response.getWriter().print(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index.jsp");
    }
}

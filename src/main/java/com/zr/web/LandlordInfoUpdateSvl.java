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
//修改了房东信息
@WebServlet(name = "LandlordInfoUpdateSvl", urlPatterns = "/LandlordInfoUpdate")
public class LandlordInfoUpdateSvl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String strJson = request.getParameter("json");
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        //根据前台传来的数据，转换为相应的对象
        Landlord landlord = JSON.parseObject(strJson, Landlord.class);

        String account = userInfo.getAccount();
        UserInfoService instance1 = UserInfoService.getInstance();
        //更新房东的名字
        int updateUserNameFlag = instance1.updateUserName(landlord.getLName(), account);
        LandlordService instance = LandlordService.getInstance();
        int updateFlag = instance.updateLandlord(landlord);
        if (updateFlag > 0 && updateUserNameFlag > 0) {
            ReturnResult result = new ReturnResult();
            result.setState(204);
            response.getWriter().print(JSON.toJSONString(result));
            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index.jsp");
    }
}

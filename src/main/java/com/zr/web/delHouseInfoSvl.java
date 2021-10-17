package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.ReturnResult;
import com.zr.service.CheckHouseRecordService;
import com.zr.service.HousingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delHouseInfoSvl" ,urlPatterns = "/delHouseInfo")
public class delHouseInfoSvl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int hid = Integer.parseInt(request.getParameter("hid"));
        HousingService instance = HousingService.getInstance();
        int delFlag = instance.deleteHouseById(hid);
        if (delFlag>0){
            ReturnResult result = new ReturnResult();
            result.setState(203);
            response.getWriter().print(JSON.toJSONString(result));
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

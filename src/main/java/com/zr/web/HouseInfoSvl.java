package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.Housing;
import com.zr.pojo.UserInfo;
import com.zr.service.HousingService;
import com.zr.service.UserInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HouseInfoSvl", urlPatterns = "/houseInfo")
public class HouseInfoSvl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取房屋id，查询房屋信息
        int hId = Integer.parseInt(request.getParameter("hid"));
        HousingService instance = HousingService.getInstance();
        Housing houseById = instance.getHouseById(hId);
        String s = JSON.toJSONString(houseById);
        response.getWriter().print(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

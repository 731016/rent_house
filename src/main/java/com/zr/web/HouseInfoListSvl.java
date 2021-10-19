package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.Housing;
import com.zr.service.HousingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//用户获取到自己发布的租房信息
@WebServlet(name = "HouseInfoListSvl" ,urlPatterns = "/HouseInfoList")
public class HouseInfoListSvl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取房东id，根据房东id查询房屋信息列表
        int lId = Integer.parseInt(request.getParameter("lId"));
        HousingService instance = HousingService.getInstance();
        List<Housing> housesBylId = instance.getHousesBylId(lId);
        String s = JSON.toJSONString(housesBylId);
        response.getWriter().print(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index.jsp");
    }
}

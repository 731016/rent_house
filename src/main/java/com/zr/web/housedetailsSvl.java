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

@WebServlet(name = "housedetailsSvl",urlPatterns = "/housedetails")
public class housedetailsSvl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Object house = request.getSession().getAttribute("house");
        response.getWriter().print(JSON.toJSONString(house));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HousingService housingService = HousingService.getInstance();
        Housing house = housingService.getHouseById(Integer.valueOf(id));
        request.getSession().setAttribute("house",house);
        response.sendRedirect("/housedetails.jsp");
    }
}

package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.Landlord;
import com.zr.service.LandlordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PaemasLandlordInfo", urlPatterns = "/getLandlordInfo")
public class PaemasLandlordInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String lid = request.getParameter("lid");
        System.out.println(lid);
        LandlordService landlordService = LandlordService.getInstance();
        Landlord landlord = landlordService.getLandlordById(Integer.valueOf(lid));
        response.getWriter().print(JSON.toJSONString(landlord));
        System.out.println(JSON.toJSONString(landlord));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

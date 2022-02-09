package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.Area;
import com.zr.service.AreaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//获取所有区域
@WebServlet(name = "Renting_Area",urlPatterns = "/area")
public class Renting_Area extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=UTF-8");
      AreaService area = AreaService.getInstance();
      List<Area> allArea = area.getAllArea();
      String s = JSON.toJSONString(allArea);
      response.getWriter().print(s);
   }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }
}

package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.HousingType;
import com.zr.service.HousingTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Renting_Type",urlPatterns = "/type")
public class Renting_Type extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=UTF-8");
      HousingTypeService type = HousingTypeService.getInstance();
      List<HousingType> allHousingTypes = type.getAllHousingTypes();
      String s = JSON.toJSONString(allHousingTypes);
      response.getWriter().print(s);
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.encodeRedirectURL("index.jsp");
   }
}

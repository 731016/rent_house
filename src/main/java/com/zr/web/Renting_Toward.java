package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.Toward;
import com.zr.service.TowardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Renting_Toward",urlPatterns = "/toward")
public class Renting_Toward extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=UTF-8");
      TowardService toward = TowardService.getInstance();
      List<Toward> allToward = toward.getAllToward();
      String s = JSON.toJSONString(allToward);
      response.getWriter().print(s);
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.encodeRedirectURL("index.jsp");
   }
}

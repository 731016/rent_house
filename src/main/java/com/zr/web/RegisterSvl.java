package com.zr.web;

import com.zr.pojo.UserInfo;
import com.zr.service.UserInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterSvl",urlPatterns = "/register")
public class RegisterSvl extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String account = request.getParameter("account");
      String password = request.getParameter("password");
      String name = request.getParameter("name");
      String nickname = request.getParameter("nickname");
      String email = request.getParameter("email");
      String phone = request.getParameter("phone");
      UserInfo userInfo = new UserInfo(account,password,name,nickname,email,phone,"default.jpg",null);
      UserInfoService.getInstance().addUserInfo(userInfo);
      response.sendRedirect("index.jsp");
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }
}

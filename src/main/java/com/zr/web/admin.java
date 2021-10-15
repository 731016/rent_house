package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.ReturnResult;
import com.zr.pojo.UserInfo;
import com.zr.service.UserInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "admin",urlPatterns = "/adminlogin")
public class admin extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=UTF-8");
      String account = request.getParameter("account");
      String password = request.getParameter("password");
      UserInfoService user = UserInfoService.getInstance();
      boolean login = user.login(account, password);
      ReturnResult result = new ReturnResult();
      if (login){
         UserInfo userInfoByAccount = user.getUserInfoByAccount(account);
         if (userInfoByAccount.getState().equals(2)){
            result.setFlag(true);
            request.getSession().setAttribute("root",userInfoByAccount);
         }else {
            result.setFlag(false);
         }
      }else {
         result.setFlag(false);
      }
      String s = JSON.toJSONString(result);
      response.getWriter().print(s);

   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }
}

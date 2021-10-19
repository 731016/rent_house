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
//管理员登录
@WebServlet(name = "admin",urlPatterns = "/adminlogin")
public class admin extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //设置编码
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=UTF-8");
      //获取前台数据
      String account = request.getParameter("account");
      String password = request.getParameter("password");
      //登录
      UserInfoService user = UserInfoService.getInstance();
      boolean login = user.login(account, password);
      //设置返回的结果
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

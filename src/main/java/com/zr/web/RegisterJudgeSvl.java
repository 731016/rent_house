package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.ReturnResult;
import com.zr.service.UserInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//判断账号是否存在
@WebServlet(name = "RegisterJudgeSvl",urlPatterns = "/registerJudge")
public class RegisterJudgeSvl extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //用户注册判断账号是否存在
      String account = request.getParameter("account");
      UserInfoService user = UserInfoService.getInstance();
      boolean b = user.UserNotExistsByAccount(account);
      ReturnResult result = new ReturnResult();
      result.setFlag(b);
      String s = JSON.toJSONString(result);
      response.getWriter().print(s);
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }
}

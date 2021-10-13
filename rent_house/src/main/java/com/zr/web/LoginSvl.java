package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.ReturnResult;
import com.zr.pojo.UserInfo;
import com.zr.service.UserInfoService;
import com.zr.utils.JDBCUtils;
import com.zr.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet(name = "LoginSvl",urlPatterns = "/login")
public class LoginSvl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        UserInfoService user = UserInfoService.getInstance();
        boolean login = user.login(account, password);
        HttpSession session = request.getSession();
        ReturnResult result = new ReturnResult(null,null,login);
        String s = JSON.toJSONString(result);
//        String s = "{\"log\":"+login+"}";
        response.getWriter().print(s);
        if (login){
            UserInfo userInfo = user.getUserInfoByAccount(account);
            session.setAttribute("user",userInfo);
            response.getWriter().print("<script>history.go(-2)</script>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login.jsp");
    }
}

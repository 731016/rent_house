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
//发起注册
@WebServlet(name = "RegisterSvl", urlPatterns = "/register")
public class RegisterSvl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("UserInfo") != null) {
            System.out.println(111);
            ReturnResult result = new ReturnResult();
            result.setState(202);
            response.getWriter().print(JSON.toJSONString(result));
            return;
        }
//获取参数
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        UserInfo userInfo = new UserInfo(account, password, name, nickname, email, phone, "", 1);
        int addFlag = UserInfoService.getInstance().addUserInfo(userInfo);
        ReturnResult result = new ReturnResult();
        //返回注册结果
        if (addFlag > 0) {
            result.setState(201);
            result.setFlag(true);
            String s = JSON.toJSONString(result);
            response.getWriter().print(s);
//            response.sendRedirect("login.jsp");
        } else {
            result.setFlag(false);
            String s = JSON.toJSONString(result);
            response.getWriter().print(s);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

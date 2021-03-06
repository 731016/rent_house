package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.ReturnResult;
import com.zr.pojo.UserInfo;
import com.zr.service.UserInfoService;
import com.zr.utils.JDBCUtils;
import com.zr.utils.Utils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//登录请求，同时也是首页判断是否登录过的
@WebServlet(name = "LoginSvl", urlPatterns = "/login")
public class LoginSvl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        //判断账号或密码是否为空
        if (account == null || StringUtils.isBlank(account) || password == null || StringUtils.isBlank(password)) {
            ReturnResult result = new ReturnResult();
            result.setFlag(false);
            if (request.getSession().getAttribute("UserInfo") != null) {
                result.setObject(request.getSession().getAttribute("UserInfo"));
                result.setState(202);
//                result.setState(200);
            } else if (request.getSession() .getAttribute("regFlag") != null) {
                result.setState(201);
            } else {
                result.setState(404);
            }

            String s = JSON.toJSONString(result);
            response.getWriter().print(s);
            return;
        }

        //查询是否存在此用户
        UserInfoService user = UserInfoService.getInstance();
        boolean login = user.login(account, password);
        HttpSession session = request.getSession();
        ReturnResult result;

        //查询是否为管理员权限
        if (user.getUserInfoByAccount(account) == null) {
            result = new ReturnResult(null, null, false);
        } else if (user.getUserInfoByAccount(account).getState().equals(2)) {
            result = new ReturnResult("root", null, false);
        } else if (user.getUserInfoByAccount(account).getState().equals(0)) {
            result = new ReturnResult("disable", null, false);
        } else {
            result = new ReturnResult(null, null, login);
        }


        if (result.getFlag()) {
            UserInfo userInfo = user.getUserInfoByAccount(account);
            session.setAttribute("UserInfo", userInfo);
            result.setObject(userInfo);
            result.setState(200);
        } else if (request.getSession().getAttribute("regFlag") != null) {
            result.setState(201);
        } else {
            result.setState(404);
        }
        String s = JSON.toJSONString(result);
//        String s = "{\"log\":"+login+"}";
        response.getWriter().print(s);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login.jsp");
    }
}

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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserListServlet",urlPatterns = "/userlist")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Object o = request.getSession().getAttribute("root");
        ReturnResult result = new ReturnResult();
        if(o==null){
            result.setState(404);
            result.setFlag(false);
            writer.print(JSON.toJSONString(result));
            return;
        }
        UserInfoService service = UserInfoService.getInstance();
        List<UserInfo> list = service.getAllUserInfo();
        list.remove(service.getUserInfoByAccount("root"));
        result.setObject(list);
        writer.print(JSON.toJSONString(result));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

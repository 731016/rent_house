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
//管理员更新用户状态(启用<----->禁用)
@WebServlet(name = "UpdateUserServlet",urlPatterns = "/updateuser")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        ReturnResult result = new ReturnResult();
        result.setFlag(false);
        //防止过期
        if(request.getSession().getAttribute("root")==null){
            result.setState(1);
            writer.print(JSON.toJSONString(result));
            return;
        }
        //防止无参
        String account = request.getParameter("account");
        if(account==null){
            result.setState(2);
            writer.print(JSON.toJSONString(result));
            return;
        }
        //防止没有修改的记录
        UserInfoService service = UserInfoService.getInstance();
        UserInfo userInfo = service.getUserInfoByAccount(account);
        if(userInfo==null){
            result.setState(3);
            writer.print(JSON.toJSONString(result));
            return;
        }
        //处理结果
        result.setFlag(true);
        userInfo.setState(userInfo.getState()==1?0:1);
        int i = service.updateUserInfo(userInfo);
        if(i==1){
            result.setState(0);
        }else{
            result.setState(1);
        }
        writer.print(JSON.toJSONString(result));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

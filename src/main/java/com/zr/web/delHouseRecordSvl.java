package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.ReturnResult;
import com.zr.service.CheckHouseRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delHouseRecordSvl",urlPatterns = "/delHouseRecord")
public class delHouseRecordSvl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int cid = Integer.parseInt(request.getParameter("cid"));
        CheckHouseRecordService instance = CheckHouseRecordService.getInstance();
        int delFlag = instance.deleteRecord(cid);
        if (delFlag>0){
            ReturnResult result = new ReturnResult();
            result.setState(203);
            response.getWriter().print(JSON.toJSONString(result));
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index.jsp");
    }
}

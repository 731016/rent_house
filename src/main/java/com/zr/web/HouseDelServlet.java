package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.ReturnResult;
import com.zr.service.HousingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HouseDelServlet",urlPatterns = "/housedel")
public class HouseDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        ReturnResult result = new ReturnResult();
        result.setFlag(false);
        PrintWriter writer = response.getWriter();
        if (request.getSession().getAttribute("root") == null) {
            result.setMsg("会话过期");
            result.setState(1);
            writer.print(JSON.toJSONString(result));
            return;
        }
        String hidStr = request.getParameter("hid");
        if(hidStr==null){
            result.setState(2);
            result.setMsg("缺少参数");
            writer.print(JSON.toJSONString(result));
        }
        result.setFlag(true);
        Integer hid = Integer.valueOf(hidStr);
        HousingService service = HousingService.getInstance();
        int i = service.deleteHouseById(hid);
        if(i < 1){
            result.setMsg("删除失败");
            result.setState(3);
        }else{
            result.setState(0);
        }
        writer.print(JSON.toJSONString(result));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

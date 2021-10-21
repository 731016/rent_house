package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.Housing;
import com.zr.pojo.ReturnResult;
import com.zr.service.HousingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//管理员删除房屋信息
@WebServlet(name = "HouseDelServlet",urlPatterns = "/housedel")
public class HouseDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        //设置返回结果，默认返回状态为失败
        ReturnResult result = new ReturnResult();
        result.setFlag(false);
        PrintWriter writer = response.getWriter();
        //会话过期
        if (request.getSession().getAttribute("root") == null) {
            result.setMsg("会话过期");
            result.setState(1);
            writer.print(JSON.toJSONString(result));
            return;
        }
        //缺少参数
        String hidStr = request.getParameter("hid");
        if(hidStr==null){
            result.setState(2);
            result.setMsg("缺少参数");
            writer.print(JSON.toJSONString(result));
        }
        //会话有效，参数有效
        result.setFlag(true);
        Integer hid = Integer.valueOf(hidStr);
        HousingService service = HousingService.getInstance();
        Housing house = service.getHouseById(hid);
        house.setState(house.getState()==1?0:1);
        int i = service.updateHouse(house);
        //防止数据库更新了但前台管理员不知道，返回一个结果信息
        if(i < 1){
            result.setMsg("修改失败");
            result.setState(3);
        }else{
            result.setState(0);
        }
        writer.print(JSON.toJSONString(result));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

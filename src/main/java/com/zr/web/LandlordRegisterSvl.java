package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.Landlord;
import com.zr.pojo.ReturnResult;
import com.zr.pojo.UserInfo;
import com.zr.service.LandlordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//房东注册
@WebServlet(name = "LandlordRegisterSvl", urlPatterns = "/fdregister")
public class LandlordRegisterSvl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("已进入fdregister");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String IName = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("zhuzhi");
        String idCard = request.getParameter("cid");
        // 房东service对象
        LandlordService landlordService = LandlordService.getInstance();
        // 房东要绑定的用户账号对象
        Object userInfo = request.getSession().getAttribute("UserInfo");
        // 判断用户是否登陆
        UserInfo user = (userInfo == null) ? null : (UserInfo) userInfo;
        // 返回结果
        ReturnResult returnResult = new ReturnResult();
        // 没有session返回登录
        if (userInfo == null) {
            response.sendRedirect("/login.jsp");
            return;
            // 有session，判断当前用户是否是房东
        } else if (landlordService.getLandlordByAccount(user.getAccount()) != null) {
            response.sendRedirect("/index.jsp");
            return;
        }

        Landlord landlord = new Landlord(null, IName, phone, address, idCard, user.getAccount());
        int addLines = landlordService.addLandlord(landlord);
        if (addLines > 0) {
            // TODO:房东信息 存储sesion
            response.sendRedirect("/renting.jsp");
            System.out.println("房东注册成功");
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

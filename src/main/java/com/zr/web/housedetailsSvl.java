package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.CheckHouseRecord;
import com.zr.pojo.Housing;
import com.zr.pojo.ShowRecord;
import com.zr.pojo.UserInfo;
import com.zr.service.CheckHouseRecordService;
import com.zr.service.HousingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
//房屋详情
@WebServlet(name = "housedetailsSvl",urlPatterns = "/housedetails")
public class housedetailsSvl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        //进入详情页面后，获得房屋信息的JSON并返回到前台，前台为ajax
        Object house = request.getSession().getAttribute("house");
        response.getWriter().print(JSON.toJSONString(house));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //租房页面发送一个带有id号的请求
        //通过此处代码添加房屋浏览记录
        String id = request.getParameter("id");
        HousingService housingService = HousingService.getInstance();
        Housing house = housingService.getHouseById(Integer.valueOf(id));
        //将获取到的房屋信息存入到session中，方便doPost的异步请求
        request.getSession().setAttribute("house",house);
        UserInfo userInfo =(UserInfo)request.getSession().getAttribute("UserInfo");
        CheckHouseRecordService recordService = CheckHouseRecordService.getInstance();
        //获取该用户的所有浏览记录
        List<ShowRecord> allRecord = recordService.getRecordByAccount(userInfo.getAccount());//用户所有浏览记录
        Boolean flag = false;
        CheckHouseRecord oneRecord = null;
        //若存在该租房的浏览记录，则更新访问的时间
        //否则，添加新记录到浏览记录中
        for (ShowRecord showRecord : allRecord) {
            if (showRecord.getCheckHouseRecord().getHId().equals(house.getHId())){
                flag=true;
                oneRecord = showRecord.getCheckHouseRecord();
            }
        }
        if (flag){
            oneRecord.setCheckDate(new Date());
            //更新时间
            recordService.updateRecord(oneRecord);
        }else {
            oneRecord = new CheckHouseRecord(null,house.getHId(),userInfo.getAccount(),new Date());
            //添加记录
            recordService.addRecord(oneRecord);
        }

        response.sendRedirect("/housedetails.jsp");
    }
}

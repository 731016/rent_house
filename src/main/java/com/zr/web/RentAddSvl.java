package com.zr.web;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.zr.pojo.Housing;
import com.zr.pojo.Landlord;
import com.zr.pojo.UserInfo;
import com.zr.service.HousingService;
import com.zr.service.LandlordService;
import com.zr.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RentAddSvl",urlPatterns = "/rent")
public class RentAddSvl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Object o = request.getSession().getAttribute("UserInfo");
            if(o==null){
                response.getWriter().print("<script>alert('会话过期');location.href=\"/login.jsp\"</script>");
                return;
            }
            SmartUpload smartUpload = Utils.getInitialedSmartUpload(getServletConfig(),request,response);
            Request uploadRequest = smartUpload.getRequest();
            List<String> filenames = Utils.fileUpload(smartUpload, this, "upload");
            String imgList = Utils.arrayToString(filenames.toArray(),",");
            String houseTitle = uploadRequest.getParameter("housetitle");
            String housingType = uploadRequest.getParameter("huxing");
            double area = Double.parseDouble(uploadRequest.getParameter("mianji"));
            int rent = Integer.parseInt(uploadRequest.getParameter("price"));
            String[] facilities = uploadRequest.getParameterValues("sheshi");
            String facility = Utils.arrayToString(facilities,",");
            String info = uploadRequest.getParameter("xinxi");
            UserInfo userInfo = (UserInfo)o;
            LandlordService service_landlord = LandlordService.getInstance();
            Landlord landlord = service_landlord.getLandlordByAccount(userInfo.getAccount());
            Integer lid = landlord.getLId();
            int typeId = Integer.parseInt(uploadRequest.getParameter("housetype"));
            int towardId = Integer.parseInt(uploadRequest.getParameter("chaoxiang"));
            int aid = Integer.parseInt(uploadRequest.getParameter("quyu"));
            String address = uploadRequest.getParameter("address");
            Housing housing = new Housing(-1,houseTitle,rent,housingType,area,towardId,imgList,lid,typeId,facility,1,aid,address);
            HousingService service = HousingService.getInstance();
            int i = service.addHouse(housing);
            if(i==1){
                //添加成功
                response.getWriter().print("<script>alert('添加成功');history.go(-2)</script>");
            }else{
                //添加失败
                response.getWriter().print("<script>alert('添加失败');history.go(-1)</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("<script>alert('添加失败');history.go(-1)</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/rent.jsp");
    }
}

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
//发起房屋出租
@WebServlet(name = "RentAddSvl", urlPatterns = "/rent")
public class RentAddSvl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            //获取session中的用户信息，查找出对应的房东编号
            Object o = request.getSession().getAttribute("UserInfo");
            if(o==null){
                response.getWriter().print("<script>alert('会话过期');location.href=\"/login.jsp\"</script>");
                return;
            }
            UserInfo userInfo = (UserInfo)o;
            LandlordService service_landlord = LandlordService.getInstance();
            Landlord landlord = service_landlord.getLandlordByAccount(userInfo.getAccount());
            if(landlord==null){
                response.getWriter().print("<script>alert('请先成为房东');history.go(-1)</script>");
                return;
            }
            //调用工具类的方法，获取一个初始化且准备上传的SmartUpload对象，
            //使得SmartUpload对象可直接使用
            SmartUpload smartUpload = Utils.getInitialedSmartUpload(getServletConfig(),request,response);
            //工具类上传文件的返回值为重命名的文件名数组
            List<String> filenames = Utils.fileUpload(smartUpload, this,"/upload/");
            //将数组转换为指定分隔符的字符串
            String imgList = Utils.arrayToString(filenames.toArray(), ",");
            Request uploadRequest = smartUpload.getRequest();
            //获取前台传来的数据
            String houseTitle = uploadRequest.getParameter("housetitle");
            String housingType = uploadRequest.getParameter("huxing");
            double area = Double.parseDouble(uploadRequest.getParameter("mianji"));
            int rent = Integer.parseInt(uploadRequest.getParameter("price"));
            String[] facilities = uploadRequest.getParameterValues("sheshi");
            String facility = "";
            if (facilities != null) {
                facility = Utils.arrayToString(facilities, ",");
            }
            String info = uploadRequest.getParameter("xinxi");
            Integer lid = landlord.getLId();
            int typeId = Integer.parseInt(uploadRequest.getParameter("housetype"));
            int towardId = Integer.parseInt(uploadRequest.getParameter("chaoxiang"));
            int aid = Integer.parseInt(uploadRequest.getParameter("quyu"));
            String address = uploadRequest.getParameter("address");
            String describe = uploadRequest.getParameter("describe");
            //将前台数据转换为一个出租房屋对象
            Housing housing = new Housing(-1,houseTitle,rent,housingType,area,towardId,imgList,lid,typeId,facility,1,aid,address,describe);
            HousingService service = HousingService.getInstance();
            //返回结果
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
            response.getWriter().print("<script>alert('出错了');history.go(-1)</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/rent.jsp");
    }
}

package com.zr.web;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.zr.pojo.Housing;
import com.zr.service.HousingService;
import com.zr.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//更新出租房屋信息
@WebServlet(name = "UpdateRentSvl", urlPatterns = "/UpdateRent")
public class UpdateRentSvl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            //获取已装载的SmartUpload对象
            SmartUpload smartUpload = Utils.getInitialedSmartUpload(getServletConfig(), request, response);
            Request uploadRequest = smartUpload.getRequest();
            Integer hId = Integer.parseInt(uploadRequest.getParameter("hid"));
            HousingService instance = HousingService.getInstance();
            Housing houseById = instance.getHouseById(hId);
            //获取所有的文件名
            List<String> filenames = Utils.fileUpload(smartUpload, this, "/upload/");
            String imgList = Utils.arrayToString(filenames.toArray(), ",");
            if (imgList.equals("")) {
                imgList = houseById.getImgList();
            } else {
                String[] split = houseById.getImgList().split(",");
                for (String s : split) {
                    Utils.deleteFileByFilename(this, "/upload/", s);
                }
            }
            //获取前台传来的参数
            String title = uploadRequest.getParameter("house_title"); //房屋标题
            Integer typeId = Integer.parseInt(uploadRequest.getParameter("housetype")); //房屋类型
            String houseType = uploadRequest.getParameter("house_type"); //户型
            Integer towardId = Integer.parseInt(uploadRequest.getParameter("toward")); //朝向
            Integer aid = Integer.parseInt(uploadRequest.getParameter("quyu")); //区域
            Double area = Double.parseDouble(uploadRequest.getParameter("house_area")); //面积
            Integer rent = Integer.parseInt(uploadRequest.getParameter("rent_price")); //租金
            String[] facilities = uploadRequest.getParameterValues("facility");
            String facility = "";
            if (facilities != null) {
                facility = Utils.arrayToString(facilities, ",");
            }
            String describe = uploadRequest.getParameter("house_describe");

            String address = uploadRequest.getParameter("house_address");
            //转换为对象
            Housing housing = new Housing(hId, title, rent, houseType, area, towardId, imgList, houseById.getLId(), typeId, facility, houseById.getState(), aid, address, describe);
            HousingService service = HousingService.getInstance();
            //处理结果
            int i = service.updateHouse(housing);
            if (i == 1) {
                //修改成功
                response.getWriter().print("<script>alert('修改成功');history.go(-1)</script>");
            } else {
                //修改失败
                response.getWriter().print("<script>alert('修改失败');history.go(-1)</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

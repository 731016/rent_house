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
import java.util.List;
//通过地址查询租房信息
@WebServlet(name = "renting_select_add",urlPatterns = "/selectadd")
public class renting_select_add extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html");
      request.setCharacterEncoding("UTF-8");
      String address = request.getParameter("address");
      HousingService housing = HousingService.getInstance();
      Object select = request.getSession().getAttribute("search_input");
      List<Housing> allHouses = null;
      if (address!=null && !address.equals("")){
         //通过地址查询房屋数据
         allHouses = housing.getHousesByAddress(address);
      }else if (select!=null && !select.equals("")){
         String sel = select.toString();
         //通过地址查询房屋数据
         allHouses = housing.getHousesByAddress(sel);
         //删除session
         request.getSession().removeAttribute("search_input");
      }else {
         allHouses = housing.getAllHouses();
      }
      String s = JSON.toJSONString(allHouses);
      response.getWriter().print(s);

   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.sendRedirect("index.jsp");
   }
}

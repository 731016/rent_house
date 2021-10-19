package com.zr.web;

import com.alibaba.fastjson.JSON;
import com.zr.pojo.Housing;
import com.zr.service.HousingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//多条件查询，通过Map传入数据到服务层。（注意：Map的key需要和数据库的字段名相同）
@WebServlet(name = "Renting_list",urlPatterns = "/rentingList")
public class Renting_list extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=UTF-8");
      int aid = Integer.parseInt(request.getParameter("aid")) ;//默认0
      int type = Integer.parseInt(request.getParameter("type")) ;//默认0
      String rent = request.getParameter("rent");//默认”不限“
      String housingType = request.getParameter("housingType");//默认”不限“
      int toward = Integer.parseInt(request.getParameter("toward")); //默认0
      Map<String,Object> map = new HashMap<>();
      //去掉查询条件中的“不限”
      if (aid != 0){
         map.put("aid",aid);
      }
      if (type != 0){
         map.put("typeId",type);
      }
      if (!rent.equals("不限")){
         map.put("rent",rent);
      }
      if (!housingType.equals("不限")){
         map.put("houseType",housingType);
      }
      if (toward != 0){
         map.put("towardId",toward);
      }

      HousingService housing = HousingService.getInstance();
      List<Housing> housesByMultiParams = housing.getHousesByMultiParams(map);
      String s = JSON.toJSONString(housesByMultiParams);
      response.getWriter().print(s);
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }
}

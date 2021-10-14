package com.zr.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Renting_list",urlPatterns = "/rentingList")
public class Renting_list extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String area = request.getParameter("area");//默认0
      String type = request.getParameter("type");//默认0
      String rent = request.getParameter("rent");//默认”不限“
      String housingType = request.getParameter("housingType");//默认”不限“
      String toward = request.getParameter("toward");//默认0
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }
}

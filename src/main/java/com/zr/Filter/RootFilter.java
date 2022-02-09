package com.zr.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "RootFilter")
public class RootFilter implements Filter {
   @Override
   public void destroy() {
   }

   @Override
   public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
      HttpServletRequest request = (HttpServletRequest)req;
      HttpServletResponse response = (HttpServletResponse)resp;
      Object root = request.getSession().getAttribute("root");
      if (root!=null){
         chain.doFilter(req,resp);
      }else {
         response.sendRedirect("index.jsp");
      }
   }

   @Override
   public void init(FilterConfig config) throws ServletException {

   }

}

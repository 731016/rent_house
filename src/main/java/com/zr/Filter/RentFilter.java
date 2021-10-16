package com.zr.Filter;

import com.zr.pojo.Landlord;
import com.zr.pojo.UserInfo;
import com.zr.service.LandlordService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description TODO
 * @Date 2021/10/16 23:06
 * @Created by 折腾的小飞
 */
@WebFilter(filterName = "RentFilter")
public class RentFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Object o = request.getSession().getAttribute("UserInfo");
        if (o == null) {
            response.sendRedirect("/login.jsp");
            return;
        }
        UserInfo userInfo = (UserInfo)o;
        LandlordService service = LandlordService.getInstance();
        Landlord landlord = service.getLandlordByAccount(userInfo.getAccount());
        if(landlord==null){
            response.sendRedirect("/fdregister.jsp");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

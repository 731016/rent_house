package com.zr.Filter;

import com.zr.pojo.Landlord;
import com.zr.pojo.UserInfo;
import com.zr.service.LandlordService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FdRegister")
public class FdRegister implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        Object userInfo = httpReq.getSession().getAttribute("UserInfo");
        LandlordService landlordService = LandlordService.getInstance();
        if (userInfo == null) {
            httpResp.sendRedirect("/login.jsp");
            return;
        } else if (landlordService.getLandlordByAccount(((UserInfo)userInfo).getAccount())!=null) {
            httpResp.sendRedirect("/renting.jsp");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

package com.zr.web;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.zr.pojo.UserInfo;
import com.zr.service.UserInfoService;
import com.zr.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//用户更新用户信息
@WebServlet(name = "UpdateUserInfoSvl", urlPatterns = "/UpdateUserInfo")
public class UpdateUserInfoSvl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            //获取前台提交的参数值
            SmartUpload smartUpload = Utils.getInitialedSmartUpload(getServletConfig(), request, response);
            UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
            UserInfoService instance = UserInfoService.getInstance();
            UserInfo userInfoByAccount = instance.getUserInfoByAccount(userInfo.getAccount());
            List<String> filenames = Utils.fileUpload(smartUpload, this, "/upload/");
            String imgList = Utils.arrayToString(filenames.toArray(), ",");
            if (imgList == "") {
                imgList = userInfoByAccount.getImg();
            } else {
                Utils.deleteFileByFilename(this, "/upload/", userInfoByAccount.getImg());
            }
            Request uploadRequest = smartUpload.getRequest();
            String nickname = uploadRequest.getParameter("nickname");
            String phone = uploadRequest.getParameter("phone");
            String email = uploadRequest.getParameter("email");
            String initial_pwd = uploadRequest.getParameter("initial_pwd").trim();

            if (!initial_pwd.equals("")) {
                String new_pwd = uploadRequest.getParameter("new_pwd");
                //MD5加密
                initial_pwd = Utils.msgEncrypt(initial_pwd);
                new_pwd = Utils.msgEncrypt(new_pwd);
                //判断初始密码是否一致
                if (userInfoByAccount.getPassword().equals(initial_pwd)) {
                    UserInfo updateUserInfo = new UserInfo(userInfoByAccount.getAccount(), new_pwd, userInfoByAccount.getUserName(), nickname, email, phone, imgList, userInfoByAccount.getState());
                    int i = instance.updateUserInfo(updateUserInfo);
                    if (i == 1) {
                        //修改成功
                        response.getWriter().print("<script>alert('修改成功');history.go(-1)</script>");
                    } else {
                        //修改失败
                        response.getWriter().print("<script>alert('修改失败');history.go(-1)</script>");
                    }
                } else {
                    response.getWriter().print("<script>alert('初始密码错误');history.go(-1)</script>");
                }
            } else {
                UserInfo updateUserInfo = new UserInfo(userInfo.getAccount(), userInfoByAccount.getPassword(), userInfoByAccount.getUserName(), nickname, email, phone, imgList, userInfoByAccount.getState());
                int i = instance.updateUserInfo(updateUserInfo);
                if (i == 1) {
                    //修改成功
                    response.getWriter().print("<script>alert('修改成功');history.go(-1)</script>");
                } else {
                    //修改失败
                    response.getWriter().print("<script>alert('修改失败');history.go(-1)</script>");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("<script>alert('出错了');history.go(-1)</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index.jsp");
    }
}

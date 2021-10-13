package com.zr.utils;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

public class Utils {
    /**
     * 消息摘要方法，md5加密
     * @param msg
     * @return
     */
    public static String msgEncrypt(String msg){
        String result = "";
        try {
            byte[] digest=null;
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest = md5.digest(msg.getBytes("utf-8"));
            result = new BigInteger(1,digest).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 产生不重复的文件名
     * @param extension
     * @return
     */
    public static String randomFileName(String extension){
        Random random = new Random();
        int randomNum = random.nextInt(90000)+10000;
        return String.valueOf(new Date().getTime()) + randomNum+"."+extension;
    }

    /**
     * 上传文件到指定的相对路径
     * @param servlet
     * @param request
     * @param response
     * @param path
     * @return
     */
    public static boolean fileUpload(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response,String path){
        String realPath = servlet.getServletContext().getRealPath(path);
        SmartUpload smartUpload = new SmartUpload();
        try {
            smartUpload.initialize(servlet.getServletConfig(),request,response);
            smartUpload.upload();
            Request uploadRequest = smartUpload.getRequest();
            String extension = smartUpload.getFiles().getFile(0).getFileExt();
            smartUpload.getFiles().getFile(0).saveAs(realPath+randomFileName(extension));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

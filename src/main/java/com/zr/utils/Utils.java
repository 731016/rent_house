package com.zr.utils;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.zr.pojo.ReturnResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;
import java.util.Random;

public class Utils {
    /**
     * 消息摘要方法，md5加密
     *
     * @param msg
     * @return
     */
    public static String msgEncrypt(String msg) {
        String result = "";
        try {
            byte[] digest = null;
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest = md5.digest(msg.getBytes("utf-8"));
            result = new BigInteger(1, digest).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 产生不重复的文件名
     *
     * @param extension
     * @return
     */
    public static String randomFileName(String extension) {
        Random random = new Random();
        int randomNum = random.nextInt(90000) + 10000;
        return String.valueOf(new Date().getTime()) + randomNum + "." + extension;
    }

    /**
     * 上传文件到指定的相对路径
     *
     * @param servlet
     * @param request
     * @param response
     * @param path
     * @return
     */
    public static String fileUpload(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response, String path) throws Exception {
        String realPath = servlet.getServletContext().getRealPath(path);
        SmartUpload smartUpload = new SmartUpload();
        smartUpload.initialize(servlet.getServletConfig(), request, response);
        smartUpload.upload();
        Request uploadRequest = smartUpload.getRequest();
        String extension = smartUpload.getFiles().getFile(0).getFileExt();
        String fileName = randomFileName(extension);
        smartUpload.getFiles().getFile(0).saveAs(realPath + fileName);
        return fileName;
    }

    /**
     * 删除指定路径的指定文件
     * @param servlet
     * @param path
     * @param filename
     * @return
     */
    public static ReturnResult deleteFileByFilename(HttpServlet servlet, String path, String filename) {
        String realPath = servlet.getServletContext().getRealPath(path);
        File file = new File(realPath + filename);
        ReturnResult result = new ReturnResult(null, null, false);
        if (file.exists()) {
            if (!file.isDirectory()) {
                result.setFlag(true);
                file.delete();
            }else{
                result.setMsg("不是一个文件");
            }
        }else{
            result.setMsg("该文件不存在");
        }
        return result;
    }
}

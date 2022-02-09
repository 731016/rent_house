package com.zr.utils;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.zr.pojo.ReturnResult;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
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
     * @param smartUpload
     * @param path
     * @return
     * @throws Exception
     */
    public static List<String> fileUpload(SmartUpload smartUpload,HttpServlet servlet, String path) throws Exception {
        String realPath = servlet.getServletContext().getRealPath(path);
//        String realPath = Utils.class.getClassLoader().getResource(path).getFile();
        {
            File file = new File(realPath);
            if (!file.exists()) {
                boolean mkdir = file.mkdir();
            }
        }
        List<String> filenames = new ArrayList<>();
        Files files = smartUpload.getFiles();
        for (int i = 0; i < files.getCount(); i++) {
            com.jspsmart.upload.File file = files.getFile(i);
            String fileExt = file.getFileExt();
            if(StringUtils.isBlank(fileExt)){
                continue;
            }
            String filename = randomFileName(fileExt);
            file.saveAs(realPath+filename);
            filenames.add(filename);
        }
//        String extension = smartUpload.getFiles().getFile(0).getFileExt();
//        String fileName = randomFileName(extension);
//        smartUpload.getFiles().getFile(0).saveAs(realPath + fileName);
        return filenames;
    }

    /**
     * 获得一个已经初始化的SmartUpload对象，可以直接使用，无需上传
     * @param config
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public static SmartUpload getInitialedSmartUpload(ServletConfig config, HttpServletRequest request, HttpServletResponse response) throws Exception{
        SmartUpload smartUpload = new SmartUpload();
        smartUpload.initialize(config, request, response);
        smartUpload.upload();
        return smartUpload;
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

    /**
     * 将数组转换为字符串
     * @param array
     * @param reg
     * @return
     */
    public static String arrayToString(Object[] array,String reg){
        if (array.length==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object o : array) {
            sb.append(o.toString()+reg.trim());
        }
        return sb.toString().substring(0,sb.length()-1);
    }
}

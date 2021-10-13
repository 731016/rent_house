package com.zr.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
    public static String msgEncrypt(String msg){
        String result = "";
        try {
            byte[] digest=null;
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest = md5.digest(msg.getBytes("utf-8"));
            result = String.valueOf(digest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

package com.zr.utils;

public class FactoryUtils {
    public static <T> T createInstance(String className){
        T instance = null;
        try{
            instance = (T)Class.forName(className).getDeclaredConstructor().newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;
    }
}

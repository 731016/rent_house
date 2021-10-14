package com.zr.utils;

import java.lang.reflect.Constructor;

public class FactoryUtils {
    public static <T> T createInstance(String className){
        T instance = null;
        try{
            Constructor<?> constructor = Class.forName(className).getDeclaredConstructor();
            constructor.setAccessible(true);
            instance = (T)constructor.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;
    }
}

package com.zr.utils;

import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Date;
import java.util.*;

public class PojoUtils {
    private static final Set<String> types = new HashSet<>();

    static {
        types.add(String.class.getName());
        types.add(Byte.class.getName());
        types.add(Short.class.getName());
        types.add(Integer.class.getName());
        types.add(Long.class.getName());
        types.add(Float.class.getName());
        types.add(Double.class.getName());
        types.add(Character.class.getName());
        types.add(Boolean.class.getName());
        types.add(Date.class.getName());
        types.add(Time.class.getName());
        types.add(Array.class.getName());
        types.add(java.io.InputStream.class.getName());
        types.add(java.math.BigDecimal.class.getName());
        types.add(Blob.class.getName());
        types.add(Byte[].class.getName());
        types.add(Reader.class.getName());
        types.add(NClob.class.getName());
        types.add(Clob.class.getName());
        types.add(Ref.class.getName());
        types.add(Timestamp.class.getName());
        types.add(java.net.URL.class.getName());

    }

    private static class ResultSet2 {
        private int index = -1;
        private List<Map<String, Object>> list;

        static ResultSet2 getInstance(ResultSet set) throws Exception {
            ResultSet2 resultSet2 = new ResultSet2();
            ResultSetMetaData metaData = set.getMetaData();
            String[] keys = new String[metaData.getColumnCount()];
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                keys[i] = metaData.getColumnLabel(i+1);
            }
            while (set.next()) {
                Map<String,Object> map = new HashMap<>();
                for (String key : keys) {
                    map.put(key.toLowerCase(),set.getObject(key));
                }
                resultSet2.list.add(map);
            }
            return resultSet2;
        }

        private ResultSet2() {
            list = new ArrayList<>();
        }
        public boolean next(){
            if(index+1>=list.size()){
                return false;
            }else{
                index++;
                return true;
            }
        }
        public Object get(String columnLabel){
            return list.get(index).get(columnLabel.toLowerCase());
        }
        public ResultRow getResultRow(){
            return ResultRow.getInstance(this);
        }
    }
    private static class ResultRow{
        private Map<String,Object> map;
        public static ResultRow getInstance(ResultSet2 resultSet2){
            ResultRow resultRow = new ResultRow();
            resultRow.map = resultSet2.list.get(resultSet2.index);
            return resultRow;
        }
        private ResultRow(){
            map = new HashMap<>();
        }
        public Object get(String columnLabel){
            return map.get(columnLabel.toLowerCase());
        }
    }

    public static <T> List<T> resultSetToPojoList(ResultSet set, Class<T> type) throws Exception {
        List<T> list = new ArrayList<>();
        ResultSet2 resultSet2 = ResultSet2.getInstance(set);
//        while (set.next()) {
//            list.add(doConvertPojo(set, type));
//        }
        while (resultSet2.next()) {
            list.add(doConvertPojo(resultSet2.getResultRow(),type));
        }
        return list;
    }

    public static <T> T resultSetToPojo(ResultSet set, Class<T> type) throws Exception {
        ResultSet2 resultSet2 = ResultSet2.getInstance(set);
        if (resultSet2.next()) {
            return doConvertPojo(resultSet2.getResultRow(), type);
        } else {
            return null;
        }
    }

    private static <T> T doConvertPojo(ResultRow row, Class<T> type) throws Exception {
        T t = getT(type);
        for (Field field : type.getDeclaredFields()) {
            field.setAccessible(true);
            if (isInTypes(field.getType())) {
                field.set(t, row.get(field.getName()));
            } else {
                field.set(t, doConvertPojo(row, field.getType()));
            }
        }
        return t;
    }

    private static <T> T getT(Class<T> type) throws Exception {
        Constructor constructor = type.getDeclaredConstructors()[0];
        int length = constructor.getParameterTypes().length;
        Object[] params = new Object[length];
        return (T) constructor.newInstance(params);
    }

    private static boolean isInTypes(Class type) {
        return types.contains(type.getName());
    }
}

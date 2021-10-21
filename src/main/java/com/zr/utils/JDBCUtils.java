package com.zr.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;
    private static Connection connection = null;
    static PreparedStatement ps = null;
    static CallableStatement call = null;

    static {
        try {
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
            ds = null;
        }
    }

    public static int update(String sql, Object... args) {
        try {
//            connection = getConnection();
//            ps = getPreparedStatement(sql, args);
            QueryRunner runner = new QueryRunner(ds);
            return runner.update(sql, args);
//            return ps.executeUpdate();
        } catch (Exception e) {
            return -1;
        }
//        finally {
//            closeConnection();
//        }
    }

    public static Integer multiUpdate(String sql, Object[][] params) {
        try {
            connection = getConnection();
            ps = getPreparedStatement(sql, params);
            int[] batch = ps.executeBatch();
            int affectRows = 0;
            for (int i : batch) {
                affectRows += i;
            }
            return affectRows;
        } catch (Exception e) {
            return -1;
        } finally {
            closeConnection();
        }
    }

    public static int procedureUpdate(String procedure, Object... args) {
        try {
            connection = getConnection();
            call = getCallableStatement(procedure, args);
            return call.executeUpdate();
        } catch (Exception e) {
            return -1;
        } finally {
            closeConnection();
        }
    }

    public static Map<String, Object> procedureUpdateOut(String procedure, Map<String, Integer> map, Object... args) {
        try {
            call = getCallableStatement(procedure, args);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                call.registerOutParameter(entry.getKey(), entry.getValue());
            }
            call.executeUpdate();
            Map<String, Object> result = new HashMap<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                result.put(entry.getKey(), entry.getValue());
            }
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            closeConnection();
        }
    }
    public static <T> List<T> queryList(String sql, Class<T> type, Object... args) {
        QueryRunner runner = getQueryRunner();
        try {
            ResultSetHandler<List<T>> handler = new BeanListHandler<>(type);
            return runner.query(sql, handler, args);
        } catch (Exception e) {
            return null;
        }
    }
    public static ResultSet query(String sql,Object...args){
        try{
            ps = getPreparedStatement(sql,args);
            return ps.executeQuery();
        }catch (Exception e){
            return null;
        }
    }
    public static <T> T query(String sql, Class<T> type, Object... args) {
        QueryRunner runner = getQueryRunner();
        try {
            BeanHandler<T> handler = new BeanHandler<>(type);
            return runner.query(sql, handler, args);
        } catch (Exception e) {
            return null;
        }
    }

    private static CallableStatement getCallableStatement(String procedure, Object... args) throws Exception {
        call = connection.prepareCall(procedure);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                call.setObject((i + 1), args[i]);
            }
        }
        return call;
    }

    private static Connection getConnection() throws SQLException {

        //建立连接
        return ds.getConnection();
    }

    private static PreparedStatement getPreparedStatement(String sql, Object... args) throws Exception {
        //加载驱动
        //执行SQL
        connection = getConnection();
        ps = connection.prepareStatement(sql);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                ps.setObject((i + 1), args[i]);
            }
        }
        return ps;
    }

    private static PreparedStatement getPreparedStatement(String sql, Object[][] params) throws Exception {
        //加载驱动
        //执行SQL
        ps = connection.prepareStatement(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                for (int j = 0; j < params[i].length; j++) {
                    ps.setObject(j + 1, params[i][j]);
                }
                ps.addBatch();
            }
        }
        return ps;
    }

    private static QueryRunner getQueryRunner() {
        return new QueryRunner(ds);
    }

    public static void closeConnection() {
        try {
            if (ps != null) {
                ps.close();
            }
            if (call != null) {
                call.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

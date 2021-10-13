package com.zr.dao.impl;

import com.zr.dao.TowardDao;
import com.zr.pojo.Toward;
import com.zr.utils.JDBCUtils;

import java.util.List;

public class TowardDaoImpl implements TowardDao {
    @Override
    public List<Toward> getAllToward() {
        String sql = "select * from toward";
        return JDBCUtils.queryList(sql,Toward.class);
    }

    @Override
    public Toward getTowardById(Integer id) {
        String sql = "select * from toward where id = ?";
        return JDBCUtils.query(sql,Toward.class,id);
    }
}

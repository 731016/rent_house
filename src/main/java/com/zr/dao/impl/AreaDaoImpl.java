package com.zr.dao.impl;

import com.zr.dao.AreaDao;
import com.zr.pojo.Area;
import com.zr.utils.JDBCUtils;

import java.util.List;

public class AreaDaoImpl implements AreaDao {
    private static final String SELECT_ALL = "select * from area ";
    @Override
    public int addArea(Area area) {
        String sql = "insert into area values(default,?)";
        return JDBCUtils.update(sql,area.getAName());
    }

    @Override
    public List<Area> getAllArea() {
        return JDBCUtils.queryList(SELECT_ALL,Area.class);
    }

    @Override
    public List<Area> getAreaLikeName(String name) {
        String sql = SELECT_ALL + " where instr(aName,?)!=0";
        return JDBCUtils.queryList(sql,Area.class,name);
    }

    @Override
    public Area getAreaById(Integer id) {
        String sql = SELECT_ALL + " where aid = ?";
        return JDBCUtils.query(sql,Area.class,id);
    }

    @Override
    public Area getAreaByName(String name) {
        String sql = SELECT_ALL + " where aName = ?";
        return JDBCUtils.query(sql,Area.class,name);
    }
}

package com.zr.dao;

import com.zr.dao.impl.AreaDaoImpl;
import com.zr.pojo.Area;
import com.zr.utils.FactoryUtils;

import java.util.List;

public interface AreaDao {
    static AreaDao getInstance() {
        return (AreaDao) FactoryUtils.createInstance(AreaDaoImpl.class.getName());
    }

    int addArea(Area area);

    List<Area> getAllArea();

    List<Area> getAreaLikeName(String name);

    Area getAreaById(Integer id);

    Area getAreaByName(String name);
}

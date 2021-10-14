package com.zr.dao;

import com.zr.pojo.Area;

import java.util.List;

public interface AreaDao {
    int addArea(Area area);
    List<Area> getAllArea();
    List<Area> getAreaLikeName(String name);
    Area getAreaById(Integer id);
    Area getAreaByName(String name);
}

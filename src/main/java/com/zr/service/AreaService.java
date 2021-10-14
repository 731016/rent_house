package com.zr.service;

import com.zr.pojo.Area;
import com.zr.service.impl.AreaServiceImpl;
import com.zr.utils.FactoryUtils;

import java.util.List;

public interface AreaService {
    static AreaService getInstance(){
        return (AreaService)FactoryUtils.createInstance(AreaServiceImpl.class.getName());
    }
    int addArea(Area area);
    List<Area> getAllArea();
    List<Area> getAreaLikeName(String name);
    Area getAreaById(Integer id);
    Area getAreaByName(String name);
}

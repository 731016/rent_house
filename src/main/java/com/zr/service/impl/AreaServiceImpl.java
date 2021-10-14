package com.zr.service.impl;

import com.zr.dao.AreaDao;
import com.zr.pojo.Area;
import com.zr.service.AreaService;

import java.util.List;

/**
 * @author 涂鏊飞tu_aofei@163.com
 * @description: TODO 类描述
 * @create 2021-10-14 15:20
 */
public class AreaServiceImpl implements AreaService {
    private static AreaDao areaDao;

    private AreaServiceImpl() {
        areaDao = AreaDao.getInstance();
    }

    @Override
    public int addArea(Area area) {
        return areaDao.addArea(area);
    }

    @Override
    public List<Area> getAllArea() {
        return areaDao.getAllArea();
    }

    @Override
    public List<Area> getAreaLikeName(String name) {
        return areaDao.getAreaLikeName(name);
    }

    @Override
    public Area getAreaById(Integer id) {
        return areaDao.getAreaById(id);
    }

    @Override
    public Area getAreaByName(String name) {
        return areaDao.getAreaByName(name);
    }
}

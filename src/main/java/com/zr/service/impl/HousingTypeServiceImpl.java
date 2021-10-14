package com.zr.service.impl;

import com.zr.dao.HousingTypeDao;
import com.zr.pojo.HousingType;
import com.zr.service.HousingTypeService;

import java.util.List;

/**
 * @author 涂鏊飞tu_aofei@163.com
 * @description: TODO 类描述
 * @create 2021-10-13 11:27
 */
public class HousingTypeServiceImpl implements HousingTypeService {
    private static HousingTypeDao housingTypeDao;

    private HousingTypeServiceImpl() {
        housingTypeDao =HousingTypeDao.getInstance();
    }

    @Override
    public List<HousingType> getAllHousingTypes() {
        return housingTypeDao.getAllHousingTypes();
    }

    @Override
    public HousingType getHousingTypeById(Integer id) {
        return housingTypeDao.getHousingTypeById(id);
    }

    @Override
    public List<HousingType> getHousingTypesLikeTypeName(String typeName) {
        return housingTypeDao.getHousingTypesLikeTypeName(typeName);
    }

    @Override
    public int addHousingType(HousingType housingType) {
        return housingTypeDao.addHousingType(housingType);
    }

    @Override
    public int updateHousingType(HousingType housingType) {
        return housingTypeDao.updateHousingType(housingType);
    }

    @Override
    public int deleteHousingTypeById(Integer id) {
        return housingTypeDao.deleteHousingTypeById(id);
    }
}

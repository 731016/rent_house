package com.zr.dao;

import com.zr.dao.impl.HousingTypeDaoImpl;
import com.zr.pojo.HousingType;
import com.zr.utils.FactoryUtils;

import java.util.List;

public interface HousingTypeDao {
    static HousingTypeDao getInstance(){
        return (HousingTypeDao) FactoryUtils.createInstance(HousingTypeDaoImpl.class.getName());
    }
    List<HousingType> getAllHousingTypes();
    HousingType getHousingTypeById(Integer id);
    List<HousingType> getHousingTypesLikeTypeName(String typeName);
    int addHousingType(HousingType housingType);
    int updateHousingType(HousingType housingType);
    int deleteHousingTypeById(Integer id);
}

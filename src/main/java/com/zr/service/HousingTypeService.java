package com.zr.service;

import com.zr.dao.HousingTypeDao;
import com.zr.dao.impl.HousingTypeDaoImpl;
import com.zr.pojo.HousingType;
import com.zr.service.impl.HousingTypeServiceImpl;
import com.zr.utils.FactoryUtils;

import java.util.List;

public interface HousingTypeService {
    static HousingTypeService getInstance(){
        return (HousingTypeService) FactoryUtils.createInstance(HousingTypeServiceImpl.class.getName());
    }
    List<HousingType> getAllHousingTypes();
    HousingType getHousingTypeById(Integer id);
    List<HousingType> getHousingTypesLikeTypeName(String typeName);
    int addHousingType(HousingType housingType);
    int updateHousingType(HousingType housingType);
    int deleteHousingTypeById(Integer id);

}

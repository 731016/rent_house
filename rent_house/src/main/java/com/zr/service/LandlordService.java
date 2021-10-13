package com.zr.service;

import com.zr.dao.LandlordDao;
import com.zr.dao.impl.LandlordDaoImpl;
import com.zr.pojo.Landlord;
import com.zr.service.impl.LandlordServiceImpl;
import com.zr.utils.FactoryUtils;

import java.util.List;

public interface LandlordService {
    static LandlordService getInstance() {
        return (LandlordService) FactoryUtils.createInstance(LandlordServiceImpl.class.getName());
    }

    List<Landlord> getAllLandlords();

    Landlord getLandlordById(Integer id);

    List<Landlord> getLandlordLikeName(String name);

    Landlord getLandLordByName(String name);

    int addLandlord(Landlord landlord);

    int updateLandlord(Landlord landlord);

    int deleteLandlordById(Integer id);

}

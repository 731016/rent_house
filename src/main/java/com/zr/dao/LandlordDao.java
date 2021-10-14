package com.zr.dao;

import com.zr.dao.impl.LandlordDaoImpl;
import com.zr.pojo.Landlord;
import com.zr.utils.FactoryUtils;

import java.util.List;

public interface LandlordDao {
    static LandlordDao getInstance(){
        return (LandlordDao) FactoryUtils.createInstance(LandlordDaoImpl.class.getName());
    }
    List<Landlord> getAllLandlords();
    Landlord getLandlordById(Integer id);
    List<Landlord> getLandlordLikeName(String name);
    Landlord getLandLordByName(String name);
    int addLandlord(Landlord landlord);
    int updateLandlord(Landlord landlord);
    int deleteLandlordById(Integer id);
}

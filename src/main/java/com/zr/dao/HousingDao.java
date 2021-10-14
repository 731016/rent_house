package com.zr.dao;

import com.zr.dao.impl.HousingDaoImpl;
import com.zr.pojo.Housing;
import com.zr.utils.FactoryUtils;

import java.util.List;

public interface HousingDao {
    static HousingDao getInstance(){
        return (HousingDao) FactoryUtils.createInstance(HousingDaoImpl.class.getName());
    }
    int addHouse(Housing housing);
    List<Housing> getAllHouses();
    List<Housing> getHousesLikeTitle(String title);
    List<Housing> getHousesByRentRange(double min,double max);
    List<Housing> getHousesByHouseType(String houseType);
    List<Housing> getHousesByAreaRange(double min,double max);
    List<Housing> getHousesByTowardId(Integer towardId);
    List<Housing> getHousesByTypeId(Integer typeId);
    List<Housing> getHousesByState(Integer state);
}

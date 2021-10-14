package com.zr.service;

import com.zr.dao.HousingDao;
import com.zr.dao.impl.HousingDaoImpl;
import com.zr.pojo.Housing;
import com.zr.service.impl.HousingServiceImpl;
import com.zr.utils.FactoryUtils;

import java.util.List;
import java.util.Map;

public interface HousingService {
    static HousingService getInstance(){
        return (HousingService) FactoryUtils.createInstance(HousingServiceImpl.class.getName());
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
    List<Housing> getHousesByMultiParams(Map<String,Object> map);
}

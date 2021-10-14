package com.zr.service.impl;

import com.zr.dao.HousingDao;
import com.zr.pojo.Housing;
import com.zr.service.HousingService;

import java.util.List;
import java.util.Map;

/**
 * @author 涂鏊飞tu_aofei@163.com
 * @description: TODO 类描述
 * @create 2021-10-13 11:42
 */
public class HousingServiceImpl implements HousingService {
    private static HousingDao housingDao;

    private HousingServiceImpl() {
        housingDao = HousingDao.getInstance();
    }

    @Override
    public int addHouse(Housing housing) {
        return housingDao.addHouse(housing);
    }

    @Override
    public List<Housing> getAllHouses() {
        return housingDao.getAllHouses();
    }

    @Override
    public List<Housing> getHousesLikeTitle(String title) {
        return housingDao.getHousesLikeTitle(title);
    }

    @Override
    public List<Housing> getHousesByRentRange(double min, double max) {
        return housingDao.getHousesByRentRange(min,max);
    }

    @Override
    public List<Housing> getHousesByHouseType(String houseType) {
        return housingDao.getHousesByHouseType(houseType);
    }

    @Override
    public List<Housing> getHousesByAreaRange(double min, double max) {
        return housingDao.getHousesByAreaRange(min,max);
    }

    @Override
    public List<Housing> getHousesByTowardId(Integer towardId) {
        return housingDao.getHousesByTowardId(towardId);
    }

    @Override
    public List<Housing> getHousesByTypeId(Integer typeId) {
        return housingDao.getHousesByTypeId(typeId);
    }

    @Override
    public List<Housing> getHousesByState(Integer state) {
        return housingDao.getHousesByState(state);
    }

    @Override
    public List<Housing> getHousesByMultiParams(Map<String, Object> map) {
        return housingDao.getHousesByMultiParams(map);
    }
}

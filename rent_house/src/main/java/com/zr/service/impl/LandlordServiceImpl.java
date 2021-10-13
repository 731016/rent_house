package com.zr.service.impl;

import com.zr.dao.LandlordDao;
import com.zr.pojo.Landlord;
import com.zr.service.LandlordService;

import java.util.List;

/**
 * @author 涂鏊飞tu_aofei@163.com
 * @description: TODO 类描述
 * @create 2021-10-13 11:51
 */
public class LandlordServiceImpl implements LandlordService {
    private static LandlordDao landlordDao;

    private LandlordServiceImpl() {
        landlordDao = LandlordDao.getInstance();
    }

    @Override
    public List<Landlord> getAllLandlords() {
        return landlordDao.getAllLandlords();
    }

    @Override
    public Landlord getLandlordById(Integer id) {
        return landlordDao.getLandlordById(id);
    }

    @Override
    public List<Landlord> getLandlordLikeName(String name) {
        return landlordDao.getLandlordLikeName(name);
    }

    @Override
    public Landlord getLandLordByName(String name) {
        return landlordDao.getLandLordByName(name);
    }

    @Override
    public int addLandlord(Landlord landlord) {
        return landlordDao.addLandlord(landlord);
    }

    @Override
    public int updateLandlord(Landlord landlord) {
        return landlordDao.updateLandlord(landlord);
    }

    @Override
    public int deleteLandlordById(Integer id) {
        return landlordDao.deleteLandlordById(id);
    }
}

package com.zr.dao.impl;

import com.zr.dao.HousingDao;
import com.zr.pojo.Housing;
import com.zr.utils.JDBCUtils;

import java.util.List;

public class HousingDaoImpl implements HousingDao {
    private static final String selectAll = "select * from housing ";

    @Override
    public int addHouse(Housing housing) {
        String sql = "insert into housing values(default,?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {
                housing.getTitle(),
                housing.getRent(),
                housing.getHouseType(),
                housing.getArea(),
                housing.getTowardId(),
                housing.getImgList(),
                housing.getLId(),
                housing.getTypeId(),
                housing.getFacilities(),
                housing.getState()
        };
        return JDBCUtils.update(sql, params);
    }

    @Override
    public List<Housing> getAllHouses() {
        return JDBCUtils.queryList(selectAll, Housing.class);
    }

    @Override
    public List<Housing> getHousesLikeTitle(String title) {
        String sql = selectAll + "where title = ?";
        return JDBCUtils.queryList(sql, Housing.class, title);
    }

    @Override
    public List<Housing> getHousesByRentRange(double min, double max) {
        String sql = selectAll + "where rent between ? and ?;";
        return JDBCUtils.queryList(sql, Housing.class, min, max);
    }

    @Override
    public List<Housing> getHousesByHouseType(String houseType) {
        String sql = selectAll + "where houseType = ?";
        return JDBCUtils.queryList(sql, Housing.class, houseType);
    }

    @Override
    public List<Housing> getHousesByAreaRange(double min, double max) {
        String sql = selectAll + "where area between ? and ?";
        return JDBCUtils.queryList(sql, Housing.class, min, max);
    }

    @Override
    public List<Housing> getHousesByTowardId(Integer towardId) {
        String sql = selectAll + "where towardId = ?";
        return JDBCUtils.queryList(sql,Housing.class,towardId);
    }

    @Override
    public List<Housing> getHousesByTypeId(Integer typeId) {
        String sql = selectAll + "where typeId = ?";
        return JDBCUtils.queryList(sql,Housing.class,typeId);
    }

    @Override
    public List<Housing> getHousesByState(Integer state) {
        String sql = selectAll + "where state = ?";
        return JDBCUtils.queryList(sql,Housing.class,state);
    }
}

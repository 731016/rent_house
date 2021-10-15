package com.zr.dao.impl;

import com.zr.dao.HousingDao;
import com.zr.pojo.Housing;
import com.zr.utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HousingDaoImpl implements HousingDao {
    private static final String SELECT_ALL = "select * from housing ";

    @Override
    public int addHouse(Housing housing) {
        String sql = "insert into housing values(default,?,?,?,?,?,?,?,?,?,?,?,?)";
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
                housing.getState(),
                housing.getAid(),
                housing.getAddress()
        };
        return JDBCUtils.update(sql, params);
    }

    @Override
    public List<Housing> getAllHouses() {
        return JDBCUtils.queryList(SELECT_ALL, Housing.class);
    }

    @Override
    public List<Housing> getHousesLikeTitle(String title) {
        String sql = SELECT_ALL + "where title = ?";
        return JDBCUtils.queryList(sql, Housing.class, title);
    }

    @Override
    public List<Housing> getHousesByRentRange(double min, double max) {
        String sql = SELECT_ALL + "where rent between ? and ?;";
        return JDBCUtils.queryList(sql, Housing.class, min, max);
    }

    @Override
    public List<Housing> getHousesByHouseType(String houseType) {
        String sql = SELECT_ALL + "where houseType = ?";
        return JDBCUtils.queryList(sql, Housing.class, houseType);
    }

    @Override
    public List<Housing> getHousesByAreaRange(double min, double max) {
        String sql = SELECT_ALL + "where area between ? and ?";
        return JDBCUtils.queryList(sql, Housing.class, min, max);
    }

    @Override
    public List<Housing> getHousesByTowardId(Integer towardId) {
        String sql = SELECT_ALL + "where towardId = ?";
        return JDBCUtils.queryList(sql,Housing.class,towardId);
    }

    @Override
    public List<Housing> getHousesByTypeId(Integer typeId) {
        String sql = SELECT_ALL + "where typeId = ?";
        return JDBCUtils.queryList(sql,Housing.class,typeId);
    }

    @Override
    public List<Housing> getHousesByState(Integer state) {
        String sql = SELECT_ALL + "where state = ?";
        return JDBCUtils.queryList(sql,Housing.class,state);
    }

    @Override
    public List<Housing> getHousesByMultiParams(Map<String,Object> map) {
        StringBuilder sb = new StringBuilder(SELECT_ALL + "where state=1 ");
        List<Object> list = new ArrayList<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if(entry.getKey().equals("rent")){
                String[] strings = entry.getValue().toString().split("-");
                if(strings.length==1){
                    sb.append(String.format(" and %s > ? ",entry.getKey()));
                    list.add(entry.getValue());
                }else {
                    sb.append(String.format(" and (%s between ? and ?) ",entry.getKey()));
                    list.add(strings[0]);
                    list.add(strings[1]);
                }
            }else {
                sb.append(String.format(" and %s = ? ", entry.getKey()));
                list.add(entry.getValue());
            }
        }
        return JDBCUtils.queryList(sb.toString(),Housing.class,list.toArray());
    }

    @Override
    public int deleteHouseById(Integer id) {
        String sql = "delete from housing where hid = ?";
        return JDBCUtils.update(sql,id);
    }
}

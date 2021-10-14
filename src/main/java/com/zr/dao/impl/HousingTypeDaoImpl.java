package com.zr.dao.impl;

import com.zr.dao.HousingTypeDao;
import com.zr.pojo.HousingType;
import com.zr.utils.JDBCUtils;

import java.util.List;

public class HousingTypeDaoImpl implements HousingTypeDao {
    private static final String selectAll = "select * from housingType ";
    @Override
    public List<HousingType> getAllHousingTypes() {
        return JDBCUtils.queryList(selectAll,HousingType.class);
    }

    @Override
    public HousingType getHousingTypeById(Integer id) {
        String sql = selectAll + "where typeId = ?";
        return JDBCUtils.query(sql,HousingType.class,id);
    }

    @Override
    public List<HousingType> getHousingTypesLikeTypeName(String typeName) {
        String sql = selectAll + "where instr(typeName,?)!=0";
        return JDBCUtils.queryList(sql,HousingType.class,typeName);
    }

    @Override
    public int addHousingType(HousingType housingType) {
        String sql = "insert into housingType values(default,?);";
        return JDBCUtils.update(sql,housingType.getTypeName());
    }

    @Override
    public int updateHousingType(HousingType housingType) {
        String sql = "update housingType set typeName = ? where typeId = ?";
        return JDBCUtils.update(sql,housingType.getTypeName(),housingType.getTypeId());
    }

    @Override
    public int deleteHousingTypeById(Integer id) {
        String sql = "delete from housingType where typeId = ?";
        return JDBCUtils.update(sql,id);
    }
}

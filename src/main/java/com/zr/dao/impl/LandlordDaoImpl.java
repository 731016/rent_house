package com.zr.dao.impl;

import com.zr.dao.LandlordDao;
import com.zr.pojo.Landlord;
import com.zr.utils.JDBCUtils;

import java.util.List;

public class LandlordDaoImpl implements LandlordDao {
    private static final String selectAll = "select * from landlord ";

    @Override
    public List<Landlord> getAllLandlords() {
        return JDBCUtils.queryList(selectAll, Landlord.class);
    }

    @Override
    public Landlord getLandlordById(Integer id) {
        String sql = selectAll + "where lid = ?";
        return JDBCUtils.query(sql, Landlord.class);
    }

    @Override
    public List<Landlord> getLandlordLikeName(String name) {
        String sql = selectAll + "where instr(lName,?)!=0";
        return JDBCUtils.queryList(sql, Landlord.class);
    }

    @Override
    public Landlord getLandLordByName(String name) {
        String sql = selectAll + "where lName = ?";
        return JDBCUtils.query(sql, Landlord.class, name);
    }

    @Override
    public int addLandlord(Landlord landlord) {
        String sql = "insert into landlord values(default,?,?,?,?)";
        Object[] params = {
                landlord.getLName(),
                landlord.getPhone(),
                landlord.getAddress(),
                landlord.getIdCard()
        };
        return JDBCUtils.update(sql, params);
    }

    @Override
    public int updateLandlord(Landlord landlord) {
        String sql = "update landlord set lName = ?,phone=?,address=? ,idCard=? where lid = ?";
        Object[] params = {
                landlord.getLName(),
                landlord.getPhone(),
                landlord.getAddress(),
                landlord.getIdCard(),
                landlord.getLId()
        };
        return JDBCUtils.update(sql,params);
    }

    @Override
    public int deleteLandlordById(Integer id) {
        String sql = "delete from landlord where lid = ?";
        return JDBCUtils.update(sql,id);
    }
}

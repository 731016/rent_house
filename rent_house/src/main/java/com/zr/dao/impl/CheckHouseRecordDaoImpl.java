package com.zr.dao.impl;

import com.zr.dao.CheckHouseRecordDao;
import com.zr.pojo.CheckHouseRecord;
import com.zr.utils.JDBCUtils;

import java.util.List;

public class CheckHouseRecordDaoImpl implements CheckHouseRecordDao {
    @Override
    public List<CheckHouseRecord> getRecordByAccount(String account) {
        String sql = "select * from checkHouseRecord where account = ?";
        return JDBCUtils.queryList(sql,CheckHouseRecord.class,account);
    }

    @Override
    public int addRecord(CheckHouseRecord record) {
        String sql = "insert into checkHouseRecord values(default,?,?,?)";
        Object[] params = {record.getHId(),record.getAccount(),record.getCheckDate()};
        return JDBCUtils.update(sql,params);
    }

    @Override
    public int deleteRecord(Integer cid) {
        String sql = "delete from checkHouseRecord where cid = ?";
        return JDBCUtils.update(sql,cid);
    }
}

package com.zr.dao;

import com.zr.dao.impl.CheckHouseRecordDaoImpl;
import com.zr.pojo.CheckHouseRecord;
import com.zr.pojo.ShowRecord;
import com.zr.utils.FactoryUtils;

import java.util.List;

public interface CheckHouseRecordDao {
    static CheckHouseRecordDao getInstance(){
        return (CheckHouseRecordDao) FactoryUtils.createInstance(CheckHouseRecordDaoImpl.class.getName());
    }
    List<ShowRecord> getRecordByAccount(String account);
    int addRecord(CheckHouseRecord record);
    int deleteRecord(Integer cid);
}

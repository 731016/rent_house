package com.zr.service;

import com.zr.dao.CheckHouseRecordDao;
import com.zr.dao.impl.CheckHouseRecordDaoImpl;
import com.zr.pojo.CheckHouseRecord;
import com.zr.service.impl.CheckHouseRecordServiceImpl;
import com.zr.utils.FactoryUtils;

import java.util.List;

public interface CheckHouseRecordService {
    static CheckHouseRecordService getInstance(){
        return (CheckHouseRecordService) FactoryUtils.createInstance(CheckHouseRecordServiceImpl.class.getName());
    }
    List<CheckHouseRecord> getRecordByAccount(String account);
    int addRecord(CheckHouseRecord record);
    int deleteRecord(Integer cid);

}

package com.zr.service.impl;

import com.zr.dao.CheckHouseRecordDao;
import com.zr.pojo.CheckHouseRecord;
import com.zr.service.CheckHouseRecordService;

import java.util.List;

/**
 * @author 涂鏊飞tu_aofei@163.com
 * @description: TODO 类描述
 * @create 2021-10-13 11:45
 */
public class CheckHouseRecordServiceImpl implements CheckHouseRecordService {
    private static CheckHouseRecordDao checkHouseRecordDao;

    private CheckHouseRecordServiceImpl() {
        checkHouseRecordDao = CheckHouseRecordDao.getInstance();
    }

    @Override
    public List<CheckHouseRecord> getRecordByAccount(String account) {
        return checkHouseRecordDao.getRecordByAccount(account);
    }

    @Override
    public int addRecord(CheckHouseRecord record) {
        return checkHouseRecordDao.addRecord(record);
    }

    @Override
    public int deleteRecord(Integer cid) {
        return checkHouseRecordDao.deleteRecord(cid);
    }
}

package com.zr.dao.impl;

import com.zr.dao.CheckHouseRecordDao;
import com.zr.dao.HousingDao;
import com.zr.pojo.CheckHouseRecord;
import com.zr.pojo.Housing;
import com.zr.pojo.Landlord;
import com.zr.pojo.ShowRecord;
import com.zr.utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

public class CheckHouseRecordDaoImpl implements CheckHouseRecordDao {
    @Override
    public List<ShowRecord> getRecordByAccount(String account) {
        String sql = "select * from checkHouseRecord where account = ?";
        List<CheckHouseRecord> checkHouseRecords = JDBCUtils.queryList(sql, CheckHouseRecord.class, account);
        if(checkHouseRecords!=null){
            List<ShowRecord> showRecords=new ArrayList<>();
            for (CheckHouseRecord checkHouseRecord : checkHouseRecords) {
                Integer hId = checkHouseRecord.getHId();
                HousingDao housingDao=new HousingDaoImpl();
                Housing houseById = housingDao.getHouseById(hId);
                showRecords.add(new ShowRecord(checkHouseRecord,houseById.getTitle()));
            }
            return showRecords;
        }
        return null;
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

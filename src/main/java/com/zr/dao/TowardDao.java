package com.zr.dao;

import com.zr.dao.impl.TowardDaoImpl;
import com.zr.pojo.Toward;
import com.zr.utils.FactoryUtils;

import java.util.List;

public interface TowardDao {
    static TowardDao getInstance(){
        return (TowardDao) FactoryUtils.createInstance(TowardDaoImpl.class.getName());
    }
    List<Toward> getAllToward();
    Toward getTowardById(Integer id);
}

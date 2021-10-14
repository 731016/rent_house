package com.zr.service;

import com.zr.dao.TowardDao;
import com.zr.dao.impl.TowardDaoImpl;
import com.zr.pojo.Toward;
import com.zr.service.impl.TowardServiceImpl;
import com.zr.utils.FactoryUtils;

import java.util.List;

public interface TowardService {
    static TowardService getInstance() {
        return (TowardService) FactoryUtils.createInstance(TowardServiceImpl.class.getName());
    }

    List<Toward> getAllToward();

    Toward getTowardById(Integer id);

}

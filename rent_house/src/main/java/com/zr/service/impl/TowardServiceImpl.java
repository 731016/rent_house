package com.zr.service.impl;

import com.zr.dao.TowardDao;
import com.zr.pojo.Toward;
import com.zr.service.TowardService;

import java.util.List;

/**
 * @author 涂鏊飞tu_aofei@163.com
 * @description: TODO 类描述
 * @create 2021-10-13 11:24
 */
public class TowardServiceImpl implements TowardService {
    private static TowardDao towardDao;

    private TowardServiceImpl() {
        towardDao = TowardDao.getInstance();
    }

    @Override
    public List<Toward> getAllToward() {
        return towardDao.getAllToward();
    }

    @Override
    public Toward getTowardById(Integer id) {
        return towardDao.getTowardById(id);
    }
}

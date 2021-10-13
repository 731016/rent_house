package com.zr.service.impl;

import com.zr.dao.UserInfoDao;
import com.zr.dao.impl.UserInfoDaoImpl;
import com.zr.pojo.UserInfo;
import com.zr.service.UserInfoService;
import com.zr.utils.FactoryUtils;

import java.util.List;

/**
 * @author 涂鏊飞tu_aofei@163.com
 * @description: TODO 类描述
 * @create 2021-10-13 10:54
 */
public class UserInfoServiceImpl implements UserInfoService {
    // 工厂模式 + 单例模式(饿汉)
    private static UserInfoDao userInfoDao; //dao接口
    private UserInfoServiceImpl() {
        userInfoDao = UserInfoDao.getInstance(); // dao实例，多态
    }
    private static UserInfoServiceImpl userInfoService = FactoryUtils.createInstance(UserInfoServiceImpl.class.getName()); //service实例
    // 返回服务层实例
    public static UserInfoServiceImpl getInstance(){
        return userInfoService;
    }

    @Override
    public boolean login(String account, String password) {
        return userInfoDao.login(account, password);
    }

    @Override
    public List<UserInfo> getAllUserInfo() {
        return userInfoDao.getAllUserInfo();
    }

    @Override
    public List<UserInfo> getUserInfoLikeAccount(String account) {
        return userInfoDao.getUserInfoLikeAccount(account);
    }

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoDao.addUserInfo(userInfo);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoDao.updateUserInfo(userInfo);
    }

    @Override
    public int deleteUserInfo(String account) {
        return userInfoDao.deleteUserInfo(account);
    }

    @Override
    public UserInfo getUserInfoByAccount(String account) {
        return userInfoDao.getUserInfoByAccount(account);
    }

    @Override
    public UserInfo getUserInfoByUserName(String userName) {
        return userInfoDao.getUserInfoByUserName(userName);
    }

    @Override
    public List<UserInfo> getUserInfoLikeUserName(String userName) {
        return userInfoDao.getUserInfoLikeUserName(userName);
    }
}

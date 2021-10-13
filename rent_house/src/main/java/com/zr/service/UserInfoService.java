package com.zr.service;

import com.zr.dao.UserInfoDao;
import com.zr.dao.impl.UserInfoDaoImpl;
import com.zr.pojo.UserInfo;
import com.zr.utils.FactoryUtils;

import java.util.List;

public interface UserInfoService {
    static UserInfoDao getInstance(){
        return (UserInfoDao) FactoryUtils.createInstance(UserInfoDaoImpl.class.getName());
    }
    boolean login(String account,String password);
    List<UserInfo> getAllUserInfo();
    List<UserInfo> getUserInfoLikeAccount(String account);
    int addUserInfo(UserInfo userInfo);
    int updateUserInfo(UserInfo userInfo);
    int deleteUserInfo(String account);
    UserInfo getUserInfoByAccount(String account);
    UserInfo getUserInfoByUserName(String userName);
    List<UserInfo> getUserInfoLikeUserName(String userName);
}

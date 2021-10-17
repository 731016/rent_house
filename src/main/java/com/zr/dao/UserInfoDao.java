package com.zr.dao;

import com.zr.dao.impl.UserInfoDaoImpl;
import com.zr.pojo.UserInfo;
import com.zr.utils.FactoryUtils;

import java.util.List;

public interface UserInfoDao {
    static UserInfoDao getInstance(){
        return (UserInfoDao) FactoryUtils.createInstance(UserInfoDaoImpl.class.getName());
    }
    boolean login(String account,String password);
    List<UserInfo> getAllUserInfo();
    List<UserInfo> getUserInfoLikeAccount(String account);
    int addUserInfo(UserInfo userInfo);
    int updateUserInfo(UserInfo userInfo);
    int updateUserName(String userName,String account);
    int deleteUserInfo(String account);
    UserInfo getUserInfoByAccount(String account);
    UserInfo getUserInfoByUserName(String userName);
    List<UserInfo> getUserInfoLikeUserName(String userName);
}

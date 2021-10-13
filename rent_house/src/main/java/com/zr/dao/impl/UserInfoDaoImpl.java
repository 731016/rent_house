package com.zr.dao.impl;

import com.zr.dao.UserInfoDao;
import com.zr.pojo.UserInfo;
import com.zr.utils.JDBCUtils;
import com.zr.utils.Utils;

import java.security.MessageDigest;
import java.util.List;

public class UserInfoDaoImpl implements UserInfoDao {
    @Override
    public boolean login(String account, String password) {
        String sql = "select * from userInfo where account = ? and `password` = ?";
        return JDBCUtils.query(sql, UserInfo.class, account, password) != null;
    }

    @Override
    public List<UserInfo> getAllUserInfo() {
        String sql = "select * from userInfo";
        return JDBCUtils.queryList(sql, UserInfo.class);
    }

    @Override
    public List<UserInfo> getUserInfoLikeAccount(String account) {
        String sql = "select * from userInfo where instr(account,?)!=0";
        return JDBCUtils.queryList(sql, UserInfo.class, account);
    }

    @Override
    public int addUserInfo(UserInfo userInfo) {
        String sql = "insert into userInfo values(?,?,?,?,?,?,?,1);";
        Object[] params = {
                userInfo.getAccount(),
                Utils.msgEncrypt(userInfo.getPassword()),
                userInfo.getUserName(),
                userInfo.getNickName(),
                userInfo.getEmail(),
                userInfo.getPhone(),
                userInfo.getImg()
        };
        return JDBCUtils.update(sql, params);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        String sql = "update userInfo set `password` = ?,userName = ?,nickName=?,email=?,phone=?,img=?,state = ? where account=?";
        Object[] params = {
                Utils.msgEncrypt(userInfo.getPassword()),
                userInfo.getUserName(),
                userInfo.getNickName(),
                userInfo.getEmail(),
                userInfo.getPhone(),
                userInfo.getImg(),
                userInfo.getState(),
                userInfo.getAccount()
        };
        return JDBCUtils.update(sql, params);
    }

    @Override
    public int deleteUserInfo(String account) {
        String sql = "delete from userInfo where account = ?";
        return JDBCUtils.update(sql,account);
    }

    @Override
    public UserInfo getUserInfoByAccount(String account) {
        String sql = "select * from userInfo where account = ?";
        return JDBCUtils.query(sql,UserInfo.class,account);
    }

    @Override
    public UserInfo getUserInfoByUserName(String userName) {
        String sql = "select * from userInfo where userName = ?";
        return null;
    }

    @Override
    public List<UserInfo> getUserInfoLikeUserName(String userName) {
        String sql = "select * from userInfo where instr(userName,?)!=0";
        return JDBCUtils.queryList(sql,UserInfo.class,userName);
    }
}
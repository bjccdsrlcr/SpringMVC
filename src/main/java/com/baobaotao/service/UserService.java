package com.baobaotao.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobaotao.dao.LoginLogDao;
import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;

/**
 * Author: bjccdsrlcr
 * Date: 2017/11/17 0017
 * Time: 11:40
 */
@Service
public class UserService {

    @Autowired
    private com.baobaotao.dao.UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userName, String password){
        int matchCount = userDao.getMatchCount(userName, password);
        if(matchCount > 0){
        	return true;
        }else{
        	return false;
        }
    }
    public User findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }
    public void loginSuccess(User user) throws Exception{
        user.setCredits(5+ user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}

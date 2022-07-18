package com.florence.Service.Impl;

import com.florence.Service.LoginService;
import com.florence.dao.LoginMapper;
import com.florence.pojo.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther:Florence
 * @date:2022/07/13/9:34
 */
@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Count login(Integer username) {
        Count login = loginMapper.login(username);
        return login;
    }

    @Override
    public Count createCount(Integer username, Integer type) {
        return loginMapper.createCount(username,type);
    }
}

package com.liyan.service.Impl;

import com.liyan.mapper.UserloginMapper;
import com.liyan.pojo.Userlogin;
import com.liyan.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserloginServiceImpl implements UserloginService {
    @Autowired
    private UserloginMapper userloginMapper;

    @Override
    public Userlogin Login(String UserName) {
        return userloginMapper.findByNameAll(UserName);
    }

    @Override
    public void save(Userlogin userlogin) throws Exception {
        userloginMapper.insert(userlogin);
    }
}

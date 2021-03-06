package com.liyan.service.Impl;

import com.liyan.mapper.UserloginMapper;
import com.liyan.pojo.Userlogin;
import com.liyan.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void removeByName(String name) throws Exception {
        userloginMapper.deleteByExample(name);
    }

    @Override
    public Userlogin findByName(String name) throws Exception {
        List<Userlogin> list = userloginMapper.selectByExample(name);
        return list.get(0);
    }

    @Override
    public void updateByName(String name, Userlogin userlogin) {
        userloginMapper.updateByExample(userlogin, name);
    }
}

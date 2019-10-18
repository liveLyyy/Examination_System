package com.liyan.service;

import com.liyan.pojo.Userlogin;

public interface UserloginService {

    Userlogin Login(String UserName);

    //保存用户登录信息
    void save(Userlogin userlogin) throws Exception;

    //根据姓名删除
    void removeByName(String name) throws Exception;
}

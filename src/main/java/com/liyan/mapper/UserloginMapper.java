package com.liyan.mapper;

import com.liyan.pojo.Userlogin;
import org.springframework.stereotype.Repository;

@Repository
public interface UserloginMapper {
    //登录
   Userlogin findByNameAll(String UserName);

   //新增
   int insert(Userlogin userlogin);
}
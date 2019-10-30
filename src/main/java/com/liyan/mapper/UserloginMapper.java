package com.liyan.mapper;

import com.liyan.pojo.Userlogin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserloginMapper {
    //登录
   Userlogin findByNameAll(String UserName);

   //新增
   int insert(Userlogin userlogin);

    //根据姓名删除
    void removeByName(String name) throws Exception;

    int deleteByExample(String UserName);

    List<Userlogin> selectByExample(String username);

    int updateByExample(Userlogin userlogin,String username);
}
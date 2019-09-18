package com.liyan.custom;


import org.springframework.stereotype.Repository;

/**
 *  UserloginMapper扩展类
 */

public interface UserloginMapperCustom {

    UserloginCustom findOneByName(String name) throws Exception;

}

package com.liyan.service;

import com.liyan.pojo.Role;
/**
 *  Role 权限表Service层
 */
public interface RoleService {
    Role findByid(Integer id) throws Exception;

}

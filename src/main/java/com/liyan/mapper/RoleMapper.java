package com.liyan.mapper;

import com.liyan.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleMapper {

    Role findByRoleID(Integer id);
}
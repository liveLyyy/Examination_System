package com.liyan.mapper;


import com.liyan.pojo.College;

import java.util.List;

public interface CollegeMapper {

    College selectByPrimaryKey(Integer id);

    List<College> selectByExample(College college);

}
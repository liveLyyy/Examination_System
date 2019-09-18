package com.liyan.service;

import com.liyan.custom.StudentCustom;


import java.util.List;

/**
 * Student学生Service层
 */
public interface StudentService {
    //获取分页查询学生信息
    List<StudentCustom> findByPaging(Integer toPageNo) throws Exception;
    //获取学生总数
    int getCountStudent() throws Exception;
    //根据名字模糊查询
    List<StudentCustom> findByName(String name) throws Exception;
}

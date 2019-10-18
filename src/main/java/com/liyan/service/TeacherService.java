package com.liyan.service;

import com.liyan.custom.TeacherCustom;
import com.liyan.pojo.Teacher;

import java.util.List;

/**
 * Teacher老师Service层
 */
public interface TeacherService {
    //获取全部教师
    List<Teacher> findAll() throws Exception;
    //保存老师信息
    Boolean save(Teacher teacher) throws Exception;
    //获取老师总数
    int getCountTeacher() throws Exception;
    //获取分页查询老师信息
    List<Teacher> findByPaging(Integer toPageNo) throws Exception;
}

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
    //根据id查询
    TeacherCustom findById(Integer id) throws Exception;
    //根据id更新老师信息
    void updateById(Integer id, Teacher teacher) throws Exception;
    //根据id删除老师信息
    void removeById(Integer id) throws Exception;
    //根据名字查询
    List<TeacherCustom> findByName(String name) throws Exception;
}

package com.liyan.service;

import com.liyan.custom.StudentCustom;
import com.liyan.pojo.Student;


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
    //保存学生信息
    Boolean save(Student student) throws Exception;
    //根据id删除学生信息
    void removeById(Integer id) throws Exception;
    //根据id获取学生信息
    Student findById(Integer id) throws Exception;
    //根据id个更新学生信息
    void updataById(Integer id, Student student) throws Exception;
    // 一对多查询，查询该学生的选课信息
    Student findStudentAndSelectCourseListByName(String name) throws Exception;
}

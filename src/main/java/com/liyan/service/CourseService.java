package com.liyan.service;

import com.liyan.custom.CourseCustom;
import com.liyan.pojo.Course;

import java.util.List;

/**
 * CourseService课程信息.
 */

public interface CourseService {
    //获取课程总数
    int getCountCouse() throws Exception;
    //获取分页查询课程信息
    List<Course> findByPaging(Integer toPageNo) throws Exception;
    //插入课程信息
    Boolean save(Course couse) throws Exception;
    //根据id查询
    CourseCustom findById(Integer id) throws Exception;
    //根据id更新课程信息
    void upadteById(Integer id, Course course) throws Exception;
    //根据id删除课程信息
    Boolean removeById(Integer id) throws Exception;
    //根据名字查询
    List<CourseCustom> findByName(String name) throws Exception;
}

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
}

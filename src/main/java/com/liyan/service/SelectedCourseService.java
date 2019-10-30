package com.liyan.service;



import com.liyan.pojo.Selectedcourse;
import com.liyan.pojo.Student;

import java.util.List;

/**
 * 选课表servic层
 */
public interface SelectedCourseService {

    //查询指定学生成绩
    Selectedcourse findOne(Selectedcourse selectedCourseCustom) throws Exception;
    //选课
    void save(Selectedcourse selectedCourse) throws Exception;
    //退课
    void remove(Selectedcourse selectedCourseCustom) throws Exception;

    List<Selectedcourse> findAll() throws  Exception;

}

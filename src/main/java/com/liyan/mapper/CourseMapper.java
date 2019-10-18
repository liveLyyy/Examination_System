package com.liyan.mapper;

import com.liyan.pojo.Course;
import com.liyan.vo.PagingVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    int countByExample(Course example);
    //分页查询学生信息
    List<Course> findByPaging(PagingVO pagingVO) throws Exception;

    Course selectByPrimaryKey(Integer courseid);

    int insert(Course course);

}
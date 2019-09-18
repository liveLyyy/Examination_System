package com.liyan.mapper;

import com.liyan.custom.StudentCustom;
import com.liyan.vo.PagingVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jacey on 2017/6/28.
 */
@Repository
public interface StudentMapperCustom {

    //分页查询学生信息
    List<StudentCustom> findByPaging(PagingVO pagingVO) throws Exception;

    //查询学生信息，和其选课信息
    StudentCustom findStudentAndSelectCourseListById(Integer id) throws Exception;

}

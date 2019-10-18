package com.liyan.mapper;

import com.liyan.pojo.Teacher;
import com.liyan.vo.PagingVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> selectByExample(Teacher teacher);

    Teacher selectByPrimaryKey(Integer userid);

    int insert(Teacher record);

    int countByExample(Teacher teacher);

    //分页查询老师信息
    List<Teacher> findByPaging(PagingVO pagingVO) throws Exception;
}
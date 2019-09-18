package com.liyan.custom;

import com.liyan.vo.PagingVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jacey on 2017/6/29.
 */

public interface CourseMapperCustom {

    //分页查询学生信息
    List<CourseCustom> findByPaging(PagingVO pagingVO) throws Exception;

}

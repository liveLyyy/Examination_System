package com.liyan.mapper;


import com.liyan.pojo.Selectedcourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SelectedcourseMapper {

    List<Selectedcourse> selectByExample(Selectedcourse selectedcourse);

    int insert(Selectedcourse selectedcourse);

    int deleteByExample(Selectedcourse selectedcourse);
}
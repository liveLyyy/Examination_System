package com.liyan.service.Impl;

import com.liyan.custom.CourseCustom;
import com.liyan.mapper.CourseMapper;
import com.liyan.pojo.Course;
import com.liyan.service.CourseService;
import com.liyan.vo.PagingVO;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacey on 2017/6/29.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int getCountCouse() throws Exception {
        Course course=new Course();
        return courseMapper.countByExample(course);
    }

    @Override
    public List<Course> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        List<Course> list = courseMapper.findByPaging(pagingVO);
        return list;
    }

    @Override
    public Boolean save(Course couse) throws Exception {
        Course course = courseMapper.selectByPrimaryKey(couse.getCourseid());
        if (course == null) {
            courseMapper.insert(couse);
            return true;
        }
        return false;
    }
}

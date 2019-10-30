package com.liyan.service.Impl;

import com.liyan.custom.CourseCustom;
import com.liyan.mapper.CollegeMapper;
import com.liyan.mapper.CourseMapper;
import com.liyan.mapper.SelectedcourseMapper;
import com.liyan.pojo.College;
import com.liyan.pojo.Course;
import com.liyan.pojo.Selectedcourse;
import com.liyan.service.CourseService;
import com.liyan.vo.PagingVO;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacey on 2017/6/29.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private SelectedcourseMapper selectedcourseMapper;
    @Autowired
    private CollegeMapper collegeMapper;

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
    public Boolean save(Course course) throws Exception {
        Course cou = courseMapper.selectByPrimaryKey(course.getCourseid());
        if (cou == null) {
            courseMapper.insert(course);
            return true;
        }
        return false;
    }

    @Override
    public CourseCustom findById(Integer id) throws Exception {
        Course course = courseMapper.selectByPrimaryKey(id);
        CourseCustom courseCustom = null;
        if (course != null) {
            courseCustom = new CourseCustom();
            BeanUtils.copyProperties(courseCustom, course);
        }
        return courseCustom;
    }

    public void upadteById(Integer id, Course course) throws Exception {
        courseMapper.updateByPrimaryKey(course);
    }

    @Override
    public Boolean removeById(Integer id) throws Exception {
        Selectedcourse selectedcourse=new Selectedcourse();
        List<Selectedcourse> list = selectedcourseMapper.selectByExample(selectedcourse);
        if (list.size() == 0) {
            courseMapper.deleteByPrimaryKey(id);
            return true;
        }
        return false;
    }

    @Override
    public List<CourseCustom> findByName(String name) throws Exception {
        List<Course> list = courseMapper.selectByExamples(name);
        List<CourseCustom> courseCustomList = null;
        if (list != null) {
            courseCustomList = new ArrayList<CourseCustom>();
            for (Course c : list) {
                CourseCustom courseCustom = new CourseCustom();
                //类拷贝
                org.springframework.beans.BeanUtils.copyProperties(c, courseCustom);
                //获取课程名
                College college = collegeMapper.selectByPrimaryKey(c.getCollegeid());
                courseCustom.setcollegeName(college.getCollegename());
                courseCustomList.add(courseCustom);
            }
        }
        return courseCustomList;
    }
}

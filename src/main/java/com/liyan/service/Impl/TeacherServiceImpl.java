package com.liyan.service.Impl;

import com.liyan.custom.TeacherCustom;
import com.liyan.custom.TeacherMapperCustom;
import com.liyan.exception.CustomException;
import com.liyan.mapper.CollegeMapper;
import com.liyan.mapper.CourseMapper;
import com.liyan.mapper.TeacherMapper;
import com.liyan.pojo.College;
import com.liyan.pojo.Course;
import com.liyan.pojo.Teacher;
import com.liyan.service.TeacherService;
import com.liyan.vo.PagingVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacey on 2017/6/29.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CollegeMapper collegeMapper;


    @Override
    public List<Teacher> findAll() throws Exception {
        Teacher teacher=new Teacher();
        List<Teacher> list=teacherMapper.selectByExample1s(teacher);
        List<Teacher> teacherCustomsList = null;
        if (list != null) {
            teacherCustomsList = new ArrayList<Teacher>();
            for (Teacher t: list) {
                Teacher teacher1 = new Teacher();
                BeanUtils.copyProperties(t, teacher1);
                teacherCustomsList.add(teacher1);
            }
        }
        return teacherCustomsList;
    }

    @Override
    public Boolean save(Teacher teacher) throws Exception {
        Teacher tea = teacherMapper.selectByPrimaryKey(teacher.getUserid());
        if (tea == null) {
            teacherMapper.insert(teacher);
            return true;
        }
        return false;
    }

    @Override
    public int getCountTeacher() throws Exception {
        //自定义查询对象
        Teacher teacher = new Teacher();
        return teacherMapper.countByExample(teacher);
    }

    public List<Teacher> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        List<Teacher> list = teacherMapper.findByPaging(pagingVO);
        return list;
    }

    @Override
    public TeacherCustom findById(Integer id) throws Exception {
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        TeacherCustom teacherCustom = null;
        if (teacher != null) {
            teacherCustom = new TeacherCustom();
            BeanUtils.copyProperties(teacher, teacherCustom);
        }
        return teacherCustom;
    }

    @Override
    public void updateById(Integer id, Teacher teacher) throws Exception {
        teacherMapper.updateByPrimaryKey(teacher);
    }

    @Override
    public void removeById(Integer id) throws Exception {
        Course course=new Course();
        List<Course> list = courseMapper.selectByExample(course);
        if (list.size() != 0) {
            throw new CustomException("请先删除该名老师所教授的课程");
        }
        teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TeacherCustom> findByName(String name) throws Exception {
        List<Teacher> list = teacherMapper.selectByExample(name);
        List<TeacherCustom> teacherCustomList = null;
        if (list != null) {
            teacherCustomList = new ArrayList<TeacherCustom>();
            for (Teacher t : list) {
                TeacherCustom teacherCustom = new TeacherCustom();
                //类拷贝
                BeanUtils.copyProperties(t, teacherCustom);
                //获取课程名
                College college = collegeMapper.selectByPrimaryKey(t.getCollegeid());
                teacherCustom.setcollegeName(college.getCollegename());
                teacherCustomList.add(teacherCustom);
            }
        }
        return teacherCustomList;
    }
}

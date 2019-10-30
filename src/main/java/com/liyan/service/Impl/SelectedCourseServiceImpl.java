package com.liyan.service.Impl;

import com.liyan.custom.SelectedCourseCustom;
import com.liyan.mapper.SelectedcourseMapper;
import com.liyan.mapper.StudentMapper;
import com.liyan.pojo.Selectedcourse;
import com.liyan.pojo.Student;
import com.liyan.service.SelectedCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacey on 2017/6/29.
 */
@Service
public class SelectedCourseServiceImpl implements SelectedCourseService {
    @Autowired
    private SelectedcourseMapper selectedcourseMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Selectedcourse findOne(Selectedcourse selectedCourseCustom) throws Exception {
        Selectedcourse example = new Selectedcourse();
        List<Selectedcourse> list = selectedcourseMapper.selectByExample(example);
        if (list.size() > 0) {
            SelectedCourseCustom sc = new SelectedCourseCustom();
            BeanUtils.copyProperties(list.get(0), sc);

            Student student = studentMapper.selectByPrimaryKey(selectedCourseCustom.getStudentid());
            Student studentCustom = new Student();
            BeanUtils.copyProperties(student, studentCustom);
            sc.setStudentCustom(studentCustom);
            return sc;
        }

        return null;
    }

    @Override
    public void save(Selectedcourse selectedCourse) throws Exception {
        selectedcourseMapper.insert(selectedCourse);
    }

    @Override
    public void remove(Selectedcourse selectedCourseCustom) throws Exception {
        Selectedcourse example = new Selectedcourse();
        selectedcourseMapper.deleteByExample(example);
    }

    @Override
    public List<Selectedcourse> findAll() throws Exception {
        Selectedcourse selectedcourse=new Selectedcourse();
        return selectedcourseMapper.selectByExample(selectedcourse);
    }


}

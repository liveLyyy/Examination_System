package com.liyan.service.Impl;

import com.liyan.custom.SelectedCourseCustom;
import com.liyan.custom.StudentCustom;

import com.liyan.mapper.CollegeMapper;
import com.liyan.mapper.StudentMapper;
import com.liyan.mapper.StudentMapperCustom;
import com.liyan.pojo.College;
import com.liyan.pojo.Student;
import com.liyan.service.StudentService;
import com.liyan.vo.PagingVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Student
 */
@Service
public class StudentServiceImpl implements StudentService {

    //使用spring 自动注入
    // @Resource(description = "studentMapperCustom")
    @Autowired
    private StudentMapperCustom studentMapperCustom;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CollegeMapper collegeMapper;


    public List<StudentCustom> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        List<StudentCustom> list = studentMapperCustom.findByPaging(pagingVO);
        return list;
    }

    @Override
    public int getCountStudent() throws Exception {
        Student student = new Student();
        return studentMapper.countBy(student);
    }

    @Override
    public List<StudentCustom> findByName(String name) throws Exception {
        List<Student> list = studentMapper.selectByExample(name);
        List<StudentCustom> studentCustomList = null;
        if (list != null) {
            studentCustomList = new ArrayList<StudentCustom>();
            for (Student s : list) {
                StudentCustom studentCustom = new StudentCustom();
                //类拷贝
                BeanUtils.copyProperties(s, studentCustom);
                //获取课程名
                College college = collegeMapper.selectByPrimaryKey(s.getCollegeid());
                studentCustom.setcollegeName(college.getCollegename());
                studentCustomList.add(studentCustom);
            }
        }
        return studentCustomList;
    }

    @Override
    public Boolean save(Student student) throws Exception {
        Student stu = studentMapper.selectByPrimaryKey(student.getUserid());
        if (stu == null) {
            studentMapper.insert(student);
            return true;
        }
        return false;
    }

    @Override
    public void removeById(Integer id) throws Exception {
        studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Student findById(Integer id) throws Exception {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updataById(Integer id, Student student) throws Exception {
        studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public Student findStudentAndSelectCourseListByName(String name) throws Exception {
        StudentCustom studentCustom = studentMapperCustom.findStudentAndSelectCourseListById(Integer.parseInt(name));
        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();
        // 判断该课程是否修完
        for (SelectedCourseCustom s : list) {
            if (s.getMark() != null) {
                s.setOver(true);
            }
        }
        return studentCustom;
    }


}

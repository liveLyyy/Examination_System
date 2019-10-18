package com.liyan.custom;

import com.liyan.pojo.Selectedcourse;
import com.liyan.pojo.Student;
import org.springframework.stereotype.Repository;

/**
 * Created by Jacey on 2017/6/29.
 */

public class SelectedCourseCustom extends Selectedcourse {
    //新增Student 对象字段
    private Student studentCustom;

    //扩展课程信息对象
    private CourseCustom courseCustom;

    //判断该学生是否已经完成该课程
    private Boolean over = false;


    public Boolean getOver() {
        return over;
    }

    public void setOver(Boolean over) {
        this.over = over;
    }

    public Student getStudentCustom() {
        return studentCustom;
    }

    public void setStudentCustom(Student studentCustom) {
        this.studentCustom = studentCustom;
    }

    public CourseCustom getCouseCustom() {
        return courseCustom;
    }

    public void setCouseCustom(CourseCustom couseCustom) {
        this.courseCustom = couseCustom;
    }
}

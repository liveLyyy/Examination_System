package com.liyan.custom;

import com.liyan.pojo.Course;
import org.springframework.stereotype.Repository;

/**
 * Course扩展类    课程
 */

public class CourseCustom extends Course {

    //所属院系名
    private String collegeName;

    public void setcollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getcollegeName() {
        return collegeName;
    }

}

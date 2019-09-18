package com.liyan.custom;

import com.liyan.pojo.Teacher;
import org.springframework.stereotype.Repository;

/**
 * teacher扩展类
 */

public class TeacherCustom extends Teacher {
    //所属院系名
    private String collegeName;

    public void setcollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getcollegeName() {
        return collegeName;
    }
}

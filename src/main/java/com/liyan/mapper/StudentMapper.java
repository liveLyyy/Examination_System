package com.liyan.mapper;

import com.liyan.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentMapper {

   int countBy(Student student);

   List<Student> selectByExample(String username);

   Student selectByPrimaryKey(Integer userid);

   int insert(Student student);
}
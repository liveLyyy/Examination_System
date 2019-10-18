package com.liyan.controller;

import com.liyan.converter.CustomDateConverter;
import com.liyan.custom.StudentCustom;
import com.liyan.custom.TeacherCustom;
import com.liyan.exception.CustomException;
import com.liyan.pojo.*;
import com.liyan.service.*;
import com.liyan.vo.PagingVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * Created by Jacey on 2017/6/30.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource(name = "studentServiceImpl")
    private StudentService studentService;

    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "collegeServiceImpl")
    private CollegeService collegeService;

    @Resource(name = "userloginServiceImpl")
    private UserloginService userloginService;

    @Resource(name = "teacherServiceImpl")
    private TeacherService teacherService;

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<学生操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

    //  学生信息显示
    @RequestMapping("/showStudent")
    public String showStudent(Model model, Integer page) throws Exception {
        List<StudentCustom> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(studentService.getCountStudent());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = studentService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = studentService.findByPaging(page);
        }
        model.addAttribute("studentList", list);
        model.addAttribute("pagingVO", pagingVO);
        return "admin/showStudent";

    }

    //  添加学生信息页面显示
    @RequestMapping(value = "/addStudent", method = {RequestMethod.GET})
    public String addStudentUI(Model model) throws Exception {
        List<College> list = collegeService.finAll();
        model.addAttribute("collegeList", list);
        return "admin/addStudent";
    }

     // 添加学生信息操作
    @RequestMapping(value = "/addStudent", method = {RequestMethod.POST})
    public String addStudent(@Param("userid") Integer userid, @Param("username") String username,
                             @Param("sex") String sex, @Param("birthyear") String birthyear,@Param("grade") String grade
            ,@Param("collegeid") Integer collegeid, Model model) throws Exception {
        Student student=new Student();
        student.setUsername(username);
        student.setUserid(userid);
        student.setSex(sex);
        CustomDateConverter customDateConverter=new CustomDateConverter();
        student.setGrade(customDateConverter.convert(grade));
        student.setBirthyear(customDateConverter.convert(birthyear));
        student.setCollegeid(collegeid);
        Boolean result = studentService.save(student);
        if (!result) {
            model.addAttribute("message", "学号重复");
            return "error";
        }
        //添加成功后，也添加到登录表
        Userlogin userlogin = new Userlogin();
        userlogin.setUsername(student.getUserid().toString());
        userlogin.setPassword("123");
        userlogin.setRole(2);
        userloginService.save(userlogin);
        //重定向
        return "redirect:/admin/showStudent";
    }

    // 修改学生信息页面显示
    @RequestMapping(value = "/editStudent", method = {RequestMethod.GET})
    public String editStudentUI(Integer id, Model model) throws Exception {
        if (id == null) {
            //加入没有带学生id就进来的话就返回学生显示页面
            return "redirect:/admin/showStudent";
        }
            Student student = studentService.findById(id);
        if (student == null) {
            throw new CustomException("未找到该名学生");
        }
        List<College> list = collegeService.finAll();
        model.addAttribute("collegeList", list);
        model.addAttribute("student", student);
        return "admin/editStudent";
    }

    // 修改学生信息处理
    @RequestMapping(value = "/editStudent", method = {RequestMethod.POST})
    public String editStudent(@Param("userid") Integer userid, @Param("username") String username,
                              @Param("sex") String sex, @Param("birthyear") String birthyear,@Param("grade") String grade
            ,@Param("collegeid") Integer collegeid) throws Exception {
        Student student=new Student();
        student.setUsername(username);
        student.setUserid(userid);
        student.setSex(sex);
        CustomDateConverter customDateConverter=new CustomDateConverter();
        student.setGrade(customDateConverter.convert(grade));
        student.setBirthyear(customDateConverter.convert(birthyear));
        student.setCollegeid(collegeid);
        studentService.updataById(student.getUserid(), student);
        //重定向
        return "redirect:/admin/showStudent";
    }

    // 删除学生
    @RequestMapping(value = "/removeStudent", method = {RequestMethod.GET} )
    private String removeStudent(Integer id) throws Exception {
        if (id == null) {
            //加入没有带学生id就进来的话就返回学生显示页面
            return "admin/showStudent";
        }
        studentService.removeById(id);
        userloginService.removeByName(id.toString());
        return "redirect:/admin/showStudent";
    }

    // 搜索学生
    @RequestMapping(value = "selectStudent", method = {RequestMethod.POST})
    private String selectStudent(String findByName, Model model) throws Exception {
        List<StudentCustom> list = studentService.findByName(findByName);
        model.addAttribute("studentList", list);
        return "admin/showStudent";
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<课程操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

    // 课程信息显示
    @RequestMapping("/showCourse")
    public String showCourse(Model model, Integer page) throws Exception {

        List<Course> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(courseService.getCountCouse());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = courseService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = courseService.findByPaging(page);
        }
        model.addAttribute("courseList", list);
        model.addAttribute("pagingVO", pagingVO);
        return "admin/showCourse";
    }

    //添加课程
    @RequestMapping(value = "/addCourse", method = RequestMethod.GET)
    public String addCourseUI(Model model) throws Exception {
        List<Teacher> list = teacherService.findAll();
        List<College> collegeList = collegeService.finAll();
        model.addAttribute("collegeList", collegeList);
        model.addAttribute("teacherList", list);
        return "admin/addCourse";
    }
    // 添加课程信息处理
    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public String addCourse( Model model,@Param("courseid") Integer courseid,@Param("coursename")String coursename,
                             @Param("teacherid")Integer teacherid,@Param("coursetime")String coursetime,@Param("classroom")String classroom
    ,@Param("courseweek")Integer courseweek,@Param("coursetype")String coursetype,@Param("collegeid")Integer collegeid,@Param("score")Integer score) throws Exception {
        Course course=new Course();
        course.setCourseid(courseid);
        course.setCoursename(coursename);

        course.setTeacherid(teacherid);


        course.setCoursetime(coursetime);
        course.setClassroom(classroom);
        course.setCourseweek(courseweek);
        course.setCoursetype(coursetype);

        course.setCollegeid(collegeid);


        course.setScore(score);
        Boolean result = courseService.save(course);
        if (!result) {
            model.addAttribute("message", "课程号重复");
            return "error";
        }
        //重定向
        return "redirect:/admin/showCourse";
    }


    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<教师操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

    @RequestMapping("/showTeacher")
    public String showTeacher(Model model, Integer page) throws Exception {
        List<Teacher> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(teacherService.getCountTeacher());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = teacherService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = teacherService.findByPaging(page);
        }
        model.addAttribute("teacherList", list);
        model.addAttribute("pagingVO", pagingVO);
        return "admin/showTeacher";
    }

//
//    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<其他操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
//
//    // 普通用户账号密码重置
//    @RequestMapping("/userPasswordRest")
//    public String userPasswordRestUI() throws Exception {
//        return "admin/userPasswordRest";
//    }
//
//    // 普通用户账号密码重置处理
//    @RequestMapping(value = "/userPasswordRest", method = {RequestMethod.POST})
//    public String userPasswordRest(Userlogin userlogin) throws Exception {
//
//        Userlogin u = userloginService.findByName(userlogin.getUsername());
//
//        if (u != null) {
//            if (u.getRole() == 0) {
//                throw new CustomException("该账户为管理员账户，没法修改");
//            }
//            u.setPassword(userlogin.getPassword());
//            userloginService.updateByName(userlogin.getUsername(), u);
//        } else {
//            throw new CustomException("没找到该用户");
//        }
//
//        return "admin/userPasswordRest";
//    }

    // 本账户密码重置
    @RequestMapping("/passwordRest")
    public String passwordRestUI() throws Exception {
        return "admin/passwordRest";
    }


}

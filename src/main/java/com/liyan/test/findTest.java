package com.liyan.test;
import com.liyan.custom.CourseCustom;
import com.liyan.pojo.Course;
import com.liyan.pojo.Selectedcourse;
import com.liyan.pojo.Userlogin;
import com.liyan.service.CourseService;
import com.liyan.service.Impl.CourseServiceImpl;
import com.liyan.service.Impl.UserloginServiceImpl;
import com.liyan.service.SelectedCourseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import java.util.List;

public class findTest {

    @Test
    public void find()throws Exception{
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        CourseService courseService= (CourseService) applicationContext.getBean("courseServiceImpl");
//        Boolean index=courseService.removeById(10);
//        System.out.println(index);
//        if (index != null){
//            System.out.println("删除成功");
//        }else {
//            System.out.println("删除失败");
//        }
        SelectedCourseService selectedCourseService= (SelectedCourseService) applicationContext.getBean(SelectedCourseService.class);
        List<Selectedcourse> list = selectedCourseService.findAll();
        System.out.println(list);

    }
}

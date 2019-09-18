package com.liyan.test;
import com.liyan.pojo.Userlogin;
import com.liyan.service.Impl.UserloginServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import java.util.List;

public class findTest {

    @Test
    public void find(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserloginServiceImpl userloginServiceImpl=applicationContext.getBean("userloginServiceImpl",UserloginServiceImpl.class);
        Userlogin user=new Userlogin();
        Userlogin userlogin=userloginServiceImpl.Login("admin");
        System.out.println(userlogin.toString());
    }
}

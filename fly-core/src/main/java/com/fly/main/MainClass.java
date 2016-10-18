package com.fly.main;

import com.fly.user.servic.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by jinxiaofei on 16/10/17.
 */
public class MainClass {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring.xml");
        UserServiceImpl userService=applicationContext.getBean(UserServiceImpl.class);
        System.out.println(userService);
    }
}

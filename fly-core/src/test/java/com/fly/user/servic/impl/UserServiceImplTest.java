package com.fly.user.servic.impl;

import com.fly.user.model.Person;
import com.fly.user.model.Teacher;
import com.fly.user.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by jinxiaofei on 16/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserServiceImplTest {
    @Resource
    private UserService userServiceImpl;
    @Test
    public void testFind() throws Exception {
        System.out.println(userServiceImpl.find(1, 1));
    }



    @Test
    public void testSave() throws Exception {
         Person person = new Person();
        person.setName("小");
        Teacher teacher = new Teacher();
        System.out.println(userServiceImpl.save(person,teacher));
    }
    @Test
    public void testFindByName() throws Exception {
        System.out.println(userServiceImpl.findByName());
    }
}
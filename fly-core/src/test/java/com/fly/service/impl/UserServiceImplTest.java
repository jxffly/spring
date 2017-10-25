package com.fly.service.impl;

import com.fly.user.model.ClassRoom;
import com.fly.user.model.Student;
import com.fly.user.model.Teacher;
import com.fly.user.service.UserService;
import com.fly.user.service.UserService2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import javax.annotation.Resource;


/**
 * Created by jinxiaofei on 16/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserServiceImplTest {

    @Resource
    private UserService userServiceImpl;

    @Autowired
    private UserService2 userService2Impl;

    @Autowired
    private  UserServiceImpl userService;


    @Test
    public void testFind() throws Exception {
        System.out.println(userServiceImpl.find(1, 1));
    }


    @Test
    public void testInnerMethodCall() throws Exception {
        Long current = System.currentTimeMillis();
        Student student = new Student();
        student.setName("金" + (current % 10000));
        student.setAge((int) (current % 100));
        student.setCId(current / 1000);


        Teacher teacher = new Teacher();
        teacher.setName("小" + (current % 10001));
        teacher.setSex((int) (current % 10));
        teacher.setCId(current / 10001);
        teacher.setUpdateTime(new Date());
        teacher.setCreateTime(new Date());

        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("三年级" + (current % 123));


        System.out.println(userServiceImpl.save(student, teacher, classRoom));
    }


    @Test
    public void testRollBackForPagagition() throws Exception {
        Long current = System.currentTimeMillis();

        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("三年级" + (current % 123));
        System.out.println(userServiceImpl.saveClassV2(classRoom));

    }


    @Test
    public void testNonTransCallTrans() throws Exception {
        Long current = System.currentTimeMillis();

        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("三年级" + (current % 123));
        System.out.println(userService2Impl.saveClass(classRoom));

    }

    @Test
    public void testClassPrivateMethod() throws Exception {
        Long current = System.currentTimeMillis();

        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("三年级" + (current % 123));
        System.out.println(userService.saveClassV4(classRoom));

    }

    @Test
    public void testRollForException() throws Exception {
        Long current = System.currentTimeMillis();

        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("三年级" + (current % 123));
        System.out.println(userService.saveClassV6(classRoom));



    }
    @Test
    public void testRollForException2() throws Exception {
        Long current = System.currentTimeMillis();
        ClassRoom classRoom2 = new ClassRoom();
        classRoom2.setName("三年级" + (current % 567));
        System.out.println(userService.saveClassV7(classRoom2));

    }


    @Test
    public void testFindByName() throws Exception {
        System.out.println(userServiceImpl.findByName());
    }
}
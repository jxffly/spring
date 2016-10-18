package com.fly.user.servic.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by jinxiaofei on 16/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserServiceImplTest {
    @Resource
    UserServiceImpl userServiceImpl;
    @Test
    public void testFind() throws Exception {
            userServiceImpl.find(10,11);
    }
}
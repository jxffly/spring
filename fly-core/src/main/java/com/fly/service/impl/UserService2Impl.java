package com.fly.service.impl;

import com.fly.user.model.ClassRoom;
import com.fly.user.service.UserService;
import com.fly.user.service.UserService2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by jinxiaofei.
 * Time 2017/10/20 上午8:50
 * Desc 文件描述
 */
@Service
public class UserService2Impl implements UserService2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService2.class);

    @Autowired
    private UserService userServiceImpl;


    public Long saveClass(ClassRoom classRoom) {
        Long cid = userServiceImpl.saveClassV3(classRoom);
        classRoom.setName(classRoom.getName()+classRoom.getName());
        classRoom.setId(null);
        Long aLong = userServiceImpl.saveClass(classRoom);
        return aLong;
    }
}

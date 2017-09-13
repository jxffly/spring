package com.fly.user.servic.impl;


import com.fly.common.model.mapper.UserMapper;
import com.fly.user.model.Person;
import com.fly.user.model.Teacher;
import com.fly.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jinxiaofei on 16/10/17.
 */
@Service
public class UserServiceImpl implements UserService {
    private  static final Logger LOGGER= LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserMapper userMapper;
    @Override
    public Person find(int personId, int bid) {
        LOGGER.info("将要进行查询操作,personId:{},bid{}",personId,bid);
        return userMapper.find(personId,bid);
    }

    @Override
    public int save(Person p,Teacher teacher) {
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("开始进行员工的添加:{}",p);
        }
        return 0;
    }
    @Override
    public Person findByName(){
        return userMapper.findByName("飞");
    }
}
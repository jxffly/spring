package com.fly.user.servic.impl;


import com.fly.user.model.Person;
import com.fly.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by jinxiaofei on 16/10/17.
 */
@Service
public class UserServiceImpl implements UserService {
    private  static final Logger LOGGER= LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public Person find(int personId, int bid) {
        LOGGER.info("将要进行查询操作,personId:{},bid{}",personId,bid);
        return null;
    }
}
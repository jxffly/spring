package com.fly.user.service;


import com.fly.user.model.Person;

/**
 * Created by jinxiaofei on 16/10/17.
 */
public interface UserService {
        Person find(int personId, int bid);
}

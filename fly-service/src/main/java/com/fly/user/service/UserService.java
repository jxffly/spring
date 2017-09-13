package com.fly.user.service;


import com.fly.user.model.Person;
import com.fly.user.model.Teacher;


/**
 * Created by jinxiaofei on 16/10/17.
 */
public interface UserService {
        Person find(int personId, int bid);

        Person findByName();

        int save(Person p,Teacher teacher);
}

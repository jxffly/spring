package com.fly.common.model.mapper;

import com.fly.user.model.Person;
import org.apache.ibatis.annotations.Param;

/**
 * Created by jinxiaofei on 16/10/18.
 */
public interface UserMapper {
    Person find(@Param("personId") long personId, @Param("bid") long bid);
    Person findByName(@Param("name") String name);
}

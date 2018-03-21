package com.fly.common.model.mapper;

import com.fly.user.model.ClassRoom;
import com.fly.user.model.Student;
import com.fly.user.model.Teacher;

import org.apache.ibatis.annotations.Param;


/**
 * Created by jinxiaofei on 16/10/18.
 */
public interface UserMapper {

    Student findByName(@Param("name") String name);
/*    Student find(@Param("personId") long personId, @Param("bid") long bid);
    Student findByName(@Param("name") String name);*/

    int save(Student p);

    int saveClassRoom(ClassRoom classRoom);

    int saveTeacher(Teacher t);
}

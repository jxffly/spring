package com.fly.user.service;


import com.fly.user.model.ClassRoom;
import com.fly.user.model.Student;
import com.fly.user.model.Teacher;


/**
 * Created by jinxiaofei on 16/10/17.
 */
public interface UserService {

    Student find(int personId, int bid);

    Student findByName();

    Long save(Student p, Teacher teacher, ClassRoom classRoom);

    Long saveTeacher(Teacher t);

    Long saveTeacherV2(Teacher t);


    Long saveClass(ClassRoom classRoom);

    Long saveClassV2(ClassRoom classRoom);

    Long saveClassV3(ClassRoom classRoom);



}
